package com.veveup.controller;

import com.veveup.dao.UserDao;
import com.veveup.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class manager  extends HttpServlet {
    public manager() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ArrayList<User> allUser = new UserDao().getAllUser();
            req.getSession().setAttribute("users",allUser);
            req.getRequestDispatcher("/manager.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
