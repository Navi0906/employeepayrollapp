package com.bridgelabz.employeepayroll.controllers;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.models.Employee;
import com.bridgelabz.employeepayroll.services.EmployeeServiceImpl;
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


    @PostMapping("/create")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO empDTO){

       return employeeService.createEmployee(empDTO);

    }

    @GetMapping("/get/{id}")
    public Employee showEmployee(@PathVariable(value = "id") Long id){

        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/get/all")
    public List<Employee> showAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
