package com.c1221g1.pharmacy.service.employee.impl;


import com.c1221g1.pharmacy.repository.employee.IPositionRepository;
import com.c1221g1.pharmacy.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;

}
