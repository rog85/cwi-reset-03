package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.enums.Genero;
import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.exception.*;
import br.com.cwi.reset.rogeriotrusz.model.*;
import br.com.cwi.reset.rogeriotrusz.repository.FilmeRepository;
import br.com.cwi.reset.rogeriotrusz.request.FilmeRequest;
import br.com.cwi.reset.rogeriotrusz.request.PersonagemAtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;
    @Autowired
    private DiretorService diretorService;
    @Autowired
    private EstudioService estudioService;
    @Autowired
    private PersonagemAtorService personagemAtorService;

    public void criarFilme(FilmeRequest filmeRequest)
            throws CampoNaoInformadoException, IdNaoEncontradoException,
            GeneroDuplicadoException, AtorPersonagemDuplicadoException {

        String nome = filmeRequest.getNome();
        Integer anoLancamento = filmeRequest.getAnoLancamento();
        String capaFilme = filmeRequest.getCapaFilme();
        List<Genero> generos = filmeRequest.getGeneros();
        Integer idDiretor = filmeRequest.getIdDiretor();
        Integer idEstudio = filmeRequest.getIdEstudio();
        List<PersonagemAtorRequest> personagens = filmeRequest.getPersonagens();
        String resumo = filmeRequest.getResumo();

        List<Genero> listaGeneroAux = new ArrayList<>();
        for (Genero g : generos) {
            if (!listaGeneroAux.contains(g)) {
                listaGeneroAux.add(g);
            } else {
                throw new GeneroDuplicadoException();
            }
        }

        Diretor diretor = diretorService.consultarDiretor(idDiretor);
        Estudio estudio = estudioService.consultarEstudio(idEstudio);

        personagemAtorService.validarPersonagensAtores(personagens);

        List<PersonagemAtor> personagensAtores = new ArrayList<>();
        PersonagemAtor personagemAtor;
        for (PersonagemAtorRequest p : personagens) {
            personagemAtor = personagemAtorService.criarPersonagem(p);
            personagensAtores.add(personagemAtor);
        }

        Filme filme = new Filme(nome, anoLancamento, capaFilme, generos, estudio, diretor, personagensAtores, resumo);
        repository.save(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor,
                                       String nomePersonagem, String nomeAtor) throws CadastroNaoEncontradoException, FilmeNaoEncontradoException {

        List<Filme> filmes = repository.findAll();
        if (filmes.isEmpty()) {
            throw new CadastroNaoEncontradoException(NomeEntidade.FILME);
        }

        //List<Filme> filtrado = repository.findByPersonagensNomePersonagemContainingIgnoreCase(nomePersonagem);

        List<Filme> resultado = new ArrayList<>();
        List<PersonagemAtor> personagens;

        for (Filme f : filmes) {
            if (f.getNome().toLowerCase().contains(nomeFilme.toLowerCase()) &&
                    f.getDiretor().getNome().toLowerCase().contains(nomeDiretor.toLowerCase())) {

                personagens = f.getPersonagens();
                for (PersonagemAtor p : personagens) {
                    if (p.getNomePersonagem().toLowerCase().contains(nomePersonagem.toLowerCase()) &&
                            p.getNomePersonagem().toLowerCase().contains(nomePersonagem.toLowerCase())) {

                        resultado.add(f);
                        break;
                    }
                }
            }
        }
        if (resultado.isEmpty()) {
            throw new FilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }
        return resultado;
    }

    public void removerFilme(Integer id) throws CampoNaoInformadoException, IdNaoEncontradoException {
        if(id == null){
            throw new CampoNaoInformadoException("id");
        }
        Filme filme = repository.findById(id).orElse(null);
        if(filme == null){
            throw new IdNaoEncontradoException(NomeEntidade.FILME, id);
        }

        for (PersonagemAtor p : filme.getPersonagens()){
            personagemAtorService.removerPersonagem(p);
        }

        repository.delete(filme);
    }

    public boolean diretorPossuiVinculoFilme(Diretor diretor) {
        return repository.existsByDiretor(diretor);
    }
}
