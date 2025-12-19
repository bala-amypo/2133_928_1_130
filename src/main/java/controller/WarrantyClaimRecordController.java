@RestController
@RequestMapping("/warranty-claim")
public class WarrantyClaimRecordController {
    private final WarrantyClaimRecordService service;
    public WarrantyClaimRecordController(WarrantyClaimRecordService service){ this.service = service; }
    @PostMapping public WarrantyClaimRecordEntity save(@RequestBody WarrantyClaimRecordEntity e){ return service.save(e); }
    @GetMapping public List<WarrantyClaimRecordEntity> getAll(){ return service.getAll(); }
}
