package com.deltadental.platform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deltadental.platform.aopconfig.LogExecutionTime;
import com.deltadental.platform.dataloader.EmployeeDataLoader;
import com.deltadental.platform.entity.Employee;
import com.deltadental.platform.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@LogExecutionTime
	public List<Employee> getEmployees() {

		List<Employee> empList = null;
		try {
			empList = employeeRepository.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return empList;
	}

	@Override
	@LogExecutionTime
	public void saveEmployees() {

		List<Employee> empList = new ArrayList<>();
		empList = EmployeeDataLoader.generateEmployeeList();
		employeeRepository.saveAll(empList);

	}

	@Override
	@LogExecutionTime
	public void updateEmployee() {

		List<Employee> empList = null;
		try {

			empList = employeeRepository.findAll();

			for (Employee emp : empList) {

				String state = emp.getDepartment();
				emp.setDepartment(state + "  ******"+ 250);
				employeeRepository.save(emp);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	@Override
	@LogExecutionTime
	public void deleteAllEmployees() {
		 employeeRepository.deleteAll();;
	}

}
