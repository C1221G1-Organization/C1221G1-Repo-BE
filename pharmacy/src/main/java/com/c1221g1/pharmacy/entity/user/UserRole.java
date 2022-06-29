package com.c1221g1.pharmacy.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username")

    private Users users;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "roleId")
    private Roles roles;
}
