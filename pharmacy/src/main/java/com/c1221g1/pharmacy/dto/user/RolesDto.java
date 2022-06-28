package com.c1221g1.pharmacy.dto.user;

import com.c1221g1.pharmacy.entity.user.UserRole;

import java.util.List;

public class RolesDto {
    private Integer roleId;
    private String roleName;
    private List<UserRole> userRoleList;

    public RolesDto() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }


    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
