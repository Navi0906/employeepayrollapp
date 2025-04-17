package com.bridgelabz.employeepayroll.services;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEmployeeService {
    ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO);

    Employee getEmployeeById(Long id);

    ResponseEntity<Employee> updateEmployee(Long id,@RequestBody EmployeeDTO employeeDTO);

    List<Employee> getAllEmployee();

    ResponseEntity<String> deleteEmployee(Long id);
}
