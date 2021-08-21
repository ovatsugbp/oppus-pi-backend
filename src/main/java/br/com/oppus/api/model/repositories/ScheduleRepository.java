package br.com.oppus.api.model.repositories;

import br.com.oppus.api.model.entities.Schedule;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    Page<Schedule> findAllByProfessionalNameContaining(String subName, Pageable pageable);
}
