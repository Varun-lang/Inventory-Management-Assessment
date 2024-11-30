package com.Inventory.Management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    @Column(unique = true)
    private String itemName;
    private int stock;
    private double itemPrice;
}
