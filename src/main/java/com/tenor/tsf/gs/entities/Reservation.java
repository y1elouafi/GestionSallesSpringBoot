package com.tenor.tsf.gs.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
//@Table(name="reservations")
public class Reservation {

//	@Column(name="reservation_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(nullable=false)
	private LocalDateTime dateDebut;

//	@Column(nullable=false)
	private LocalDateTime dateFin;

//	@Column(name="user_id")
	@ManyToOne
	private User user;

//	@Column(name="salle_id")
	@ManyToOne
	private Salle salle;

}
