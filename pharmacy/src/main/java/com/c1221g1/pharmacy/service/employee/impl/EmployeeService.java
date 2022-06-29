package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.dto.employee.AccountEmployee;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public List<AccountEmployee> findAllAccount() {
        return iEmployeeRepository.findAllAccount();
    }
}
