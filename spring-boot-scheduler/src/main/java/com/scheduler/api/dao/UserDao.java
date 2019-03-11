package com.scheduler.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduler.api.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
