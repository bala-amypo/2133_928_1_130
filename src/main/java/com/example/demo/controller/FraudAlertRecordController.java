@RestController
@RequestMapping("/api/fraud-alerts")
public class FraudAlertRecordController {

    private final FraudAlertService fraudAlertService;

    public FraudAlertRecordController(FraudAlertService fraudAlertService) {
        this.fraudAlertService = fraudAlertService;
    }

    @GetMapping
    public List<FraudAlertRecord> getAlerts() {
        return fraudAlertService.getAllAlerts();
    }
}
