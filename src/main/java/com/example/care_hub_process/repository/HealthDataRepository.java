package com.example.care_hub_process.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.care_hub_process.model.HealthData;

public interface HealthDataRepository extends JpaRepository<HealthData, Long> {}