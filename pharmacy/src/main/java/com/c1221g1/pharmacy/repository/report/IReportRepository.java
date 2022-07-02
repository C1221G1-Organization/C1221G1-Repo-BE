package com.c1221g1.pharmacy.repository.report;

import com.c1221g1.pharmacy.dto.report.*;
import com.c1221g1.pharmacy.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReportRepository extends JpaRepository<Customer, String> {
    /**
     * this method to get revenue and profit in period of time that you input
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @Query(value = "Select i.invoice_id invoiceId,\n" +
            "            i.invoice_created_date createdDay,\n" +
            "            i.employee_id employeeId,\n" +
            "            (ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                                               *m.medicine_retail_sale_profit)) total,\n" +
            "            (ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                 *(m.medicine_retail_sale_profit-1)) profit\n" +
            "            from invoice i\n" +
            "            inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "            inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "            Where ((i.invoice_created_date>=:startTime) and (i.invoice_created_date<=:endTime))\n" +
            "            Group by i.invoice_id", nativeQuery = true)
    List<Revenue> getRevenue(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * this method to get revenue in period of time that you input; the revenue will be group by employee
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    @Query(value = "select " +
            "       i.employee_id employeeId,\n" +
            "       sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                                          *m.medicine_retail_sale_profit))) total,\n" +
            "       sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                                            *(m.medicine_retail_sale_profit-1))) profit\n" +
            "        from invoice i\n" +
            "         inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "         inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "        Where ((i.invoice_created_date>=:startTime) and (i.invoice_created_date<=:endTime))\n" +
            "        Group by i.employee_id;", nativeQuery = true)
    List<Revenue> getRevenueByEmployee(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * this method to get list of supplier that have receivable or payable
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    @Query(value = "select s.supplier_id supplierId, s.supplier_name supplierName,\n" +
            "       sum((ii.total-ii.payment_prepayment)) balance\n" +
            "from supplier s\n" +
            "         inner join import_invoice ii on s.supplier_id = ii.supplier_id\n" +
            "group by s.supplier_id\n" +
            "having balance>0", nativeQuery = true)
    List<SupplierHaveReceivable> getSupplierHaveReceivable();

    /**
     * this method to get list medicine to be out of stock
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Query(value = "select m.medicine_id medicineId, m.medicine_name medicineName, ms.medicine_quantity quantity\n" +
            "from medicine m\n" +
            "inner join medicine_storage ms on m.medicine_id = ms.medicine_id\n" +
            "where medicine_quantity<5;", nativeQuery = true)
    List<MedicineNeedToImport> getMedicineNeedToImport();

    /**
     * this method to get list medicine to be about out of date
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Query(value = "select m.medicine_id medicineId, m.medicine_name medicineName, ms.medicine_quantity quantity,\n" +
            "       iim.import_invoice_medicine_expiry expiredDate\n" +
            "from medicine_storage ms\n" +
            "inner join medicine m on ms.medicine_id = m.medicine_id\n" +
            "inner join import_invoice_medicine iim on m.medicine_id = iim.medicine_id\n" +
            "where (iim.import_invoice_medicine_expiry-curdate()<10)\n" +
            "group by m.medicine_id", nativeQuery = true)
    List<MedicineBeAboutExpired> getMedicineBeAboutExpired();

    /**
     * this method to get list revenue and profit to show static on angular
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Query(value = "Select      month('2021-01-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-01-01') and (i.invoice_created_date<='2021-01-31'));", nativeQuery = true)
    Static getMonth1();
    @Query(value = "Select  month('2021-02-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-02-01') and (i.invoice_created_date<='2021-02-28'));", nativeQuery = true)
    Static getMonth2();
    @Query(value = "Select  month('2021-03-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-03-01') and (i.invoice_created_date<='2021-03-31'));", nativeQuery = true)
    Static getMonth3();
    @Query(value = "Select      month('2021-04-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-04-01') and (i.invoice_created_date<='2021-04-30'));", nativeQuery = true)
    Static getMonth4();
    @Query(value = "Select      month('2021-05-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-05-01') and (i.invoice_created_date<='2021-05-31'));", nativeQuery = true)
    Static getMonth5();
    @Query(value = "Select      month('2021-06-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-06-01') and (i.invoice_created_date<='2021-06-30'));", nativeQuery = true)
    Static getMonth6();
    @Query(value = "Select      month('2021-07-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-07-01') and (i.invoice_created_date<='2021-07-31'));", nativeQuery = true)
    Static getMonth7();
    @Query(value = "Select      month('2021-08-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-08-01') and (i.invoice_created_date<='2021-08-31'));", nativeQuery = true)
    Static getMonth8();
    @Query(value = "Select      month('2021-09-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-09-01') and (i.invoice_created_date<='2021-09-30'));", nativeQuery = true)
    Static getMonth9();
    @Query(value = "Select      month('2021-10-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-10-01') and (i.invoice_created_date<='2021-10-31'));", nativeQuery = true)
    Static getMonth10();
    @Query(value = "Select      month('2021-11-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-11-01') and (i.invoice_created_date<='2021-11-30'));", nativeQuery = true)
    Static getMonth11();
    @Query(value = "Select      month('2021-12-01') 'month',\n" +
            "            sum((ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *m.medicine_retail_sale_profit))) revenue,\n" +
            "            sum((ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                *(m.medicine_retail_sale_profit-1))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where ((i.invoice_created_date>='2021-12-01') and (i.invoice_created_date<='2021-12-31'));", nativeQuery = true)
    Static getMonth12();
}
