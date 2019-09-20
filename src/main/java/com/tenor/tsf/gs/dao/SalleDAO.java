package com.tenor.tsf.gs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tenor.tsf.gs.entities.Salle;

@Repository
public interface SalleDAO extends CrudRepository<Salle, Long> {

}
