package com.spring.boot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.app.pojo.Employee;
import com.spring.boot.app.util.EmployeeUtility;

@Service
public class EMSService {

	@Autowired(required = true)
	private EmployeeUtility utility;

	public List<Employee> getAllEmployee() {
		return utility.getAllEmployee();
	}

}
