package com.c1221g1.pharmacy.controller.report;

import com.c1221g1.pharmacy.dto.report.Revenue;
import com.c1221g1.pharmacy.dto.report.Supplier;
import com.c1221g1.pharmacy.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RequestMapping(value = "/api/manager_report/report")
@RestController
public class ReportController {
    @Autowired
    private IReportService iReportService;

    /**
     * this method to get revenue in period of time that you input
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @GetMapping("/revenue")
    public ResponseEntity<List<Revenue>> getRevenue(@RequestParam Optional<String> startTime,
                                                    @RequestParam Optional<String> endTime){
        String startTimeVal = startTime.orElse("");
        String endTimeVal = endTime.orElse("");
        if ("".equals(startTimeVal)||"".equals(endTimeVal)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Revenue> revenueList = this.iReportService.getRevenue(startTimeVal, endTimeVal);
            if (revenueList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(revenueList, HttpStatus.OK);
        }
    }

    /**
     * this method to get profit in period of time that you input
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:00 29/06/2022
     */
    @GetMapping("/profit")
    public ResponseEntity<List<Revenue>> getProfit(@RequestParam Optional<String> startTime,
                                                 @RequestParam Optional<String> endTime){
        String startTimeVal = startTime.orElse("");
        String endTimeVal = endTime.orElse("");
        if ("".equals(startTimeVal)||"".equals(endTimeVal)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Revenue> revenueList = this.iReportService.getRevenue(startTimeVal, endTimeVal);
            if (revenueList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(revenueList, HttpStatus.OK);
        }

    }

    /**
     * this method to get revenue in period of time that you input; the revenue will be group by employee
     * @param startTime
     * @param endTime
     * @author DinhH
     * @Time 15:30 29/06/2022
     */
    @GetMapping("/diary")
    public ResponseEntity<List<Revenue>> getRevenueByEmployee(@RequestParam Optional<String> startTime,
                                                   @RequestParam Optional<String> endTime){
        String startTimeVal = startTime.orElse("");
        String endTimeVal = endTime.orElse("");
        if ("".equals(startTimeVal)||"".equals(endTimeVal)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            List<Revenue> revenueList = this.iReportService.getRevenueByEmployee(startTimeVal, endTimeVal);
            if (revenueList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(revenueList, HttpStatus.OK);
        }
    }
    /**
     * this method to get list of supplier that have receivable or payable
     * @author DinhH
     * @Time 15:30 29/06/2022
     * ps: because the data base of supplier, stock have issue so
     */
    @GetMapping("/supplier")
    public ResponseEntity<List<Supplier>> getSupplier(){
            List<Supplier> suppliers = new ArrayList<>();
            suppliers.add(new Supplier(1,"Hoa Long",15000000,10000000,5000000));
            suppliers.add(new Supplier(2,"Nhất Sơn",20000000,10000000,10000000));
            suppliers.add(new Supplier(3,"Hoa Đà",200000000,100000000,100000000));
            if (suppliers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }
}
