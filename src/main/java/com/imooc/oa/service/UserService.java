package com.imooc.oa.service;

import com.imooc.oa.dao.RbacDao;
import com.imooc.oa.dao.UserDao;
import com.imooc.oa.entity.Node;
import com.imooc.oa.entity.User;
import com.imooc.oa.service.exception.BussinessException;
import com.imooc.oa.utils.MD5Utils;

import java.util.List;

public class UserService {
    private final UserDao userDao = new UserDao();
    private final RbacDao rbacDao = new RbacDao();

    public User checkLogin(String username, String password) {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            throw new BussinessException("L001", "用户名不存在");
        }
        String passwordMd5 = MD5Utils.MD5Digest(password, user.getSalt());
        if (!passwordMd5.equals(user.getPassword())) {
            throw new BussinessException("L002", "密码错误");
        }
        return user;
    }

    public List<Node> selectNodeByUserId(Long userId){
        List<Node> nodeList = rbacDao.selectNodeByUserId(userId);
        return nodeList;
    }
}
