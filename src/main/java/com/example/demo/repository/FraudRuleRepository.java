package com.example.demo.repository;

import com.example.demo.entity.FraudRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FraudRuleRepository
        extends JpaRepository<FraudRuleEntity, Long> {

    List<FraudRuleEntity> findByActiveTrue();

    Optional<FraudRuleEntity> findByRuleCode(String ruleCode);
}
