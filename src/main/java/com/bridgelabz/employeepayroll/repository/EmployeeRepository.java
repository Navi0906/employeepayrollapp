package com.bridgelabz.employeepayroll.repository;


import com.bridgelabz.employeepayroll.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
