package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface DeviceOwnershipRecordRepository
        extends JpaRepository<DeviceOwnershipRecordEntity, Long> {

    boolean existsBySerialNumber(String serialNumber);
    Optional<DeviceOwnershipRecordEntity> findBySerialNumber(String serialNumber);
}
