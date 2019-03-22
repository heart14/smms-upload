package com.heart.smmsupload.pojo;

/**
 * @ClassName:SMMSRole
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/21 18:06
 */
public class SMMSRole {

    private Integer roleId;

    private String roleName;

    private String roleDesc;

    public Integer getRoleId() {
        return roleId;
    }

    public SMMSRole setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public SMMSRole setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public SMMSRole setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
        return this;
    }

    @Override
    public String toString() {
        return "SMMSRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
