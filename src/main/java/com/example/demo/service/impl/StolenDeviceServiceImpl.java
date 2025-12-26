package com.example.demo.service.impl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.StolenDeviceService;
import org.springframework.stereotype.Service;

@Service
public class StolenDeviceServiceImpl implements StolenDeviceService {

    private final DeviceOwnershipRecordRepository repository;

    public StolenDeviceServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord reportStolen(String serial) {

        DeviceOwnershipRecord device = repository.findBySerialNumber(serial)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        // FIX: mark stolen
        device.setStolen(true);
        return repository.save(device);
    }
}
