package com.heart.smmsupload.shiro;

import com.heart.smmsupload.pojo.SMMSPermission;
import com.heart.smmsupload.pojo.SMMSRole;
import com.heart.smmsupload.pojo.SMMSUser;
import com.heart.smmsupload.service.SMMSUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description:
 * @Author: Heart
 * @Date: 2019/3/21 10:07
 */
public class ShiroRealm extends AuthorizingRealm {

    public static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private SMMSUserService smmsUserService;

    /**
     * 角色、权限鉴定
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("↓↓↓↓ ShiroRealm.doGetAuthorizationInfo(principals) ↓↓↓↓");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        String username = (String) principals.getPrimaryPrincipal();
        SMMSUser smmsUserByUsername = smmsUserService.findSMMSUserByUsername(username);
        logger.info("用户信息 :{}", smmsUserByUsername);

        if (smmsUserByUsername.getRoles() != null) {
            List<String> rolesList = new ArrayList<>();
            for (SMMSRole smmsRole : smmsUserByUsername.getRoles()) {
                rolesList.add(smmsRole.getRoleName());
            }
            //将用户角色信息告诉shiro
            simpleAuthorizationInfo.setRoles(new HashSet<>(rolesList));
        }
        if (smmsUserByUsername.getPermissions() != null) {
            List<String> permissionsList = new ArrayList<>();
            for (SMMSPermission smmsPermission : smmsUserByUsername.getPermissions()) {
                permissionsList.add(smmsPermission.getPermissionName());
            }
            //将用户权限信息告诉shiro
            simpleAuthorizationInfo.setStringPermissions(new HashSet<>(permissionsList));
        }

        logger.info("↑↑↑↑ ShiroRealm.doGetAuthorizationInfo(principals) ↑↑↑↑");
        return simpleAuthorizationInfo;
    }

    /**
     * 用户身份验证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("↓↓↓↓ ShiroRealm.doGetAuthenticationInfo(token) ↓↓↓↓");

        //获取用户输入的账号
        String username = (String) token.getPrincipal();

        //通过username查询用户账号
        SMMSUser smmsUserByUsername = smmsUserService.findSMMSUserByUsername(username);
        logger.info("用户信息 :{}", smmsUserByUsername);
        if (smmsUserByUsername == null) {
            return null;
        }
        //构造身份认证信息
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                smmsUserByUsername.getPassword(),
                ByteSource.Util.bytes(smmsUserByUsername.getUserSalt()),
                getName());

        logger.info("↑↑↑↑ ShiroRealm.doGetAuthenticationInfo(token) ↑↑↑↑");
        return authenticationInfo;
    }
}
