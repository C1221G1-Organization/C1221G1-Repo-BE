package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.repository.employee.IEmployeeRepository;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    /**
     * Created by: TrungTVH
     * Date created: 5/7/2022
     * function: get medicine list dùng tạm
     */
    @Override
    public List<Employee> getList() {
        return this.iEmployeeRepository.findAll();
    }
}
