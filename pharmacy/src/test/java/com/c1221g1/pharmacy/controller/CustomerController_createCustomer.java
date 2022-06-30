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

    @Test
    public void createCustomer_customerType_14() throws Exception {
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
