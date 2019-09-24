package com.metacube.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.student.dao.StudentDao;
import com.metacube.student.model.Student;
import com.metacube.student.service.StudentService;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {
	
	@Autowired
	private StudentService serviceObject;
	private List studentList;
	
	@Value("${msg}")
	private String message;

	/**
	 * Home
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/index")
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
	public String showStudent(Model model) {
		studentList = serviceObject.getAllstudent();
		model.addAttribute("studentList", studentList);
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
			BindingResult result, Model model, RedirectAttributes attribute) {
		boolean check = false;
		List<Student> allStudentList = serviceObject.getAllstudent();
		for (int i = 0; i < allStudentList.size(); i++) {
			if (allStudentList.get(i).getEmail().equals(user.getEmail())) {
				check = true;
			}
		}
		if (result.hasErrors()) {
			ObjectError objectError = new ObjectError("form",
					"Please fill all the details");
			result.addError(objectError);
			return "addStudent";
		} else if (check) {
			FieldError error = new FieldError("email", "email",
					"Email Already in use");
			result.addError(error);
			return "addStudent";
		}
		model.addAttribute("student", user);
		serviceObject.addStudentService(user);
		attribute.addFlashAttribute("message", "Student added");
		return "redirect:/index";
	}
}
