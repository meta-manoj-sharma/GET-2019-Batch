package com.metacube.parking.service;

import static org.junit.Assert.*;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Before;
import org.junit.Test;

import com.metacube.parking.model.Employee;
import com.metacube.parking.model.Plan;
import com.metacube.parking.model.Vehicle;

public class MeatcubeParkingSystemTest {

private Employee employee = new Employee("/images/download.jpg","manoj","Male","manoj@gmail.com","1234","1234","822585626","metacube");
private Vehicle vehicle = new Vehicle("manoj@gmail.com","alto","car","8965","03","black car");
private Plan plan = new Plan("USD","6.98");
ParkingService service = new ParkingService();
	@Test
	public void testForAddEmployee() throws SQLIntegrityConstraintViolationException {
		assertEquals(true,service.addEmployee(employee));
	}
	
	@Test
	public void testForAddVehicle() {
		assertEquals(true,service.addVehicle(vehicle, employee.getEmail()));
	}
	
	@Test
	public void testForAddPlan() {
		assertEquals(true,service.addPlan(plan,employee.getEmail(), 2));
	}
	
	@Test
	public void testForCheckAuthantication() {
		assertEquals(true,service.checkAuthentication(employee.getEmail(), employee.getPassword()));
	}
	
	@Test
	public void testForUpdate() {
		assertEquals(true,service.updatePhotoUrl("/images/download1.jpg", employee.getEmail()));
	}
}
