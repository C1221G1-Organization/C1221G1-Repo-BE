package com.c1221g1.pharmacy.controller.user;

import com.c1221g1.pharmacy.dto.user.payload.JwtResponse;
import com.c1221g1.pharmacy.dto.user.payload.LoginRequest;
import com.c1221g1.pharmacy.dto.user.payload.ResponseMessage;
import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.service.customer.ICustomerService;
import com.c1221g1.pharmacy.service.user.IUsersService;
import com.c1221g1.pharmacy.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/manager-security/users")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUsersService iUsersService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private JwtUtils jwtUtils;
    /**
     * Created by HuuNQ
     * Time 16:00 30/06/2022
     * Function Sign-in Account Online and when success login server will return information with JWT
     */
    @PostMapping("/sign-in")
    public ResponseEntity<?> getSignIn(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtKey(authentication);
        User user = (User) authentication.getPrincipal();
        List<String> role = user.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(
                jwt, loginRequest.getUsername(), loginRequest.getPassword(), role)
        );
    }

    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Function Sign Up Online And Validate Sign Up Form
     */
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest,BindingResult bindingResult){
        new SignUpRequest().validate(signUpRequest,bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors()
                    .forEach(
                            err -> errorMap.put(err.getField(),err.getDefaultMessage())
                    );
            return ResponseEntity.badRequest().body(new ResponseMessage<>(false,"Failed!",errorMap,new ArrayList<>()));
        }
        if(this.iUsersService.checkEmail(signUpRequest.getEmail()).size() > 0){
            errorMap.put("email","Email đã được sử dụng!");
            return ResponseEntity.badRequest().body(new ResponseMessage<>(false,"Failed!",errorMap,new ArrayList<>()));
        }
        this.iUsersService.saveUsers(signUpRequest);
        return ResponseEntity.ok().body("Đăng ký thành công");
    }
}
