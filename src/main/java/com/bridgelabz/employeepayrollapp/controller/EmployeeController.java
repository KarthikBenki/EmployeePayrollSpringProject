package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private IEmployeePayrollService employeePayrollService;


    /**
     *
     * @param employee
     * @return employee json on successful addition
     */
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeePayrollService.addEmp(employee);
    }

    /**
     *
     * @param employee
     * @return employee json on successful edition
     */
    @PutMapping("/edit")
    public Employee editEmployeeBy(@RequestBody Employee employee){
        return employeePayrollService.editEmp(employee);
    }

    /**
     *
     * @param id
     * @return returns employeejson if found in database
     */
    @GetMapping("/find/{id}")
    public Employee findEmployeeById(@PathVariable(value = "id") Long id){
        return employeePayrollService.findEmpById(id);
    }

    /**
     *
     * @return ret list of employee details
     */
    @GetMapping("/findall")
    public List<Employee> findAllEmployeeData(){
        return employeePayrollService.findAll();
    }

    /**
     *
     * @param id
     * @return employee json who got deleted
     */
    @DeleteMapping("/delete")
    public Employee deleteEmployeeById(@RequestParam Long id){
        return employeePayrollService.deleteEmpById(id);
    }
}
