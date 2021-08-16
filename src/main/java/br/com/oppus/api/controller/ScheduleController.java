package br.com.oppus.api.controller;

import br.com.oppus.api.model.entities.Schedule;
import br.com.oppus.api.model.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping
    public Schedule getSchedule(){
        return (Schedule) scheduleRepository.findAll();
    }

    @PostMapping("/register")
    public Schedule registerSchedule(@RequestBody Schedule schedule){
        scheduleRepository.save(schedule);
        return schedule;
    }
}
