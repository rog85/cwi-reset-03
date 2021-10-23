package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorJaExistenteException;
import br.com.cwi.reset.projeto1.exception.AtorNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

    public Ator salvar(Ator ator) throws AtorJaExistenteException {
        Ator atorJaExiste = repository.findByNome(ator.getNome());
        if (atorJaExiste != null) {
            throw new AtorJaExistenteException("Ator com o nome " + ator.getNome() + " já existe");
        }
        repository.save(ator);
        return ator;
    }

    public Ator buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<Ator> buscarPorOscars(Integer oscars) {
        return repository.findByNumeroOscars(oscars);
    }

    public void deletar(Integer id) throws AtorNaoExistenteException {
        if(!repository.existsById(id)){
            throw new AtorNaoExistenteException("Ator com o id " + id + " não existe");
        }
        repository.deleteById(id);
    }

    public List<Ator> buscarPorFiltro(Integer oscars, Integer anoNascimento) {
        LocalDate dataNascimento = LocalDate.of(anoNascimento, 1, 1);
        return repository.findByNumeroOscarsGreaterThanAndDataNascimentoGreaterThan(oscars, dataNascimento);
    }
}
