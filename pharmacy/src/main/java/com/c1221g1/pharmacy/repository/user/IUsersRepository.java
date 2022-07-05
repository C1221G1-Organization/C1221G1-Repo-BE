package com.c1221g1.pharmacy.repository.user;

import com.c1221g1.pharmacy.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsersRepository extends JpaRepository<Users,String> {
    @Query(value="select * from users u where exists (select * from users where u.username = :email)",nativeQuery=true)
    List<Users> checkEmail(@Param("email") String email);
}
