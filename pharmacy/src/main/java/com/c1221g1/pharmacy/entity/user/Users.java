package com.c1221g1.pharmacy.entity.user;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id @Column(columnDefinition = "VARCHAR(30)")
    private String username;
    private String password;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @OneToMany(mappedBy = "users")
    private List<UserRole> userRoleList;
    @JsonBackReference(value = "customer")
    @OneToOne(mappedBy = "customerUsername")
    private Customer customer;
    @JsonBackReference(value = "employee")
    @OneToOne(mappedBy = "employeeUsername")
    private Employee employee;
}
