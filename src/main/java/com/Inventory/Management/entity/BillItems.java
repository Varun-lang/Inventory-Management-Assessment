package com.Inventory.Management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BillItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billItemsId;
    private int itemId;  //Inventory ItemId
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "bill_id", referencedColumnName = "billId")
    private Bill bill;
}
