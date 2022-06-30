package com.c1221g1.pharmacy.dto.invoice;

import com.c1221g1.pharmacy.dto.customer.CustomerDto;
import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import com.c1221g1.pharmacy.entity.medicine.Medicine;

import javax.validation.Valid;
import java.util.List;


public class InvoiceMedicineDto {
    private Integer invoiceMedicineId;
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: remove properties from InvoiceMedicineDto: invoiceMedicineQuantity,invoice,medicine
     * Note: I just commented them back and i didn't delete them, wait for every one discuss about it
     * */
//    private Integer invoiceMedicineQuantity;
//    private Invoice invoice;
//    private Medicine medicine;


    /*
     * Created by DaLQA
     * Time: 8:36 PM 30/06/2022
     * Function: create new property invoiceCreateTime
     * */
    private Double invoiceTotalMoney;

    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: create property invoiceNote for InvoiceMedicineDto
     * */
    private String invoiceNote;
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: create property customerDto for InvoiceMedicineDto
     * */
    @Valid
    private CustomerDto customerDto;
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: create property medicines for InvoiceMedicineDto
     * */
    private EmployeeDto employeeDto;
    private Customer customer;
    private Employee employee;
    private List<MedicineInvoiceDto> medicines;
    public InvoiceMedicineDto() {
    }

    public String getInvoiceNote() {
        return invoiceNote;
    }

    public Double getInvoiceTotalMoney() {
        return invoiceTotalMoney;
    }

    public void setInvoiceTotalMoney(Double invoiceTotalMoney) {
        this.invoiceTotalMoney = invoiceTotalMoney;
    }


    public void setInvoiceNote(String invoiceNote) {
        this.invoiceNote = invoiceNote;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public List<MedicineInvoiceDto> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicineInvoiceDto> medicines) {
        this.medicines = medicines;
    }

    public Integer getInvoiceMedicineId() {
        return invoiceMedicineId;
    }

    public void setInvoiceMedicineId(Integer invoiceMedicineId) {
        this.invoiceMedicineId = invoiceMedicineId;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
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
