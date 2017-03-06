package com.jskj.course.servlet;

import com.alibaba.fastjson.JSON;
import com.jskj.course.UserStatusResult;
import com.jskj.course.domain.Result;
import com.jskj.course.domain.User;
import com.jskj.course.util.C3p0Util;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuecheng.cui on 2017/2/4.
 */

public class RegistServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/json;charset=UTF-8");
        try {
            User user = C3p0Util.query(username);
            if(user == null) {
                //用户不存在，进行插入操作
                user = new User();
                user.setName(username);
                user.setPassword(password);
                C3p0Util.insert(user);
                response.getWriter().println(JSON.toJSONString(new Result(UserStatusResult.SUCCESS_CODE,"注册成功")));
            } else {
                //用户已经存在
                response.getWriter().println(JSON.toJSONString(new Result(UserStatusResult.USER_EXISIT,"用户已经存在")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
