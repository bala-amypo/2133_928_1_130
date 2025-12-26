package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repo;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device) {
        if (repo.existsBySerialNumber(device.getSerialNumber())) {
            throw new IllegalArgumentException("Duplicate serial");
        }
        return repo.save(device);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getBySerial(String serial) {
        return repo.findBySerialNumber(serial);
    }

    @Override
    public List<DeviceOwnershipRecord> getAllDevices() {
        return repo.findAll();
    }

    @Override
    public DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active) {
        DeviceOwnershipRecord d = repo.findById(id)
                .orElseThrow(NoSuchElementException::new);
        d.setActive(active);
        return repo.save(d);
    }
}
