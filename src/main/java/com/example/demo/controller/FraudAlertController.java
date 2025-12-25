package com.example.demo.controller;

import com.example.demo.model.FraudAlertRecord;
import com.example.demo.service.FraudAlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertController {

    private final FraudAlertService service;

    public FraudAlertController(FraudAlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FraudAlertRecord> create(@RequestBody FraudAlertRecord alert) {
        return ResponseEntity.ok(service.createAlert(alert));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<FraudAlertRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.resolveAlert(id));
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertRecord>> getAll() {
        return ResponseEntity.ok(service.getAllAlerts());
    }
}
