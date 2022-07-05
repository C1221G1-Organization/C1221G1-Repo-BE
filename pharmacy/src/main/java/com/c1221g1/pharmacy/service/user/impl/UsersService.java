package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
import com.c1221g1.pharmacy.entity.customer.Customer;
import com.c1221g1.pharmacy.entity.customer.CustomerType;
import com.c1221g1.pharmacy.entity.user.Provider;
import com.c1221g1.pharmacy.entity.user.Roles;
import com.c1221g1.pharmacy.entity.user.UserRole;
import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.repository.customer.ICustomerRepository;
import com.c1221g1.pharmacy.repository.user.IRoleRepository;
import com.c1221g1.pharmacy.repository.user.IUserRoleRepository;
import com.c1221g1.pharmacy.repository.user.IUsersRepository;
import com.c1221g1.pharmacy.service.user.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


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

    @Autowired
    private IRoleRepository iRoleRepository;


    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function format Date, and save data for customer when sign up
     */
    @Override
    public void saveUsers(SignUpRequest signUpRequest) {
            Users users = new Users(signUpRequest.getEmail(),passwordEncoder.encode(signUpRequest.getPassword()));
            users.setFlag(true);
            CustomerType customerType = new CustomerType();
            customerType.setCustomerTypeId(2);
            customerType.setCustomerTypeName("Khách lẻ");
            Customer customer = new Customer();
            customer.setCustomerName(signUpRequest.getName());
            customer.setCustomerBirthday(signUpRequest.getDayOfBirth());
            customer.setCustomerAddress(signUpRequest.getAddress());
            customer.setCustomerNote(signUpRequest.getNote());
            customer.setCustomerPhone(signUpRequest.getPhone());
            customer.setCustomerGender(signUpRequest.getGender());
            customer.setCustomerUsername(users);
            customer.setCustomerType(customerType);
            customer.setFlag(true);
            Roles roles = this.iRoleRepository.findRolesByRoleName("ROLE_USER");
            UserRole userRole = new UserRole(users,roles);
            this.iUsersRepository.save(users);
            this.iUserRoleRepository.save(userRole);
            this.iCustomerRepository.save(customer);


    }

    /**
     * Created by HuuNQ
     * Time 12:00 30/06/2022
     * Function Create new User for facebook login first time
     */

    public UsersDetails processOAuthPostLogin(String username, Map<String,Object> attributes) {
        Users existUser = this.iUsersRepository.getUserByUsername(username);
        if (existUser == null) {
            Users newUser = new Users();
            newUser.setUsername(username);
            newUser.setProvider(Provider.FACEBOOK);
            newUser.setFlag(true);
            this.iUsersRepository.save(newUser);
        }

        return UsersDetails.create(existUser,attributes);

    }

    @Override
    public void saveUser(Users users) {
        this.iUsersRepository.save(users);
    }


    @Override
    public List<Users> checkEmail(String email) {
        return this.iUsersRepository.checkEmail(email);
    }
}
