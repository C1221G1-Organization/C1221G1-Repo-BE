package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getEmployeeCreate
     * Note: Fix method getEmployeeCreate to run method createRetailInvoice
     * */
    @Query(value = "select employee_id, employee_address, employee_date_start," +
            " employee_image, employee_name, employee_note, " +
            " employee_phone, flag, username, position_id " +
            " from employee" +
            " order by employee_id " +
            " asc limit 1;", nativeQuery = true)
    Employee getEmployeeCreate();
}
