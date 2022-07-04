package com.c1221g1.pharmacy.service.user.oauth2;

import com.c1221g1.pharmacy.service.user.impl.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class CustomOidcUserService extends OidcUserService {
    @Autowired
    private UsersService usersService;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
//        OidcUser oidcUser =
//        usersService.processOAuthPostLogin(userRequest.getClientRegistration().getRegistrationId(),
//                oidcUser.getAttributes()
//                ,oidcUser.getIdToken()
//                ,oidcUser.getUserInfo())
        return super.loadUser(userRequest);
    }
}
