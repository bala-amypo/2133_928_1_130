package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.WarrantyClaimRecordService;
import com.example.demo.entity.WarrantyClaimRecordEntity;

@RestController
@RequestMapping("/warranty-claims")
public class WarrantyClaimRecordController {

    private final WarrantyClaimRecordService service;

    public WarrantyClaimRecordController(WarrantyClaimRecordService service) {
        this.service = service;
    }

    @PostMapping
    public WarrantyClaimRecordEntity submit(@RequestBody WarrantyClaimRecordEntity claim) {
        return service.submit(claim);
    }
}
