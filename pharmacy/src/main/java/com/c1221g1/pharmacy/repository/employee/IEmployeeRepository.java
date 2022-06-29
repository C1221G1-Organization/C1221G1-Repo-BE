package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {
    @Query(value="select employee_id,employee_address,employee_date_start,\n" +
            "       employee_image,employee_name,employee_note,\n" +
            "       employee_phone,position_id,username,flag\n" +
            "from c1221g1_pharmacy.employee where employee_id like :employeeIdVal \n" +
            "                                 and employee_name like :employeeNameVal \n" +
            "                                 and position_id like :positionVal \n" +
            "                                 and employee_phone like :employeePhoneVal \n" +
            "                                 and employee_address like :employeeAddressVal \n" +
            "                                 and flag = 1",
    countQuery= "select employee_id,employee_address,employee_date_start,\n" +
            "       employee_image,employee_name,employee_note,\n" +
            "       employee_phone,position_id,username,flag\n" +
            "from c1221g1_pharmacy.employee where employee_id like :employeeIdVal \n" +
            "                                 and employee_name like :employeeNameVal \n" +
            "                                 and position_id like :positionVal \n" +
            "                                 and employee_phone like :employeePhoneVal \n" +
            "                                 and employee_address like :employeeAddressVal \n" +
            "                                 and flag = 1", nativeQuery = true)
    Page<Employee> getAllEmployee(String employeeIdVal, String employeeNameVal,
                                  String positionVal, String employeeAddressVal,
                                  String employeePhoneVal, Pageable pageable);

    @Query(value = "select employee_address,employee_phone,employee_name," +
            "employee_id,employee_note,employee_image,employee_date_start\n" +
            "from employee where employee_id = :id",nativeQuery=true)
    Employee findEmployeeById(Integer id);

    @Transactional
    @Modifying
    @Query(value="UPDATE employee set flag = 0 where employee_id = :id ", nativeQuery=true)
    void deleteEmployeeById(Integer id);
}
