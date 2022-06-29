package com.c1221g1.pharmacy.repository.prescription;

import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPrescriptionRepository extends JpaRepository<Prescription, String> {

    /*
     * Created by DaLQA
     * Time: 11:30 PM 29/06/2022
     * Function: function findAllPage
     * */
    @Query(value = "select prescription.prescription_id, " +
            " prescription.flag, " +
            " prescription.prescription_name," +
            " prescription.prescription_target_user," +
            " prescription.prescription_symptom, " +
            " prescription.prescription_number_of_days, " +
            " prescription.prescription_note " +
            " from prescription" +
            " where prescription.prescription_id like :id " +
            " and prescription.prescription_name like :names" +
            " and prescription.prescription_target_user like :target " +
            " and prescription.prescription_symptom like :symptom " +
            " and prescription.flag = 1",
            countQuery = "select prescription.prescription_id, " +
                    " prescription.flag, " +
                    " prescription.prescription_name," +
                    " prescription.prescription_target_user," +
                    " prescription.prescription_symptom, " +
                    " prescription.prescription_number_of_days, " +
                    " prescription.prescription_note " +
                    " from prescription" +
                    " where prescription.prescription_id like :id " +
                    " and prescription.prescription_name like :names" +
                    " and prescription.prescription_target_user like :target " +
                    " and prescription.prescription_symptom like :symptom " +
                    " and prescription.flag = 1",
            nativeQuery = true)
    Page<Prescription> findAllPage(
            @Param("id") String id,
            @Param("names") String names,
            @Param("target") String target,
            @Param("symptom") String symptom,
            Pageable pageable);
    /*
     * Created by DaLQA
     * Time: 11:30 PM 29/06/2022
     * Function: function findByIdQuery
     * */
    @Query(value = "select prescription.prescription_id, " +
            " prescription.flag, " +
            " prescription.prescription_name," +
            " prescription.prescription_target_user," +
            " prescription.prescription_symptom, " +
            " prescription.prescription_number_of_days, " +
            " prescription.prescription_note " +
            "from prescription" +
            " where prescription.prescription_id = :id ",
            nativeQuery = true)
    Prescription findByIdQuery( @Param("id") String id);
}
