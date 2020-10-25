package com.veveup.dao;

import com.veveup.domain.AdminSecret;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAdmin {
    public AdminSecret findAdminBySecret(String secet) throws SQLException;

    public boolean setEnableAdminByAdmin(AdminSecret adminSecret);

    public boolean setUnableAdminByAdmin(AdminSecret adminSecret);

    public ArrayList<AdminSecret> getAllAdminSecret() throws SQLException;
}
