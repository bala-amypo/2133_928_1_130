package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.FraudRuleEntity;

public interface FraudRuleRepository
        extends JpaRepository<FraudRuleEntity, Long> {}
