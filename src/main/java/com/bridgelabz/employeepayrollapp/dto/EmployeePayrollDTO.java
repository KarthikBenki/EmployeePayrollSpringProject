/**
 * EmployeePayrollDTO.java
 */

package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;


public @ToString class  EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
    @NotEmpty(message = "Employee name cannot be null")
    public String name;
    @Min(value = 500, message = "min wage should be more than 500")
    public long salary;

    public String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    public LocalDate startDate;

    public String note;

    public String profilePic;

    public List<String> departments;


}
