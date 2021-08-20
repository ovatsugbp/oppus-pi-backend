package br.com.oppus.api.model.repositories;

import br.com.oppus.api.model.entities.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

}
