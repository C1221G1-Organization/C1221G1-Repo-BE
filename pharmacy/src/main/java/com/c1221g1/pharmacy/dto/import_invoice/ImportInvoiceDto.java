package com.c1221g1.pharmacy.dto.import_invoice;
import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ImportInvoiceDto implements Validator {
    private String importInvoiceId;
    private Integer importSystemCode;
    private Double paymentPrepayment;
    private Double total;
    private String importInvoiceDate;
    private String importInvoiceHour;
    private boolean flag;
    @NotNull
    private SupplierDto supplierDto;
    @NotNull
    private EmployeeDto employeeDto;
    private List<ImportInvoiceMedicineDto> importInvoiceMedicineList;

    public ImportInvoiceDto() {
    }

    public String getImportInvoiceId() {
        return importInvoiceId;
    }

    public void setImportInvoiceId(String importInvoiceId) {
        this.importInvoiceId = importInvoiceId;
    }

    public Integer getImportSystemCode() {
        return importSystemCode;
    }

    public void setImportSystemCode(Integer importSystemCode) {
        this.importSystemCode = importSystemCode;
    }

    public Double getPaymentPrepayment() {
        return paymentPrepayment;
    }

    public void setPaymentPrepayment(Double paymentPrepayment) {
        this.paymentPrepayment = paymentPrepayment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getImportInvoiceDate() {
        return importInvoiceDate;
    }

    public void setImportInvoiceDate(String importInvoiceDate) {
        this.importInvoiceDate = importInvoiceDate;
    }

    public String getImportInvoiceHour() {
        return importInvoiceHour;
    }

    public void setImportInvoiceHour(String importInvoiceHour) {
        this.importInvoiceHour = importInvoiceHour;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public SupplierDto getSupplierDto() {
        return supplierDto;
    }

    public void setSupplierDto(SupplierDto supplierDto) {
        this.supplierDto = supplierDto;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public List<ImportInvoiceMedicineDto> getImportInvoiceMedicineList() {
        return importInvoiceMedicineList;
    }

    public void setImportInvoiceMedicineList(List<ImportInvoiceMedicineDto> importInvoiceMedicineList) {
        this.importInvoiceMedicineList = importInvoiceMedicineList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
