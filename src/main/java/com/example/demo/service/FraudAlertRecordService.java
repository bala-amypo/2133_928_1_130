package com.example.demo.service;

import com.example.demo.entity.FraudAlertRecordEntity;
import java.util.List;

public interface FraudAlertRecordService {

    FraudAlertRecordEntity createAlert(FraudAlertRecordEntity alert);

    FraudAlertRecordEntity resolveAlert(Long id);

    List<FraudAlertRecordEntity> getAlertsBySerial(String serialNumber);

    List<FraudAlertRecordEntity> getAlertsByClaim(Long claimId);

    List<FraudAlertRecordEntity> getAllAlerts();
}
