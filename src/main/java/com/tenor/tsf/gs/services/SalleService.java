package com.tenor.tsf.gs.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenor.tsf.gs.dao.MaterielDAO;
import com.tenor.tsf.gs.dao.SalleDAO;
import com.tenor.tsf.gs.entities.Materiel;
import com.tenor.tsf.gs.entities.Salle;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SalleService {


	@Autowired
	private SalleDAO salleDAO;

	@Autowired
	private MaterielDAO materielDAO;

	public Iterable<Salle> getSalles() {
		Iterable<Salle> salles = this.salleDAO.findAll();
		log.info(salles);
		return salles;
	}

	public Optional<Salle> getSalleById(Long salleId) {
		log.info(salleId);
		Optional<Salle> salle = this.salleDAO.findById(salleId);
		log.info(salle);
		return salle;
	}

	public Salle addSalle(Salle salle) {
		log.info(salle);
		Validate.notNull(salle);
		List<Materiel> materiels = salle.getMateriels();
		log.debug(materiels);
		for (Materiel materiel : materiels) {
			Optional<Materiel> materiel1 = this.materielDAO.findById(materiel.getId());
			log.debug(materiel1);
		}
		Salle salle2 = this.salleDAO.save(salle);
		log.info(salle2);
		return salle2;
	}

	public Salle updateSalle(Salle salle) {
		log.info(salle);
		Validate.notNull(salle);
		this.salleDAO.findById(salle.getId());
		List<Materiel> materiels = salle.getMateriels();
		log.debug(materiels);
		for (Materiel materiel : materiels) {
			Optional<Materiel> materiel2 = this.materielDAO.findById(materiel.getId());
			log.info(materiel2);
		}
		Salle salle2 = this.salleDAO.save(salle);
		log.info(salle2);
		return salle2;
	}

	public void deleteSalle(Salle salle) {
		log.info(salle);
		this.salleDAO.deleteById(salle.getId());
		log.info("La salle avec id = "+ salle.getId() + " a ete supprime");
	}
	
	
	public void addMaterielToSalle(Salle salle, Materiel materiel){

	}
	
	public void retryMaterielFromSalle(Salle salle, Long materielId){
		
	}
}
