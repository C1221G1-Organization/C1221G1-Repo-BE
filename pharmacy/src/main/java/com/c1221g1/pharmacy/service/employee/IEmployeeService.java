package com.c1221g1.pharmacy.service.employee;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> getAllEmployee(String employeeIdVal, String employeeNameVal, String positionVal, String employeeAddressVal, String employeePhoneVal, Pageable pageable);

    Employee findEmployeeById(String id);

    void deleteEmployeeById(String id);

    List<Employee> getListEmployee();

/*
  Created by TamNA
  Time: 13:35:00 01/07/2022
  Function: Save Emoloyee
*/
    void saveEmployee(Employee employee);

/*
  Created by TamNA
  Time: 13:35:00 01/07/2022
  Function: Update Emoloyee
*/
    void updateEmployee(Employee employee);
}
