package com.tenor.tsf.gs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
//@Table(name="departements")
public class Departement {

	@Id
//	@Column(name="departement_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(nullable=false)
	private String libelle;

	@OneToMany
//	@Column
	private List<User> users;

}
