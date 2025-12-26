package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.model.StolenDeviceReport;
import com.example.demo.repository.DeviceOwnershipRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository reportRepository;
    private final DeviceOwnershipRepository deviceRepository;

    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository reportRepository,
            DeviceOwnershipRepository deviceRepository) {
        this.reportRepository = reportRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public StolenDeviceReport reportStolen(StolenDeviceReport report) {
        DeviceOwnershipRecord device = deviceRepository
                .findBySerialNumber(report.getSerialNumber())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        device.setStolen(true);
        deviceRepository.save(device);

        return reportRepository.save(report);
    }

    @Override
    public List<StolenDeviceReport> getAllReports() {
        return reportRepository.findAll();
    }
}
