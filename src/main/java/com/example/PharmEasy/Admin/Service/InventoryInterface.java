package com.example.PharmEasy.Admin.Service;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.PharmEasy.Admin.Model.InventoryModel;

public interface InventoryInterface extends MongoRepository<InventoryModel, String> {
}
