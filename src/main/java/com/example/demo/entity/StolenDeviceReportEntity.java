@Entity
public class StolenDeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String reporter;
    private LocalDateTime reportDate;
    private String details;

    // getters & setters
}
