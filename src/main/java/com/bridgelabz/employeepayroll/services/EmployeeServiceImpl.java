package com.bridgelabz.employeepayroll.services;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.models.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    public static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public ResponseEntity<Employee> createEmployee(EmployeeDTO employeeDTO){

        Employee emp=new Employee();
        emp.setName(employeeDTO.getName());
        emp.setSalary(employeeDTO.getSalary());
        emp.setGender(employeeDTO.getGender());
        emp.setDepartments(employeeDTO.getDepartments());
        employeeRepository.save(emp);
        log.info("Employee Created and Saved Successfully.");
        return new ResponseEntity<>(emp,HttpStatus.CREATED);

    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) {
            log.warn("No Employee Data is present at ID:{}",id);
            return null;
        }
        Employee empl = employee.get();
        log.info("Fetching employee with ID: {}", id);
        return empl;
    }

    public ResponseEntity<Employee> updateEmployee(Long id, EmployeeDTO employeeDTO){

        Optional<Employee> empTemp = employeeRepository.findById(id);
        if(empTemp.isEmpty()){
            log.warn("Employee by Id: {} doesn't exist.",id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Employee emp=empTemp.get();

        log.debug("Updating name for employee ID {}: {}", id, employeeDTO.getName());
        emp.setName(employeeDTO.getName());

        log.debug("Updating salary for employee ID {}: {}", id, employeeDTO.getSalary());
        emp.setSalary(employeeDTO.getSalary());

        log.debug("Updating gender for employee ID {}: {}", id, employeeDTO.getGender());
        emp.setGender(employeeDTO.getGender());

        log.debug("Updating departments for employee ID {}: {}", id, employeeDTO.getDepartments());
        emp.setDepartments(employeeDTO.getDepartments());

        employeeRepository.save(emp);
        log.info("Employee with Id: {} Details updated successfully.",id);
        return new ResponseEntity<>(emp,HttpStatus.OK);

    }

    public List<Employee> getAllEmployee(){
        log.info("Fetching all the Data.");
        return employeeRepository.findAll();
    }

    public ResponseEntity<String> deleteEmployee(Long id){

        Optional<Employee> empTemp = employeeRepository.findById(id);
        if(empTemp.isEmpty()){
            log.warn("No data found at Id: {}",id);
            return new ResponseEntity<>("Employee with ID:"+id+" doesn't exist!",HttpStatus.NOT_FOUND);
        }
        employeeRepository.deleteById(id);

        log.info("Employee with ID:{} Deleted Successfully.",id);
        return new ResponseEntity<String>("Employee with ID:"+id+" is successfully deleted!",HttpStatus.OK);
    }
}
