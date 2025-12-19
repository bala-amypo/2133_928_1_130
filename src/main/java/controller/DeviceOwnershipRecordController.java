package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.service.*;

@RestController
@RequestMapping("/device-ownership")
public class DeviceOwnershipRecordController {

    private final DeviceOwnershipRecordService service;

    public DeviceOwnershipRecordController(DeviceOwnershipRecordService service) {
        this.service = service;
    }

    @PostMapping
    public DeviceOwnershipRecordEntity save(@RequestBody DeviceOwnershipRecordEntity e) {
        return service.save(e);
    }

    @GetMapping
    public List<DeviceOwnershipRecordEntity> getAll() {
        return service.getAll();
    }
}
