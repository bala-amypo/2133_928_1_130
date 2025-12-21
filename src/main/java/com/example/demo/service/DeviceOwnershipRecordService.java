package com.example.demo.service;

import com.example.demo.entity.DeviceOwnershipRecordEntity;
import java.util.List;

@Service
public interface DeviceOwnershipRecordService {

    DeviceOwnershipRecordEntity registerDevice(DeviceOwnershipRecordEntity device);

    DeviceOwnershipRecordEntity getBySerial(String serialNumber);

    List<DeviceOwnershipRecordEntity> getAllDevices();

    DeviceOwnershipRecordEntity updateDeviceStatus(Long id, boolean active);
}
