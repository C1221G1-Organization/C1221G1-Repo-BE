package com.c1221g1.pharmacy.dto.employee;

import com.c1221g1.pharmacy.dto.user.UsersDto;
import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.entity.import_invoice.ImportInvoice;
import com.c1221g1.pharmacy.entity.user.Users;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class EmployeeDto implements Validator {
    private String employeeId;
    @NotNull(message = "Name may not be null")
    @NotEmpty(message = "Name may not be empty")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "\n" +
            "Do not enter special characters\n")
    @Size(max = 50, message = "\n" +
            "Do not exceed 50 characters")
    @Size(min = 1, message = "\n" +
            "No less than 1 character")
    private String employeeName;
    @NotNull(message = "Image may not be null")
    @NotEmpty(message = "Image may not be empty")
    @Pattern(regexp = "(https?:\\/\\/.*\\.(?:png|jpg))", message = "\n" +
            "Incorrect image file format\n")

    @Size(max = 500, message = "\n" +
            "Do not exceed 50 characters")
    @Size(min = 4, message = "\n" +
            "No less than 1 character")
    private String employeeImage;

    @NotNull(message = "Address may not be null")
    @NotEmpty(message = "Address may not be empty")
    @Pattern(regexp = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ][\\s\\S]*$", message = "\n" +
            "Do not enter special characters\n")
    private String employeeAddress;

    @NotNull(message = "Phone may not be null")
    @NotEmpty(message = "Phone may not be empty")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",
            message = "\n" +
                    "Enter the correct phone number format including 10 numbers")
    private String employeePhone;
    @NotNull(message = "Start Day may not be null")
    @NotEmpty(message = "Start Day may not be empty")
    private String employeeDateStart;
    private String employeeNote;
    private boolean flag;


    private PositionDto positionDto;


    private UsersDto employeeUsername;
    private List<ImportInvoice> importInvoiceList;

    public EmployeeDto() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeDateStart() {
        return employeeDateStart;
    }

    public void setEmployeeDateStart(String employeeDateStart) {
        this.employeeDateStart = employeeDateStart;
    }

    public UsersDto getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(UsersDto employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getEmployeeNote() {
        return employeeNote;
    }

    public void setEmployeeNote(String employeeNote) {
        this.employeeNote = employeeNote;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public PositionDto getPositionDto() {
        return positionDto;
    }

    public void setPositionDto(PositionDto positionDto) {
        this.positionDto = positionDto;
    }

    public List<ImportInvoice> getImportInvoiceList() {
        return importInvoiceList;
    }

    public void setImportInvoiceList(List<ImportInvoice> importInvoiceList) {
        this.importInvoiceList = importInvoiceList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {


    }
}
