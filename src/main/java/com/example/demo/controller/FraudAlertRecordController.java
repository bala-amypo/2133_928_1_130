package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.FraudAlertRecordService;
import com.example.demo.entity.FraudAlertRecordEntity;
import java.util.List;

@RestController
@RequestMapping("/fraud-alerts")
public class FraudAlertRecordController {

    private final FraudAlertRecordService service;

    public FraudAlertRecordController(FraudAlertRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<FraudAlertRecordEntity> getAll() {
        return service.findAll();
    }
}
