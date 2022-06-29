package com.c1221g1.pharmacy.repository.employee;

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
//    @Query(value = "insert into employee (employee_name, employee_image, employee_address, employee_phone, employee_date_start,\n" +
//            "                      employee_note,position_id,username) values (:employee_name,:employee_image,:employee_address," +
//            ":employee_phone,:employee_date_start,:employee_note:position_id,:username)", nativeQuery = true)

    @Query(value = "insert into employee (employee_name, employee_image, employee_address, employee_phone, employee_date_start,\n" +
            "                      employee_note,position_id,username) values (:name,:image,:address,:phone,:date,:note,:position,:user)", nativeQuery = true)
    void saveEmployee(@Param("name") String employeeName,@Param("image") String employeeImage,@Param("address") String employeeAddress,
                      @Param("phone")String employeePhone,@Param("date") String employeeDateStart,@Param("note") String employeeNote,
                      @Param("position") Position positionID,@Param("user") Users userName );

    Employee finByEmployee();


//    Employee finByEmployee();
}
