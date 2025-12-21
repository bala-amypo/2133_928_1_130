package com.example.demo.repository;

import com.example.demo.entity.DeviceOwnershipRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceOwnershipRecordRepository
        extends JpaRepository<DeviceOwnershipRecordEntity, Long> {

    boolean existsBySerialNumber(String serialNumber);

    Optional<DeviceOwnershipRecordEntity> findBySerialNumber(String serialNumber);
}
