package com.c1221g1.pharmacy.service.employee;

import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
import com.c1221g1.pharmacy.entity.employee.Employee;

public interface IEmployeeService {
    void saveEmployee(Employee employee);


    void updateEmployee(Employee employee);
}
