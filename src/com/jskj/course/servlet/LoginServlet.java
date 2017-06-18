package com.jskj.course.servlet;

import com.alibaba.fastjson.JSON;
import com.jskj.course.UserStatusResult;
import com.jskj.course.domain.Result;
import com.jskj.course.domain.User;
import com.jskj.course.util.C3p0Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Result result;
        String requestResult = "";
        try {
            User user = C3p0Util.query(username);
            if (user == null) {
                //数据库没有这个用户
                result = new Result();
                result.code = UserStatusResult.USER_NOT_EXIST;
                result.msg = "用户不存在";
            } else {
                if (password.equals(user.getPassword())) {
                    result = new Result();
                    result.code = UserStatusResult.SUCCESS_CODE;
                    result.msg = "登录成功";
                } else {
                    result = new Result();
                    result.code = UserStatusResult.PASSWORD_ERROR_CODE;
                    result.msg = "密码错误";
                }
            }
            requestResult = JSON.toJSONString(result);
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().println(requestResult);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
