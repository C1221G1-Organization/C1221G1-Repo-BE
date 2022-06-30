package com.c1221g1.pharmacy.service.report;

import com.c1221g1.pharmacy.dto.report.Revenue;

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

}
