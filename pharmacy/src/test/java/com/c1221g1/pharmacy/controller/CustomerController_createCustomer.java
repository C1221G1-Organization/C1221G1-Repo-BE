package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.customer.CustomerDto;
import com.c1221g1.pharmacy.dto.customer.CustomerTypeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class CustomerController_createCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by TruongNQ
     * Time : 11:22 30/06/2022
     * Function test method with arg customer name not null
     */
    @Test
    public void createCustomer_customerName_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
//        customerDto.setCustomerId("KH-00001");
        customerDto.setCustomerName(null);
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 11:33 30/06/2022
     * Function test method with arg customer name not empty
     */
    @Test
    public void createCustomer_customerName_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 11:45 30/06/2022
     * Function test method with arg customer name size min 2
     */
    @Test
    public void createCustomer_customerName_16() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("a");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TruongNQ
     * Time : 11:22 30/06/2022
     * Function test method with arg customer name size max 20
     */
    @Test
    public void createCustomer_customerName_17() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn Quang Trường Hải Tín");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TruongNQ
     * Time : 13:35 30/06/2022
     * Function test method with valid arg customer name and valid data
     */
    @Test
    public void createCustomer_customerName_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by TruongNQ
     * Time : 13:40 30/06/2022
     * Function test method with arg customer phone not null
     */
    @Test
    public void createCustomer_customerPhone_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone(null);
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TruongNQ
     * Time : 14:00 30/06/2022
     * Function test method with arg customer phone not empty
     */
    @Test
    public void createCustomer_customerPhone_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TruongNQ
     * Time : 14:10 30/06/2022
     * Function test method with arg customer phone not item
     */
    @Test
    public void createCustomer_customerPhone_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("01234567890");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by TruongNQ
     * Time : 14:30 30/06/2022
     * Function test method with valid arg customer phone and valid data
     */
    @Test
    public void createCustomer_customerPhone_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905386737");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by TruongNQ
     * Time : 14:31 30/06/2022
     * Function test method with arg customer type not null
     */
    @Test
    public void createCustomer_customerType_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905386737");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(null);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by TruongNQ
     * Time : 14:59 30/06/2022
     * Function test method with valid arg customer type and valid data
     */
    @Test
    public void createCustomer_customerType_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905386737");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by TruongNQ
     * Time : 16:40 30/06/2022
     * Function test method with arg customer gender not null
     */
    @Test
    public void createCustomer_customerGender_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905386737");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setFlag(true);

        CustomerTypeDto customerTypeDto = new CustomerTypeDto();
        customerTypeDto.setCustomerTypeId(2);
        customerDto.setCustomerTypeDto(customerTypeDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager_customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
