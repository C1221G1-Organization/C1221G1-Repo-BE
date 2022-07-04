package com.c1221g1.pharmacy.entity.user;

import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"userRoleList","customer","employee"})
public class Users {
    @Id
    @Column(columnDefinition = "VARCHAR(30)")
    private String username;
    private String password;
    @Column(columnDefinition = "BIT")
    private boolean flag;
    @OneToMany(mappedBy = "users")
    private List<UserRole> userRoleList;
    @OneToOne(mappedBy = "customerUsername")
    private Customer customer;
    @OneToOne(mappedBy = "employeeUsername")
    private Employee employee;

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}



