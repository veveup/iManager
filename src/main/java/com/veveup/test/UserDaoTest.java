package com.veveup.test;

import com.veveup.dao.IUser;
import com.veveup.dao.UserDao;
import com.veveup.domain.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoTest {

    IUser iUser = null;

    private static Logger LOGGER = null;

//    @BeforeClass
//    public static void setLogger() throws MalformedURLException
//    {
//        System.setProperty("log4j.configurationFile","log4j2-testConfig.xml");
//        LOGGER = LogManager.getLogger();
//    }

    @Before
    public void init(){
        iUser =new UserDao();
    }

    @Test
    public void getUser() throws SQLException {
        User userById = iUser.getUserById(1+"");
        System.out.println(userById);
    }

    @Test
    public void inserUSer() throws SQLException {
        User user = new User();
        user.setName("sb1");
        user.setProfile("very sb");
        user.setPass("12345667");
        Boolean aBoolean = iUser.insertUser(user);
        System.out.println(aBoolean);
    }

    @Test
    public void updateUserByU() throws SQLException {
        User user = new User();
        user.setName("sb1");
        user.setProfile("tmd very sb");
        user.setPass("12345667");
        User userByName = iUser.getUserByName(user.getName());
        user.setId(userByName.getId());
        iUser.updateUserByUser(user);

    }

    @Test
    public void getAllUser() throws SQLException {
        ArrayList<User> allUser = iUser.getAllUser();
        for (User u :
                allUser) {
            System.out.println("用户："+u);
        }
    }

}
