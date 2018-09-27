package com.changhf;

/**
* @ClassName: UserManager
* @Description: 用户业务类接口
* @author 牛迁迁
* @date 2016-4-27 下午8:09:07
*/
public interface UserManager {

    public void addUser(String username, String password);

    public void delUser(int userId);

    public String findUserById(int userId);

    public void modifyUser(int userId, String username, String password);
}