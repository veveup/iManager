package com.veveup.dao;

import com.veveup.domain.User;
import com.veveup.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;

public class UserDao implements IUser{

    private Connection cn ;
    private User user;

    @Override
    public User getUserById(String id) throws SQLException {

        if(cn==null){
            cn = JdbcUtils.getConnection();
        }

        String sql = "select * from User where id ="+id;
        System.out.println("执行的语句是+"+sql);
        Statement statement = cn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id")+"");
            user.setName(rs.getString("name"));
            user.setPass(rs.getString("password"));
            user.setProfile(rs.getString("profile"));
        }
        if(user!=null){
            System.out.println("查询到的用户："+user);
            return user;
        }
        System.out.println("没有查询到用户，憨包！");
        statement.close();
        return null;
    }

    @Override
    public Boolean insertUser(User user) throws SQLException {
        if(cn==null){
            cn = JdbcUtils.getConnection();
        }
        String sql = "insert into User(name,password,profile) values( \""+user.getName()+"\",\""+user.getPass()+"\",\""+user.getProfile()+"\")";
        System.out.println("执行的sql："+sql);
        Statement statement = cn.createStatement();
        int i = statement.executeUpdate(sql);
        System.out.println("数据插入 返回的数据是："+i);
        statement.close();
//        cn.commit();
        return null;
    }

    @Override
    public User updateUserByUser(User user) throws SQLException {
        if(cn==null){
            cn = JdbcUtils.getConnection();
        }
        String sql = "update User set password=\""+user.getPass()+"\",profile = \""+user.getProfile()+
                "\" where id="+user.getId();
        System.out.println("执行的Sql语句是："+sql);
        Statement statement = cn.createStatement();
        int i = statement.executeUpdate(sql);
        statement.close();
//        cn.commit();
        System.out.println("更新数据了 返回的数据是："+i);
        statement.close();

        return user;
//        return null;
    }

    @Override
    public Boolean verifyUser(User user) throws SQLException {
        if(cn==null){
            cn = JdbcUtils.getConnection();
        }

        String sql = "select * from User where id = "+ user.getId();
        Statement statement = cn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()){
            String pass = rs.getString("password");
            if(pass.equals(user.getPass())){
                System.out.println("验证成功了 是同一个用户 憨包让他通过");
                return true;
            }
        }
        System.out.println("肯定验证失败了 密码不匹配 憨包不要让让他通过");
        statement.close();

        return false;
    }

    @Override
    public Boolean hadUser(User user) throws SQLException {
        if(cn==null) cn = JdbcUtils.getConnection();

        String sql = "select * from User where id = "+ user.getId();
        Statement statement = cn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            System.out.println("查询到这个用户了 不知道是啥用户 你看一下"+user);
            return true;
        }
        System.out.println("没有查到这个 用户 检查一个数据库 语法 还有憨包是用户");
        statement.close();

        return false;
    }

    @Override
    public User getUserByName(String name) throws SQLException {
        if(cn==null) cn = JdbcUtils.getConnection();

        String sql = "select * from User where name =\""+name+"\"";

        Statement statement = cn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        User user = null;
        if(resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id")+"");
            user.setPass(resultSet.getString("password"));
            user.setProfile(resultSet.getString("profile"));
            user.setName(resultSet.getString("name"));
            System.out.println("查询到这个用户了 不知道是啥用户 你看一下"+user);
            return user;
        }
        System.out.println("没有查到这个 用户 检查一个数据库 语法 还有憨包是用户");
        statement.close();

        return null;
    }

    @Override
    public ArrayList<User> getAllUser() throws SQLException {
        if(cn==null) cn = JdbcUtils.getConnection();


        ArrayList userArray = new ArrayList<User>();
        String sql = "select * from User";
        Statement statement = cn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id")+"");
            user.setPass(resultSet.getString("password"));
            user.setProfile(resultSet.getString("profile"));
            user.setName(resultSet.getString("name"));
            userArray.add(user);
        }
        System.out.println("查询到了 好多用户 不要乱给别人"+userArray.size());
        statement.close();

        return  userArray;

    }

    @Override
    public boolean deleteUserByUser(User user) throws SQLException {
        if(cn==null) cn = JdbcUtils.getConnection();

        String sql = "delete from User where id = \""+user.getId()+"\"";

        Statement statement = cn.createStatement();
        boolean execute = statement.execute(sql);
        statement.close();
        System.out.println("执行删除成功 返回的值是"+execute+"删除的用户是 "+user);
        return true;
    }
}
