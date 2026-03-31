package com.tcs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;

	public Employee saveEmployee(@RequestBody Employee emp) {
		return er.saveEmployee(emp);

	}

	public List<Employee> showEmployees() {
		return er.showEmployee();
	}

	public Employee updateEmployee(Employee emp) {

		return er.updateEmployee(emp);
	}

	public String deleteEmployee(int id) {

		return er.deleteEmployee(id);
	}

}
