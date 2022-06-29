package com.c1221g1.pharmacy.service.employee;

import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> getAllEmployee(String employeeIdVal, String employeeNameVal, String positionVal, String employeeAddressVal, String employeePhoneVal, Pageable pageable);

    Employee findEmployeeById(Integer id);

    void deleteEmployeeById(Integer id);
}
