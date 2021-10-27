package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.repository.AtorRepository;
import br.com.cwi.reset.rogeriotrusz.request.AtorRequest;
import br.com.cwi.reset.rogeriotrusz.model.Ator;
import br.com.cwi.reset.rogeriotrusz.response.AtorEmAtividade;
import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.enums.StatusCarreira;
import br.com.cwi.reset.rogeriotrusz.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;
    @Autowired
    private PersonagemAtorService personagemAtorService;

    public void criarAtor(AtorRequest atorRequest) throws AnoInvalidoException, NomeJaCadastradoException {
        String nome = atorRequest.getNome();
        LocalDate dataNascimento = atorRequest.getDataNascimento();
        StatusCarreira statusCarreira = atorRequest.getStatusCarreira();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();

        if (repository.existsByNomeEqualsIgnoreCase(nome)) {
            throw new NomeJaCadastradoException(NomeEntidade.ATOR, nome);
        }
        if (anoInicioAtividade < dataNascimento.getYear()) {
            throw new AnoInvalidoException(NomeEntidade.ATOR);
        }

        Ator ator = new Ator(nome, dataNascimento, statusCarreira, anoInicioAtividade);
        repository.save(ator);
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome)
            throws FiltroNaoEncontradoException, CadastroNaoEncontradoException {

        List<Ator> atores;
        if (filtroNome == null || filtroNome.isEmpty()) {
            atores = repository.findByStatusCarreira(StatusCarreira.EM_ATIVIDADE);
            if (atores.isEmpty()) {
                throw new CadastroNaoEncontradoException(NomeEntidade.ATOR);
            }
        } else {
            atores = repository.findByStatusCarreiraAndNomeContainingIgnoreCase(StatusCarreira.EM_ATIVIDADE, filtroNome);
            if (atores.isEmpty()) {
                throw new FiltroNaoEncontradoException(NomeEntidade.ATOR, filtroNome);
            }
        }

        List<AtorEmAtividade> atoresEmAtividade = new ArrayList<>();
        AtorEmAtividade atorAtividade;
        for (Ator a : atores) {
            atorAtividade = new AtorEmAtividade(a.getId(), a.getNome(), a.getDataNascimento());
            atoresEmAtividade.add(atorAtividade);
        }
        return atoresEmAtividade;
    }

    public Ator consultarAtor(Integer id) throws IdNaoEncontradoException, CampoNaoInformadoException {
        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }
        Ator ator = repository.findById(id).orElse(null);
        if (ator == null) {
            throw new IdNaoEncontradoException(NomeEntidade.ATOR, id);
        }
        return ator;
    }

    public List<Ator> consultarAtores() throws CadastroNaoEncontradoException {
        List<Ator> atores = repository.findAll();
        if (atores.isEmpty()) {
            throw new CadastroNaoEncontradoException(NomeEntidade.ATOR);
        }
        return atores;
    }

    public void atualizarAtor(Integer id, AtorRequest atorRequest)
            throws IdNaoEncontradoException, NomeJaCadastradoException {
        Ator ator = repository.findById(id).orElse(null);
        if(ator == null){
            throw new IdNaoEncontradoException(NomeEntidade.ATOR, id);
        }
        if(repository.existsByNomeEqualsIgnoreCase(atorRequest.getNome()) &&
            !ator.getNome().equalsIgnoreCase(atorRequest.getNome())){

            throw new NomeJaCadastradoException(NomeEntidade.ATOR, atorRequest.getNome());
        }

        ator.setNome(atorRequest.getNome());
        ator.setDataNascimento(atorRequest.getDataNascimento());
        ator.setStatusCarreira(atorRequest.getStatusCarreira());
        ator.setAnoInicioAtividade(atorRequest.getAnoInicioAtividade());
        repository.save(ator);
    }

    public void removerAtor(Integer id) throws CampoNaoInformadoException, IdNaoEncontradoException, AtorVinculadoException {
        if(id == null){
            throw new CampoNaoInformadoException("id");
        }
        Ator ator = repository.findById(id).orElse(null);
        if(ator == null){
            throw new IdNaoEncontradoException(NomeEntidade.ATOR, id);
        }
        if(personagemAtorService.atorPossuiVinculoPersonagem(ator)){
            throw new AtorVinculadoException();
        }

        repository.delete(ator);
    }
}
