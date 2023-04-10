package com.example.PharmEasy.User.Service;

import com.example.PharmEasy.User.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserInterface extends MongoRepository<UserModel, Long> {
    @Query("{email:'?0'}")
    UserModel findItemByEmail(String email);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<UserModel> findAll(String category);

    public long count();
}
