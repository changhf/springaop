package com.changhf.spring;

/**
* @ClassName: UserManager
* @Description: 用户业务类接口
*/
public interface UserManager {

    public void addUser(String username, String password);

    public void delUser(int userId);

    public String findUserById(int userId);

    public void modifyUser(int userId, String username, String password);
}