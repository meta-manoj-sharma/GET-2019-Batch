package com.metacube.parking.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.parking.dto.dtoEmployee;
import com.metacube.parking.model.Employee;
import com.metacube.parking.model.Login;
import com.metacube.parking.model.Plan;
import com.metacube.parking.model.Vehicle;
import com.metacube.parking.service.ParkingService;

/**
 * program of parking system
 * @author Manoj Sharma 
 * Dated 16 sept. 2019
 */
@Controller
public class ParkingController {
	ParkingService service = new ParkingService();

	/**
	 * This method redirect to index page
	 * @param model object of Model class
	 * @return String name of page
	 */
	@GetMapping("/index")
	public String goToIndexPage(Model model) {
		Employee employee = new Employee();
		model.addAttribute(employee);
		return "Registration";

	}

	/**
	 * @param employee
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/addEmployee")
	public String addEmployee(
			@Validated @ModelAttribute("employee") Employee employee,
			BindingResult bindingResult, Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "Registration";
		}
		if (!employee.getPassword().equals(employee.getConfirmPassword())) {
			FieldError error = new FieldError("confirmPassword", "confirmPassword", "Password and Confirm Password should be same");
			System.out.println(error);
			bindingResult.addError(error);
			return "Registration";
		} else {
			try {
				employee.setProfilePhtotoUrl("/images/default.jpg");
				service.addEmployee(employee);
			} catch (SQLIntegrityConstraintViolationException e) {
				FieldError error = new FieldError("email", "email", "Email Already in use");
				bindingResult.addError(error);
				return "Registration";
			}
			Vehicle vehicle = new Vehicle();
			model.addAttribute(vehicle);
			session.setAttribute("Email", employee.getEmail());
			return "Vehicle";
		}
	}

	/**
	 * @param vehicle
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return string
	 */
	@PostMapping("/addVehicle")
	public String addVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle,
			BindingResult bindingResult, Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "Vehicle";
		} else {
			service.addVehicle(vehicle, (String) session.getAttribute("Email"));
			Plan plan = new Plan();
			model.addAttribute(plan);
			session.setAttribute("VehicleId", service.getVehicleId((String) session.getAttribute("Email")));
			session.setAttribute("Type", vehicle.getVehicleType());
			return "Plan";
		}
	}

	/**
	 * @param plan
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @param request
	 * @return string
	 */
	@PostMapping("/addPlan")
	public String addPlan(@Valid @ModelAttribute("plan") Plan plan,
			BindingResult bindingResult, Model model, HttpSession session,
			HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			return "Error";
		} else {
			plan.setCurrency(request.getParameter("CurrencySelect"));
			plan.setPrice(request.getParameter("TotalCost"));
			service.addPlan(plan, (String) session.getAttribute("Email"),(int) session.getAttribute("VehicleId"));
			Login login = new Login();
			model.addAttribute(login);
			return "Login";
		}
	}

	/**
	 * @param model
	 * @return string
	 */
	@GetMapping("/login")
	public String loginPage(Model model) {
		Login login = new Login();
		model.addAttribute(login);
		return "Login";
	}

	/**
	 * @param login
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return string
	 */
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model, HttpSession session) {
		if (!bindingResult.hasErrors()) {
			if (service.checkAuthentication(login.getEmail(), login.getPassword())) {
				session.setAttribute("Email", login.getEmail());
				session.setAttribute("ProfilePhotoUrl", service.getPhotoUrl(login.getEmail()));
				session.setAttribute("Name", service.getName(login.getEmail()));
				session.setAttribute("UserProfile", service.getUserProfile((String) session.getAttribute("Email")));
				session.setAttribute("FriendsProfile", service.getFriendsProfile((String) session.getAttribute("Email")));
				return "Home";
			}
		}
		return "Login";
	}

	/**
	 * @param session
	 * @return string
	 */
	@PostMapping("/updateProfilePhoto")
	public String updateProfilePhoto(
			@RequestParam("PhotoUrl") MultipartFile file,
			HttpServletRequest req, HttpSession session) {
		service.updatePhotoUrl("/images/" + file.getOriginalFilename(),
				(String) session.getAttribute("Email"));
		byte[] bytes;
		try {
			bytes = file.getBytes();
			Path path = Paths.get("C:\\EAD spring\\MeatcubeParkingSystem\\src\\main\\resources\\static\\images\\" + file.getOriginalFilename());
			Files.write(path, bytes);
			session.setAttribute("ProfilePhotoUrl", service.getPhotoUrl((String) session.getAttribute("Email")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Home";
	}


	@GetMapping("/profilePhoto")
	public String profilePhoto() {
		return "ProfilePhoto";
	}

	@GetMapping("/friends")
	public String friends() {
		return "Friends";
	}

	/**
	 * @param session
	 * @return string
	 */
	@PostMapping("/profile")
	public String profile(HttpServletRequest req, HttpSession session) {
		String email = (String) req.getParameter("EmailId");
		if (email.equals(session.getAttribute("Email"))) {
			session.setAttribute("Profile", session.getAttribute("UserProfile"));
			session.setAttribute("IsUser", true);
		} else
			session.setAttribute("Profile", service.getUserProfile(email));
		return "Profile";
	}

	/**
	 * 
	 * @param session
	 * @param model
	 * @return string
	 */
	@GetMapping("/update")
	public String update(HttpSession session, Model model) {
		dtoEmployee dtoEmployee = (dtoEmployee) session.getAttribute("UserProfile");
		model.addAttribute(dtoEmployee);
		return "Update";
	}

	/**
	 * 
	 * @param session
	 * @return string
	 */
	@GetMapping("/home")
	public String home(HttpSession session) {
		session.setAttribute("UserProfile", service.getUserProfile((String) session.getAttribute("Email")));
		session.setAttribute("FriendsProfile", service.getFriendsProfile((String) session.getAttribute("Email")));
		return "Home";
	}

	/**
	 * @param dtoEmployee
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/detailsUpdate")
	public String detailsUpdate(
			@Valid @ModelAttribute("dtoEmployee") dtoEmployee dtoEmployee,
			BindingResult bindingResult, Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			return "Update";
		} else {
			service.updateEmployee((String) session.getAttribute("Email"), dtoEmployee);
			session.setAttribute("UserProfile", service.getUserProfile((String) session.getAttribute("Email")));
			session.setAttribute("FriendsProfile", service.getFriendsProfile((String) session.getAttribute("Email")));
			return "Home";
		}
	}

	/**
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		Login login = new Login();
		model.addAttribute(login);
		session.invalidate();
		return "Login";
	}
}