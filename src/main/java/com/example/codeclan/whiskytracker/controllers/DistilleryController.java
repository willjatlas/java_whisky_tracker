package com.example.codeclan.whiskytracker.controllers;

import com.example.codeclan.whiskytracker.models.Distillery;
import com.example.codeclan.whiskytracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping("/distilleries")
    public ResponseEntity<List<Distillery>> getDistilleryIndex(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getDistilleryById(@PathVariable Long id){
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/distilleries")
    public ResponseEntity<Distillery> createDistillery(@PathVariable Distillery distillery){
        distilleryRepository.save(distillery);
        return new ResponseEntity<>(distillery, HttpStatus.CREATED);
    }

}
