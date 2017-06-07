package com.spring.boot.app.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.spring.boot.app.pojo.Employee;

@Component
public class EmployeeUtility {

	private List<Employee> employees = new ArrayList<>();

	@PostConstruct
	public void initDummyValue() {
		employees.add(new Employee(143, "Basant", "IT_DEV", 10000));
		employees.add(new Employee(199, "Santosh", "IT_FS_DEV", 100000));
		employees.add(new Employee(786, "Khiladi", "IT_DEV_MASTER", 800000));
		employees.add(new Employee(719, "Manoj", "IT_UI_DEV", 20000));
	}

	public List<Employee> getAllEmployee() {
		return employees;
	}

}
