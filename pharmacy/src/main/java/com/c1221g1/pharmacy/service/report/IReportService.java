package com.c1221g1.pharmacy.service.report;

import com.c1221g1.pharmacy.dto.report.MedicineBeAboutExpired;
import com.c1221g1.pharmacy.dto.report.MedicineNeedToImport;
import com.c1221g1.pharmacy.dto.report.Revenue;
import com.c1221g1.pharmacy.dto.report.SupplierHaveReceivable;

import java.util.List;

public interface IReportService {
    /**
     * this method to get revenue and profit in period of time that you input
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    List<Revenue> getRevenue(String startTime, String endTime);

    /**
     * this method to get revenue in period of time that you input; the revenue will be group by employee
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    List<Revenue> getRevenueByEmployee(String startTime, String endTime);

    /**
     * this method to get list of supplier that have receivable or payable
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    List<SupplierHaveReceivable> getSupplierHaveReceivable();

    /**
     * this method to get list medicine to be out of stock
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    List<MedicineNeedToImport> getMedicineNeedToImport();

    /**
     * this method to get list medicine to be about out of date
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    List<MedicineBeAboutExpired> getMedicineBeAboutExpired();
}
