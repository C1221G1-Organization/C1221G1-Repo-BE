package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.dto.employee.AccountEmployee;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<AccountEmployee> findAccount(String name, String id, String position, String userName, Pageable pageable) {
        return iEmployeeRepository.findAccount(name, id, position, userName, pageable);
    }

    @Override
    public void updateAccount(AccountEmployee accountEmployee) {

    }
}
