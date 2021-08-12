package br.com.oppus.api.controller;

import br.com.oppus.api.model.entities.Address;
import br.com.oppus.api.model.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
     AddressRepository AddressRepository;

    @GetMapping
    public Address getAddress(){
        return (Address) AddressRepository.findAll();
    }

    @PostMapping("/register")
    public Address registerAddress(Address address){
        AddressRepository.save(address);
        return address;

    }
}
