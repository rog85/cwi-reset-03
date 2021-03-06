package br.com.cwi.reset.rogeriotrusz.repository;

import br.com.cwi.reset.rogeriotrusz.model.Diretor;
import br.com.cwi.reset.rogeriotrusz.model.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {
    List<Filme> findAll();

    boolean existsByDiretor(Diretor diretor);

    //List<Filme> findByNomeContainingIgnoreCase(String nome);

    //List<Filme> findByDiretorContainingIgnoreCase(String diretor);

    //List<Filme> findByPersonagensNomePersonagemContainingIgnoreCase(String nomePersonagem);
}
