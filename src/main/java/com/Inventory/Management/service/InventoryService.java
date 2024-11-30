package com.Inventory.Management.service;

import com.Inventory.Management.entity.Inventory;
import com.Inventory.Management.repository.InventoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class InventoryService {

    InventoryRepo inventoryRepo;

    public String createItem(Inventory inventory){
        try{
            inventoryRepo.save(inventory);
        }catch (DataIntegrityViolationException e){
            return "Item already Exist!";
        }
        return "Item is added to Inventory Successfully!";
    }

    public List<Inventory> getInventory(){
        return (List<Inventory>) inventoryRepo.findAll();
    }

    public Optional<Inventory> getInventoryById(int id){
        return inventoryRepo.findById(id);
    }

    public String updateInventory(Inventory inventory){
        Optional<Inventory> inventory1 = inventoryRepo.findById(inventory.getItemId());
        if(inventory1.isPresent()){
            inventory1.get().setItemName(inventory.getItemName());
            inventory1.get().setStock(inventory.getStock());
            inventory1.get().setItemPrice(inventory.getItemPrice());
            inventoryRepo.save(inventory1.get());
            return "Inventory Updated Successfully!";
        }else{
            return "Item not found!";
        }
    }

    public String deleteInventory(int id){
        Optional<Inventory> inventory1 = inventoryRepo.findById(id);
        if(inventory1.isPresent()){
            inventoryRepo.deleteById(id);
            return "Item Deleted Successfully!";
        }else{
            return "No Item found with the provided ID!";
        }
    }

}
