package com.example.client_hub_process.repository;

import com.example.client_hub_process.model.HealthData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthDataRepository extends JpaRepository<HealthData, Long> {}