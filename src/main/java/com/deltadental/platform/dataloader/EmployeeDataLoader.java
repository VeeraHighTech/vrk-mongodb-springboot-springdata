package com.deltadental.platform.dataloader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.deltadental.platform.entity.Address;
import com.deltadental.platform.entity.Employee;

public class EmployeeDataLoader {

	public static List<Employee> generateEmployeeList(){
		
		List<Employee> empList = new ArrayList<>();
			
			for(long i=1; i<=30; i++) {
				
				Employee emp = new Employee();
				emp.setId(String.valueOf(i));
				emp.setDepartment("Delta Dental");
				emp.setType("Delta Dental TECH");
				
				if(i<=5 && i<6) {
					emp.setName("Veerraju");
				}else if(i>=6 && i<11){
					emp.setName("Satya");
				}
				else if(i>=11 && i<16){
					emp.setName("Soma");
				}
				else if(i>=16 && i<21){
					emp.setName("Raghu");
				}
				else if(i>=21 && i<26){
					emp.setName("Naresh");
				}else {
					emp.setName("Bhaskar");
				}
				emp.setDepartment("MicroServices and Spring JPA");
				
				Address add = new Address();
				add.setId(i);
				add.setStreet1("Hitech City beside Techm");
				add.setStreet1("Hitech City Cyber Gate way");
				add.setCity("Hiderabad");
				add.setState("Hyderabad");
				add.setCountry("INDIA");
				add.setZipCode("500034");
				emp.setAddress(Arrays.asList(add));
				empList.add(emp);
				
			}	
			return empList;
		}
}
