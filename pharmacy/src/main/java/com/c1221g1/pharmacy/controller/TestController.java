package com.c1221g1.pharmacy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pharmacy")
public class TestController {
    @GetMapping("/")
    public ResponseEntity<?> homepage(){
        return ResponseEntity.ok("Trang chủ");
    }
    @GetMapping("/user-page")
    public ResponseEntity<?> userPage(){
        return ResponseEntity.ok("User page");
    }
    @GetMapping("/cart")
    public ResponseEntity<?> userCartPage(){
        return ResponseEntity.ok("Màn hình giỏ hàng");
    }
    @GetMapping("/employee-page")
    public ResponseEntity<?> employeePage(){
        return ResponseEntity.ok("Màn hình nhân viên");
    }
    @GetMapping("/employee-page/sale")
    public ResponseEntity<?> employeeSalePage(){
        return ResponseEntity.ok("Màn hình danh sách thuốc");
    }
    @GetMapping("/manager-page")
    public ResponseEntity<?> managerPage(){
        return ResponseEntity.ok("Màn hình dành cho quản lý");
    }

    @GetMapping("/manager-page/manager")
    public ResponseEntity<?> managerControlPage(){
        return ResponseEntity.ok("Màn hình danh sách thuốc");
    }
}
