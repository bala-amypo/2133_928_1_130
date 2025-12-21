package com.example.demo.service.impl;

import com.example.demo.entity.StolenDeviceReportEntity;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceReportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceReportService {

    private final StolenDeviceReportRepository stolenRepository;
    private final DeviceOwnershipRecordRepository deviceRepository;

    public StolenDeviceServiceImpl(
            StolenDeviceReportRepository stolenRepository,
            DeviceOwnershipRecordRepository deviceRepository) {
        this.stolenRepository = stolenRepository;
        this.deviceRepository = deviceRepository;
    }

    @Override
    public StolenDeviceReportEntity reportStolen(StolenDeviceReportEntity report) {

        deviceRepository.findBySerialNumber(report.getSerialNumber())
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        return stolenRepository.save(report);
    }

    @Override
    public List<StolenDeviceReportEntity> getReportsBySerial(String serialNumber) {

        return stolenRepository.findBySerialNumber(serialNumber)
                .map(List::of)
                .orElse(List.of());
    }

    @Override
    public StolenDeviceReportEntity getReportById(Long id) {

        return stolenRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Request not found"));
    }

    @Override
    public List<StolenDeviceReportEntity> getAllReports() {
        return stolenRepository.findAll();
    }
}
