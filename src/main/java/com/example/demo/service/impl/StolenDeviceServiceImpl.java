package com.example.demo.service.impl;

import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository reportRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository reportRepository,
                                   DeviceOwnershipRecordRepository deviceRepository) {
        this.reportRepository = reportRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        if (!deviceRepository.existsBySerialNumber(report.getSerialNumber())) {
            throw new NoSuchElementException("Device not found");
        }
        return reportRepository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getReportsBySerial(String serialNumber) {
        return reportRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Optional<StolenDeviceReport> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return reportRepository.findAll();
    }
}
