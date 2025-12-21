package com.example.demo.service.impl;

import com.example.demo.entity.FraudRuleEntity;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.service.FraudRuleService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FraudRuleServiceImpl implements FraudRuleService {

    private final FraudRuleRepository repository;

    public FraudRuleServiceImpl(FraudRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public FraudRuleEntity createRule(FraudRuleEntity rule) {

        if (repository.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new IllegalArgumentException("Rule already exists");
        }

        return repository.save(rule);
    }

    @Override
    public FraudRuleEntity updateRule(Long id, FraudRuleEntity updatedRule) {

        FraudRuleEntity rule = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        rule.setActive(updatedRule.getActive());
        rule.setRuleType(updatedRule.getRuleType());
        rule.setDescription(updatedRule.getDescription());

        return repository.save(rule);
    }

    @Override
    public List<FraudRuleEntity> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public FraudRuleEntity getRuleByCode(String ruleCode) {

        return repository.findByRuleCode(ruleCode)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public List<FraudRuleEntity> getAllRules() {
        return repository.findAll();
    }
}
