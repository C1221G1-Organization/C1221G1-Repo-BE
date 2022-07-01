package com.c1221g1.pharmacy.dto.employee;

import com.c1221g1.pharmacy.entity.employee.Employee;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PositionDto {
    @NotNull(message = "Position may not be null")
    private Integer positionId;
    private String positionName;
    private List<Employee> employeeList;

    public PositionDto() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
