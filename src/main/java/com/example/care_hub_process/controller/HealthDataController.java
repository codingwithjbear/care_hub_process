package com.example.care_hub_process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.care_hub_process.model.HealthData;
import com.example.care_hub_process.repository.HealthDataRepository;

@RestController
@RequestMapping("/api/healthdata")
public class HealthDataController {

    @Autowired
    private HealthDataRepository healthDataRepository;

    @PostMapping("/process")
    public HealthData processHealthData(@RequestBody HealthData healthData) {
        if (healthData.getOxygenLevel() < 90) {
            System.out.println("Warning: Low oxygen level detected.");
        }
        return healthDataRepository.save(healthData);
    }
}
