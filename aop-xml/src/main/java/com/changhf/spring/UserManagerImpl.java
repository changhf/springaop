package com.changhf.spring;

public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String username, String password) {
        System.out.println("---------UserManagerImpl.add()--------");
    }

    @Override
    public void delUser(int userId) {
        System.out.println("---------UserManagerImpl.delUser()--------");
    }

    @Override
    public String findUserById(int userId) {
        System.out.println("---------UserManagerImpl.findUserById()--------");
        return "张三";
    }

    @Override
    public void modifyUser(int userId, String username, String password) {
        System.out.println("---------UserManagerImpl.modifyUser()--------");
    }
}