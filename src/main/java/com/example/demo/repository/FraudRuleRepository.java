public interface FraudRuleRepository
        extends JpaRepository<FraudRuleEntity, Long> {

    List<FraudRuleEntity> findByActiveTrue();
    Optional<FraudRuleEntity> findByRuleCode(String ruleCode);
}
