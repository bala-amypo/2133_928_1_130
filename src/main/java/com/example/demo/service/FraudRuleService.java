package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.FraudRuleRepository;
import com.example.demo.entity.FraudRuleEntity;
import java.util.List;

@Service
public class FraudRuleService {

    private final FraudRuleRepository repo;

    public FraudRuleService(FraudRuleRepository repo) {
        this.repo = repo;
    }

    public List<FraudRuleEntity> findAll() {
        return repo.findAll();
    }
}
