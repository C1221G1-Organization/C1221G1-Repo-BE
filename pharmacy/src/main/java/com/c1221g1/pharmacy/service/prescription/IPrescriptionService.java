package com.c1221g1.pharmacy.service.prescription;

import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPrescriptionService {
    /*
     * Created by DaLQA
     * Time: 11:30 PM 29/06/2022
     * Function: function findAllPage
     * */
    Page<Prescription> findAllPage(String idVal, String nameVal, String targetVal, String symptomVal, Pageable pageable);

    /*
     * Created by DaLQA
     * Time: 11:55 PM 29/06/2022
     * Function: function findAllPage
     * */
    Prescription findById(String id);
}
