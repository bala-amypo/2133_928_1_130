package com.example.demo.service.impl;

import com.example.demo.entity.DeviceOwnershipRecordEntity;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipRecordService;

import java.util.List;
import java.util.NoSuchElementException;

public class DeviceOwnershipServiceImpl implements DeviceOwnershipRecordService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecordEntity registerDevice(DeviceOwnershipRecordEntity device) {

        if (repository.existsBySerialNumber(device.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number already exists");
        }

        return repository.save(device);
    }

    @Override
    public DeviceOwnershipRecordEntity getBySerial(String serialNumber) {

        return repository.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
    }

    @Override
    public List<DeviceOwnershipRecordEntity> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecordEntity updateDeviceStatus(Long id, boolean active) {

        DeviceOwnershipRecordEntity device = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));

        device.setActive(active);
        return repository.save(device);
    }
}
