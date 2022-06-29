package com.c1221g1.pharmacy.service.user;

import com.c1221g1.pharmacy.dto.user.payload.SignUpRequest;
import com.c1221g1.pharmacy.entity.user.Users;

public interface IUsersService {
    Users findUsersByUsernameAndPassword(String username, String password);

    void saveUsers(SignUpRequest signUpRequest);

    boolean checkEmail(String email);
}
