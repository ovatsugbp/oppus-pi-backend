package br.com.oppus.api.controller;

import br.com.oppus.api.model.entities.Professional;
import br.com.oppus.api.model.entities.Schedule;
import br.com.oppus.api.model.repositories.ProfessionalRepository;
import br.com.oppus.api.model.repositories.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;
    private final ProfessionalRepository professionalRepository;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository, ProfessionalRepository professionalRepository){
        this.scheduleRepository = scheduleRepository;
        this.professionalRepository = professionalRepository;
    }

    @PostMapping("/register/{profId}")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule, @PathVariable Integer profId){
        Optional<Professional> optionalProfessional = professionalRepository.findById(profId);
        if(!optionalProfessional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        schedule.setProfessional(optionalProfessional.get());

        Schedule savedSchedule = scheduleRepository.save(schedule);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedSchedule.getId()).toUri();

        return  ResponseEntity.created(location).body(savedSchedule);
    }

    @PutMapping("/update/{profId}/{schId}")
    public ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule schedule,@PathVariable Integer profId, @PathVariable Integer schId){

        Optional<Professional> optionalProfessional = professionalRepository.findById(profId);
        if(!optionalProfessional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Schedule> optionalSchedule = scheduleRepository.findById(schId);
        schedule.setProfessional(optionalProfessional.get());
        schedule.setId(optionalSchedule.get().getId());
        scheduleRepository.save(schedule);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Schedule>> getAll (Pageable pageable){
        return ResponseEntity.ok(scheduleRepository.findAll(pageable));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable Integer id){
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if (!optionalSchedule.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        scheduleRepository.delete(optionalSchedule.get());
        return ResponseEntity.noContent().build();
    }
}
