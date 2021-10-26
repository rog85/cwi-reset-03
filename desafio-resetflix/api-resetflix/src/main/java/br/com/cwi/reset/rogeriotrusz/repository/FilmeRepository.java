package br.com.cwi.reset.rogeriotrusz.repository;

import br.com.cwi.reset.rogeriotrusz.model.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {
}
