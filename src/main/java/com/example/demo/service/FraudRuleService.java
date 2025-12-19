@Service
public class FraudRuleService {

    private final FraudRuleRepository fraudRuleRepository;

    public FraudRuleService(FraudRuleRepository fraudRuleRepository) {
        this.fraudRuleRepository = fraudRuleRepository;
    }

    public List<FraudRule> activeRules() {
        return fraudRuleRepository.findAll()
                .stream()
                .filter(FraudRule::isActive)
                .toList();
    }
}
