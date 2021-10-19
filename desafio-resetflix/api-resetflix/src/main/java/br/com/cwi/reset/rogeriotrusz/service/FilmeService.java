package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.FakeDatabase;
import br.com.cwi.reset.rogeriotrusz.enums.Genero;
import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.exception.*;
import br.com.cwi.reset.rogeriotrusz.model.*;
import br.com.cwi.reset.rogeriotrusz.request.FilmeRequest;
import br.com.cwi.reset.rogeriotrusz.request.PersonagemRequest;
import org.springframework.web.bind.annotation.RequestParam;

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

        personagemService.validaAtoresId(personagens);

        List<PersonagemAtor> personagensAtores = new ArrayList<>();
        PersonagemAtor personagemAtor;

        for (PersonagemRequest p : personagens){
            Integer idPersonagem = personagemService.criarPersonagem(p);
            personagemAtor = personagemService.consultarPersonagem(idPersonagem);
            personagensAtores.add(personagemAtor);
        }

        Integer id = proximoId();
        Filme filme = new Filme(id, nome, anoLancamento, capaFilme, generos, diretor, estudio, personagensAtores, resumo);
        fakeDatabase.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor,
                                       String nomePersonagem, String nomeAtor) throws CadastroNaoEncontradoException, FilmeNaoEncontradoException {

        List<Filme> filmes = fakeDatabase.recuperaFilmes();
        if(filmes.isEmpty()){
            throw new CadastroNaoEncontradoException(NomeEntidade.FILME);
        }

        List<Filme> resultado = new ArrayList<>();

        if(nomeFilme != null && !nomeFilme.isEmpty()){
            for (Filme f : filmes){
                if(f.getNome().toLowerCase().contains(nomeFilme.toLowerCase()) && !resultado.contains(f)){
                    resultado.add(f);
                }
            }
        }

        if(nomeDiretor != null && !nomeDiretor.isEmpty()){
            for (Filme f : filmes){
                if(f.getDiretor().getNome().toLowerCase().contains(nomeDiretor.toLowerCase()) && !resultado.contains(f)){
                    resultado.add(f);
                }
            }
        }

        if(nomePersonagem != null && !nomePersonagem.isEmpty()){
            for (Filme f : filmes){
                List<PersonagemAtor> personagens = f.getPersonagens();
                for (PersonagemAtor p : personagens){
                    if(p.getNomePersonagem().toLowerCase().contains(nomePersonagem.toLowerCase()) && !resultado.contains(f)){
                        resultado.add(f);
                    }
                    if(p.getAtor().getNome().toLowerCase().contains(nomeAtor.toLowerCase()) && !resultado.contains(f)){
                        resultado.add(f);
                    }
                }
            }
        }

        if(resultado.isEmpty()){
            throw new FilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return resultado;
    }

    private Integer proximoId(){
        return fakeDatabase.recuperaFilmes().size() + 1;
    }

    private boolean existeResquestDuplicada(List<PersonagemRequest> personagens){
        PersonagemRequest requestAtual;
        PersonagemRequest proximoRequest;
        for(int i = 0; i < personagens.size() - 1; i++) {
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
