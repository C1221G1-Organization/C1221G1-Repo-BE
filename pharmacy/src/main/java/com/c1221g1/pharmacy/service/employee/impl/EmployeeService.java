package com.c1221g1.pharmacy.service.employee.impl;

import com.c1221g1.pharmacy.entity.employee.Employee;
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
    public Page<Employee> getAllEmployee(String employeeIdVal, String employeeNameVal,
                                         String positionVal, String employeeAddressVal, String employeePhoneVal, Pageable pageable) {
        return this.iEmployeeRepository.getAllEmployee(
                "%" + employeeIdVal + "%",
                "%" + employeeNameVal + "%",
                "%" + positionVal + "%",
                "%" + employeeAddressVal + "%",
                "%"+employeePhoneVal+"%", pageable);
    }

    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @Override
    public Employee findEmployeeById(String id) {
        return this.iEmployeeRepository.findEmployeeById(id);
    }

    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 17:00 29/06/2022
     */
    @Override
    public void deleteEmployeeById(String id) {
        this.iEmployeeRepository.deleteEmployeeById(id);
    }


    /**
     * this function use to get all list Employee
     *
     * @author GiangTB
     * @Time 16:00 29/06/2022
     */
    @Override
    public List<Employee> getListEmployee() {
        return this.iEmployeeRepository.getListEmployee();
    }
}
