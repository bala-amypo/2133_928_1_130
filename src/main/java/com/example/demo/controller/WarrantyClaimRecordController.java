package com.example.demo.controller;

import com.example.demo.entity.WarrantyClaimRecordEntity;
import com.example.demo.service.WarrantyClaimRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class WarrantyClaimRecordController {

    private final WarrantyClaimRecordService service;

    public WarrantyClaimRecordController(WarrantyClaimRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WarrantyClaimRecordEntity> submit(
            @RequestBody WarrantyClaimRecordEntity claim) {
        return ResponseEntity.ok(service.submitClaim(claim));
    }

    @GetMapping
    public ResponseEntity<List<WarrantyClaimRecordEntity>> getAll() {
        return ResponseEntity.ok(service.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarrantyClaimRecordEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClaimById(id));
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<WarrantyClaimRecordEntity>> getBySerial(
            @PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getClaimsBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<WarrantyClaimRecordEntity> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(service.updateClaimStatus(id, status));
    }
}
