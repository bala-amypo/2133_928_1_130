package com.example.demo.controller;

import com.example.demo.entity.DeviceOwnershipRecordEntity;
import com.example.demo.service.DeviceOwnershipRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipRecordController {

    private final DeviceOwnershipRecordService service;

    public DeviceOwnershipRecordController(DeviceOwnershipRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DeviceOwnershipRecordEntity> register(
            @RequestBody DeviceOwnershipRecordEntity device) {
        return ResponseEntity.ok(service.registerDevice(device));
    }

    @GetMapping
    public ResponseEntity<List<DeviceOwnershipRecordEntity>> getAll() {
        return ResponseEntity.ok(service.getAllDevices());
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<DeviceOwnershipRecordEntity> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DeviceOwnershipRecordEntity> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateDeviceStatus(id, active));
    }
}
