package com.c1221g1.pharmacy.controller.user;

import com.c1221g1.pharmacy.dto.user.payload.LoginRequest;
import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import com.c1221g1.pharmacy.service.user.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/api/manager-security/users")
public class UserController {
    @Autowired
    private IUsersService iUsersService;

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> getSignIn(@RequestBody LoginRequest loginRequest){
        Users users = this.iUsersService.findUsersByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
        return ResponseEntity.ok().body(users);
    }

    /**
     * Created by HuuNQ
     * Time
     * Function Sign Up
     */

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest){
//        if(this.iUsersService.checkEmail(signUpRequest.getEmail())){
//            return ResponseEntity.badRequest().body("Đã tồn tại email này");
//        }
        this.iUsersService.saveUsers(signUpRequest);
        return ResponseEntity.ok().body("Đăng ký thành công");
    }
}
