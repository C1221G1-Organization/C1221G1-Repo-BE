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
 *
 * JUnit Test for method get5RelativeMedicinesOf in MedicineController()
 */

@SpringBootTest
@AutoConfigureMockMvc
public class MedicineController_get5RelativeMedicinesOf {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get5RelativeMedicinesOf_medicineId_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                    .get("/api/manager-medicine/medicines/get-5-relative-medicines-type/{medicineId}", "null"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    public void get5RelativeMedicinesOf_medicineId_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                    .get("/api/manager-medicine/medicines/get-5-relative-medicines-type/{medicineId}", ""))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    public void get5RelativeMedicinesOf_medicineId_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                    .get("/api/manager-medicine/medicines/get-5-relative-medicines-type/{medicineId}", "INVALID_ID"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    public void get5RelativeMedicinesOf_medicineId_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                    .get("/api/manager-medicine/medicines/get-5-relative-medicines-type/{medicineId}", "T-00001"))
            .andDo(print())
            .andExpect(status().is2xxSuccessful())
            .andExpect(jsonPath("$[3].medicineId").value("T-00005"))
            .andExpect(jsonPath("$[3].medicineName").value("Dung dịch vệ sinh mũi Nose Hygiene Spray (80ml)"))
            .andExpect(jsonPath("$[3].medicineUsage").value("Làm sạch các tạp chất và dịch nhầy từ đường mũi, cải thiện hô hấp."))
            .andExpect(jsonPath("$[3].medicineImage").value("null"))
            .andExpect(jsonPath("$[3].medicineActiveIngredients").value("Được tinh chiết từ muối biển tự nhiên, giàu khoáng chất và nguyên tố vi lượng như Ca++, Na+, Cu++, Zn++."))
            .andExpect(jsonPath("$[3].medicineRetailSaleProfit").value(5.0))
            .andExpect(jsonPath("$[3].medicineImportPrice").value( 70000.0))
            .andExpect(jsonPath("$[3].medicineManufacture").value("1"))
            .andExpect(jsonPath("$[3].medicineInstruction").value("Đưa nhẹ vòi phun vào mũi cho vừa khít. Ấn nhanh gọn vòi xịt 3-6 lần vào mỗi bên mũi. Để dung dịch thừa chảy ra ngoài sau đó xì mũi."))
            .andExpect(jsonPath("$[3].medicineDescription").value("Dung dịch vệ sinh mũi Nose Hygiene Spray được tinh chiết từ muối biển tự nhiên và tinh dầu bạc hà, giàu khoáng chất và nguyên tố vi lượng như Ca++, Na+, Cu++, Zn++, giúp làm sạch các tạp chất và dịch nhầy từ đường mũi, cải thiện hô hấp, hỗ trợ phòng ngừa và làm giảm triệu chứng sổ mũi, ngạt mũi..."))
            .andExpect(jsonPath("$[3].medicineAgeApproved").value("Trẻ em trên 9 tuổi"));
    }
}
