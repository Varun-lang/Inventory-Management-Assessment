package com.Inventory.Management.repository;

import com.Inventory.Management.entity.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepo extends CrudRepository<Inventory,Integer> {
}
