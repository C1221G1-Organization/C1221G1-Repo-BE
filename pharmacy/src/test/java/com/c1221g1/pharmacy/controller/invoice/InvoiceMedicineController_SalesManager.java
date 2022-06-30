package com.c1221g1.pharmacy.controller.invoice;

import com.c1221g1.pharmacy.dto.invoice.InvoiceDto;
import com.c1221g1.pharmacy.dto.invoice.InvoiceMedicineDto;
import com.c1221g1.pharmacy.dto.invoice.MedicineInvoiceDto;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.employee.Employee;
import com.c1221g1.pharmacy.entity.invoice.TypeOfInvoice;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import com.c1221g1.pharmacy.service.invoice.ITypeOfInvoiceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceMedicineController_SalesManager {
    @Autowired
    private ITypeOfInvoiceService iTypeOfInvoiceService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //Test khi List thuốc null
    @Test
    public void createRetailInvoice_medicineInvoiceDtoList_13() throws Exception {
    }

    // Test thành công
    @Test
    public void createRetailInvoice_18() throws Exception {
        InvoiceMedicineDto invoiceMedicineDto = new InvoiceMedicineDto();
        InvoiceDto invoiceDto = new InvoiceDto();
        Customer customer = iCustomerService.getRetailCustomer();
        Employee employee = iEmployeeService.getEmployeeCreate();
        TypeOfInvoice typeOfInvoice = iTypeOfInvoiceService.getTypeOfInvoiceRetail();
        List<MedicineInvoiceDto> medicineInvoiceDtoList = new ArrayList<>();
        MedicineInvoiceDto medicineInvoiceDto = new MedicineInvoiceDto();
        medicineInvoiceDto.setId(1);
        invoiceDto.setTypeOfInvoice(typeOfInvoice);
        invoiceDto.setEmployee(employee);
        invoiceDto.setCustomer(customer);
        invoiceDto.setInvoiceTotalMoney(1000.0);
        invoiceDto.setInvoiceCreatedDate("30-06-2022");
        invoiceDto.setInvoiceCreateTime("02:44");
        invoiceDto.setInvoiceNote("người lớn");
        invoiceDto.setFlag(true);
        invoiceMedicineDto.setInvoiceDto(invoiceDto);
        medicineInvoiceDtoList.add(medicineInvoiceDto);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/manager-sale/invoiceMedicines/createRetail")
                        .content(this.objectMapper.writeValueAsString(invoiceDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());

    }


}
