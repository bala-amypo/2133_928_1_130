package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.FraudRuleService;
import com.example.demo.entity.FraudRuleEntity;
import java.util.List;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @GetMapping
    public List<FraudRuleEntity> getAll() {
        return service.findAll();
    }
}
