package com.c1221g1.pharmacy.dto.customer;


import com.c1221g1.pharmacy.entity.customer.CustomerType;
import com.c1221g1.pharmacy.entity.user.Users;
import javax.validation.constraints.*;

public class CustomerDto {
    private String customerId;
    @NotNull(message = "Name may not be null")
    @NotEmpty(message = "Name may not be empty")
    @Size(max = 20, message = "\n" +
            "Do not exceed 20 characters")
    @Size(min = 2, message = "\n" +
            "No less than 2 character")
    private String customerName;
    private String customerBirthday;
    @NotNull(message = "Name may not be null")
    private Integer customerGender;
    private String customerAddress;

    @NotNull(message = "Name may not be null")
    @NotEmpty(message = "Name may not be empty")
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})$")
    private String customerPhone;
    private String customerNote;
    private boolean flag;
    private Users customerUsername;
    private CustomerType customerType;


    public CustomerDto() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Users getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(Users customerUsername) {
        this.customerUsername = customerUsername;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


}
