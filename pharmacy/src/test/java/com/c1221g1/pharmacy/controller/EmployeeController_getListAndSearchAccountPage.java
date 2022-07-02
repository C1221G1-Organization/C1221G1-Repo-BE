package com.c1221g1.pharmacy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_getListAccountPage {
    @Autowired
    private MockMvc mockMvc;


    /**
     * HaiNX
     * 02/07/2022
     * tes case if list returns size = 0 then return status 4xx
     */
    @Test
    public void getListAccountPage_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/manager-employee/employees/listAccountPage/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * HaiNX
     * 02/07/2022
     * tes case if list returns size > 0 then return status 2xx ( success )
     * and will have the same value as in DB
     */
    @Test
    public void getListAccountPage_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/manager-employee/employees/listAccount/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(5))
                .andExpect(jsonPath("$.content[4].password").value("111111"))
                .andExpect(jsonPath("$.content[4].positionId").value(2))
                .andExpect(jsonPath("$.content[4].username").value("nguena"))
                .andExpect(jsonPath("$.content[4].employeeName").value("Nguyễn A"))
                .andExpect(jsonPath("$.content[4].employeeId").value("NV-0006"));

    }

}
