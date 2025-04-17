package com.bridgelabz.employeepayroll.services;

//import com.bridgelabz.employeepayroll.dto.ResponseDTO;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.models.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
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

    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO){

        Employee emp=new Employee();
        emp.setName(employeeDTO.getName());
        emp.setSalary(employeeDTO.getSalary());

        if(emp.getName()!=null && emp.getSalary()!=null){
            employeeRepository.save(emp);
            return new ResponseEntity<>(emp,HttpStatus.CREATED);
        }

        return new ResponseEntity<>(emp,HttpStatus.BAD_REQUEST);
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()) {
            return null;
        }
        Employee empl = employee.get();
        return empl;
    }

    public ResponseEntity<Employee> updateEmployee(Long id, @RequestBody EmployeeDTO employeeDTO){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Employee emp=employee.get();
        emp.setSalary(employeeDTO.getSalary());
        emp.setName(employeeDTO.getName());
        employeeRepository.save(emp);
        return new ResponseEntity<>(emp,HttpStatus.OK);

    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public ResponseEntity<String> deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return new ResponseEntity<String>("Employee with ID:"+id+" is successfully deleted!",HttpStatus.OK);
    }
}
