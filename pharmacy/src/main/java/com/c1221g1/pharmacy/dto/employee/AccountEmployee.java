package com.c1221g1.pharmacy.dto.employee;

import javax.validation.constraints.NotBlank;

public interface AccountEmployee {
    String getEmployeeId();
    String getEmployeeName();
    String getPositionName();
    String getUsername();
    String getPassword();
}
