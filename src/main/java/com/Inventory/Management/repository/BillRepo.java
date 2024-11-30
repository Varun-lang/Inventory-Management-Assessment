package com.Inventory.Management.repository;

import com.Inventory.Management.entity.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill,Integer> {
}
