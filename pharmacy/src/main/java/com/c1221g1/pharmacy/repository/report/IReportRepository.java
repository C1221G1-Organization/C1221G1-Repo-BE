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
     *
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @Query(value = "Select i.invoice_id invoiceId,\n" +
            "            i.invoice_created_date createdDay,\n" +
            "            i.employee_id employeeId,\n" +
            "            (if(i.type_of_invoice_id = 1,\n" +
            "                ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                                               *m.medicine_retail_sale_profit),\n" +
            "                ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                                               *m.medicine_wholesale_profit))) total,\n" +
            "           (if(i.type_of_invoice_id = 1,\n" +
            "               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                   *(m.medicine_retail_sale_profit-1),\n" +
            "               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                   *(m.medicine_wholesale_profit-1))) profit\n" +
            "            from invoice i\n" +
            "            inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "            inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "            Where ((i.invoice_created_date>=:startTime) and (i.invoice_created_date<=:endTime))\n" +
            "            Group by i.invoice_id;", nativeQuery = true)
    List<Revenue> getRevenue(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * this method to get revenue in period of time that you input; the revenue will be group by employee
     *
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    @Query(value = "select\n" +
            "       i.employee_id employeeId,\n" +
            "       sum((if(i.type_of_invoice_id = 1,\n" +
            "               ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                   *m.medicine_retail_sale_profit),\n" +
            "               ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                   *m.medicine_wholesale_profit)))) total,\n" +
            "       sum((if(i.type_of_invoice_id = 1,\n" +
            "               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                   *(m.medicine_retail_sale_profit-1),\n" +
            "               ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                   *(m.medicine_wholesale_profit-1)))) profit\n" +
            "        from invoice i\n" +
            "         inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "         inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "        Where ((i.invoice_created_date>=:startTime) and (i.invoice_created_date<=:endTime))\n" +
            "        Group by i.employee_id;", nativeQuery = true)
    List<Revenue> getRevenueByEmployee(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * this method to get list of supplier that have receivable or payable
     *
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
     *
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
     *
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
     * this method to get list 100 medicine that have best sold-out
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Query(value = "select m.medicine_id medicineId, m.medicine_name medicineName, " +
            "sum(im.invoice_medicine_quantity) totalQuantity\n" +
            "from medicine m\n" +
            "inner join invoice_medicine im on m.medicine_id = im.medicine_id\n" +
            "group by m.medicine_id\n" +
            "order by totalQuantity desc\n" +
            "limit 100;", nativeQuery = true)
    List<TopMedicine> getTopMedicine();

    /**
     * this method to get list revenue and profit to show static on angular
     *
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Query(value = "Select      '1' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='1' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth1(@Param("year") String year);

    @Query(value = "Select      '2' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='2' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth2(@Param("year") String year);

    @Query(value = "Select      '3' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='3' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth3(@Param("year") String year);

    @Query(value = "Select      '4' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='4' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth4(@Param("year") String year);

    @Query(value = "Select      '5' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='5' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth5(@Param("year") String year);

    @Query(value = "Select      '6' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='6' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth6(@Param("year") String year);

    @Query(value = "Select      '7' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='7' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth7(@Param("year") String year);

    @Query(value = "Select      '8' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='8' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth8(@Param("year") String year);

    @Query(value = "Select      '9' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='9' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth9(@Param("year") String year);

    @Query(value = "Select      '10' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='10' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth10(@Param("year") String year);

    @Query(value = "Select      '11' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='11' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth11(@Param("year") String year);

    @Query(value = "Select      '12' month,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_retail_sale_profit),\n" +
            "                    ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *m.medicine_wholesale_profit)))) revenue,\n" +
            "            sum((if(i.type_of_invoice_id = 1,\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_retail_sale_profit-1),\n" +
            "                    ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)\n" +
            "                        *(m.medicine_wholesale_profit-1)))) profit\n" +
            "     from invoice i\n" +
            "              inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "              inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "     Where (month(i.invoice_created_date)='12' and year(i.invoice_created_date)=:year);", nativeQuery = true)
    Static getMonth12(@Param("year") String year);
}
