package com.tenor.tsf.gs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tenor.tsf.gs.entities.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

}
