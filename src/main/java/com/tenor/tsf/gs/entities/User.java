package com.tenor.tsf.gs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
//@Table(name="users")
public class User {

//	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column(nullable=false)
	private String firstName;

//	@Column(nullable=false)
	private String secondName;

//	@Column
	private String function;

//	@Column(nullable=false)
	private String pseudo;

//	@Column(nullable=false)
	private String password;

//	@Column(nullable=false)
	@ManyToOne
	private Departement departement;

}
