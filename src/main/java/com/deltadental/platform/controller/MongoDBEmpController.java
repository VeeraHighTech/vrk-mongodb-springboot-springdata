package com.deltadental.platform.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deltadental.platform.aopconfig.LogExecutionTime;
import com.deltadental.platform.entity.Employee;
import com.deltadental.platform.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class MongoDBEmpController {

	private static final Logger logger = Logger.getLogger(MongoDBEmpController.class.getName());

	@Autowired
	EmployeeService employeeServiceImpl;
    
	 @ApiOperation(value = "Service all employees")
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Successfully retrieved the contracts.", response = MongoDBEmpController.class),
	      @ApiResponse(code = 500, message = "Internal server error.", response = Exception.class),
	      @ApiResponse(code = 404, message = "Unable to find contracts", response = Exception.class) })
	  @ResponseBody
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST, produces = "application/json")
	@LogExecutionTime
	public ResponseEntity <Object> saveAllEmployees(@RequestBody(required=false) Employee empinput) {

		logger.info("Start: saveAllEmployees ");

		employeeServiceImpl.saveEmployees();

		logger.info("End: saveAllEmployees ");

		return new ResponseEntity<Object> ("Successfully Saved",HttpStatus.OK) ;
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = "application/json")
	@LogExecutionTime
	public ResponseEntity <Object> getAllEmployees() {

		logger.info("Start: getAllEmployees ");

		List<Employee> empList = null;
		empList = employeeServiceImpl.getEmployees();

		logger.info("End: getAllEmployees ");

		return new ResponseEntity<Object> (empList,HttpStatus.OK) ;
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT, produces = "application/json")
	@LogExecutionTime
	public ResponseEntity <Object> updateAllEmployees(@RequestBody(required=false) Employee empinput) {

		logger.info("Start: updateAllEmployees ");

		employeeServiceImpl.updateEmployee();

		logger.info("End: updateAllEmployees ");

		return new ResponseEntity<Object> ("Update All Employees Successfully",HttpStatus.OK) ;
	}
    
	
	@RequestMapping(value = "/deleteAllEmployees", method = RequestMethod.DELETE, produces = "application/json")
	@LogExecutionTime
	public ResponseEntity <Object> deleteAllEmployees(@RequestBody(required=false) Employee empinput) {

		logger.info("Start: deleteAllEmployees ");

		employeeServiceImpl.deleteAllEmployees();

		logger.info("End: deleteAllEmployees ");

		return new ResponseEntity<Object> ("Deleted All Employees Successfully",HttpStatus.OK) ;
	}
	
	
	
}
