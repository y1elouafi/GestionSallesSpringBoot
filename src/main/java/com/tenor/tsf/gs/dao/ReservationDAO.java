package com.tenor.tsf.gs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tenor.tsf.gs.entities.Reservation;

@Repository
public interface ReservationDAO extends CrudRepository<Reservation, Long> {

}
