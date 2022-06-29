package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.dto.user.IUsersDto;
import com.c1221g1.pharmacy.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsersRepository extends JpaRepository<Users,String> {

    @Query(value="SELECT username,password,flag FROM Users where username = :username and password = :password",nativeQuery=true)
    IUsersDto getUsersByUsernameAndPassword(String username, String password);
    @Query(value="select * from users u where exists (select * from users where u.username = :email)",nativeQuery=true)
    boolean checkEmail(String email);
    @Query(value="insert into users(username,password,flag) values (:username,:password,:flag)", nativeQuery=true)
    void saveUser(String username,String password,boolean flag);
}
