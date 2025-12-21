package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.entity.StolenDeviceReportEntity;

@Service
public class StolenDeviceReportService {

    private final StolenDeviceReportRepository repo;

    public StolenDeviceReportService(StolenDeviceReportRepository repo) {
        this.repo = repo;
    }
}
