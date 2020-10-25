package com.veveup.controller;

import com.veveup.dao.UserDao;
import com.veveup.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUser extends HttpServlet {
    public UpdateUser() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("author")==null){
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location",req.getContextPath()+"/index.jsp");
            return;
        }
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"), "utf-8");

        String password = new String(req.getParameter("password").getBytes("iso-8859-1"), "utf-8");

        String newpassword = new String(req.getParameter("newpassowrd").getBytes("iso-8859-1"), "utf-8");

        String profile = new String(req.getParameter("profile").getBytes("iso-8859-1"), "utf-8");


        if(name.equals(null)||password.equals(null)||newpassword.equals(null)){
//            req.getRequestDispatcher("/manager.jsp").forward(req,resp);
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location",req.getContextPath()+"/manager.jsp");
            return;
        }

        try {
            User userByName = new UserDao().getUserByName(name);
            if(userByName!=null){
                if(userByName.getPass().equals(password)){
                    userByName.setPass(newpassword);
                    if (profile!=null){
                        userByName.setProfile(profile);
                    }
                    User user = new UserDao().updateUserByUser(userByName);
                    System.out.println("用户密码/信息可能更新成功了");
                    resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                    resp.setHeader("Location",req.getContextPath()+"/manager.jsp");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location",req.getContextPath()+"/manager.jsp");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
