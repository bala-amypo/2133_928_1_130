package com.example.demo.service;

import com.example.demo.entity.FraudRuleEntity;
import java.util.List;

public interface FraudRuleService {

    FraudRuleEntity createRule(FraudRuleEntity rule);

    FraudRuleEntity updateRule(Long id, FraudRuleEntity updatedRule);

    List<FraudRuleEntity> getActiveRules();

    FraudRuleEntity getRuleByCode(String ruleCode);

    List<FraudRuleEntity> getAllRules();
}
