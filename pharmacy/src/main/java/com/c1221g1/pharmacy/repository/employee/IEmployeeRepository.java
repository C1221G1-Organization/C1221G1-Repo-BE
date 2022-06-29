package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.dto.employee.AccountEmployee;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {
    @Query(value = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`, \n" +
            "e.position_id `positionName`, e.username `userame`, u.password as `password` \n" +
            "from employee e left join users u on e.username =  u.username group by e.employee_id",
            countQuery = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`, \n" +
                    "e.position_id `positionName`, e.username `userame`, u.password as `password` \n" +
                    "from employee e left join users u on e.username =  u.username group by e.employee_id",
            nativeQuery = true)
    List<AccountEmployee> findAllAccount();
//    Page<AccountEmployee> findAccount(String name, String id, String position, String userName, Pageable pageable);

}
