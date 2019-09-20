package com.tenor.tsf.gs.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenor.tsf.gs.dao.DepartementDAO;
import com.tenor.tsf.gs.dao.UserDAO;
import com.tenor.tsf.gs.entities.Departement;
import com.tenor.tsf.gs.entities.User;
import com.tenor.tsf.gs.exceptions.function.ElementNotFoundException;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class DepartementService {

	@Autowired
	private DepartementDAO deptDAO;

	@Autowired
	private UserDAO userDAO;

	public Iterable<Departement> getDepartements() {
		Iterable<Departement> departements = this.deptDAO.findAll();
		log.info(departements);
		return departements;
	}

	public Optional<Departement> getDepartementById(Long departementId) {
		log.info(departementId);
		Optional<Departement> departement = this.deptDAO.findById(departementId);
		log.info(departement);
		return departement;
	}

	public Departement addDepartement(Departement departement) {
		log.info(departement);
		Validate.notNull(departement);
		Departement dept = this.deptDAO.save(departement);
		log.info(dept);
		return dept;
	}

	public Departement updateDepartement(Departement departement) throws ElementNotFoundException {
		log.info(departement);
		Validate.notNull(departement);
		Optional<Departement> depart = this.deptDAO.findById(departement.getId());
		if(depart.isPresent()) {
			Departement dept = this.deptDAO.save(departement);
			log.info(dept);
			return dept;
		}
		throw new ElementNotFoundException(" id: "+ departement.getId()+ " n'exist pas!");
	}

	public void deleteDepartement(Departement departement) {
		log.info(departement);
		this.deptDAO.deleteById(departement.getId());
		log.info("La departement avec id = "+ departement.getId() + " a ete supprime");
	}

}
