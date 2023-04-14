package com.example.PharmEasy.Admin.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.PharmEasy.Admin.Model.InventoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import java.util.Collection;

public interface InventoryInterface extends MongoRepository<InventoryModel, String> {
}
