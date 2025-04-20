package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "[A-Z]{1}[A-Za-z\\s]{2,}",message = "Name should have first letter capital and no number in name")
    private String name;

    @NotNull(message = "Salary is required")
    @Min(value = 10000, message = "Salary should be at least 10000")
    private Double salary;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female", message = "Gender must be Male/Female")
    private String gender;


    @NotNull(message = "department can not be null")
    @Size(min = 1, message = "At least one department must be specified")
    private List<String> departments;

    @NotNull(message = "DOB cannot be null")
    @Past(message = "must be in past")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
//    It doesnt matter if u change input format DB will save in the yyyy-MM-dd format and we cant change that
    private LocalDate dob;


}
