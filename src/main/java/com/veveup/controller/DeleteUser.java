package com.veveup.controller;

import com.veveup.dao.UserDao;
import com.veveup.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUser  extends HttpServlet {
    public DeleteUser() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DeleteUser doGet runing");
        String name = req.getParameter("name");
        String id = req.getParameter("id");

        try {
            User userByName = new UserDao().getUserByName(name);
            User userById = new UserDao().getUserById(id);
            if(userById!=null){
                boolean b = new UserDao().deleteUserByUser(userById);
                System.out.println("可能删除成功了");
                resp.setStatus(resp.SC_MOVED_TEMPORARILY);
                resp.setHeader("Location",req.getContextPath()+"/manager.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
