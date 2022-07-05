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
public class ReportController_getStatic {
    @Autowired
    private MockMvc mockMvc;
    /**
     * this method to test method getStatic that return empty list
     * @author DinhH
     * @Time 11:30 01/07/2022
     */
    @Test
    public void getStatic_5() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/static/")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getStatic that return list
     * @author DinhH
     * @Time 09:30 01/07/2022
     */
    @Test
    public void getStatic_6() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                        get("/api/manager_report/report/static/")
                ).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].revenue").value(120000000.0))
                .andExpect(jsonPath("$[0].profit").value(20000000.0));
    }
}
