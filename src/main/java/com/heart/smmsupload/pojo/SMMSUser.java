package com.heart.smmsupload.pojo;

import java.util.List;

public class SMMSUser {
    private Integer userId;

    private String username;

    private String password;

    private String userSalt;

    private List<SMMSRole> roles;

    private List<SMMSPermission> permissions;

    public String getUserSalt() {
        return userSalt;
    }

    public SMMSUser setUserSalt(String userSalt) {
        this.userSalt = userSalt;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public List<SMMSRole> getRoles() {
        return roles;
    }

    public SMMSUser setRoles(List<SMMSRole> roles) {
        this.roles = roles;
        return this;
    }

    public List<SMMSPermission> getPermissions() {
        return permissions;
    }

    public SMMSUser setPermissions(List<SMMSPermission> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public String toString() {
        return "SMMSUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userSalt='" + userSalt + '\'' +
                ", roles=" + roles +
                ", permissions=" + permissions +
                '}';
    }
}