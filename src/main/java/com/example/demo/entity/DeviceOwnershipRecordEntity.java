;
private String ownerEmail;
private LocalDate purchaseDate;
private LocalDate warrantyExpiration;
private boolean active;
package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class DeviceOwnershipRecord {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true, nullable = false)
private String serialNumber;


private String ownerName
// getters & setters
}