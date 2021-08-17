package br.com.oppus.api.model.repositories;

import br.com.oppus.api.model.entities.Professional;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfessionalRepository extends PagingAndSortingRepository<Professional, Integer> {

}
