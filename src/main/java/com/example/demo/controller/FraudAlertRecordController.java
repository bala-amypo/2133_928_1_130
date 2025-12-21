package com.example.demo.controller;

import com.example.demo.entity.FraudAlertRecordEntity;
import com.example.demo.service.FraudAlertRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-alerts")
public class FraudAlertRecordController {

    private final FraudAlertRecordService service;

    public FraudAlertRecordController(FraudAlertRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FraudAlertRecordEntity> create(
            @RequestBody FraudAlertRecordEntity alert) {
        return ResponseEntity.ok(service.createAlert(alert));
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertRecordEntity>> getAll() {
        return ResponseEntity.ok(service.getAllAlerts());
    }

    @GetMapping("/claim/{claimId}")
    public ResponseEntity<List<FraudAlertRecordEntity>> getByClaim(
            @PathVariable Long claimId) {
        return ResponseEntity.ok(service.getAlertsByClaim(claimId));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<FraudAlertRecordEntity>> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getAlertsBySerial(serialNumber));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<FraudAlertRecordEntity> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.resolveAlert(id));
    }
}
