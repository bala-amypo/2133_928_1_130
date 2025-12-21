package com.example.demo.controller;

import com.example.demo.entity.StolenDeviceReportEntity;
import com.example.demo.service.StolenDeviceReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stolen-devices")
public class StolenDeviceReportController {

    private final StolenDeviceReportService service;

    public StolenDeviceReportController(StolenDeviceReportService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StolenDeviceReportEntity> report(
            @RequestBody StolenDeviceReportEntity report) {
        return ResponseEntity.ok(service.reportStolen(report));
    }

    @GetMapping
    public ResponseEntity<List<StolenDeviceReportEntity>> getAll() {
        return ResponseEntity.ok(service.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StolenDeviceReportEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getReportById(id));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<StolenDeviceReportEntity>> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getReportsBySerial(serialNumber));
    }
}
