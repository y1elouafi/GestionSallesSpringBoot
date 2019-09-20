package com.tenor.tsf.gs.services;

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
public class MaterielService {

	@Autowired
	private MaterielDAO materielDAO;

	@Autowired
	private SalleDAO salleDAO;

	public Iterable<Materiel> getMateriels() {
		Iterable<Materiel> materiels = this.materielDAO.findAll();
		log.info(materiels);
		return materiels;
	}

	public Optional<Materiel> getMaterielById(Long materielId) {
		log.info(materielId);
		Optional<Materiel> materiel = this.materielDAO.findById(materielId);
		log.info(materiel);
		return materiel;
	}

	public Materiel addMateriel(Materiel materiel) {
		log.info(materiel);
		Validate.notNull(materiel);
		Salle salle = materiel.getSalle();
		log.debug(salle);
		if(salle != null){
			Optional<Salle> salle2 = this.salleDAO.findById(salle.getId());
			log.debug(salle2);
		}
		Materiel mat = this.materielDAO.save(materiel);
		log.info("materiel "+ mat + " a ete ajouter");
		return mat;
	}

	public Materiel updateMateriel(Materiel materiel) {
		log.info(materiel);
		Validate.notNull(materiel);
		this.materielDAO.findById(materiel.getId());
		Salle salle = materiel.getSalle();
		log.debug(salle);
		if(salle != null){
			Optional<Salle> salle2 = this.salleDAO.findById(salle.getId());
			log.debug(salle2);
		}
		Materiel mat = this.materielDAO.save(materiel);
		log.info("materiel "+ mat + " a ete modifie");
		return mat;
	}

	public void deleteMateriel(Materiel materiel) {
		log.info(materiel);
		this.materielDAO.deleteById(materiel.getId());
		log.info("materiel avec id = "+ materiel.getId() + " a ete supprime");
	}

	
	
	
	
	
}
	


