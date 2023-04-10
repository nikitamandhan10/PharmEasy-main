package com.example.PharmEasy.Admin.Service;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.PharmEasy.Admin.Model.SalesModel;

public interface SalesInterface extends MongoRepository<SalesModel, Long>{
}
