package com.c1221g1.pharmacy.controller.medicine;


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
public class SupplierRestController_getPageSupplier {


    @Autowired
    private MockMvc mockMvc;

    /**
     * trần ngọc luật 11h 30/06/2022
     * tes case if list returns size = 0 then return status 4xx
     */
    @Test
    public void getListSupplier_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if list returns size > 0 then return status 2xx ( success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(0))
                .andExpect(jsonPath("$.totalElements").value(5))
                .andExpect(jsonPath("$.content[0].supplierId").value("NCC-00015"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Bệnh Viện Châu Á Dịu Điêu "))
                .andExpect(jsonPath("$.content[0].supplierAddress").value("15 Nguyễn Hữu Thọ "))
                .andExpect(jsonPath("$.content[0].supplierPhone").value("0903265955"))
                .andExpect(jsonPath("$.content[0].supplierEmail").value("giadinh@gmail.com"))
                .andExpect(jsonPath("$.content[0].note").value("Thân Thiện")
                );
    }

    /**
     * this function use to test get page when parameters [ MÃ Nhà Cung Cấp ] is null
     *
     * @author Trần Ngọc Luật
     * @Time 17:15 05/07/2022
     */
    @Test
    public void getPageSupplier_searchhId_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/manager-medicine/medicines/supplier")
                .param("searchId", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test get page when parameters [ MÃ Nhà Cung Cấp ] is null
     *
     * @author Trần Ngọc Luật
     * @Time 17:15 05/07/2022
     */
    @Test
    public void getPageSupplier_searchName_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/manager-medicine/medicines/supplier")
                .param("searchName", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test get page when parameters [ MÃ Nhà Cung Cấp ] is null
     *
     * @author Trần Ngọc Luật
     * @Time 17:15 05/07/2022
     */
    @Test
    public void getPageSupplier_searchAddres_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/manager-medicine/medicines/supplier")
                .param("searchAddress", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test get page when parameters [ MÃ Nhà Cung Cấp ] is null
     *
     * @author Trần Ngọc Luật
     * @Time 17:15 05/07/2022
     */
    @Test
    public void getPageSupplier_searchPhone_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/manager-medicine/medicines/supplier")
                .param("searchPhone", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchId = ''  2xx ( success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchId_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchId", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(0))
                .andExpect(jsonPath("$.totalElements").value(5))
                .andExpect(jsonPath("$.content[0].supplierId").value("NCC-00015"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Bệnh Viện Châu Á Dịu Điêu "))
                .andExpect(jsonPath("$.content[0].supplierAddress").value("15 Nguyễn Hữu Thọ "))
                .andExpect(jsonPath("$.content[0].supplierPhone").value("0903265955"))
                .andExpect(jsonPath("$.content[0].supplierEmail").value("giadinh@gmail.com"))
                .andExpect(jsonPath("$.content[0].note").value("Thân Thiện")
                );
    }


    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchName = ''  2xx ( success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchName_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchName", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(0))
                .andExpect(jsonPath("$.totalElements").value(5))
                .andExpect(jsonPath("$.content[0].supplierId").value("NCC-00015"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Bệnh Viện Châu Á Dịu Điêu "))
                .andExpect(jsonPath("$.content[0].supplierAddress").value("15 Nguyễn Hữu Thọ "))
                .andExpect(jsonPath("$.content[0].supplierPhone").value("0903265955"))
                .andExpect(jsonPath("$.content[0].supplierEmail").value("giadinh@gmail.com"))
                .andExpect(jsonPath("$.content[0].note").value("Thân Thiện")
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchAddress = ''  2xx ( success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchAddress_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchAddress", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(0))
                .andExpect(jsonPath("$.totalElements").value(5))
                .andExpect(jsonPath("$.content[0].supplierId").value("NCC-00015"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Bệnh Viện Châu Á Dịu Điêu "))
                .andExpect(jsonPath("$.content[0].supplierAddress").value("15 Nguyễn Hữu Thọ "))
                .andExpect(jsonPath("$.content[0].supplierPhone").value("0903265955"))
                .andExpect(jsonPath("$.content[0].supplierEmail").value("giadinh@gmail.com"))
                .andExpect(jsonPath("$.content[0].note").value("Thân Thiện")
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchPhone = ''  2xx ( success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchPhone_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchPhone", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(0))
                .andExpect(jsonPath("$.totalElements").value(5))
                .andExpect(jsonPath("$.content[0].supplierId").value("NCC-00015"))
                .andExpect(jsonPath("$.content[0].supplierName").value("Bệnh Viện Châu Á Dịu Điêu "))
                .andExpect(jsonPath("$.content[0].supplierAddress").value("15 Nguyễn Hữu Thọ "))
                .andExpect(jsonPath("$.content[0].supplierPhone").value("0903265955"))
                .andExpect(jsonPath("$.content[0].supplierEmail").value("giadinh@gmail.com"))
                .andExpect(jsonPath("$.content[0].note").value("Thân Thiện")
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchPhone != in batabasse  .is4xxClientError() (not  success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchPhone_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchPhone", "49999999999999"))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchAddress = ''  .is4xxClientError() (not success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchAddress_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchAddress", "sssssssssssssssssssss"))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }


    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchId = ''  .is4xxClientError() (not success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchId_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchId", "aaaaaaaaaaaaaaaa"))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }


    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchName != in batabasse .is4xxClientError() (  not success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchName_10() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchName", "aaaaaaaaaaaaaaa"))
                .andDo(print())
                .andExpect(status().is4xxClientError()
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchName = in batabasse .is2xxSuccessful() (   success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchName_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchName", "nhà thuốc"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchName = in batabasse .is2xxSuccessful() (   success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchPhone_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchPhone", "09"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchName = in batabasse .is2xxSuccessful() (   success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchAddress_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchAddress", "đà nẵng"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
                );
    }

    /**
     * trần ngọc luật 11h21 30/06/2022
     * tes case if searchName = in batabasse .is2xxSuccessful() (   success )
     * and will have the same value as in batabasse
     */
    @Test
    public void getListSupplier_searchId_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/supplier/")
                        .param("searchId", "NCC-000"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful()
                );
    }

}
