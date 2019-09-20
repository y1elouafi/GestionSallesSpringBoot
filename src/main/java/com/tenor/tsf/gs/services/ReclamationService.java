package com.tenor.tsf.gs.services;

import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenor.tsf.gs.dao.ReclamationDAO;
import com.tenor.tsf.gs.dao.SalleDAO;
import com.tenor.tsf.gs.dao.UserDAO;
import com.tenor.tsf.gs.entities.Reclamation;
import com.tenor.tsf.gs.entities.Salle;
import com.tenor.tsf.gs.entities.User;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReclamationService {
	
	@Autowired
	private ReclamationDAO recDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SalleDAO salleDAO;
	
	
	public Iterable<Reclamation> getReclamations() {
		Iterable<Reclamation> reclamations = this.recDAO.findAll();
		log.info(reclamations);
		return reclamations;
	}

	public Optional<Reclamation> getReclamationById(Long reclamationId) {
		log.info(reclamationId);
		Optional<Reclamation> reclamation = this.recDAO.findById(reclamationId);
		log.info(reclamation);
		return reclamation;
	}

	public Reclamation addReclamation(Reclamation reclamation) {
		log.info(reclamation);
		Validate.notNull(reclamation);
		Optional<User> user = userDAO.findById(reclamation.getUser().getId());
		log.debug(user);
		Optional<Salle> salle = salleDAO.findById(reclamation.getSalle().getId());
		log.debug(salle);
		Reclamation rec = this.recDAO.save(reclamation);
		log.info(rec);
		return rec;
	}

	public Reclamation updateReclamation(Reclamation reclamation) {
		log.info(reclamation);
		Validate.notNull(reclamation);
		this.recDAO.findById(reclamation.getId());
		Optional<User> user = userDAO.findById(reclamation.getUser().getId());
		log.debug(user);
		Optional<Salle> salle = salleDAO.findById(reclamation.getSalle().getId());
		log.debug(salle);
		Reclamation rec = this.recDAO.save(reclamation);
		log.info(rec);
		return rec;
	}

	public void deleteReclamation(Reclamation reclamation) {
		log.info(reclamation);
		this.recDAO.deleteById(reclamation.getId());
		log.info("La reclamation avec id = "+ reclamation.getId() + " a ete supprime");
	}
	

//	private static final Logger LOGGER = LogManager.getLogger(ReclamationService.class.getName());
//	ReclamationDAO recDAO = new ReclamationDAO();
//	
//	public List<Reclamation> getReclamations(){
//		return recDAO.getAll();
//	}
//
//	public Reclamation reclame(Salle salle, User user, String message)
//			throws ElementNotFoundException, CreationFuncException, CreationTechException {
//		LOGGER.info(salle);
//		LOGGER.info(user);
//		LOGGER.info(message);
//		Reclamation rec;
//		validateParams(salle, user, message);
//
//		Reclamation reclamation = new Reclamation();
//		reclamation.setSalle(salle);
//		reclamation.setUser(user);
//		reclamation.setMessage(message);
//		reclamation.setStatu(Status.NotSee);
//		reclamation.setDateRec(new Date());
//		LOGGER.info(reclamation);
//		rec = this.recDAO.create(reclamation);
//		return rec;
//	}
//	
//	public void annulerReclamationById(Long reclamationId)
//			throws ElementNotFoundException, DeleteFuncException, DeleteTechException {
//		Validate.notNull(reclamationId);
//		recDAO.getElementById(reclamationId);
//		recDAO.delete(reclamationId);
//	}
//	
//	
//	public Reclamation updateReclamation(Reclamation reclamation) throws ElementNotFoundException, UpdateFuncException, UpdateTechException {
//		return recDAO.update(reclamation);
//	}
//	
//	public Reclamation getReclamationById(Long reclamationId) throws ElementNotFoundException {
//		return recDAO.getElementById(reclamationId);
//	}
//	
//
//	private void validateParams(Salle salle, User user, String message) throws ElementNotFoundException {
//		LOGGER.info(salle);
//		LOGGER.info(user);
//		LOGGER.info(message);
//		Boolean salleIsFound = false;
//		Boolean userIsFound = false;
//		SalleDAO salleDAO = new SalleDAO();
//		List<Salle> salles = salleDAO.getAll();
//		UserDAO userDAO = new UserDAO();
//		List<User> users = userDAO.getAll();
//
//		Validate.notNull(salle, "Reference Salle can't be null");
//		Validate.notNull(salle.getId());
//		SalleDB.getSalleById(salle.getId());
//		Validate.notNull(user, "Reference Salle can't be null");
//		Validate.notNull(user.getId());
//		UserDB.getUserById(user.getId());
//		Validate.notNull(message, "Reference message can't be null");
//		Validate.notEmpty(message);
//		for (Salle getSalle : salles) {
//			if (salle.getId() == getSalle.getId()) {
//				salleIsFound = true;
//			}
//		}
//		if (!salleIsFound)
//			throw new NullPointerException("salle introuvable");
//
//		for (User getUser : users) {
//			if (user.getId() == getUser.getId()) {
//				userIsFound = true;
//			}
//		}
//		if (!userIsFound)
//			throw new NullPointerException("user introuvable");
//	}

}
