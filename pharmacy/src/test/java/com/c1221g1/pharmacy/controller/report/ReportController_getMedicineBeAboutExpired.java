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
public class ReportController_getMedicineBeAboutExpired {
    @Autowired
    private MockMvc mockMvc;
    /**
     * this method to test method getMedicineBeAboutExpired that return empty list
     * @author DinhH
     * @Time 10:30 01/07/2022
     */
    @Test
    public void getMedicineBeAboutExpired_5() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/medicineBeAboutExpired/")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getMedicineBeAboutExpired that return list
     * @author DinhH
     * @Time 10:30 01/07/2022
     */
    @Test
    public void getMedicineBeAboutExpired_6() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/manager_report/report/medicineBeAboutExpired/")
                ).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].medicineId").value("1"))
                .andExpect(jsonPath("$[0].medicineName").value("Panadol"))
                .andExpect(jsonPath("$[0].quantity").value(2000))
                .andExpect(jsonPath("$[0].expiredDate").value("10-07-2022"));
    }
}
