package com.example.demo.controller;

import com.example.demo.entity.FraudRule;
import com.example.demo.service.FraudRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService fraudRuleService;

    public FraudRuleController(FraudRuleService fraudRuleService) {
        this.fraudRuleService = fraudRuleService;
    }

    @PostMapping
    public FraudRule createRule(@RequestBody FraudRule rule) {
        return fraudRuleService.save(rule);
    }

    @GetMapping
    public List<FraudRule> getAllRules() {
        return fraudRuleService.getAllRules();
    }

    @GetMapping("/active")
    public List<FraudRule> getActiveRules() {
        return fraudRuleService.getActiveRules();
    }
}
