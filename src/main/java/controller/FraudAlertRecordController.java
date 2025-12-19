@RestController
@RequestMapping("/fraud-alert")
public class FraudAlertRecordController {
    private final FraudAlertRecordService service;
    public FraudAlertRecordController(FraudAlertRecordService service){ this.service = service; }
    @PostMapping public FraudAlertRecordEntity save(@RequestBody FraudAlertRecordEntity e){ return service.save(e); }
    @GetMapping public List<FraudAlertRecordEntity> getAll(){ return service.getAll(); }
}
