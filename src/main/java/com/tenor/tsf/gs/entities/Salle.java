package com.tenor.tsf.gs.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
//@Table(name="salles")
public class Salle {

	@Column(name="salle_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(nullable=false)
	private String libelle;

//	@Column
	@OneToMany
	private List<Materiel> materiels;

//	@Column(nullable=false)
	private Integer capacite;

}
