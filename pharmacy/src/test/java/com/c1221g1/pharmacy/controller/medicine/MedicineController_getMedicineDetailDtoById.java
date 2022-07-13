package com.c1221g1.pharmacy.controller.medicine;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Creator: NghiaNTT Time: 30/02/2022
 * <p>
 * JUnit Test for method getMedicineDetailDtoById in MedicineController()
 */

@SpringBootTest
@AutoConfigureMockMvc
public class MedicineController_getMedicineDetailDtoById {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getMedicineDetailDtoById_medicineId_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "null"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void getMedicineDetailDtoById_medicineId_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", ""))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void getMedicineDetailDtoById_medicineId_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "INVALID_ID"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void getMedicineDetailDtoById_medicineId_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-medicine/medicines/detail/{medicineId}", "T-00027"))
            .andDo(print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$.medicineId").value("T-00027"))
            .andExpect(jsonPath("$.medicineName").value("Agiparofen 525mg"))
            .andExpect(jsonPath("$.medicineUsage").value("Giảm đau từ nhẹ đến vừa các chứng đau liên quan đến đau đầu, đau lưng, đau bụng kinh..."))
            .andExpect(jsonPath("$.medicineImage").value("https://firebasestorage.googleapis.com/v0/b/c1221g1-pharmacy.appspot.com/o/08-07-2022011558PMagiparofen.webp?alt=media&token=8953e897-5ffe-43b3-b89f-c7a98d9d9342"))
            .andExpect(jsonPath("$.medicineActiveIngredients").value(
                "Acetaminophen 325mg, Ibuprofen 200mg"))
            .andExpect(jsonPath("$.medicinePrice").value(2208.3333333333335))
            .andExpect(jsonPath("$.medicineManufacture").value("Nhà Máy Sản Xuất Dược Phẩm Agimexpharm"))
            .andExpect(jsonPath("$.medicineInstruction").value(
                "Uống thuốc sau bữa ăn."))
            .andExpect(jsonPath("$.medicineDescription").value(
                "Agiparofen ít có tác dụng phụ khi được dùng với liều và thời gian đề nghị"))
            .andExpect(jsonPath("$.medicineAgeApproved").value("trên 12 tuổi"));
    }
}
