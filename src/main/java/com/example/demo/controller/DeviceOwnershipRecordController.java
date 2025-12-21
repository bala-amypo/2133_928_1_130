@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipRecordController {

    private final DeviceOwnershipService deviceOwnershipService;

    public DeviceOwnershipRecordController(DeviceOwnershipService deviceOwnershipService) {
        this.deviceOwnershipService = deviceOwnershipService;
    }

    @GetMapping("/{serialNumber}")
    public DeviceOwnershipRecord getDevice(
            @PathVariable String serialNumber) {

        return deviceOwnershipService.getBySerial(serialNumber);
    }
}
