package com.Inventory.Management.repository;

import com.Inventory.Management.entity.BillItems;
import org.springframework.data.repository.CrudRepository;

public interface BillItemRepo extends CrudRepository<BillItems,Integer> {
}
