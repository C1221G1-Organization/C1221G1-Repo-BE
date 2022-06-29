package com.c1221g1.pharmacy.service.report.impl;

import com.c1221g1.pharmacy.dto.report.Revenue;
import com.c1221g1.pharmacy.repository.report.IReportRepository;
import com.c1221g1.pharmacy.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    private IReportRepository iReportRepository;
    /**
     * this method to get revenue and profit in period of time that you input
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @Override
    public List<Revenue> getRevenue(String startTime, String endTime) {
        return this.iReportRepository.getRevenue(startTime,endTime);
    }

    /**
     * this method to get revenue in period of time that you input; the revenue will be group by employee
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    @Override
    public List<Revenue> getRevenueByEmployee(String startTime, String endTime) {
        return this.iReportRepository.getRevenueByEmployee(startTime,endTime);
    }
}
