package com.c1221g1.pharmacy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.Column;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_getPage {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getSearchAndSortCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/manager-customer/customers"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }


    @Test
    public void getSearchAndSortCustomer_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/manager-customer/customers"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(2))
                .andExpect(jsonPath("$.content[1].customerId").value("KL-0002"))
                .andExpect(jsonPath("$.content[1].customerName").value("luật"))
                .andExpect(jsonPath("$.content[1].customerBirthday").value("1999-01-25"))
                .andExpect(jsonPath("$.content[1].customerGender").value(0))
                .andExpect(jsonPath("$.content[1].customerAddress").value("đà nẵng"))
                .andExpect(jsonPath("$.content[1].customerPhone").value("0123456789"))
                .andExpect(jsonPath("$.content[1].customerNote").value("123"))
                .andExpect(jsonPath("$.content[1].flag").value(true));
    }


}
