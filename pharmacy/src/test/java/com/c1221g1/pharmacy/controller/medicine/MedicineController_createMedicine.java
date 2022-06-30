package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineDto;
import com.c1221g1.pharmacy.entity.medicine.MedicineConversionUnit;
import com.c1221g1.pharmacy.entity.medicine.MedicineOrigin;
import com.c1221g1.pharmacy.entity.medicine.MedicineType;
import com.c1221g1.pharmacy.entity.medicine.MedicineUnit;
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
public class MedicineController_createMedicine {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test the validation of field name more specific is null
     *
     * @author LongNH
     * @Time 15:00 30/06/2022
     */
    @Test
    public void createMedicine_name_13() throws Exception {
        MedicineDto medicineDto = new MedicineDto();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineType medicineType = new MedicineType();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
//        medicineDto.setMedicineName("thốc nhỏ mắt");
        medicineDto.setMedicineActiveIngredients("vitaminC");
        medicineDto.setMedicineImportPrice(500.0);
        medicineDto.setMedicineDiscount(3.0);
        medicineDto.setMedicineWholesaleProfit(2.0);
        medicineDto.setMedicineRetailSaleProfit(2.0);
        medicineDto.setMedicineTax(5.0);
        medicineDto.setMedicineConversionRate(10.0);
        medicineDto.setMedicineManufacture("daphaco");
        medicineDto.setMedicineUsage("giảm mù mắt");
        medicineDto.setMedicineInstruction("nhỏ vào mắt");
        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
        medicineDto.setMedicineImage("img.png");
        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
        medicineDto.setFlag(true);
        medicineOrigin.setMedicineOriginId(1);
        medicineDto.setMedicineOrigin(medicineOrigin);
        medicineType.setMedicineTypeId("LT0001");
        medicineDto.setMedicineType(medicineType);
        medicineUnit.setMedicineUnitId(1);
        medicineDto.setMedicineUnit(medicineUnit);
        medicineConversionUnit.setMedicineConversionUnitId(1);
        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-medicine/medicines")
                .content(this.objectMapper.writeValueAsString(medicineDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field name more specific is empty
     *
     * @author LongNH
     * @Time 15:00 30/06/2022
     */
    @Test
    public void createMedicine_name_14() throws Exception {
        MedicineDto medicineDto = new MedicineDto();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineType medicineType = new MedicineType();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
        medicineDto.setMedicineName("");
        medicineDto.setMedicineActiveIngredients("vitaminC");
        medicineDto.setMedicineImportPrice(500.0);
        medicineDto.setMedicineDiscount(3.0);
        medicineDto.setMedicineWholesaleProfit(2.0);
        medicineDto.setMedicineRetailSaleProfit(2.0);
        medicineDto.setMedicineTax(5.0);
        medicineDto.setMedicineConversionRate(10.0);
        medicineDto.setMedicineManufacture("daphaco");
        medicineDto.setMedicineUsage("giảm mù mắt");
        medicineDto.setMedicineInstruction("nhỏ vào mắt");
        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
        medicineDto.setMedicineImage("img.png");
        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
        medicineDto.setFlag(true);
        medicineOrigin.setMedicineOriginId(1);
        medicineDto.setMedicineOrigin(medicineOrigin);
        medicineType.setMedicineTypeId("LT0001");
        medicineDto.setMedicineType(medicineType);
        medicineUnit.setMedicineUnitId(1);
        medicineDto.setMedicineUnit(medicineUnit);
        medicineConversionUnit.setMedicineConversionUnitId(1);
        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-medicine/medicines")
                .content(this.objectMapper.writeValueAsString(medicineDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field name more specific is wrong format
     *
     * @author LongNH
     * @Time 15:02 30/06/2022
     */
    @Test
    public void createMedicine_name_15() throws Exception {
        MedicineDto medicineDto = new MedicineDto();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineType medicineType = new MedicineType();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
        medicineDto.setMedicineName("thuoc bo t1#%$");
        medicineDto.setMedicineActiveIngredients("vitaminC");
        medicineDto.setMedicineImportPrice(500.0);
        medicineDto.setMedicineDiscount(3.0);
        medicineDto.setMedicineWholesaleProfit(2.0);
        medicineDto.setMedicineRetailSaleProfit(2.0);
        medicineDto.setMedicineTax(5.0);
        medicineDto.setMedicineConversionRate(10.0);
        medicineDto.setMedicineManufacture("daphaco");
        medicineDto.setMedicineUsage("giảm mù mắt");
        medicineDto.setMedicineInstruction("nhỏ vào mắt");
        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
        medicineDto.setMedicineImage("img.png");
        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
        medicineDto.setFlag(true);
        medicineOrigin.setMedicineOriginId(1);
        medicineDto.setMedicineOrigin(medicineOrigin);
        medicineType.setMedicineTypeId("LT0001");
        medicineDto.setMedicineType(medicineType);
        medicineUnit.setMedicineUnitId(1);
        medicineDto.setMedicineUnit(medicineUnit);
        medicineConversionUnit.setMedicineConversionUnitId(1);
        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-medicine/medicines")
                .content(this.objectMapper.writeValueAsString(medicineDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this function use to test the validation of field name more specific is min length
     *
     * @author LongNH
     * @Time 15:05 30/06/2022
     */
    @Test
    public void createMedicine_name_16() throws Exception {
        MedicineDto medicineDto = new MedicineDto();
        MedicineOrigin medicineOrigin = new MedicineOrigin();
        MedicineType medicineType = new MedicineType();
        MedicineUnit medicineUnit = new MedicineUnit();
        MedicineConversionUnit medicineConversionUnit = new MedicineConversionUnit();
        medicineDto.setMedicineName("aa");
        medicineDto.setMedicineActiveIngredients("vitaminC");
        medicineDto.setMedicineImportPrice(500.0);
        medicineDto.setMedicineDiscount(3.0);
        medicineDto.setMedicineWholesaleProfit(2.0);
        medicineDto.setMedicineRetailSaleProfit(2.0);
        medicineDto.setMedicineTax(5.0);
        medicineDto.setMedicineConversionRate(10.0);
        medicineDto.setMedicineManufacture("daphaco");
        medicineDto.setMedicineUsage("giảm mù mắt");
        medicineDto.setMedicineInstruction("nhỏ vào mắt");
        medicineDto.setMedicineAgeApproved("trên 18 tuổi");
        medicineDto.setMedicineImage("img.png");
        medicineDto.setMedicineDescription("chống chỉ định chọt vào mắt");
        medicineDto.setFlag(true);
        medicineOrigin.setMedicineOriginId(1);
        medicineDto.setMedicineOrigin(medicineOrigin);
        medicineType.setMedicineTypeId("LT0001");
        medicineDto.setMedicineType(medicineType);
        medicineUnit.setMedicineUnitId(1);
        medicineDto.setMedicineUnit(medicineUnit);
        medicineConversionUnit.setMedicineConversionUnitId(1);
        medicineDto.setMedicineConversionUnit(medicineConversionUnit);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/manager-medicine/medicines")
                .content(this.objectMapper.writeValueAsString(medicineDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
