package com.c1221g1.pharmacy.controller.report;

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
public class ReportController_getSupplierHaveReceivable {
    @Autowired
    private MockMvc mockMvc;
    /**
     * this method to test method getSupplierHaveReceivable that return empty list
     * @author DinhH
     * @Time 09:30 01/07/2022
     */
    @Test
    public void getSupplierHaveReceivable_5() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/supplier/")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getSupplierHaveReceivable that return list
     * @author DinhH
     * @Time 09:30 01/07/2022
     */
    @Test
    public void getSupplierHaveReceivable_6() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/supplier/")
        ).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].supplierId").value("1"))
                .andExpect(jsonPath("$[0].supplierName").value("Danapha"))
                .andExpect(jsonPath("$[0].balance").value(10000000.0));
    }

}
