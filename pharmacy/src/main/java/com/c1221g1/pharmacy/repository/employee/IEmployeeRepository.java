package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.dto.employee.AccountEmployee;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`,\n" +
            "p.position_name `positionName`, e.username `username`, u.`password` as `password`\n" +
            "from employee e left join users u on e.username =  u.username left join position p on p.position_id = e.position_id group by e.employee_id",nativeQuery=true)
    List<AccountEmployee> findAllAccount();


    @Query(value = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`,\n" +
            "p.position_name `positionName`, e.username `username`, u.`password` as `password`\n" +
            "from employee e left join users u on e.username =  u.username left join position p on p.position_id = e.position_id group by e.employee_id",
            countQuery = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`,\n" +
                    "       p.position_name `positionName`, e.username `userame`, u.`password` as `password`\n" +
                    "from employee e left join users u on e.username =  u.username left join position p on p.position_id = e.position_id group by e.employee_id",
            nativeQuery = true)
    Page<AccountEmployee> findAccount(String name, String idEmployee, String position, String userName, Pageable pageable);



    @Query(value = "select * from employee where :id in ( e.employee_id as `employeeId` from employee e )",nativeQuery = true)
    Employee findEmployeeById(String id);

    @Query(value = "update employee set position_id = :positionId where employee_id = :id",nativeQuery=true)
    void updateEmployeeByAccount(
            @Param("positionId") Integer positionId ,
            @Param("id") String employeeId);

}
