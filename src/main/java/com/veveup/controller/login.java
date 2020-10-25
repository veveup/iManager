package com.veveup.controller;

import com.veveup.dao.UserDao;
import com.veveup.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

public class login extends HttpServlet{
    public login() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("doGet");
        while (parameterNames.hasMoreElements()){
            System.out.println(parameterNames.nextElement());
        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        System.out.println("name:"+name+"  "+"password:"+password);

        if(req.getSession().getAttribute("user")!=null){
            System.out.println("已经登陆了 不需要再登陆了");
            return;
        }
        try {
            User userByName = new UserDao().getUserByName(name);
            if(userByName!=null){
                if(userByName.getPass().equals(password)){
                    System.out.println("密码正确 登陆成功！");
                    req.getSession().setAttribute("user",userByName);
                    req.getRequestDispatcher("/manager.do").forward(req,resp);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
