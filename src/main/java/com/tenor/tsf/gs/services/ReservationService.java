package com.tenor.tsf.gs.services;

import java.util.Optional;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenor.tsf.gs.dao.ReservationDAO;
import com.tenor.tsf.gs.dao.SalleDAO;
import com.tenor.tsf.gs.dao.UserDAO;
import com.tenor.tsf.gs.entities.Reservation;
import com.tenor.tsf.gs.entities.Salle;
import com.tenor.tsf.gs.entities.User;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ReservationService {
	
	
	@Autowired
	private ReservationDAO resDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private SalleDAO salleDAO;
	
	
	public Iterable<Reservation> getReservations() {
		Iterable<Reservation> reservations = this.resDAO.findAll();
		log.info(reservations);
		return reservations;
	}

	public Optional<Reservation> getReservationById(Long reservationId) {
		log.info(reservationId);
		Optional<Reservation> reservation = this.resDAO.findById(reservationId);
		log.info(reservation);
		return reservation;
	}

	public Reservation addReservation(Reservation reservation) {
		log.info(reservation);
		Validate.notNull(reservation);
		Optional<User> user = userDAO.findById(reservation.getUser().getId());
		log.debug(user);
		Optional<Salle> salle = salleDAO.findById(reservation.getSalle().getId());
		log.debug(salle);
		Reservation res = this.resDAO.save(reservation);
		log.info(res);
		return res;
	}

	public Reservation updateReservation(Reservation reservation) {
		log.info(reservation);
		Validate.notNull(reservation);
		this.resDAO.findById(reservation.getId());
		Optional<User> user = userDAO.findById(reservation.getUser().getId());
		log.debug(user);
		Optional<Salle> salle = salleDAO.findById(reservation.getSalle().getId());
		log.debug(salle);
		Reservation res = this.resDAO.save(reservation);
		log.info(res);
		return res;
	}

	public void deleteReservation(Reservation reservation) {
		log.info(reservation);
		this.resDAO.deleteById(reservation.getId());
		log.info("La reservation avec id = "+ reservation.getId() + " a ete supprime");
	}
	

	
	
	
	
	
	
//
//	private static final Logger LOGGER = LogManager.getLogger(ReservationService.class.getName());
//	ReservationDAO resDAO = new ReservationDAO();
//	
//	public List<Reservation> getReservations(){
//		return resDAO.getAll();
//	}
//
//	// TODO GET ROOMS AVIALABLE
//	public List<Salle> sallesDisponible(LocalDateTime dateDebut, LocalDateTime dateFin)
//			throws DateFinNotGreaterThanDateBeginException {
//		LOGGER.info(dateDebut);
//		LOGGER.info(dateFin);
//		validateParamsTime(dateDebut, dateFin);
//		List<Reservation> getReservations = ReservationDB.getReservations();
//		LOGGER.debug(getReservations);
//		List<Reservation> reservations = new ArrayList<Reservation>();
//		List<Salle> getSalles = SalleDB.getSalles();
//		LOGGER.debug(getSalles);
//		List<Salle> salles = new ArrayList<Salle>();
//		Boolean found = false;
//
//		for (Reservation reservation : getReservations) {
//			int compareValueTimeMin1 = dateDebut.compareTo(reservation.getDateDebut());
//			LOGGER.debug(compareValueTimeMin1);
//			int compareValueTimeMin2 = dateFin.compareTo(reservation.getDateDebut());
//			LOGGER.debug(compareValueTimeMin2);
//			int compareValueTimeMax1 = dateDebut.compareTo(reservation.getDateFin());
//			LOGGER.debug(compareValueTimeMax1);
//			int compareValueTimeMax2 = dateFin.compareTo(reservation.getDateFin());
//			LOGGER.debug(compareValueTimeMax2);
//			if (compareValueTimeMin1 >= 0 && compareValueTimeMin2 > 0 && compareValueTimeMax1 < 0
//					&& compareValueTimeMax2 <= 0) {
//				reservations.add(reservation);
//			}
//		}
//		LOGGER.debug(reservations);
//		LOGGER.debug("All salles = " + getSalles);
//		for (Salle salle : getSalles) {
//			LOGGER.debug("salle = " + salle);
//			for (Reservation reservation : reservations) {
//				LOGGER.debug("salle from reservation = " + reservation.getSalle().getId());
//				if (salle.getId() == reservation.getSalle().getId())
//					found = true;
//				LOGGER.debug("found = " + found);
//				if (!found) {
//					salles.add(salle);
//				}
//				found = false;
//				LOGGER.debug("found = " + found);
//			}
//		}
//		Boolean isFilling = salles.size() > 0;
//		LOGGER.info("salles = " + salles);
//		if (isFilling)
//			return salles;
//		throw new NullPointerException("Object salles is null");
//
//	}
//
//	public Reservation ReserveSalle(User user, Salle salle, LocalDateTime dateDebut, LocalDateTime dateFin)
//			throws DateFinNotGreaterThanDateBeginException, ElementNotFoundException, CreationFuncException,
//			CreationTechException, RoomNotAvialable {
//		LOGGER.info(user);
//		LOGGER.info(dateDebut);
//		LOGGER.info(dateFin);
//		validateParams(user, salle);
//		validateParamsTime(dateDebut, dateFin);
//		Reservation reservation = new Reservation();
//		List<Salle> salles = sallesDisponible(dateDebut, dateFin);
//		LOGGER.debug(salles);
//		if (salles != null) {
//			for (Salle getSalle : salles) {
//				if (salle.getId() == getSalle.getId()) {
//					reservation.setUser(user);
//					reservation.setSalle(salle);
//					reservation.setDateDebut(dateDebut);
//					reservation.setDateFin(dateFin);
//					reservation = resDAO.create(reservation);
//					LOGGER.debug(reservation);
//					return reservation;
//				}
//			}
//			throw new RoomNotAvialable("salle n'est pas disponible");
//		} else
//			throw new NullPointerException("Object salles is null");
//	}
//
//	public void annulerReservationById(Long reservationId)
//			throws ElementNotFoundException, DeleteFuncException, DeleteTechException {
//		Validate.notNull(reservationId);
//		resDAO.getElementById(reservationId);
//		resDAO.delete(reservationId);
//	}
//	
//	
//	public Reservation getReservationById(Long reservationId) throws ElementNotFoundException {
//		return resDAO.getElementById(reservationId);
//	}
//	
//	
//
//	private void validateParamsTime(LocalDateTime dateDebut, LocalDateTime dateFin)
//			throws DateFinNotGreaterThanDateBeginException {
//		LOGGER.info(dateDebut);
//		LOGGER.info(dateFin);
//		Validate.notNull(dateDebut);
//		Validate.notNull(dateFin);
//		int compareValue = dateDebut.compareTo(dateFin);
//		if (compareValue > 0 || compareValue == 0) {
//			throw new DateFinNotGreaterThanDateBeginException("ReservationSalle");
//		}
//	}
//
//	private void validateParams(User user, Salle salle) {
//		Validate.notNull(user, "Object User null");
//		Validate.notNull(salle, "Object salle null");
//	}

}
