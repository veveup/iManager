package com.veveup.dao;

import com.veveup.domain.User;

public interface IUser {
    public User getUserById(String id);

    public Boolean insertUser(User user);

    public User updateUserByUser(User user);

    public Boolean verifyUser(User user);

    public Boolean hadUser(User user);


}
