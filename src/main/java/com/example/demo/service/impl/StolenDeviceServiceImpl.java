package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.StolenDeviceReportRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final StolenDeviceReportRepository stolenDeviceReportRepository;

    public StolenDeviceServiceImpl(StolenDeviceReportRepository stolenDeviceReportRepository) {
        this.stolenDeviceReportRepository = stolenDeviceReportRepository;
    }

    @Override
    public DeviceOwnershipRecord reportStolen(DeviceOwnershipRecord device) {
        device.setStolen(true);
        return stolenDeviceReportRepository.save(device);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllReports() {
        return stolenDeviceReportRepository.findAll();
    }

    @Override
    public Optional<DeviceOwnershipRecord> getReportById(Long id) {
        return stolenDeviceReportRepository.findById(id);
    }
}
