package com.c1221g1.pharmacy.service.employee;

import com.c1221g1.pharmacy.dto.employee.AccountEmployee;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<AccountEmployee> findAllAccount ();
    Page<AccountEmployee> findAccount (String name, String id, String position, String userName, Pageable pageable);
    Employee findByEmployeeId(String employeeId);
    void updateEmployeeByAccount(Integer positionId, String employeeId);
}
