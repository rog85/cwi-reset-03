package br.com.cwi.reset.rogeriotrusz.repository;

import br.com.cwi.reset.rogeriotrusz.enums.StatusCarreira;
import br.com.cwi.reset.rogeriotrusz.model.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {
    List<Ator> findAll();
    boolean existsByNomeEqualsIgnoreCase(String nome);
    List<Ator> findByStatusCarreira(StatusCarreira statusCarreira);
    List<Ator> findByStatusCarreiraAndNomeContainingIgnoreCase(StatusCarreira statusCarreira, String nome);
}
