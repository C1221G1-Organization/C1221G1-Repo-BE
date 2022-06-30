package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
//        iEmployeeRepository.saveEmployee(employee.getEmployeeName(), employee.getEmployeeImage(), employee.getEmployeeAddress(), employee.getEmployeePhone(), employee.getEmployeeDateStart(), employee.getEmployeeNote(), employee.getPosition(), employee.getEmployeeUsername());
        iEmployeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(Employee employee) {
        iEmployeeRepository.updateEmployee(employee.getEmployeeName(), employee.getEmployeeImage(), employee.getEmployeeAddress(), employee.getEmployeePhone(), employee.getEmployeeDateStart(), employee.getEmployeeNote(), employee.getPosition(), employee.getEmployeeUsername(), employee.getEmployeeId());
    }


//
//    @Override
//    public Employee findEmployeeById(String id) {
//        return iEmployeeRepository.finByEmployee();
//    }
}
