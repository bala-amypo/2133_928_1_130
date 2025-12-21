@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimRecordController {

    private final WarrantyClaimService service;

    public WarrantyClaimRecordController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public WarrantyClaimRecord submit(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }
}
