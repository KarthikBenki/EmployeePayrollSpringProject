package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollserviceImpl implements IEmployeePayrollService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee addEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmp(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isPresent()) {
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


    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
    /**
     * service class for employee payroll data
     * @return
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollDataList.get(empId-1);//as arraylist index is starts from 0
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        //employeePayrollDataList.size()+1 because size will be 0 initially
        employeePayrollData = new EmployeePayrollData(employeePayrollDataList.size()+1, employeePayrollDTO);
        employeePayrollDataList.add(employeePayrollData);//adds in employee list
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(employeePayrollDTO.name);
        employeePayrollData.setSalary(employeePayrollDTO.salary);
        employeePayrollDataList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataList.remove(empId-1);
    }
}
