package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.enums.TipoAtuacao;
import br.com.cwi.reset.rogeriotrusz.exception.AtorPersonagemDuplicadoException;
import br.com.cwi.reset.rogeriotrusz.exception.CampoNaoInformadoException;
import br.com.cwi.reset.rogeriotrusz.exception.IdNaoEncontradoException;
import br.com.cwi.reset.rogeriotrusz.model.Ator;
import br.com.cwi.reset.rogeriotrusz.model.PersonagemAtor;
import br.com.cwi.reset.rogeriotrusz.repository.PersonagemAtorRepository;
import br.com.cwi.reset.rogeriotrusz.request.PersonagemAtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonagemAtorService {

    @Autowired
    private PersonagemAtorRepository repository;
    @Autowired
    private AtorService atorService;

    public PersonagemAtor criarPersonagem(PersonagemAtorRequest personagemRequest)
            throws CampoNaoInformadoException, IdNaoEncontradoException {

        Integer idAtor = personagemRequest.getIdAtor();
        String nomePersonagem = personagemRequest.getNomePersonagem();
        String descricaoPersonagem = personagemRequest.getDescricaoPersonagem();
        TipoAtuacao tipoAtuacao = personagemRequest.getTipoAtuacao();
        Ator ator = atorService.consultarAtor(idAtor);

        PersonagemAtor personagemAtor = new PersonagemAtor(ator, nomePersonagem, descricaoPersonagem, tipoAtuacao);
        repository.save(personagemAtor);
        return personagemAtor;
    }

    public void validarPersonagensAtores(List<PersonagemAtorRequest> personagensAtores)
            throws CampoNaoInformadoException, IdNaoEncontradoException, AtorPersonagemDuplicadoException {

        List<PersonagemAtorRequest> personagensAtoresValidados = new ArrayList<>();
        for (PersonagemAtorRequest p : personagensAtores) {
            atorService.consultarAtor(p.getIdAtor());
            if (personagensAtoresValidados.contains(p)) {
                throw new AtorPersonagemDuplicadoException();
            } else {
                personagensAtoresValidados.add(p);
            }
        }
    }
}
