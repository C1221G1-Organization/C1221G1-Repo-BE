package com.c1221g1.pharmacy.repository.prescription;

import com.c1221g1.pharmacy.entity.prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IPrescriptionRepository extends JpaRepository<Prescription, String> {
    /**
     * HienTLD
     * Câu lệnh sql danh sách toa thuốc và tìm kiếm
     * 16:00 29/06/2022
     */
    @Query(value = "select prescription.prescription_id, prescription.flag, prescription.prescription_name, prescription.prescription_target_user," +
            " prescription.prescription_symptom, prescription.prescription_number_of_days, prescription.prescription_note from prescription" +
            " where prescription.prescription_id like :id and prescription.prescription_name like :names" +
            " and prescription.prescription_target_user like :target and prescription.prescription_symptom like :symptom and prescription.flag = 1",
            countQuery = "select prescription.prescription_id,prescription.flag, prescription.prescription_name, prescription.prescription_target_user," +
                    " prescription.prescription_symptom, prescription.prescription_number_of_days, prescription.prescription_note from prescription" +
                    " where prescription.prescription_id like :id and prescription.prescription_name like :names" +
                    " and prescription.prescription_target_user like :target and prescription.prescription_symptom like :symptom",
            nativeQuery = true)
    Page<Prescription> findAll(
            @Param("id") String id,
            @Param("names") String names,
            @Param("target") String target,
            @Param("symptom") String symptom,
            Pageable pageable);

//    /**
//     * HienTLD
//     * Câu lệnh sql thêm mới toa thuốc
//     * 16:30 29/06/2022
//     */
//    @Transactional
//    @Modifying
//    @Query(value = "insert into prescription(prescription_id, flag, prescription_name, prescription_note, prescription_number_of_days, prescription_symptom, prescription_target_user)" +
//            " values (?,?,?,?,?,?,?); ", nativeQuery = true)
//    void createPrescription();

    /**
     * HienTLD
     * Câu lệnh sql xoá toa thuốc theo cờ 'flag'
     * 16:00 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update prescription set `flag` = 0 where prescription_id = :id", nativeQuery = true)
    void deletePrescriptionById(@Param("id") String id);


    /**
     * HienTLD
     * Sửa toa thuốc (xoá theo cờ 'flag')
     * 20:14 29/06/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update prescription" +
            " set prescription_name = :prescription_name," +
            " prescription_symptom = :prescription_symptom," +
            " prescription_target_user = :prescription_target_user," +
            " prescription_note = :prescription_note," +
            " prescription_number_of_days = :prescription_number_of_days " +
            "where prescription_id = :prescription_id",
            nativeQuery = true)
    void editPrescription(@Param("prescription_name") String name,
                          @Param("prescription_symptom") String symptom,
                          @Param("prescription_target_user") String targetUser,
                          @Param("prescription_note") String note,
                          @Param("prescription_number_of_days") Integer numberOfDays,
                          @Param("prescription_id") String id);

}
