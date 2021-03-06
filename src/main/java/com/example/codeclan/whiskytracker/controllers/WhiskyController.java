package com.example.codeclan.whiskytracker.controllers;

import com.example.codeclan.whiskytracker.models.Whisky;
import com.example.codeclan.whiskytracker.repositories.WhiskyRepository;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping("/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskyIndex(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "distillery", required = false) String distillery,
            @RequestParam(name = "region", required = false) String region
    ){
        //Finding whiskies by year and distillery name.
        if (year != null && distillery != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskiesByAgeAndDistilleryName(year, distillery),
                                         HttpStatus.OK);
        }
        //Finding whiskies by year only.
        if( year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        //Finding whiskies by distillery region.
        if(region != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskiesByDistilleryRegion(region),
                                        HttpStatus.OK);
        }
        //Standard index return.
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/whiskies/{id}")
    public ResponseEntity<Optional<Whisky>> getWhiskyById(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/whiskies")
    public ResponseEntity<Whisky> createWhisky(@PathVariable Whisky whisky){
        whiskyRepository.save(whisky);
        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
    }

}
