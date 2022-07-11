package com.c1221g1.pharmacy.controller.prescription;

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
public class PrescriptionRestController_listPrescription {
    @Autowired
    private MockMvc mockMvc;

    /**
     * HienTLD
     * JUnit trường hợp danh sách trả về size = 0
     * 16:50 30/06/2022
     */
    @Test
    public void getListPrescription_5() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?page=3"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit trường hợp danh sách trả về size > 0
     * 17:13 30/06/2022
     */
    @Test
    public void getListPrescription_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/manager-prescription/prescriptions"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(2))
                .andExpect(jsonPath("$.totalElements").value(9))
                .andExpect(jsonPath("$.content[2].prescriptionName").value("Cảm cúm TE"))
                .andExpect(jsonPath("$.content[2].prescriptionSymptom").value("Sốt, đau đầu, sổ mũi."))
                .andExpect(jsonPath("$.content[2].prescriptionTargetUser").value("Trẻ em"))
                .andExpect(jsonPath("$.content[2].prescriptionNote").value("Cấm trẻ sơ sinh."))
                .andExpect(jsonPath("$.content[2].prescriptionNumberOfDays").value(3))
                .andExpect(jsonPath("$.content[2].flag").value(true));
    }
}