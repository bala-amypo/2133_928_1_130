package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;

import java.util.List;
import java.util.Optional;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord registerDevice(DeviceOwnershipRecord device);

    /**
     * MUST return Optional — tests expect Optional.empty() when not found
     */
    Optional<DeviceOwnershipRecord> getBySerial(String serial);

    List<DeviceOwnershipRecord> getAllDevices();

    DeviceOwnershipRecord updateDeviceStatus(Long id, boolean active);
}
