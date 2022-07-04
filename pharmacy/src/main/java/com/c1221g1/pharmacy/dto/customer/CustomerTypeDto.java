package com.c1221g1.pharmacy.dto.customer;

import com.c1221g1.pharmacy.entity.customer.Customer;

import java.util.List;

public class CustomerTypeDto {
    private Integer customerTypeId;
    private String customerTypeName;

    public CustomerTypeDto() {
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

}
