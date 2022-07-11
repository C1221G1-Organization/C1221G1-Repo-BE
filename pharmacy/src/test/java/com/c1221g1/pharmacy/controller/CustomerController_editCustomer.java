package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.dto.customer.CustomerDto;
import com.c1221g1.pharmacy.entity.customer.CustomerType;
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
public class CustomerController_editCustomer {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by TruongNQ
     * Time : 20:10 30/06/2022
     * Function test method with arg customer name not null
     */
    @Test
    public void editCustomer_customerName_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName(null);
        customerDto.setCustomerBirthday("1999-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Không ");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00001")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:12 30/06/2022
     * Function test method with arg customer name not empty
     */
    @Test
    public void editCustomer_customerName_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("");
        customerDto.setCustomerBirthday("2001-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123458");
        customerDto.setCustomerNote("1 đơn");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00001")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:12 30/06/2022
     * Function test method with arg customer name not format
     */
    @Test
    public void editCustomer_customerName_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("aaaaaaaaaaa");
        customerDto.setCustomerBirthday("2001-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123458");
        customerDto.setCustomerNote("1 đơn");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00001")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:14 30/06/2022
     * Function test method with arg customer name size min 2
     */
    @Test
    public void editCustomer_customerName_22() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("a");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Sài Gòn");
        customerDto.setCustomerPhone("0905387777");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00001")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:17 30/06/2022
     * Function test method with arg customer name size max 20
     */
    @Test
    public void editCustomer_customerName_23() throws Exception {


        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Phan Đàm Thị Ngọc Linh Chi Thùy Dương");
        customerDto.setCustomerBirthday("2004-01-02");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905444333");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00001")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:20 30/06/2022
     * Function test method with valid arg customer name and valid data
     */
    @Test
    public void editCustomer_customerName_24() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn A");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905098123");
        customerDto.setCustomerNote("N/A");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00025")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by TruongNQ
     * Time : 20:21 30/06/2022
     * Function test method with arg customer birthday not null
     */
    @Test
    public void editCustomer_customerBirthday_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn T");
        customerDto.setCustomerBirthday(null);
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone(null);
        customerDto.setCustomerNote("N/A");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00002")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:21 30/06/2022
     * Function test method with arg customer phone not null
     */
    @Test
    public void editCustomer_customerPhone_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn T");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone(null);
        customerDto.setCustomerNote("Khách lẻ");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00004")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:23 30/06/2022
     * Function test method with arg customer phone not empty
     */
    @Test
    public void editCustomer_customerPhone_20() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn T");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("");
        customerDto.setCustomerNote("Mua thuốc trị covid nặng");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00001")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:25 30/06/2022
     * Function test method with arg customer phone not format
     */
    @Test
    public void editCustomer_customerPhone_21() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn Long");
        customerDto.setCustomerBirthday("2003-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("1234567890");
        customerDto.setCustomerNote("Mua que test covid");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00005")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:32 30/06/2022
     * Function test method with arg customer type not null
     */
    @Test
    public void editCustomer_customerType_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Thị Ngọc");
        customerDto.setCustomerBirthday("1991-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(null);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00004")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by TruongNQ
     * Time : 20:35 30/06/2022
     * Function test method with arg customer gender not null
     */
    @Test
    public void editCustomer_customerGender_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn T");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(null);
        customerDto.setCustomerAddress("Đà Nẵng");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager_customer/customers/{customerId}", "KH-00001")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * Create by TruongNQ
     * Time : 23:54 01/07/2022
     * Function test method with arg customer address size max 20
     */
    @Test
    public void editCustomer_customerAddress_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn T");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("abcdabcdabcdabcdabcdd");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-customer/customers", "KH_00002")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    /**
     * Create by TruongNQ
     * Time : 23:57 01/07/2022
     * Function test method with arg customer note not null
     */
    @Test
    public void editCustomer_customerNote_19() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn T");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Lạt");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote(null);
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-customer/customers", "KH-00003")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    /**
     * Create by TruongNQ
     * Time : 23:57 01/07/2022
     * Function test method with arg customer note size min 2
     */
    @Test
    public void editCustomer_customerNote_22() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Nguyễn Văn T");
        customerDto.setCustomerBirthday("2000-04-22");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("Đà Lạt");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("a");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-customer/customers", "KH-00003")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Create by TruongNQ
     * Time : 00:01 02/07/2022
     * Function test method with arg customer note size max 20
     */
    @Test
    public void editCustomer_customerNote_23() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Huỳnh Văn Huy");
        customerDto.setCustomerBirthday("1981-02-04");
        customerDto.setCustomerGender(1);
        customerDto.setCustomerAddress("abcdabcdabcdabcdabcdd");
        customerDto.setCustomerPhone("0905123456");
        customerDto.setCustomerNote("Khách hàng mua lần đầu");
        customerDto.setCustomerUsername(null);
        customerDto.setFlag(true);
        CustomerType customerType = new CustomerType();
        customerType.setCustomerTypeId(1);
        customerDto.setCustomerType(customerType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-customer/customers", "KH-00004")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
