package com.tenor.tsf.gs.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tenor.tsf.gs.entities.Departement;
import com.tenor.tsf.gs.exceptions.function.ElementNotFoundException;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class DepartementServiceTest {
	
	
	@Autowired
	private DepartementService deptService;
	
	
	@Test
	public void addDepartementCaseSuccess() {
		Departement dept = new Departement();
		dept.setLibelle("developpement");
		Departement output = deptService.addDepartement(dept);
		assertNotNull(output);
	}
	
	@Test(expected = NullPointerException.class)
	public void addDepartementCaseEchec() {
		deptService.addDepartement(null);
	}
	
	@Test
	public void updateDepartementCaseSuccess() throws ElementNotFoundException
	{
		Departement dept = new Departement();
		dept.setLibelle("developpement");
		Departement dept1 = deptService.addDepartement(dept);
		dept1.setLibelle("Dist");
		Departement output = deptService.updateDepartement(dept1);
		assertNotNull(output);
		assertEquals(dept1, output);
	}
	
	
	@Test(expected = NullPointerException.class)
	public void updateDepartementCaseNull() throws ElementNotFoundException {
		deptService.updateDepartement(null);
	}
	
	@Test(expected = ElementNotFoundException.class)
	public void updateDepartementCaseNotFoundId() throws ElementNotFoundException {
		Departement dept = new Departement();
		dept.setId(55L);
		deptService.updateDepartement(dept);
	}

}
