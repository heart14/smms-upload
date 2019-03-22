package com.heart.smmsupload.pojo;

/**
 * @ClassName:SMMSPermission
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/22 11:42
 */
public class SMMSPermission {

    private Integer permissionId;

    private String permissionName;

    private String permissionDesc;

    private String permissionUrl;

    private Integer permissionParentId;

    public Integer getPermissionId() {
        return permissionId;
    }

    public SMMSPermission setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public SMMSPermission setPermissionName(String permissionName) {
        this.permissionName = permissionName;
        return this;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public SMMSPermission setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
        return this;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public SMMSPermission setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
        return this;
    }

    public Integer getPermissionParentId() {
        return permissionParentId;
    }

    public SMMSPermission setPermissionParentId(Integer permissionParentId) {
        this.permissionParentId = permissionParentId;
        return this;
    }

    @Override
    public String toString() {
        return "SMMSPermission{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                ", permissionDesc='" + permissionDesc + '\'' +
                ", permissionUrl='" + permissionUrl + '\'' +
                ", permissionParentId=" + permissionParentId +
                '}';
    }
}
