package com.c1221g1.pharmacy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ImportInvoiceController_getPageListImportInvoice {

    @Autowired
    private MockMvc mockMvc;

    /**
     * this function use to test get list when no parameters were passed and no result
     *
     * @author HongHTX
     * @Time 17:15 30/06/2022
     */
    @Test
    public void getPageListImportInvoice_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/manager-medicine/import-invoice/"))
                            .andDo(print())
                            .andExpect(status().isNoContent());
    }

    /**
     * this function use to test get list when no parameters were passed and has result
     *
     * @author HongHTX
     * @Time 17:15 30/06/2022
     */
    @Test
    public void getPageListImportInvoice_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/manager-medicine/import-invoice/"))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.totalPages").value(2))
                            .andExpect(jsonPath("$.totalElements").value(7))
                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
                            .andExpect(jsonPath("$.content[4].total").value(675467400))
                            .andExpect(jsonPath("$.content[4].flag").value(true))
                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
    }

    /**
     * this function use to test get list when parameters startDate is null
     *
     * @author HongHTX
     * @Time 17:15 30/06/2022
     */
    @Test
    public void getPageListImportInvoice_startDate_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/manager-medicine/import-invoice")
                            .param("startDate", "null"))
                            .andDo(print())
                            .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test get list when parameters startDate is ""
     *
     * @author HongHTX
     * @Time 17:15 30/06/2022
     */
    @Test
    public void getPageListImportInvoice_startDate_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/manager-medicine/import-invoice")
                            .param("startDate", ""))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.totalPages").value(2))
                            .andExpect(jsonPath("$.totalElements").value(7))
                            .andExpect(jsonPath("$.content[4].importInvoiceId").value("HDN-0004"))
                            .andExpect(jsonPath("$.content[4].importSystemCode").value(5634))
                            .andExpect(jsonPath("$.content[4].importInvoiceDate").value("2022-01-01"))
                            .andExpect(jsonPath("$.content[4].importInvoiceHour").value("20:00"))
                            .andExpect(jsonPath("$.content[4].paymentPrepayment").value(6745000))
                            .andExpect(jsonPath("$.content[4].total").value(675467400))
                            .andExpect(jsonPath("$.content[4].flag").value(true))
                            .andExpect(jsonPath("$.content[4].supplier.supplierId").value(1))
                            .andExpect(jsonPath("$.content[4].employee.employeeId").value(1));
    }

    // startDate, endDate, startTime, endTime is always valid so no need to test.

    /**
     * this function use to test get list when parameters startDate is 2022-10-10
     *
     * @author HongHTX
     * @Time 17:15 30/06/2022
     */
    @Test
    public void getPageListImportInvoice_startDate_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/manager-medicine/import-invoice")
                            .param("startDate", "2022-10-10"))
                            .andDo(print())
                            .andExpect(status().isNoContent());
    }
}
