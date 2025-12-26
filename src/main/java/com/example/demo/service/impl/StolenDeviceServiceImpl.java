package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenRepo) {
        this.stolenRepo = stolenRepo;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return stolenRepo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepo.findAll();
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return stolenRepo.findById(id);
    }

    /* =========================================================
       🔧 FIX: MISSING METHOD REQUIRED BY INTERFACE
       ========================================================= */

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return stolenRepo.findBySerialNumber(serialNumber);
    }
}
