package com.c1221g1.pharmacy.service.user.impl;

import com.c1221g1.pharmacy.entity.user.Users;
import com.c1221g1.pharmacy.repository.user.IUsersRepository;
import com.c1221g1.pharmacy.service.user.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService {
    @Autowired
    private IUsersRepository iUsersRepository;

    @Override
    public void saveUser(Users users) {
        this.iUsersRepository.save(users);
    }

    @Override
    public List<Users> checkEmail(String email) {
        return this.iUsersRepository.checkEmail(email);
    }
}
