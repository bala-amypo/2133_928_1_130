public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecord, Long> {

    boolean existsBySerialNumberAndClaimantEmail(String serialNumber, String claimantEmail);
}
