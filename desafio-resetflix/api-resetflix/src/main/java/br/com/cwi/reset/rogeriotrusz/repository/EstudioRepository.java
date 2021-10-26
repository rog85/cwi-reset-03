package br.com.cwi.reset.rogeriotrusz.repository;

import br.com.cwi.reset.rogeriotrusz.model.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {
    List<Estudio> findAll();

    boolean existsByNomeEqualsIgnoreCase(String nome);

    List<Estudio> findByNomeContainingIgnoreCase(String nome);
}
