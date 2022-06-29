package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.service.employee.IEmployeeService;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping(value = "api/manager-employee/")
public class PositionController {
    @Autowired
    IPositionService iPositionService;

    @GetMapping(value = "/position")
    public ResponseEntity<List<Position>> getAllPosition() {
        List<Position> positions = this.iPositionService.findAll();
        if (positions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }
}
