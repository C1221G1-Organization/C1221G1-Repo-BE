package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.import_invoice.SupplierDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SupplierRestController_editSupplier {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * trần ngọc luật
     * test name supplier == ""
     * 16h10 30/06/2022
     */
    @Test
    public void editStudent_name_20() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        // test this
        supplierDto.setSupplierName("");
        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
        supplierDto.setSupplierEmail("thienan@gmail.com");
        supplierDto.setSupplierPhone("09027726752");
        supplierDto.setNote("hòa nhã");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-medicine/medicines/supplier/save")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * trần ngọc luật
     * test phone supplier == ""
     * 16h10 30/06/2022
     */
    @Test
    public void editStudent_phone_20() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
        supplierDto.setSupplierEmail("thienan@gmail.com");
        // test this
        supplierDto.setSupplierPhone("");
        supplierDto.setNote("hòa nhã");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-medicine/medicines/supplier/save")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * trần ngọc luật
     * test phone email == ""
     * 16h10 30/06/2022
     */
    @Test
    public void editStudent_email_20() throws Exception {

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setSupplierName("Nhà Thuốc Thiên An  ");
        supplierDto.setSupplierAddress("63 Phạm Vinh , Cẩm Lệ , Đà Nẵng");
        // test this
        supplierDto.setSupplierEmail("");
        supplierDto.setSupplierPhone("0902292822");
        supplierDto.setNote("hòa nhã");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-medicine/medicines/supplier/save")
                        .content(this.objectMapper.writeValueAsString(supplierDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
