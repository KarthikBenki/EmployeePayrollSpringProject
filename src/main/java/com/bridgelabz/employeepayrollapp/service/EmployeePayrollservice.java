package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollservice implements IEmployeePayrollService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee addEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmp(Employee employee) {
       if(employeeRepository.findById(employee.getId()).isPresent()){
           return employeeRepository.save(employee);
       }
       return null;
    }


    @Override
    public Employee findEmpById(Long id) {
        if (employeeRepository.findById(id).isPresent())
            return employeeRepository.findById(id).get();
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee deleteEmpById(Long id) {
        Employee employee = null;
        if (employeeRepository.findById(id).isPresent()) {
            employee = employeeRepository.findById(id).get();
            employeeRepository.deleteById(id);
        }
        return employee;
    }
}
