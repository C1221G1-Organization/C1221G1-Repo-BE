package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {

    @Transactional
    @Modifying
    @Query(value = "update employee set employee_name = :employeeName, employee_image = :employeeImage ,employee_address = :employeeAddress," +
            "employee_phone = :employeePhone , employee_date_start = :employeeDateStart,employee_note = :employeeNote," +
            "position_id = :position,username = :employeeUsername where employee_id = :employeeId", nativeQuery = true)
    void updateEmployee(
            @Param("employeeName") String employeeName,
            @Param("employeeImage") String employeeImage,
            @Param("employeeAddress") String employeeAddress,
            @Param("employeePhone") String employeePhone,
            @Param("employeeDateStart") String employeeDateStart,
            @Param("employeeNote") String employeeNote,
            @Param("position") Position position,
            @Param("employeeUsername") Users employeeUsername,
            @Param("employeeId") String employeeId);


//    @Transactional
//    @Modifying
////    @Query(value = "insert into employee (employee_name, employee_image, employee_address, employee_phone, employee_date_start,\n" +
////            "                      employee_note,position_id,username) values (:employee_name,:employee_image,:employee_address," +
////            ":employee_phone,:employee_date_start,:employee_note:position_id,:username)", nativeQuery = true)
//
////    @Query(value = "insert into employee (employee_id,employee_name, employee_image, employee_address, employee_phone, employee_date_start,\n" +
////            "                      employee_note,position_id,username) values :#{employee.employeeName},:#{employee.employeeImage},:#{employee.employeeAddress}," +
////            ":#{employee.employeePhone},:#{employee.employeeDateStart},:#{employee.employeeNote},:#{employee.position},:#{employee.employeeUsername}", nativeQuery = true)
////    void saveEmployee(@Param("name") String employeeName,@Param("image") String employeeImage,@Param("address") String employeeAddress,
////                      @Param("phone")String employeePhone,@Param("date") String employeeDateStart,@Param("note") String employeeNote,
////                      @Param("position") Position positionID,@Param("user") Users userName );
//    void saveEmployee(Employee employee);
//    Employee finByEmployee();


//    Employee finByEmployee();


}
