package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.enums.StatusAtividade;
import br.com.cwi.reset.rogeriotrusz.exception.*;
import br.com.cwi.reset.rogeriotrusz.model.Estudio;
import br.com.cwi.reset.rogeriotrusz.repository.EstudioRepository;
import br.com.cwi.reset.rogeriotrusz.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository repository;

    public void criarEstudio(EstudioRequest estudioRequest) throws NomeJaCadastradoException {
        String nome = estudioRequest.getNome();
        String descricao = estudioRequest.getDescricao();
        LocalDate dataCriacao = estudioRequest.getDataCriacao();
        StatusAtividade statusAtividade = estudioRequest.getStatusAtividade();

        if (repository.existsByNomeEqualsIgnoreCase(nome)) {
            throw new NomeJaCadastradoException(NomeEntidade.ESTUDIO, nome);
        }

        Estudio estudio = new Estudio(nome, descricao, dataCriacao, statusAtividade);
        repository.save(estudio);
    }

    public List<Estudio> consultarEstudios(String filtroNome)
            throws CadastroNaoEncontradoException, FiltroNaoEncontradoException {

        List<Estudio> estudios;

        if (filtroNome == null || filtroNome.isEmpty()) {
            estudios = repository.findAll();
            if (estudios.isEmpty()) {
                throw new CadastroNaoEncontradoException(NomeEntidade.ESTUDIO);
            }
        } else {
            estudios = repository.findByNomeContainingIgnoreCase(filtroNome);
            if (estudios.isEmpty()) {
                throw new FiltroNaoEncontradoException(NomeEntidade.ESTUDIO, filtroNome);
            }
        }
        return estudios;
    }

    public Estudio consultarEstudio(Integer id)
            throws CampoNaoInformadoException, IdNaoEncontradoException {
        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }
        Estudio estudio = repository.findById(id).orElse(null);
        if (estudio == null) {
            throw new IdNaoEncontradoException(NomeEntidade.ESTUDIO, id);
        }
        return estudio;
    }
}
