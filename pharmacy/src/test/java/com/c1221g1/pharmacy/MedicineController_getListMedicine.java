package com.c1221g1.pharmacy;

import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
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
public class MedicineController_getListMedicine {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListMedicine_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/manager-medicine/medicines/list"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListMedicine_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/manager-medicine/medicines/list"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.totalPages").value(1))
                .andExpect(jsonPath("$.totalElements").value(5))
                .andExpect(jsonPath("$.content[4].medicineId").value("TH-0001"))
                .andExpect(jsonPath("$.content[4].medicineName").value("Thuốc bổ mắt"))
                .andExpect(jsonPath("$.content[4].medicineActiveIngredients").value("omega3"))
                .andExpect(jsonPath("$.content[4].medicineImportPrice").value(200.000))
                .andExpect(jsonPath("$.content[4].medicineDiscount").value(0))
                .andExpect(jsonPath("$.content[4].medicineWholesaleProfit").value(4))
                .andExpect(jsonPath("$.content[4].medicineRetailSaleProfit").value(3))
                .andExpect(jsonPath("$.content[4].medicineTax").value(5))
                .andExpect(jsonPath("$.content[4].medicineConversionRate").value(2))
                .andExpect(jsonPath("$.content[4].medicineManufacture").value(2))
                .andExpect(jsonPath("$.content[4].medicineUsage").value(2))
                .andExpect(jsonPath("$.content[4].medicineInstruction").value(2))
                .andExpect(jsonPath("$.content[4].medicineAgeApproved").value(2))
                .andExpect(jsonPath("$.content[4].medicineImage").value(2))
                .andExpect(jsonPath("$.content[4].medicineDescription").value(2))
                .andExpect(jsonPath("$.content[4].medicineOrigin.medicineOriginId").value(1))
                .andExpect(jsonPath("$.content[4].medicineType.medicineTypeId").value(1))
                .andExpect(jsonPath("$.content[4].medicineUnit.medicineUnitId").value(1))
                .andExpect(jsonPath("$.content[4].medicineConversionUnit.medicineConversionUnitId").value(1));

    }
}


