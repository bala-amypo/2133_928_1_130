public interface WarrantyClaimRecordRepository
        extends JpaRepository<WarrantyClaimRecordEntity, Long> {

    boolean existsBySerialNumberAndClaimReason(String serialNumber, String claimReason);
    List<WarrantyClaimRecordEntity> findBySerialNumber(String serialNumber);
}
