package com.LiuYuhao.dao;

import com.LiuYuhao.model.User;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public int saveUser(Connection con, User user) throws SQLException {
        //insert
        String sql ="insert userdb.dbo.usertable  id=?,username=?,password=?,email=?,gender=?,birthdate=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,user.getId());
        st.setString(2,user.getUsername());
        st.setString(3,user.getPassword());
        st.setString(4,user.getEmail());
        st.setString(5,user.getGender());
        st.setDate(6, (java.sql.Date) user.getBirthdate());
//        ResultSet rs = st.executeQuery();
//        if(rs.next()){
//            user = new User();
//            user.setId(rs.getInt("id"));
//            user.setUsername(rs.getString("username"));
//            user.setPassword(rs.getString("password"));
//            user.setEmail(rs.getString("email"));
//            user.setGender(rs.getString("gender"));
//            user.setBirthdate(rs.getDate("birthdate"));
//        }
//        return true;
        return st.executeUpdate();
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String deleteUser ="delete from userdb.dbo.usertable where id=?";
        PreparedStatement st = con.prepareStatement(deleteUser);
        st.setInt(1,user.getId());
        return st.executeUpdate();
    }


    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update userdb.dbo.usertable set username=? , password=?,email=?, gender=?, birthdate=? where id=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        // st.setDate(6, (java.sql.Date) user.getBirthdate());
        // new java.sql.Date(user.getBirthdate().getTime())
        st.setDate(5, new java.sql.Date(user.getBirthdate().getTime()));
        st.setInt(6,user.getId());

        int rs = st.executeUpdate();

        return rs;
    }




    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select..where id=?
        String sql ="select * from userdb.dbo.usertable where id=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //use for login
        //select..where username=? and password=?
        Statement st = con.createStatement();
        String sql = "select * from userdb.dbo.usertable where username=" + "'" + username + "'" + "and password='" + password + "'";
        ResultSet rs = st.executeQuery(sql);
        User user=null;
        if (rs.next()) {
            //get from rs and set into user model
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {

        String ListbyUsername ="select * from userdb.dbo.usertable where username=?";
        PreparedStatement st = con.prepareStatement(ListbyUsername);
        st.setString(1,username);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>)user;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {

        String ListbyPassword ="select * from userdb.dbo.usertable where password=?";
        PreparedStatement st = con.prepareStatement(ListbyPassword);
        st.setString(1,password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {

        String ListbyEmail ="select * from userdb.dbo.usertable where Email=?";
        PreparedStatement st = con.prepareStatement(ListbyEmail);
        st.setString(1,email);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {

        String sql ="select * from userdb.dbo.usertable where gender=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,gender);

        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthdate) throws SQLException {
        //select..where birthdate=?
        String sql ="select * from userdb.dbo.usertable where birthdate=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthdate);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select * from usertable
        String sql ="select * from userdb.dbo.usertable";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return (List<User>) user;
    }
}