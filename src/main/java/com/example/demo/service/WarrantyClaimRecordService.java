@Service
public class WarrantyClaimService {

    private final WarrantyClaimRecordRepository claimRepo;
    private final DeviceOwnershipRecordRepository ownershipRepo;
    private final StolenDeviceReportRepository stolenRepo;
    private final FraudAlertRecordRepository alertRepo;
    private final FraudRuleRepository ruleRepo;

    public WarrantyClaimService(
            WarrantyClaimRecordRepository claimRepo,
            DeviceOwnershipRecordRepository ownershipRepo,
            StolenDeviceReportRepository stolenRepo,
            FraudAlertRecordRepository alertRepo,
            FraudRuleRepository ruleRepo) {

        this.claimRepo = claimRepo;
        this.ownershipRepo = ownershipRepo;
        this.stolenRepo = stolenRepo;
        this.alertRepo = alertRepo;
        this.ruleRepo = ruleRepo;
    }

    public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

        DeviceOwnershipRecord device =
                ownershipRepo.findBySerialNumber(claim.getSerialNumber());

        if (device == null) {
            throw new IllegalArgumentException("Invalid serial number");
        }

        if (stolenRepo.findBySerialNumber(claim.getSerialNumber()) != null) {
            claim.setStatus(WarrantyClaimRecord.Status.FLAGGED);
            createAlert(claim, "STOLEN_DEVICE", "HIGH");
        }

        claim.setSubmittedAt(LocalDateTime.now());
        return claimRepo.save(claim);
    }

    private void createAlert(WarrantyClaimRecord claim, String type, String severity) {
        FraudAlertRecord alert = new FraudAlertRecord();
        alert.setClaimId(claim.getId());
        alert.setSerialNumber(claim.getSerialNumber());
        alert.setAlertType(type);
        alert.setSeverity(severity);
        alert.setMessage("Fraud risk detected");
        alert.setCreatedDate(LocalDateTime.now());
        alertRepo.save(alert);
    }
}
