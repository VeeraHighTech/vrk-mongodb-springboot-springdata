package com.deltadental.platform.service;

import java.util.List;

import com.deltadental.platform.entity.Employee;

public interface EmployeeService {
  
	  public List<Employee> getEmployees();
	  public void saveEmployees();
	  public void updateEmployee();
	  public void deleteAllEmployees();
	 
}
