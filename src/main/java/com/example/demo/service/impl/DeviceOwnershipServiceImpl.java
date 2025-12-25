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

    // ✅ MUST MATCH INTERFACE
    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord record) {
        return repository.save(record);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repository.findAll();
    }

    @Override
    public DeviceOwnershipRecord getBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord record = repository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        record.setActive(active);
        return repository.save(record);
    }
}
