package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.customer.CustomerType;
import com.c1221g1.pharmacy.entity.user.Provider;
import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.entity.user.UserRole;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.repository.user.IUserRoleRepository;
import com.c1221g1.pharmacy.repository.user.IUsersRepository;
import com.c1221g1.pharmacy.service.user.IUsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class UsersService implements IUsersService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUsersRepository iUsersRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function find User when submit Login form
     */
    @Override
    public Users findUsersByUsernameAndPassword(String username, String password) {
        Users users = new Users();
        users = (Users) this.iUsersRepository.getUsersByUsernameAndPassword(username,password);
        return users;
    }
    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function format Date, and save data for customer when sign up
     */
    @Override
    public void saveUsers(SignUpRequest signUpRequest) {
        String id = String.valueOf(Math.random()*8999+1000);
        String[] dateSplit = signUpRequest.getDayOfBirth().split("/");
        String dateFormat = dateSplit[2]+"-"+dateSplit[1]+"-"+dateSplit[0];
        try{
            this.iUsersRepository.saveUser(signUpRequest.getEmail(),passwordEncoder.encode(signUpRequest.getPassword()),true);
            this.iCustomerRepository.saveCustomer(id,signUpRequest.getName(),
                    signUpRequest.getAddress(),
                    dateFormat,
                    signUpRequest.getGender(),
                    signUpRequest.getPhone(),
                    signUpRequest.getNote(),signUpRequest.getFlag(),signUpRequest.getCustomerType(),signUpRequest.getEmail());
            this.iUserRoleRepository.saveUserRole(signUpRequest.getEmail(),1);
        }catch (Exception e){
            e.getMessage();
        }

    }

    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function Create new User for facebook login first time
     */

    public void processOAuthPostLogin(String username) {
        Users existUser = this.iUsersRepository.getUserByUsername(username);
        if (existUser == null) {
            Users newUser = new Users();
            newUser.setUsername(username);
            newUser.setProvider(Provider.FACEBOOK);
            newUser.setFlag(true);
            this.iUsersRepository.save(newUser);
        }

    }
    @Override
    public List<Users> checkEmail(String email) {
        return this.iUsersRepository.checkEmail(email);
    }
}
