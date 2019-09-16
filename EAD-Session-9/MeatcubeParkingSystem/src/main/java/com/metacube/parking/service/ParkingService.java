package com.metacube.parking.service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

import com.metacube.parking.dao.EmployeeDAO;
import com.metacube.parking.dao.ParkingDAO;
import com.metacube.parking.dao.PlanDAO;
import com.metacube.parking.dao.VehicleDAO;
import com.metacube.parking.model.Employee;
import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.model.Plan;
import com.metacube.parking.model.Vehicle;

public class ParkingService {
	/**
	 * 
	 * @param employee
	 * @return boolean true
	 * @throws SQLIntegrityConstraintViolationException
	 */
	public boolean addEmployee(Employee employee) throws SQLIntegrityConstraintViolationException {

		EmployeeDAO employeeDB = new EmployeeDAO();
		try {
			employeeDB.insertEmployee(employee);
		} catch (SQLIntegrityConstraintViolationException e) {
			throw e;
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	/**
	 * 
	 * @param vehicle
	 * @param email
	 * @return boolean true
	 */
	public boolean addVehicle(Vehicle vehicle, String email) {

		VehicleDAO vehicleDB = new VehicleDAO();
		try {
			vehicleDB.insertVehicle(vehicle, email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public int getVehicleId(String email) {
		VehicleDAO vehicleDB = new VehicleDAO();
		int vehicleId = 0;
		try {
			vehicleId = vehicleDB.getVehicleId(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return vehicleId;
	}

	/**
	 * 
	 * @param plan
	 * @param email
	 * @param i
	 * @return boolean true
	 */
	public boolean addPlan(Plan plan, String email, int index) {

		PlanDAO planDB = new PlanDAO();
		try {
			planDB.insertPlan(plan, email, index);
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @return boolean true
	 */
	public boolean checkAuthentication(String email, String password) {
		ParkingDAO parkingDB = new ParkingDAO();
		boolean flag = false;
		try {
			if (parkingDB.checkAuthentication(email, password)) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public dtoEmployee getUserProfile(String email) {
		try {
			return EmployeeDAO.getUserProfile(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public LinkedList<dtoEmployee> getFriendsProfile(String email) {
		try {
			return EmployeeDAO.getFriendsProfile(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * 
	 * @param email
	 * @param dtoemployee
	 * @return boolean true
	 */
	public boolean updateEmployee(String email, dtoEmployee dtoemployee) {
		EmployeeDAO employeeDB = new EmployeeDAO();
		try {
			employeeDB.updateEmployee(email, dtoemployee);
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public String getPhotoUrl(String email) {
		try {
			return EmployeeDAO.getPhotoUrl(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * 
	 * @param url
	 * @param email
	 * @return boolean true
	 */
	public boolean updatePhotoUrl(String url, String email) {
		try {
			return EmployeeDAO.updatePhotoUrl(url, email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	/**
	 * 
	 * @param email
	 * @return
	 */
	public String getName(String email) {

		try {
			return EmployeeDAO.getName(email);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}