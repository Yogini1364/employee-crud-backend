package com.tcs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

	@Autowired
	private SessionFactory sf; 
	
	
	public Employee saveEmployee(Employee emp) {
		
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(emp);
		tr.commit();
		s.close();
		return emp;
	}
	
	public List<Employee> showEmployee(){
		Session s=sf.openSession();
		List<Employee>allemp=s.createCriteria(Employee.class).list();
		return allemp;
	}
	public Employee updateEmployee(Employee newemp) {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Employee exemp=s.get(Employee.class, newemp.getId());
		exemp.setName(newemp.getName());
		exemp.setRole(newemp.getRole());
		exemp.setSalary(newemp.getSalary());
		s.save(exemp);
		tr.commit();
		s.close();
		return exemp;
	} 
	public String deleteEmployee(int id) {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Employee emp=s.load(Employee.class, id);
		s.delete(emp);
		tr.commit();
		s.close();
		return id+" id employee deleted Succsessfully..";
	}
	
}
