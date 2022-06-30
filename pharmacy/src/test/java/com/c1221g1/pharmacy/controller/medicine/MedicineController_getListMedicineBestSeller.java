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
public class MedicineController_getListMedicineBestSeller {
    @Autowired
    private MockMvc mockMvc;

    /*
        Created by AnP
        Time: 14:00 30/06/2022
        Function: Test JUnit 5 for method getListMedicineBestSeller(), case: size list = 0
    */
    @Test
    public void getListMedicineBestSeller_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/best-seller"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /*
       Created by AnP
       Time: 14:05 30/06/2022
       Function: Test JUnit 5 for method getListMedicineBestSeller(), case: size list > 0
    */
    @Test
    public void getListMedicineBestSeller_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/manager-medicine/medicines/best-seller"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].medicineName").value("Cam"))
                .andExpect(jsonPath("$[1].medicinePrice").value("1385.0289"))
                .andExpect(jsonPath("$[1].soldQuantity").value(16))
                .andExpect(jsonPath("$[1].medicineTypeName").hasJsonPath())
                .andExpect(jsonPath("$[1].medicineImage").value("mana"));
    }
}
