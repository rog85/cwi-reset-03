package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.FakeDatabase;
import br.com.cwi.reset.rogeriotrusz.model.Diretor;
import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.exception.*;
import br.com.cwi.reset.rogeriotrusz.request.DiretorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws CampoNaoInformadoException,
            NomeCompostoException, NomeJaCadastradoException, DataNascimentoException, AnoInvalidoException {

        Integer id = 0;
        String nome = diretorRequest.getNome();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();

        if(nome == null || nome.isEmpty()){
            throw new CampoNaoInformadoException("nome");
        } else if(!nome.matches("^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$")){
            throw new NomeCompostoException(NomeEntidade.DIRETOR);
        } else if(nomeJaExiste(nome)){
            throw new NomeJaCadastradoException(NomeEntidade.DIRETOR, nome);
        }

        if(dataNascimento == null){
            throw new CampoNaoInformadoException("dataNascimento");
        } else if(dataNascimento.isAfter(LocalDate.now())){
            throw new DataNascimentoException(NomeEntidade.DIRETOR);
        }

        if(anoInicioAtividade == null){
            throw new CampoNaoInformadoException("anoInicioAtividade");
        } else if(anoInicioAtividade < dataNascimento.getYear()){
            throw new AnoInvalidoException(NomeEntidade.DIRETOR);
        }

        id = proximoDiretorId();
        Diretor diretor = new Diretor(id, nome, dataNascimento, anoInicioAtividade);
        fakeDatabase.persisteDiretor(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws FiltroNaoEncontradoException, CadastroNaoEncontradoException {
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        if(diretores.isEmpty()){
            throw new CadastroNaoEncontradoException(NomeEntidade.DIRETOR);
        }

        if(filtroNome == null || filtroNome.isEmpty()){
            return diretores;
        }

        List<Diretor> resultadoFiltrado = new ArrayList<>();

        for(Diretor d : diretores){
            if(d.getNome().toLowerCase().contains(filtroNome.toLowerCase())){
                resultadoFiltrado.add(d);
            }
        }

        if(resultadoFiltrado.isEmpty()){
            throw new FiltroNaoEncontradoException(NomeEntidade.DIRETOR, filtroNome);
        }
        return resultadoFiltrado;
    }

    public Diretor consultarDiretor(Integer id) throws CampoNaoInformadoException, IdNaoEncontradoException {
        if(id == null){
            throw new CampoNaoInformadoException("id");
        }
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        Diretor resultado = null;
        for (Diretor d : diretores){
            if(d.getId() == id){
                resultado = d;
            }
        }
        if(resultado == null){
            throw new IdNaoEncontradoException(NomeEntidade.DIRETOR, id);
        }
        return resultado;
    }

    private Integer proximoDiretorId(){
        return fakeDatabase.recuperaDiretores().size() + 1;
    }

    private boolean nomeJaExiste(String nome){
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        for (Diretor d : diretores) {
            if(d.getNome().equals(nome))
                return true;
        }
        return false;
    }
}
