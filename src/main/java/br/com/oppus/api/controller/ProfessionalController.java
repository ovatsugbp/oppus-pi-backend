package br.com.oppus.api.controller;

import br.com.oppus.api.model.entities.Professional;
import br.com.oppus.api.model.repositories.ProfessionalRepository;
import br.com.oppus.api.model.repositories.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/professionals")
public class ProfessionalController {

    private final ProfessionalRepository professionalRepository;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ProfessionalController(ProfessionalRepository professionalRepository, ScheduleRepository scheduleRepository){
        this.professionalRepository = professionalRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<Professional> registerProfessional(@RequestBody Professional professional){
        Professional savedProfessional = professionalRepository.save(professional);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProfessional.getId()).toUri();

        return ResponseEntity.created(location).body(savedProfessional);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Professional> updateProfessional(@PathVariable Integer id, @RequestBody Professional professional){
        Optional<Professional> optionalProfessional = professionalRepository.findById(id);
        if(!optionalProfessional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        professional.setId(optionalProfessional.get().getId());
        professionalRepository.save(professional);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/me/{id}")
    public ResponseEntity<Professional> deleteProfessionalData(@PathVariable Integer id){

        Optional<Professional> optionalProfessional = professionalRepository.findById(id);
        if(!optionalProfessional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        professionalRepository.delete(optionalProfessional.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me/{id}")
    public ResponseEntity<Professional> getMyProfessionalData(@PathVariable Integer id){
        Optional<Professional> optionalProfessional = professionalRepository.findById(id);
        if(!optionalProfessional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalProfessional.get());
    }

    @GetMapping
    public ResponseEntity<Page<Professional>> getAll(Pageable pageable){
        return ResponseEntity.ok(professionalRepository.findAll(pageable));
    }



}