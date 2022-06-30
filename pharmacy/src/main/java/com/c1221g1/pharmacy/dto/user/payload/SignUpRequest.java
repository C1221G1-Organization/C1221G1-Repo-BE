package com.c1221g1.pharmacy.dto.user.payload;

import com.c1221g1.pharmacy.entity.user.Roles;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Created by HuuNQ
 * Time 12:00 30/06/2022
 * Function: when user submit sign-up form, this class will use to take all field in sign-up form and send to url mapping method
 */
public class SignUpRequest implements Validator {

    private String name;
    @NotBlank(message = "Không bỏ trống")
    @NotEmpty(message = "Không bỏ trống")
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpRequest signUpRequest = (SignUpRequest) target;
        if(!signUpRequest.getEmail().matches("^[a-z0-9]((.|\\+)?[a-z0-9]){4,}@g(oogle)?mail\\.com$")){
            errors.rejectValue("email","email.invalid.pattern","Không đúng định dạng email");
        }
        if(!signUpRequest.getPhone().matches("((09)|(08)|(07))\\d{8}")){
            errors.rejectValue("phone","phone.invalid.pattern","Số điện thoại phải bắt đầu bằng 09 08 hoặc 07");
        }
        if(!signUpRequest.getDayOfBirth().matches("([012]\\d|[3][0-1])/([0]\\d|[1][0-2])/((19)(\\d){2}|(20)(([01]\\d)|[2][0-2]))$")){
            errors.rejectValue("dayOfBirth","date.invalid.pattern","Sai định dạng ngày/tháng/năm");
        }
        if(!signUpRequest.getPassword().matches(signUpRequest.getConfirmPassword())){
            errors.rejectValue("confirmPassword","confirmPassword.invalid","Xác nhận mật khẩu chính xác");
        }
    }
}
