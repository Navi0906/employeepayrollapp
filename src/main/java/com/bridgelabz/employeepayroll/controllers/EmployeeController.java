package com.bridgelabz.employeepayroll.controllers;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.models.Employee;
import com.bridgelabz.employeepayroll.services.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    @PostMapping("/create")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO empDTO){
        logger.info("Employee details successfully added.");
        return employeeService.createEmployee(empDTO);

    }

    @GetMapping("/get/{id}")
    public Employee showEmployee(@PathVariable(value = "id") Long id){
        logger.info("Displayed Employee with Id:{}", id);
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/get/all")
    public List<Employee> showAllEmployee(){
        logger.info("Displayed data of all employees.");
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable(value = "id") Long id){
        logger.info("Successfully deleted employee with ID:{}", id);
        return employeeService.deleteEmployee(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") Long id,@Valid @RequestBody EmployeeDTO employeeDTO){
        logger.info("Successfully Updated Employee details with Id:{}", id);
        return employeeService.updateEmployee(id,employeeDTO);
    }

}
