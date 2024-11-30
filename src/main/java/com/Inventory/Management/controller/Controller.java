package com.Inventory.Management.controller;

import com.Inventory.Management.entity.Bill;
import com.Inventory.Management.entity.Inventory;
import com.Inventory.Management.service.BillService;
import com.Inventory.Management.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class Controller {

    InventoryService inventoryService;
    BillService billService;

    @RequestMapping(path = "/createInventory")
    public String createItem(@RequestBody Inventory inventory){
        return inventoryService.createItem(inventory);
    }

    @RequestMapping(path = "/getInventory")
    public List<Inventory> getInventory(){
        return inventoryService.getInventory();
    }

    @RequestMapping(path = "/getInventoryById/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable int id){
        return inventoryService.getInventoryById(id);
    }

    @RequestMapping(path = "/updateInventory")
    public String updateInventory(@RequestBody Inventory inventory){
        return inventoryService.updateInventory(inventory);
    }

    @RequestMapping(path = "/deleteInventoryItem/{id}")
    public String deleteInventory(@PathVariable int id){
        return inventoryService.deleteInventory(id);
    }

    @RequestMapping(path = "/createBill")
    public String createBill(@RequestBody Bill bill){
        return billService.createBill(bill);
    }

    @RequestMapping(path = "/fetchAllBills")
    public List<Bill> fetchBill(){
        return billService.getBillDetails();
    }

    @RequestMapping(path = "/fetchBill/{id}")
    public Optional<Bill> fetchBillById(@PathVariable int id){
        return billService.getBillById(id);
    }

}
