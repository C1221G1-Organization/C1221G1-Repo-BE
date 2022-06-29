package com.c1221g1.pharmacy.entity.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username")
    @JsonBackReference
    private Users users;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "roleId")
    @JsonBackReference
    private Roles roles;
}
