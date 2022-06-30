package com.c1221g1.pharmacy.entity.user;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
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
    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function: this provider use for some one login by social
     */
    @Enumerated(EnumType.STRING)
    private Provider provider;
    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<UserRole> userRoleList;

    @OneToOne(mappedBy = "customerUsername")
    private Customer customer;

    @OneToOne(mappedBy = "employeeUsername")
    private Employee employee;
}
