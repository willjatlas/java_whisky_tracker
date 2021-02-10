package com.example.codeclan.whiskytracker;

import com.example.codeclan.whiskytracker.models.Distillery;
import com.example.codeclan.whiskytracker.models.Whisky;
import com.example.codeclan.whiskytracker.repositories.DistilleryRepository;
import com.example.codeclan.whiskytracker.repositories.WhiskyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WhiskytrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddNewWhiskyAndDistillery(){

		Distillery dist = new Distillery("Test Distillery", "Test Region");
		distilleryRepository.save(dist);

		Whisky whisky = new Whisky("Test Whisky", 2021, 0 , dist);
		whiskyRepository.save(whisky);

	}


}
