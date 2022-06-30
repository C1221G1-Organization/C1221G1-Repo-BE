package com.c1221g1.pharmacy.repository.report;

import com.c1221g1.pharmacy.dto.report.Revenue;
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
            "            (ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)*m.medicine_retail_sale_profit)) total,\n" +
            "            (ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)*(m.medicine_retail_sale_profit-1)) profit\n" +
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
    @Query(value = "Select i.invoice_id invoiceId,\n" +
            "            i.invoice_created_date createdDay,\n" +
            "            i.employee_id employeeId,\n" +
            "            (ic.invoice_medicine_quantity*((m.medicine_import_price/m.medicine_conversion_rate)*m.medicine_retail_sale_profit)) total,\n" +
            "            (ic.invoice_medicine_quantity*(m.medicine_import_price/m.medicine_conversion_rate)*(m.medicine_retail_sale_profit-1)) profit\n" +
            "            from invoice i\n" +
            "            inner join invoice_medicine ic on  i.invoice_id = ic.invoice_id\n" +
            "            inner join medicine m on ic.medicine_id = m.medicine_id\n" +
            "            Where ((i.invoice_created_date>=:startTime) and (i.invoice_created_date<=:endTime))\n" +
            "            Group by i.employee_id", nativeQuery = true)
    List<Revenue> getRevenueByEmployee(@Param("startTime") String startTime, @Param("endTime") String endTime);

}
