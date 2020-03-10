package com.example.springbootjpamysql.repository;

import com.example.springbootjpamysql.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
