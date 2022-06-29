package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.customer.CustomerType;
import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.entity.user.UserRole;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.repository.user.IUserRoleRepository;
import com.c1221g1.pharmacy.repository.user.IUsersRepository;
import com.c1221g1.pharmacy.service.user.IUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UsersService implements IUsersService {
    @Autowired
    private IUsersRepository iUsersRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Override
    public Users findUsersByUsernameAndPassword(String username, String password) {
        Users users = new Users();
        users = (Users) this.iUsersRepository.getUsersByUsernameAndPassword(username,password);
        return users;
    }

    @Override
    public void saveUsers(SignUpRequest signUpRequest) {
        this.iUsersRepository.saveUser(signUpRequest.getEmail(),signUpRequest.getPassword(),true);
        String id = String.valueOf(Math.random()*8999+1000);
        this.iCustomerRepository.saveCustomer(id,signUpRequest.getName(),
                signUpRequest.getAddress(),
                signUpRequest.getDayOfBirth(),
                signUpRequest.getGender(),
                signUpRequest.getPhone(),
                signUpRequest.getNote(),signUpRequest.getFlag(),signUpRequest.getCustomerType(),signUpRequest.getEmail());
        this.iUserRoleRepository.saveUserRole(signUpRequest.getEmail(),1);
    }

    @Override
    public boolean checkEmail(String email) {
        return this.iUsersRepository.checkEmail(email);
    }
}
