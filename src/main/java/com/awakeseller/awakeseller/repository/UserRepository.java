package com.awakeseller.awakeseller.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.awakeseller.awakeseller.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUsername(String username);

  Optional<User> findByEtsyId(Long etsyId);
}