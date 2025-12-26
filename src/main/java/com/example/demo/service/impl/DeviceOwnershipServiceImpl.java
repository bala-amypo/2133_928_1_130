package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {

        // FIX: duplicate serial
        if (repository.findBySerialNumber(device.getSerialNumber()).isPresent()) {
            throw new RuntimeException("Duplicate serial");
        }

        return repository.save(device);
    }

    @Override
    public DeviceOwnershipRecord getDeviceBySerial(String serial) {
        return repository.findBySerialNumber(serial)
                .orElseThrow(() -> new NoSuchElementException("Device not found"));
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord d = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not found"));
        d.setActive(active);
        return repository.save(d);
    }
}
