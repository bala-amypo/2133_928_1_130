package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.DeviceOwnershipRecordService;
import com.example.demo.entity.DeviceOwnershipRecordEntity;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceOwnershipRecordController {

    private final DeviceOwnershipRecordService service;

    public DeviceOwnershipRecordController(DeviceOwnershipRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeviceOwnershipRecordEntity> getAll() {
        return service.findAll();
    }
}
