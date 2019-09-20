package com.tenor.tsf.gs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tenor.tsf.gs.entities.Materiel;

@Repository
public interface MaterielDAO extends CrudRepository<Materiel, Long> {

}
