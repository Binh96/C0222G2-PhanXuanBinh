package com.pxb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoleList;

    public Role() {
    }

    public Role(int id, String roleName, List<UserRole> userRoleList) {
        this.id = id;
        this.roleName = roleName;
        this.userRoleList = userRoleList;
    }

    public Role(String roleName, List<UserRole> userRoleList) {
        this.roleName = roleName;
        this.userRoleList = userRoleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
