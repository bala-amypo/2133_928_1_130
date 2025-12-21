public interface FraudAlertRecordRepository
        extends JpaRepository<FraudAlertRecordEntity, Long> {
    List<FraudAlertRecordEntity> findByClaimId(Long claimId);
}
