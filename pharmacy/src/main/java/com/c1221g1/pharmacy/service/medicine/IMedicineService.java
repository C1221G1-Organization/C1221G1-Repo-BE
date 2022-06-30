package com.c1221g1.pharmacy.service.medicine;

import com.c1221g1.pharmacy.entity.medicine.Medicine;

import java.util.Optional;

public interface IMedicineService {
    void createMedicine(Medicine medicine);

    Optional<Medicine> findMedicineById(String id);

    void updateMedicine(Medicine existMedicine);
<<<<<<< HEAD
}
=======
}
>>>>>>> 5994c8197acff693e71bb33472520fe498661423
