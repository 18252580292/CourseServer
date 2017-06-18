package com.jskj.course.util;

import com.jskj.course.domain.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by xuecheng.cui on 2017/2/4.
 */
public class C3p0Util {
    private static ComboPooledDataSource mDataSource;
    private static Connection conn;

    static {
        try {
            mDataSource = new ComboPooledDataSource();
            mDataSource.setDriverClass("com.mysql.jdbc.Driver");
            mDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/course");
            mDataSource.setUser("root");
            mDataSource.setPassword("ROOT");
            conn = mDataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(User user) throws SQLException {
        if (conn != null) {
            Statement stmt = conn.createStatement();
            stmt.execute("insert into user(username,password) VALUES ('" + user.getName() + "','"
                    + MD5Utils.getMd5(user.getPassword()) + "')");
        }
    }

    public static User query(String name) throws SQLException {
        if (conn != null) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from user where username='" + name + "'");
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
            }
            resultSet.close();
            return user;
        }
        return null;
    }

    /**
     * release all resources
     */
    public static void release() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (mDataSource != null) {
            mDataSource.close();
        }
    }
}
