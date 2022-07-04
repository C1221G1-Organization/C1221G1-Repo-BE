package com.c1221g1.pharmacy.repository.invoice;

import com.c1221g1.pharmacy.dto.invoice.IInvoiceDto;
import com.c1221g1.pharmacy.entity.invoice.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IInvoiceRepository extends JpaRepository<Invoice, String> {
    /*
     * Created by DaLQA
     * Time: 7:30 PM 29/06/2022
     * Function: function getNewInvoice
     * */
    @Query(value = "select invoice_id, flag, invoice_create_time, invoice_created_date," +
            " invoice_note, customer_id,employee_id, type_of_invoice_id" +
            " from invoice " +
            " order by invoice.invoice_id " +
            " desc limit 1;",
            nativeQuery = true)
    Invoice getNewInvoice();

    @Query(value = "select invoice_id,invoice_created_date,customer_id,employee_id,invoice_note,flag,\n" +
            "       type_of_invoice_id" +
            "from invoice \n" +
            "where invoice_id = :invoice_id and flag = :status ",
            nativeQuery = true)
    Invoice findByInvoiceId(@Param("invoice_id")String invoiceId, @Param("status") boolean status);


    /**
     * @author TuanPA
     * Function: find all invoice with all arguments in search field
     * @return invoice page
     */
    @Query(value = "select invoice.invoice_id as invoiceId, customer.customer_name as customerName, employee.employee_name as employeeName, " +
            "invoice_created_date as invoiceCreatedDate, invoice_create_time as invoiceCreateTime, invoice_note as " +
            "invoiceNote, invoice.type_of_invoice_id as typeOfInvoiceId, sum((medicine.medicine_retail_sale_profit + 1) " +
            "* medicine.medicine_import_price * invoice_medicine.invoice_medicine_quantity) as invoiceTotalMoney " +
            "from medicine join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id " +
            "join invoice on invoice_medicine.invoice_id = invoice.invoice_id " +
            "join customer on invoice.customer_id = customer.customer_id " +
            "join employee on invoice.employee_id = employee.employee_id " +
            "where (invoice_created_date between :startDate and :endDate) " +
            "   and (invoice_create_time between :startTime and :endTime ) " +
            "   and invoice.type_of_invoice_id = :typeOfInvoiceId " +
            "   and invoice.flag = 1 " +
            "group by invoice.invoice_id ",
            countQuery = "select invoice.invoice_id as invoiceId, customer.customer_name as customerName, employee.employee_name as employeeName, " +
                    "invoice_created_date as invoiceCreatedDate, invoice_create_time as invoiceCreateTime, invoice_note as " +
                    "invoiceNote, invoice.type_of_invoice_id as typeOfInvoiceId, sum((medicine.medicine_retail_sale_profit + 1) " +
                    "* medicine.medicine_import_price * invoice_medicine.invoice_medicine_quantity) as invoiceTotalMoney " +
                    "from medicine join invoice_medicine on medicine.medicine_id = invoice_medicine.medicine_id " +
                    "join invoice on invoice_medicine.invoice_id = invoice.invoice_id " +
                    "join customer on invoice.customer_id = customer.customer_id " +
                    "join employee on invoice.employee_id = employee.employee_id " +
                    "where (invoice_created_date between :startDate and :endDate) " +
                    "   and (invoice_create_time between :startTime and :endTime ) " +
                    "   and invoice.type_of_invoice_id = :typeOfInvoiceId " +
                    "   and invoice.flag = 1 " +
                    "group by invoice.invoice_id ",
            nativeQuery = true)
    Page<IInvoiceDto> findAllInvoice(@Param("startDate") String startDate,
                                     @Param("endDate") String endDate,
                                     @Param("startTime") String startTime,
                                     @Param("endTime") String endTime,
                                     @Param("typeOfInvoiceId") String typeOfInvoiceId,
                                     Pageable pageable);
    /**
     * @author TuanPA
     * function: find invoice by id
     * @return invoice
     */
    @Query(value = "select invoice_id from invoice where invoice_id = :id", nativeQuery = true)
    Invoice findInvoiceById(String id);


    /**
     * @author TuanPA
     * function: set invoice flag = 0
     * @return invoice
     */
    @Transactional
    @Modifying
    @Query(value="UPDATE invoice set flag = 0 where invoice_id = :id ", nativeQuery=true)
    void deleteByFlag(String id);
}
