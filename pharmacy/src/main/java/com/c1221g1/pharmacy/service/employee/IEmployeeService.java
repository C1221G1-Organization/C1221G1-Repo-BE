package com.c1221g1.pharmacy.service.employee;

import com.c1221g1.pharmacy.dto.employee.IAccountEmployeeDto;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeService {


    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     */
    List<IAccountEmployeeDto> findAllAccount();

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method update account, find by employee_id
     */
    void updateAccount(String password, Integer position, String id);

    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method find account by employee_id
     */
    IAccountEmployeeDto findAccountId(String id);


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    Page<IAccountEmployeeDto> findAndSearchAccount(
            String id,
            String name,
            Integer position,
            String username,
            Pageable pageable);


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    Page<IAccountEmployeeDto> findAndSearchAccount2(
            String id,
            String name,
            String username,
            Pageable pageable);


}
