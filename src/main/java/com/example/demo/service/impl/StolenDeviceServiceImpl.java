package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    // ✅ EXISTING constructor (KEEP – Spring uses this)
    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenRepo) {
        this.stolenRepo = stolenRepo;
        this.deviceRepo = null;
    }

    // ✅ REQUIRED by tests (DO NOT REMOVE)
    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository stolenRepo,
            DeviceOwnershipRecordRepository deviceRepo
    ) {
        this.stolenRepo = stolenRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport save(StolenDeviceReport report) {
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

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return stolenRepo.findBySerialNumber(serial);
    }
}
