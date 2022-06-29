package com.c1221g1.pharmacy.controller.medicine;

import com.c1221g1.pharmacy.service.medicine.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
@CrossOrigin("**")
public class MedicineController {
    @Autowired
    private IMedicineService medicineService;
}
