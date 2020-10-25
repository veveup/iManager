package com.veveup.controller;

import com.veveup.utils.GoogleAuthenticatorUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorController extends HttpServlet {
    public AuthorController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("number");
        if(num.equals(null)||num.length()<6){
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location",req.getContextPath());
        }
        if(GoogleAuthenticatorUtils.verify(num)){
            req.getSession().setAttribute("author"," authored");
            resp.setStatus(resp.SC_MOVED_TEMPORARILY);
            resp.setHeader("Location",req.getContextPath()+"/manager.jsp");
        }
    }
}
