package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getEmployeeCreate
     * Note: Fix method getEmployeeCreate to run method createRetailInvoice
     * */
    @Override
    public Employee getEmployeeCreate() {
        return this.employeeRepository.getEmployeeCreate();
    }
}
