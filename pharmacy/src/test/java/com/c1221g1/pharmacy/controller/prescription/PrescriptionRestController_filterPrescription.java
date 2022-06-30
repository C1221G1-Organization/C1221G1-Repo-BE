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
public class PrescriptionRestController_filterPrescription {
    @Autowired
    private MockMvc mockMvc;

    /**
     * HienTLD
     * JUnit tìm kiếm theo Id (Id = null)
     * 19:00 30/06/2022
     */
    @Test
    public void getSearchPrescription_id_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?id={id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo Id (Id = rỗng)
     * 20:09 30/06/2022
     */
    @Test
    public void getSearchPrescription_id_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?id={id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo Id (Id không tồn tại trong DB)
     * 20:20 30/06/2022
     */
    @Test
    public void getSearchPrescription_id_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?id={id}", "^#@$@AVVV"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * HienTLD
     * JUnit tìm kiếm theo Id (Id tồn tại trong DB)
     * 20:22 30/06/2022
     */
    @Test
    public void getSearchPrescription_id_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?id={id}", "DT-00002"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo Name (Name = null)
     * 20:41 30/06/2022
     */
    @Test
    public void getSearchPrescription_name_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?names={names}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo Name (Name = rỗng)
     * 20:42 30/06/2022
     */
    @Test
    public void getSearchPrescription_name_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?names={names}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo Name (Name không tồn tại trong DB)
     * 20:43 30/06/2022
     */
    @Test
    public void getSearchPrescription_name_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?names={names}", "^#@$@AVVV"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * HienTLD
     * JUnit tìm kiếm theo Name (Name tồn tại trong DB)
     * 20:44 30/06/2022
     */
    @Test
    public void getSearchPrescription_name_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?names={names}", "Viêm họng NL"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo TargetUser (TargetUser = null)
     * 20:45 30/06/2022
     */
    @Test
    public void getSearchPrescription_targetUser_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?target={target}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo TargetUser (TargetUser = rỗng)
     * 20:46 30/06/2022
     */
    @Test
    public void getSearchPrescription_targetUser_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?target={target}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo TargetUser (TargetUser không tồn tại trong DB)
     * 20:47 30/06/2022
     */
    @Test
    public void getSearchPrescription_targetUser_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?target={target}", "^#@$@AVVV"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * HienTLD
     * JUnit tìm kiếm theo TargetUser (TargetUser tồn tại trong DB)
     * 20:48 30/06/2022
     */
    @Test
    public void getSearchPrescription_targetUser_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?target={target}", "Người lớn"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /**
     * HienTLD
     * JUnit tìm kiếm theo Symptom (Symptom = null)
     * 20:50 30/06/2022
     */
    @Test
    public void getSearchPrescription_symptom_1() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo symptom (symptom = rỗng)
     * 20:51 30/06/2022
     */
    @Test
    public void getSearchPrescription_symptom_2() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * HienTLD
     * JUnit tìm kiếm theo symptom (symptom không tồn tại trong DB)
     * 20:52 30/06/2022
     */
    @Test
    public void getSearchPrescription_symptom_3() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", "^#@$@AVVV"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * HienTLD
     * JUnit tìm kiếm theo symptom (symptom tồn tại trong DB)
     * 20:53 30/06/2022
     */
    @Test
    public void getSearchPrescription_symptom_4() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/manager-prescription/prescriptions?symptom={symptom}", "Sốt, đau đầu, sổ mũi"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
