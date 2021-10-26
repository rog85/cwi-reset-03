package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.FakeDatabase;
import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.enums.TipoAtuacao;
import br.com.cwi.reset.rogeriotrusz.exception.CampoNaoInformadoException;
import br.com.cwi.reset.rogeriotrusz.exception.IdNaoEncontradoException;
import br.com.cwi.reset.rogeriotrusz.model.Ator;
import br.com.cwi.reset.rogeriotrusz.model.PersonagemAtor;
import br.com.cwi.reset.rogeriotrusz.request.PersonagemRequest;

import java.util.List;

public class PersonagemService {

    private FakeDatabase fakeDatabase;
    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public int criarPersonagem(PersonagemRequest personagemRequest)
            throws CampoNaoInformadoException, IdNaoEncontradoException {

        /*Integer idAtor = personagemRequest.getIdAtor();
        String nomePersonagem = personagemRequest.getNomePersonagem();
        String descricaoPersonagem = personagemRequest.getDescricaoPersonagem();
        TipoAtuacao tipoAtuacao = personagemRequest.getTipoAtuacao();

        if(idAtor == null){
            throw new CampoNaoInformadoException("idAtor");
        }
        AtorService atorService = new AtorService(fakeDatabase);
        Ator ator = atorService.consultarAtor(idAtor);

        if(nomePersonagem == null || nomePersonagem.isEmpty()){
            throw new CampoNaoInformadoException("nomePersonagem");
        }

        if(descricaoPersonagem == null || descricaoPersonagem.isEmpty()){
            throw new CampoNaoInformadoException("descricaoPersonagem");
        }

        if(tipoAtuacao == null){
            throw new CampoNaoInformadoException("tipoAtuacao");
        }

        //Integer id = proximoId();
        PersonagemAtor personagemAtor = new PersonagemAtor(ator, nomePersonagem, descricaoPersonagem, tipoAtuacao);
        fakeDatabase.persistePersonagem(personagemAtor);*/

        return 0;
    }

    public PersonagemAtor consultarPersonagem(Integer id)
            throws CampoNaoInformadoException, IdNaoEncontradoException {

        if(id == null){
            throw new CampoNaoInformadoException("id");
        }
        List<PersonagemAtor> personagens = fakeDatabase.recuperaPersonagens();
        PersonagemAtor resultado = null;
        for (PersonagemAtor p : personagens){
            if(p.getId() == id){
                resultado = p;
            }
        }
        if(resultado == null){
            throw new IdNaoEncontradoException(NomeEntidade.PERSONAGEM_ATOR, id);
        }
        return resultado;
    }

    private Integer proximoId(){
        return fakeDatabase.recuperaPersonagens().size() + 1;
    }

    public void validaAtoresId(List<PersonagemRequest> personagens) throws CampoNaoInformadoException, IdNaoEncontradoException {
        /*AtorService atorService = new AtorService(fakeDatabase);
        for (PersonagemRequest p : personagens){
            atorService.consultarAtor(p.getIdAtor());
        }*/
    }

}
