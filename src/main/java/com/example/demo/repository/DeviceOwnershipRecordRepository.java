package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.DeviceOwnershipRecordEntity;

public interface DeviceOwnershipRecordRepository
        extends JpaRepository<DeviceOwnershipRecordEntity, Long> {}
