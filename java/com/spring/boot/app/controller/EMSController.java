package com.spring.boot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boot.app.pojo.Employee;
import com.spring.boot.app.service.EMSService;

@Controller
@RequestMapping(value = "/EMS")
public class EMSController {
	@Autowired(required = true)
	private EMSService service;

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		List<Employee> employees = service.getAllEmployee();
		model.addAttribute("employees", employees);
		return "";
	}
}
