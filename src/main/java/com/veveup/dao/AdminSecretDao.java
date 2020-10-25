package com.veveup.dao;

import com.veveup.domain.AdminSecret;
import com.veveup.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminSecretDao implements IAdmin
{
    private Connection cn;

    private void initCn() {
        if(cn==null){
            try {
                cn = JdbcUtils.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public AdminSecret findAdminBySecret(String secet) throws SQLException {
        initCn();

        String sql = "select * from secret =\""+secet+"\"";
        boolean b = JdbcUtils.sql_inj(sql);
        if(b){
            System.out.println("竟然有憨包想注入 干他");
            return null;
        }
        Statement statement = cn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()){
            String secret = resultSet.getString("secret");
            boolean enable = resultSet.getBoolean("enable");
        }

        statement.close();

        return null;
    }

    @Override
    public boolean setEnableAdminByAdmin(AdminSecret adminSecret) {
        return false;
    }

    @Override
    public boolean setUnableAdminByAdmin(AdminSecret adminSecret) {
        return false;
    }

    @Override
    public ArrayList<AdminSecret> getAllAdminSecret() throws SQLException {
        initCn();
        String sql = "select * from AdminSecret";
        Statement statement = cn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<AdminSecret> adminSecrets = new ArrayList<>();
        while (resultSet.next()){
            String secret = resultSet.getString("secret");
            boolean enable = resultSet.getBoolean("enable");
            if(true){
                AdminSecret adminSecret = new AdminSecret();
                adminSecret.setSecret(secret);
                adminSecret.setEnable(true);
                adminSecrets.add(adminSecret);
            }
        }
        if(adminSecrets.size()>0){
            return adminSecrets;
        }
        statement.close();

        return null;
    }


}
