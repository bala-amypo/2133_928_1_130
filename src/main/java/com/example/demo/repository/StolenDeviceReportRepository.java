package com.example.demo.repository;

import com.example.demo.entity.StolenDeviceReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReportEntity, Long> {

    boolean existsBySerialNumber(String serialNumber);

    Optional<StolenDeviceReportEntity> findBySerialNumber(String serialNumber);
}
