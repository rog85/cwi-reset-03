package br.com.cwi.reset.rogeriotrusz.repository;

import br.com.cwi.reset.rogeriotrusz.model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {
    List<Diretor> findAll();

    boolean existsByNomeEqualsIgnoreCase(String nome);

    List<Diretor> findByNomeContainingIgnoreCase(String nome);
}
