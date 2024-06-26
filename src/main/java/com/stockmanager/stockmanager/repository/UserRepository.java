package com.stockmanager.stockmanager.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.stockmanager.model.UserModel;

@Qualifier("Users")
@Repository
public interface UserRepository extends MongoRepository<UserModel, String>{
    Boolean existsByEmail(String email);

    UserModel findByEmail(String email);

    UserModel findByName(String name);
    
}
