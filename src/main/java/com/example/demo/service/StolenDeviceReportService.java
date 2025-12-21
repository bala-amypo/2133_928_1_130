package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.StolenDeviceReportEntity;
import com.example.demo.repository.StolenDeviceReportRepository;

@Service
public class StolenDeviceReportService {

    private final StolenDeviceReportRepository repo;

    public StolenDeviceReportService(StolenDeviceReportRepository repo) {
        this.repo = repo;
    }

    public List<StolenDeviceReportEntity> findAll() {
        return repo.findAll();
    }
}
