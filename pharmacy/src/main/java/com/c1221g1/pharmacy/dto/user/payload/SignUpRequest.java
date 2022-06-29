package com.c1221g1.pharmacy.dto.user.payload;

import com.c1221g1.pharmacy.entity.user.Roles;

public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private Integer gender;
    private String address;
    private String phone;
    private String dayOfBirth;
    private String note;
    private Boolean flag;
    private Integer customerType = 1;
    private Integer roleId = 1;


    public SignUpRequest() {
    }

    public SignUpRequest(String name, String email, String password, String confirmPassword, Integer gender, String address, String phone, String dayOfBirth, String note, Boolean flag, Integer customerType, Integer roleId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.dayOfBirth = dayOfBirth;
        this.note = note;
        this.flag = flag;
        this.customerType = customerType;
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
