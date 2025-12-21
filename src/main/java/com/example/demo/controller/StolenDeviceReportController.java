package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.StolenDeviceReportService;
import com.example.demo.entity.StolenDeviceReportEntity;
import java.util.List;

@RestController
@RequestMapping("/stolen-devices")
public class StolenDeviceReportController {

    private final StolenDeviceReportService service;

    public StolenDeviceReportController(StolenDeviceReportService service) {
        this.service = service;
    }

    @GetMapping
    public List<StolenDeviceReportEntity> getAll() {
        return service.findAll();
    }
}
