package com.c1221g1.pharmacy.service.report.impl;

import com.c1221g1.pharmacy.dto.report.*;
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
    /**
     * this method to get list of supplier that have receivable or payable
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<SupplierHaveReceivable> getSupplierHaveReceivable() {
        return this.iReportRepository.getSupplierHaveReceivable();
    }

    /**
     * this method to get list medicine to be out of stock
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<MedicineNeedToImport> getMedicineNeedToImport() {
        return this.iReportRepository.getMedicineNeedToImport();
    }

    /**
     * this method to get list medicine to be about out of date
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<MedicineBeAboutExpired> getMedicineBeAboutExpired() {
        return this.iReportRepository.getMedicineBeAboutExpired();
    }

    /**
     * this method to get list revenue and profit to show static on angular
     * @author DinhH
     * @Time 20:30 30/06/2022
     */
    @Override
    public List<Static> getStatic() {
        return this.iReportRepository.getStatic();
    }
}
