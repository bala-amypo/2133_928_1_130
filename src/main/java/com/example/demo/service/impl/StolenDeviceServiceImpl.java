package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        return repository.save(device);
    }

    @Override
    public DeviceOwnershipRecord getBySerial(String serial) {
        return repository.findBySerialNumber(serial)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord device = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setActive(active);
        return repository.save(device);
    }
}
