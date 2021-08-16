package br.com.oppus.api.controller;

import br.com.oppus.api.model.entities.Professional;
import br.com.oppus.api.model.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/professional")
public class ProfessionalController {

    @Autowired
    ProfessionalRepository professionalRepository;

    @PostMapping("/register")
    public Professional registerProfessional(@RequestBody Professional professional){
        professionalRepository.save(professional);
        return professional;
    }

    @PutMapping("/update")
    public Professional updateProfessional(@RequestBody Professional professional){
        professionalRepository.save(professional);
        return professional;
    }

}