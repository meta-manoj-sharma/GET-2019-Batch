package com.metacube.student.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.student.model.Student;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {

	@Value("${msg}")
	private String message;

	/**
	 * Home
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("msg", message);
		return "index";
	}

	/**
	 * Adds the student.
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("userform", new Student());
		return "addStudent";
	}

	/**
	 * Show student.
	 * @return the string
	 */
	@RequestMapping("/showStudent")
	public String showStudent() {
		return "showStudent";
	}

	/**
	 * Do login
	 * @param user the user
	 * @param result the result
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("userform") @Validated Student user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("Error present");
			return "addStudent";
		}
		model.addAttribute("student", user);
		return "detail";
	}

	/**
	 * Form post
	 * @param student the student
	 * @return the string
	 */
	@PostMapping("/details")
	public String formPost(Student student) {
		return "detail";
	}
}
