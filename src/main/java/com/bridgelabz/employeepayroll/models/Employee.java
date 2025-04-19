package com.bridgelabz.employeepayroll.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;


import java.util.List;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeId;
    private String name;
    private Double salary;
    private String gender;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="employee_department", joinColumns = @JoinColumn)
    @Column(name="department")
    public List<String> departments;

}
