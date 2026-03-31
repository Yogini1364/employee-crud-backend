package com.tcs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService es; 
	
	@PostMapping("save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		return es.saveEmployee(emp);
		
	}
	@GetMapping("show_all_emps")
	public List<Employee> showEmployees(){
		return es.showEmployees();
		
	}
	@PutMapping("update")
	public Employee updateEmployee(@RequestBody Employee newemp) {
		return es.updateEmployee(newemp);
		
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return es.deleteEmployee(id);
		
	}
	
}
