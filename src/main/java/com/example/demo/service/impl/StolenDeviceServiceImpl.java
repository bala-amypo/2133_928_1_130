package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenRepo;
    private final DeviceOwnershipRecordRepository deviceRepo;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenRepo,
                                   DeviceOwnershipRecordRepository deviceRepo) {
        this.stolenRepo = stolenRepo;
        this.deviceRepo = deviceRepo;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        if (deviceRepo.findBySerialNumber(report.getSerialNumber()).isEmpty()) {
            throw new NoSuchElementException();
        }
        return stolenRepo.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenRepo.findAll();
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return stolenRepo.findBySerialNumber(serial);
    }
}
