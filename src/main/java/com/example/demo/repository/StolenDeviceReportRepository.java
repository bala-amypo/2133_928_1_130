package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.StolenDeviceReportEntity;

public interface StolenDeviceReportRepository
        extends JpaRepository<StolenDeviceReportEntity, Long> {}
