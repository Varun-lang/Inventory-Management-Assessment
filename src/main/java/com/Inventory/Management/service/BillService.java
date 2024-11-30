package com.Inventory.Management.service;

import com.Inventory.Management.entity.Bill;
import com.Inventory.Management.entity.BillItems;
import com.Inventory.Management.entity.Inventory;
import com.Inventory.Management.repository.BillItemRepo;
import com.Inventory.Management.repository.BillRepo;
import com.Inventory.Management.repository.InventoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BillService {

    BillRepo billRepo;
    BillItemRepo billItemRepo;
    InventoryRepo inventoryRepo;

    public String createBill(Bill bill){
        double totalAmt = 0;
        List<BillItems> savedBillItems = new ArrayList<>();

        for (BillItems billItems : bill.getBillItems()) {
            Optional<Inventory> inventory = inventoryRepo.findById(billItems.getItemId());

            if (inventory.isPresent()) {
                BillItems billItems1 = new BillItems();
                billItems1.setItemId(billItems.getItemId());

                // Check stock availability
                if (billItems.getQuantity() > inventory.get().getStock()) {
                    return String.format("Sorry! We have only %d units of Item %d",
                            inventory.get().getStock(), inventory.get().getItemId());
                } else {
                    billItems1.setQuantity(billItems.getQuantity());
                    inventory.get().setStock(inventory.get().getStock() - billItems.getQuantity()); // Update stock
                    inventoryRepo.save(inventory.get());
                }

                billItems1.setPrice(inventory.get().getItemPrice());
                totalAmt += inventory.get().getItemPrice() * billItems.getQuantity();

                // Set Bill reference
                billItems1.setBill(bill);

                savedBillItems.add(billItems1);
            } else {
                return String.format("Item with Id: %d is not available!", billItems.getItemId());
            }
        }

        bill.setTotalAmount(totalAmt);
        bill.setBillItems(savedBillItems);
        bill.setBillDate(LocalDate.now());

        // Save the Bill
        billRepo.save(bill);

        return "Bill Created Successfully!";
    }

    public List<Bill> getBillDetails(){
       return (List<Bill>) billRepo.findAll();
    }

    public Optional<Bill> getBillById(int id){
        return billRepo.findById(id);
    }

}
