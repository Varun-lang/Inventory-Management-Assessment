package com.Inventory.Management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billId;
    private LocalDate billDate;
    private double totalAmount;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bill")
    private List<BillItems> billItems;
}
