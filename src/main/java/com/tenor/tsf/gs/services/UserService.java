package com.tenor.tsf.gs.services;

import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenor.tsf.gs.dao.UserDAO;
import com.tenor.tsf.gs.entities.Departement;
import com.tenor.tsf.gs.entities.User;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public Iterable<User> getUsers() {
		Iterable<User> users = this.userDAO.findAll();
		log.info(users);
		return users;
	}

	public Optional<User> getUserById(Long userId) {
		log.info(userId);
		Optional<User> user = this.userDAO.findById(userId);
		log.info(user);
		return user;
	}

	public User addUser(User user) {
		log.info(user);
		Validate.notNull(user);
		Departement departement = user.getDepartement();
		log.debug(departement);
		User user2 = this.userDAO.save(user);
		log.info(user2);
		return user2;
	}

	public User updateUser(User user) {
		log.info(user);
		Validate.notNull(user);
		this.userDAO.findById(user.getId());
		Departement departement = user.getDepartement();
		log.debug(departement);
		User user2 = this.userDAO.save(user);
		log.info(user2);
		return user2;
	}

	public void deleteUser(User user) {
		log.info(user);
		this.userDAO.deleteById(user.getId());
		log.info("L'utilisateur avec id = "+ user.getId() + " a ete supprime");
	}

}
