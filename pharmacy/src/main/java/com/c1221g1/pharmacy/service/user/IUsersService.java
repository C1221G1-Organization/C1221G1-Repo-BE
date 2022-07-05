package com.c1221g1.pharmacy.service.user;

import com.c1221g1.pharmacy.entity.user.Users;

import java.util.List;

public interface IUsersService {
    void saveUser(Users users);
    List<Users> checkEmail(String email);
}
