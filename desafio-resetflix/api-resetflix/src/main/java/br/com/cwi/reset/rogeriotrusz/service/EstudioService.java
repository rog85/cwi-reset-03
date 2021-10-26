package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.FakeDatabase;
import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.enums.StatusAtividade;
import br.com.cwi.reset.rogeriotrusz.exception.*;
import br.com.cwi.reset.rogeriotrusz.model.Estudio;
import br.com.cwi.reset.rogeriotrusz.request.EstudioRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest)
            throws CampoNaoInformadoException, NomeJaCadastradoException, DataCriacaoException {

        String nome = estudioRequest.getNome();
        String descricao = estudioRequest.getDescricao();
        LocalDate dataCriacao = estudioRequest.getDataCriacao();
        StatusAtividade statusAtividade = estudioRequest.getStatusAtividade();

        if(nome == null || nome.isEmpty()){
            throw new CampoNaoInformadoException("nome");
        } else if(nomeExiste(nome)){
            throw new NomeJaCadastradoException(NomeEntidade.ESTUDIO, nome);
        }

        if(descricao == null || descricao.isEmpty()){
            throw new CampoNaoInformadoException("descricao");
        }

        if(dataCriacao == null){
            throw new CampoNaoInformadoException("dataCriacao");
        } else if(dataCriacao.isAfter(LocalDate.now())){
            throw new DataCriacaoException(NomeEntidade.ESTUDIO);
        }

        if(statusAtividade == null){
            throw new CampoNaoInformadoException("statusAtividade");
        }

        //Integer id = proximoId();
        Estudio estudio = new Estudio(nome, descricao, dataCriacao, statusAtividade);
        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome)
            throws CadastroNaoEncontradoException, FiltroNaoEncontradoException {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        if(estudios.isEmpty()){
            throw new CadastroNaoEncontradoException(NomeEntidade.ESTUDIO);
        }

        List<Estudio> resultado = estudios;

        if(filtroNome != null && !filtroNome.isEmpty()){
            resultado = new ArrayList<>();
            for(Estudio e : estudios){
                if(e.getNome().toLowerCase().contains(filtroNome.toLowerCase())){
                    resultado.add(e);
                }
            }
        }

        if(resultado.isEmpty()){
            throw new FiltroNaoEncontradoException(NomeEntidade.ESTUDIO, filtroNome);
        }

        return resultado;
    }

    public Estudio consultarEstudio(Integer id)
            throws CampoNaoInformadoException, IdNaoEncontradoException {

        if(id == null){
            throw new CampoNaoInformadoException("id");
        }

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        Estudio resultado = null;
        for (Estudio e : estudios){
            if(e.getId() == id){
                resultado = e;
            }
        }
        if(resultado == null){
            throw new IdNaoEncontradoException(NomeEntidade.ESTUDIO, id);
        }
        return resultado;
    }

    private Integer proximoId(){
        return fakeDatabase.recuperaEstudios().size() + 1;
    }

    private boolean nomeExiste(String nome){
        List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        for (Estudio e : estudios) {
            if(e.getNome().equals(nome))
                return true;
        }
        return false;
    }
}
