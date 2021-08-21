package br.com.oppus.api.model.repositories;

import br.com.oppus.api.model.entities.Professional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

//    Page<Professional> findAllByNameActivityAndAvailableDay(String subName, String avDay, Pageable pageable);
}
