package com.tenor.tsf.gs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.tenor.tsf.gs.enumerations.Status;

import lombok.Data;



@Data
@Entity
//@Table(name="reclamations")
public class Reclamation {

//	@Column(name="reclamation_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(nullable=false)
	private Date dateRec;

//	@Column(nullable=false)
	@ManyToOne
	private User user;

//	@Column(nullable=false)
	@ManyToOne
	private Salle salle;

//	@Column(nullable=false)
	private Status statu;

//	@Column(nullable=false)
	private String message;

}
