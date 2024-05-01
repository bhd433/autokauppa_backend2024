package com.example.demo.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Auto;
import com.example.demo.domain.AutoRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class CarRestController {

    // Auto repo
    @Autowired
    AutoRepository autoRepository;



    // all cars
    @GetMapping("/cars")
    public Iterable<Auto> getCars() {
        
        return autoRepository.findAll();
    }

    // car by id
    @GetMapping("/cars/{id}")
    public @ResponseBody Optional<Auto> getCarById(@PathVariable("id") Long id) {

        return autoRepository.findById(id);
    }
}