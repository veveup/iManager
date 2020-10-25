package com.veveup.utils;

import org.sqlite.SQLiteException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


//使用配置文件

public class JdbcUtils {

    private static final String DRIVERCLASS;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static Connection con;

    static {

        DRIVERCLASS = ResourceBundle.getBundle("jdbc").getString("driverClass");
        URL = ResourceBundle.getBundle("jdbc").getString("url");
        USERNAME = ResourceBundle.getBundle("jdbc").getString("username");
        PASSWORD = ResourceBundle.getBundle("jdbc").getString("password");
    }

    static {
        try {
            // 将加载驱动操作，放置在静态代码块中.这样就保证了只加载一次.
            Class.forName(DRIVERCLASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {

        // 2.获取连接
        if(con!=null){
            return  con;
        }
        try {
            // 首先使用Mysql连接数据库 若无法连接则使用 Sqlite文件连接数据库
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLiteException sqLiteException) {
            con = DriverManager.getConnection(URL);
        }
        return con;
    }

    //关闭操作
    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public static void closeStatement(Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }


    public static boolean sql_inj(String str) {
        String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
//这里的东西还可以自己添加
        String[] inj_stra = inj_str.split("\\|");
        for (int i = 0; i < inj_stra.length; i++) {
            if (str.indexOf(inj_stra[i]) >= 0) {
                return true;
            }
        }
        return false;

    }

}