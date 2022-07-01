package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.dto.employee.IAccountEmployeeDto;
import com.c1221g1.pharmacy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {


    /**
     * create by HaiNX
     * time: 29/06/2022
     * This method to get data for account table from table employee and user (just List, don't have pagination)
     */
    @Query(value = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`,\n" +
            "e.position_id `positionId`, e.username `username`, u.`password` as `password`\n" +
            "from employee e left join users u on e.username =  u.username left join `position` p on p.position_id = e.position_id group by e.employee_id", nativeQuery = true)
    List<IAccountEmployeeDto> findAllAccount();




    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method find account by employee_id
     */
    @Query(value = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`,\n" +
            " p.position_name as `positionName`, e.username as `username`, u.`password` as `password`\n" +
            "from employee e " +
            "left join users u on e.username =  u.username " +
            "left join `position` p on p.position_id = e.position_id " +
            "where e.employee_id = ? ", nativeQuery = true)
    IAccountEmployeeDto findByAccountId(String id);




    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    @Query(value = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`, " +
            " e.position_id `positionId`, e.username `username`, u.`password` as `password`" +
            " from employee e left join users u on e.username =  u.username left join `position` p on p.position_id = e.position_id " +
            "where e.employee_id like %:id% " +
            "or e.employee_name like %:name% " +
            "or e.position_id like %:position% " +
            "or e.username like %:username% " , nativeQuery = true)
    Page<IAccountEmployeeDto> findAndSearchAccount (
            @Param("id") String id,
            @Param("name") String name,
            @Param("position") Integer position,
            @Param("username") String username,
            Pageable pageable);


    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method to get data for account table from table employee and user (have pagination and search)
     */
    @Query(value = "select e.employee_name as `employeeName`, e.employee_id as `employeeId`, " +
            " e.position_id `positionId`, e.username `username`, u.`password` as `password`" +
            " from employee e left join users u on e.username =  u.username left join `position` p on p.position_id = e.position_id " +
            "where e.employee_id like %:id% " +
            "or e.employee_name like %:name% " +
            "or e.username like %:username% " , nativeQuery = true)
    Page<IAccountEmployeeDto> findAndSearchAccount2 (
            @Param("id") String id,
            @Param("name") String name,
            @Param("username") String username,
            Pageable pageable);




    /**
     * create by HaiNX
     * time: 01/07/2022
     * This method update account, find by employee_id
     */
    @Transactional
    @Modifying
    @Query(value = "update employee  " +
            "join users  on employee.username =  users.username \n" +
            "join `position`  on `position`.position_id = employee.position_id \n" +
            "set `users`.`password` = :password, employee.position_id = :position   where employee.employee_id = :id ", nativeQuery = true)
    void updateAccount(String password, Integer position, @Param("id") String id);



}
