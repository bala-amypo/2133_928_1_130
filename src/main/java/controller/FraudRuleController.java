@RestController
@RequestMapping("/fraud-rule")
public class FraudRuleController {
    private final FraudRuleService service;
    public FraudRuleController(FraudRuleService service){ this.service = service; }
    @PostMapping public FraudRuleEntity save(@RequestBody FraudRuleEntity e){ return service.save(e); }
    @GetMapping public List<FraudRuleEntity> getAll(){ return service.getAll(); }
}
