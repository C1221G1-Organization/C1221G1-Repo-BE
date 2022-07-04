package com.c1221g1.pharmacy.config;

import com.c1221g1.pharmacy.service.user.impl.UsersDetailsService;
import com.c1221g1.pharmacy.service.user.impl.UsersService;
import com.c1221g1.pharmacy.service.user.oauth2.CustomOAuth2User;
import com.c1221g1.pharmacy.service.user.oauth2.CustomOAuth2UserService;
import com.c1221g1.pharmacy.service.user.oauth2.HttpCookieOAuth2AuthorizationRequestRepository;
import com.c1221g1.pharmacy.utils.AuthEntryPointJwt;
import com.c1221g1.pharmacy.utils.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.core.endpoint.DefaultMapOAuth2AccessTokenResponseConverter;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UsersDetailsService usersDetailService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    public AuthTokenFilter authTokenFilter;
    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Function : this method use to encode password
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Function Create Bean AuthenticationManager
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    /**
     * Created by HuuNQ
     * Time 16:00 29/06/2022
     * Override method configure to config
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         * manager-cart
         * manager-account
         * manager-customer
         * manager-employee
         * manager-medicine
         * manager-prescription
         * manager-report
         * manager-sale
         * manager-security
         * */
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/api/manager-security/users/sign-in"
                        ,"/api/manager-security/users/sign-up","/api/manager-cart/cart","/oauth2/**"
                        ,"/api/auth/**"
                    )
                .permitAll()
                .antMatchers("/api/manager-cart**")
                .hasRole("USER")
                .antMatchers("/api/manager-customer/**","/api/manager-prescription","/api/manager-sale/**")
                .hasAnyRole("EMPLOYEE","MANAGER")
                .antMatchers("/api/manager-account/**","/api/manager-medicine/**","/api/manager-employee/**","/api/manager-report/**")
                .hasRole("MANAGER")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60 * 60 * 24);
        http
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize")
                .authorizationRequestRepository(cookieOAuth2AuthorizationRequestRepository())
                .and()
                .redirectionEndpoint()
                .baseUri("/oauth2/callback/*")
                .and()
                .userInfoEndpoint()
                .userService(oauth2UserService)
                .and()
                .tokenEndpoint()
                .accessTokenResponseClient(oAuth2AccessTokenResponseClient())
                .and()
        .successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

                usersService.processOAuthPostLogin(oauthUser.getEmail(),oauthUser.getAttributes());
            }
        })
        .failureHandler(new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

                            }
                        }
        );

        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }


    private PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    private UsersService usersService;
    @Autowired
    private CustomOAuth2UserService oauth2UserService;

    @Bean
    public HttpCookieOAuth2AuthorizationRequestRepository cookieOAuth2AuthorizationRequestRepository(){
        return new HttpCookieOAuth2AuthorizationRequestRepository();
    }

    private OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> oAuth2AccessTokenResponseClient(){
        OAuth2AccessTokenResponseHttpMessageConverter tokenResponseHttpMessageConverter = new OAuth2AccessTokenResponseHttpMessageConverter();
        tokenResponseHttpMessageConverter.setAccessTokenResponseConverter(new DefaultMapOAuth2AccessTokenResponseConverter());
        RestTemplate restTemplate =  new RestTemplate(Arrays.asList(new FormHttpMessageConverter(),tokenResponseHttpMessageConverter));
        restTemplate.setErrorHandler(new OAuth2ErrorResponseErrorHandler());
        DefaultAuthorizationCodeTokenResponseClient tokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
        tokenResponseClient.setRestOperations(restTemplate);
        return  tokenResponseClient;
    }

}
