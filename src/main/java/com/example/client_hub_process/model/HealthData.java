package com.example.client_hub_process.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class HealthData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double oxygenLevel;
    private int heartRate;
    private LocalDateTime timestamp;

    public HealthData() {
        this.timestamp = LocalDateTime.now();
    }

    public void setOxygenLevel (double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    public double getOxygenLevel () {
        return this.oxygenLevel;
    }
    
    public void setHeartRate (int heartRate) {
        this.heartRate = heartRate;
    }

    public int getHeartRate () {
        return this.heartRate;
    }

    public LocalDateTime getTimestamp () {
        return this.timestamp;
    }
}