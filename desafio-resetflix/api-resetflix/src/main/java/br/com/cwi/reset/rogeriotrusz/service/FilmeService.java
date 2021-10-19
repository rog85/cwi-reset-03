package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.FakeDatabase;
import br.com.cwi.reset.rogeriotrusz.enums.Genero;
import br.com.cwi.reset.rogeriotrusz.exception.AtorPersonagemDuplicadoException;
import br.com.cwi.reset.rogeriotrusz.exception.CampoNaoInformadoException;
import br.com.cwi.reset.rogeriotrusz.exception.GeneroDuplicadoException;
import br.com.cwi.reset.rogeriotrusz.exception.IdNaoEncontradoException;
import br.com.cwi.reset.rogeriotrusz.model.*;
import br.com.cwi.reset.rogeriotrusz.request.FilmeRequest;
import br.com.cwi.reset.rogeriotrusz.request.PersonagemRequest;

import java.util.ArrayList;
import java.util.List;

public class FilmeService {
    private FakeDatabase fakeDatabase;
    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarFilme(FilmeRequest filmeRequest)
            throws CampoNaoInformadoException, IdNaoEncontradoException,
            GeneroDuplicadoException, AtorPersonagemDuplicadoException {

        String nome = filmeRequest.getNome();
        Integer anoLancamento = filmeRequest.getAnoLancamento();
        String capaFilme = filmeRequest.getCapaFilme();
        List<Genero> generos = filmeRequest.getGeneros();
        Integer idDiretor = filmeRequest.getIdDiretor();
        Integer idEstudio = filmeRequest.getIdEstudio();
        List<PersonagemRequest> personagens = filmeRequest.getPersonagens();
        String resumo = filmeRequest.getResumo();

        if(nome == null || nome.isEmpty()) {
            throw new CampoNaoInformadoException("nome");
        }

        if(anoLancamento == null){
            throw new CampoNaoInformadoException("anoLancamento");
        }

        if(capaFilme == null || capaFilme.isEmpty()) {
            throw new CampoNaoInformadoException("capaFilme");
        }

        if(generos != null && !generos.isEmpty()){
            List<Genero> listaGeneroAux = new ArrayList<>();
            for(Genero g : generos){
                if(!listaGeneroAux.contains(g)){
                    listaGeneroAux.add(g);
                } else{
                    throw new GeneroDuplicadoException();
                }
            }
        }

        if(idDiretor == null){
            throw new CampoNaoInformadoException("idDiretor");
        }
        DiretorService diretorService = new DiretorService(fakeDatabase);
        Diretor diretor = diretorService.consultarDiretor(idDiretor);


        if(idEstudio == null){
            throw new CampoNaoInformadoException("idEstudio");
        }
        EstudioService estudioService = new EstudioService(fakeDatabase);
        Estudio estudio = estudioService.consultarEstudio(idEstudio);

        if(resumo == null || resumo.isEmpty()) {
            throw new CampoNaoInformadoException("resumo");
        }

        if(personagens == null || personagens.isEmpty()) {
            throw new CampoNaoInformadoException("personagens");
        } else if(existeResquestDuplicada(personagens)){
            throw new AtorPersonagemDuplicadoException();
        }

        PersonagemService personagemService = new PersonagemService(fakeDatabase);
        List<PersonagemAtor> personagensAtores = new ArrayList<>();
        PersonagemAtor personagemAtor;
        for (PersonagemRequest p : personagens){
            Integer id = personagemService.criarPersonagem(p);
            personagemAtor = personagemService.consultarPersonagem(id);
            personagensAtores.add(personagemAtor);
        }

        Integer id = proximoId();
        Filme filme = new Filme(id, nome, anoLancamento, capaFilme, generos, diretor, estudio, personagensAtores, resumo);
        fakeDatabase.persisteFilme(filme);
    }

    private Integer proximoId(){
        return fakeDatabase.recuperaFilmes().size() + 1;
    }

    private boolean existeResquestDuplicada(List<PersonagemRequest> personagens){
        PersonagemRequest requestAtual;
        PersonagemRequest proximoRequest;
        for(int i = 0; i < personagens.size(); i++) {
            requestAtual = personagens.get(i);
            for (int j = i + 1; j < personagens.size(); j++) {
                proximoRequest = personagens.get(j);
                boolean mesmoId = requestAtual.getIdAtor() == proximoRequest.getIdAtor();
                boolean mesmoNome = requestAtual.getNomePersonagem().equals(proximoRequest.getNomePersonagem());
                if (mesmoId && mesmoNome) {
                    return true;
                }
            }
        }
        return false;
    }
}
