package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.dto.medicine.MedicineLookUpDto;
import com.c1221g1.pharmacy.entity.medicine.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicineService {
    List<MedicineLookUpDto> findAllMedicine(String columName, String condition,
                                            String keyword);

    Medicine findMedicineById(String id);

    void deleteMedicineById(String id);
}
