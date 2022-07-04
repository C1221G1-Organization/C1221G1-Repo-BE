package com.c1221g1.pharmacy.controller;

import com.c1221g1.pharmacy.entity.employee.Position;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/manager-position/positions")
public class PositionController {

    @Autowired
    private IPositionService iPositionService;
    @GetMapping(value = "")
    public ResponseEntity<List<Position>> getAllPosition(){
        List<Position> positionList = this.iPositionService.getPositionList();
        if(positionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(positionList,HttpStatus.OK);
    }
}
