package br.com.oppus.api.model.repositories;

import br.com.oppus.api.model.entities.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
