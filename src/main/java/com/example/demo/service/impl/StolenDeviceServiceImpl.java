package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenDeviceReportRepository;
    private final DeviceOwnershipRecordRepository deviceOwnershipRecordRepository;

    // ✅ REQUIRED BY TESTS
    @Autowired
    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository stolenDeviceReportRepository,
            DeviceOwnershipRecordRepository deviceOwnershipRecordRepository
    ) {
        this.stolenDeviceReportRepository = stolenDeviceReportRepository;
        this.deviceOwnershipRecordRepository = deviceOwnershipRecordRepository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        return stolenDeviceReportRepository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return stolenDeviceReportRepository.findAll();
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return stolenDeviceReportRepository.findById(id);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serial) {
        return stolenDeviceReportRepository.findAll()
                .stream()
                .filter(r ->
                        r.getSerialNumber() != null &&
                        r.getSerialNumber().equals(serial)
                )
                .collect(Collectors.toList());
    }
}
