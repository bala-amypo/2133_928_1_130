@RestController
@RequestMapping("/api/devices")
public class DeviceOwnershipController {

    private final DeviceOwnershipService deviceOwnershipService;

    public DeviceOwnershipController(DeviceOwnershipService deviceOwnershipService) {
        this.deviceOwnershipService = deviceOwnershipService;
    }

    @GetMapping("/{serialNumber}")
    public DeviceOwnershipRecord getDevice(
            @PathVariable String serialNumber) {

        return deviceOwnershipService.getBySerial(serialNumber);
    }
}
