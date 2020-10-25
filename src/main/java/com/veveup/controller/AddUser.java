package com.veveup.controller;

import com.veveup.dao.UserDao;
import com.veveup.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddUser extends HttpServlet {
    public AddUser() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        System.out.println("name:"+name);
        String password = req.getParameter("password");
        String profile = new String(req.getParameter("profile").getBytes("iso-8859-1"), "utf-8");
        if(name.equals(null)||password.equals(null)){
//            req.getRequestDispatcher("/manager.jsp").forward(req,resp);
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location",req.getContextPath()+"/manager.jsp");
        }

        try {
            User userByName = new UserDao().getUserByName(name);
            if(userByName==null){
                User user = new User();
                user.setName(name);
                user.setPass(password);
                user.setProfile(profile);
                Boolean aBoolean = new UserDao().insertUser(user);
                System.out.println("新用户添加成功"+user);
//                req.getRequestDispatcher("/manager.jsp").forward(req,resp);
                resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                resp.setHeader("Location",req.getContextPath()+"/manager.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
