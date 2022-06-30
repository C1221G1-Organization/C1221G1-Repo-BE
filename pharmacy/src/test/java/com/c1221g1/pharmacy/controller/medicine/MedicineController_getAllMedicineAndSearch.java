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
public class MedicineController_getAllMedicineAndSearch {
    @Autowired
    private MockMvc mockMvc;

    /*
       Created by AnP
       Time: 14:30 30/06/2022
       Function: Test JUnit 5 for method getAllMedicineAndSearch(), case: pass in parameter name =1
    */
    @Test
    public void getAllMedicineAndSearch_name_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines?name=null")
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /*
       Created by AnP
       Time: 18:30 30/06/2022
       Function: Test JUnit 5 for method getAllMedicineAndSearch(), case: size list > 0
    */
    @Test
    public void getAllMedicineAndSearch_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(2))
                .andExpect(jsonPath("$.content[1].medicineName").value("Cam"))
                .andExpect(jsonPath("$.content[1].medicinePrice").value("1385.0289"))
                .andExpect(jsonPath("$.content[1].medicineTypeName").hasJsonPath())
                .andExpect(jsonPath("$.content[1].medicineImage").value("mana"));
    }
}
