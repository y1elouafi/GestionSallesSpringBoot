package com.tenor.tsf.gs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
//@Table(name="materiels")
public class Materiel {

//	@Column(name="materiel_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(nullable=false)
	private String libelle;

//	@Column(nullable=false)
	private String categortie;

//	@Column
	@ManyToOne
	private Salle salle;

}
