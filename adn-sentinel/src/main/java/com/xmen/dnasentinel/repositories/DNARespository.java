package com.xmen.dnasentinel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xmen.dnasentinel.repositories.dcouments.DnaDcoument;

@Repository
public interface DNARespository extends MongoRepository<DnaDcoument, String> {

}
