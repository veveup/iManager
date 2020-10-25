package com.veveup.dao;

import com.veveup.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IUser {
    public User getUserById(String id) throws SQLException;

    public Boolean insertUser(User user) throws SQLException;

    public User updateUserByUser(User user) throws SQLException;

    public Boolean verifyUser(User user) throws SQLException;

    public Boolean hadUser(User user) throws SQLException;

    public User getUserByName(String name) throws SQLException;

    public ArrayList<User> getAllUser() throws SQLException;

    public boolean deleteUserByUser(User user) throws SQLException;


}
