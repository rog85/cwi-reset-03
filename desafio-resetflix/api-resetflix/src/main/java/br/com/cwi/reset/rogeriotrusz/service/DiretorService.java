package br.com.cwi.reset.rogeriotrusz.service;

import br.com.cwi.reset.rogeriotrusz.model.Diretor;
import br.com.cwi.reset.rogeriotrusz.enums.NomeEntidade;
import br.com.cwi.reset.rogeriotrusz.exception.*;
import br.com.cwi.reset.rogeriotrusz.repository.DiretorRepository;
import br.com.cwi.reset.rogeriotrusz.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;
    @Autowired
    private FilmeService filmeService;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws NomeJaCadastradoException, AnoInvalidoException {
        String nome = diretorRequest.getNome();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();

        if (repository.existsByNomeEqualsIgnoreCase(nome)) {
            throw new NomeJaCadastradoException(NomeEntidade.DIRETOR, nome);
        }
        if (anoInicioAtividade < dataNascimento.getYear()) {
            throw new AnoInvalidoException(NomeEntidade.DIRETOR);
        }

        Diretor diretor = new Diretor(nome, dataNascimento, anoInicioAtividade);
        repository.save(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome)
            throws FiltroNaoEncontradoException, CadastroNaoEncontradoException {

        List<Diretor> diretores;
        if (filtroNome == null || filtroNome.isEmpty()) {
            diretores = repository.findAll();
            if (diretores.isEmpty()) {
                throw new CadastroNaoEncontradoException(NomeEntidade.DIRETOR);
            }
        } else {
            diretores = repository.findByNomeContainingIgnoreCase(filtroNome);
            if (diretores.isEmpty()) {
                throw new FiltroNaoEncontradoException(NomeEntidade.DIRETOR, filtroNome);
            }
        }
        return diretores;
    }

    public Diretor consultarDiretor(Integer id) throws CampoNaoInformadoException, IdNaoEncontradoException {
        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }
        Diretor diretor = repository.findById(id).orElse(null);
        if (diretor == null) {
            throw new IdNaoEncontradoException(NomeEntidade.DIRETOR, id);
        }
        return diretor;
    }

    public void atualizarDiretor(Integer id, DiretorRequest diretorRequest) throws IdNaoEncontradoException, NomeJaCadastradoException, CampoNaoInformadoException {
        if(id == null){
            throw new CampoNaoInformadoException("id");
        }
        Diretor diretor = repository.findById(id).orElse(null);
        if (diretor == null) {
            throw new IdNaoEncontradoException(NomeEntidade.DIRETOR, id);
        }
        if (repository.existsByNomeEqualsIgnoreCase(diretorRequest.getNome()) &&
                !diretor.getNome().equalsIgnoreCase(diretorRequest.getNome())) {

            throw new NomeJaCadastradoException(NomeEntidade.DIRETOR, diretorRequest.getNome());
        }

        diretor.setNome(diretorRequest.getNome());
        diretor.setDataNascimento(diretorRequest.getDataNascimento());
        diretor.setAnoInicioAtividade(diretorRequest.getAnoInicioAtividade());
        repository.save(diretor);
    }

    public void removerDiretores(Integer id) throws CampoNaoInformadoException, IdNaoEncontradoException, DiretorVinculadoException {
        if(id == null){
            throw new CampoNaoInformadoException("id");
        }
        Diretor diretor = repository.findById(id).orElse(null);
        if(diretor == null){
            throw new IdNaoEncontradoException(NomeEntidade.DIRETOR, id);
        }
        if(filmeService.diretorPossuiVinculoFilme(diretor)){
            throw new DiretorVinculadoException();
        }
        repository.delete(diretor);
    }
}
