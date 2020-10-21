package com.veveup.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.veveup.utils.JdbcUtils;
import org.junit.Before;
import org.junit.Test;

public class JdbcTest {

    public static  Connection con = null;

    @Before
    public void init() throws SQLException {
        con = JdbcUtils.getConnection();



    }

    @Test
    public void findByIdTest() throws SQLException {
        // 1.定义sql
        String sql = "select * from user where id=1";

        Statement st = null;
        ResultSet rs = null;

            // 3.获取操作sql语句对象Statement
            st = con.createStatement();

            // 4.执行sql
            rs = st.executeQuery(sql);

            // 5.遍历结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");

                System.out.println(id + "  " + username + "  " + password
                        + "  " + email);
            }
        }

    // 添加操作
    @Test
    public void addTest() {
        // 定义sql
        String sql = "insert into user values(null,'张三','123','zs@163.com')";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 1.注册驱动

            Class.forName("com.mysql.jdbc.Driver");

            // 2.获取连接
            con = DriverManager.getConnection("jdbc:mysql:///day17", "root",
                    "abc");

            // 3.获取操作sql语句对象Statement
            st = con.createStatement();

            // 4.执行sql
            int row = st.executeUpdate(sql);

            if (row != 0) {
                System.out.println("添加成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6.释放资源

            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // update操作
    @Test
    public void updateTest() {
        // 将id=3的人的password修改为456
        String password = "456";
        String sql = "update user set password='" + password + "' where id=3";

        // 1.得到Connection
        Connection con = null;
        Statement st = null;
        try {
            con = JdbcUtils.getConnection();

            // 3.获取操作sql语句对象Statement
            st = con.createStatement();

            // 4.执行sql
            int row = st.executeUpdate(sql);

            if (row != 0) {
                System.out.println("修改成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // delete测试
    @Test
    public void deleteTest() {
        // 将id=3的人删除

        String sql = "delete from user where id=2";

        // 1.得到Connection
        Connection con = null;
        Statement st = null;
        try {
            con = JdbcUtils.getConnection();

            // 3.获取操作sql语句对象Statement
            st = con.createStatement();

            // 4.执行sql
            int row = st.executeUpdate(sql);

            if (row != 0) {
                System.out.println("删除成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源

            try {
                JdbcUtils.closeStatement(st);
                JdbcUtils.closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}


