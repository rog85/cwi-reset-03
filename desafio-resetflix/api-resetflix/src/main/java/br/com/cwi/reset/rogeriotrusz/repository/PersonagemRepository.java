package br.com.cwi.reset.rogeriotrusz.repository;

import br.com.cwi.reset.rogeriotrusz.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends CrudRepository<PersonagemAtor, Integer> {
}
