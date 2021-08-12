package br.com.oppus.api.model.repositories;

import br.com.oppus.api.model.entities.Professional;
import org.springframework.data.repository.CrudRepository;

public interface ProfessionalRepository extends CrudRepository<Professional, Integer> {
}
