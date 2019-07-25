package com.deltadental.platform.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.deltadental.platform.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
      
	
}
