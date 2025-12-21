package com.example.demo.controller;

import com.example.demo.entity.FraudRuleEntity;
import com.example.demo.service.FraudRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fraud-rules")
public class FraudRuleController {

    private final FraudRuleService service;

    public FraudRuleController(FraudRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FraudRuleEntity> create(@RequestBody FraudRuleEntity rule) {
        return ResponseEntity.ok(service.createRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<FraudRuleEntity>> getAll() {
        return ResponseEntity.ok(service.getAllRules());
    }

    @GetMapping("/active")
    public ResponseEntity<List<FraudRuleEntity>> getActive() {
        return ResponseEntity.ok(service.getActiveRules());
    }

    @GetMapping("/code/{ruleCode}")
    public ResponseEntity<FraudRuleEntity> getByCode(@PathVariable String ruleCode) {
        return ResponseEntity.ok(service.getRuleByCode(ruleCode));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraudRuleEntity> update(
            @PathVariable Long id,
            @RequestBody FraudRuleEntity rule) {
        return ResponseEntity.ok(service.updateRule(id, rule));
    }
}
