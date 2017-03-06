package com.jskj.course.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jskj.course.domain.User;

@WebServlet("/login.svl")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ObjectMapper mapper = new ObjectMapper();
	private static Logger logger;

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger = LoggerFactory.getLogger(LoginServlet.class);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/json;charset=UTF-8");
		if (username != null && username != "" && password != null && password != "") {
			if ("admin".equals(username) && "admin".equals(password)) {
				// login success
				User user = new User(200, username, password, "登录成功");
				String result = mapper.writeValueAsString(user);
				response.getWriter().write(result);
				logger.debug("login successful:" + new Date().toLocaleString());
			} else {
				response.getWriter().write(mapper.writeValueAsString(new User(500, null, null, "用户名或密码错误")));
			}
		} else {
			response.getWriter().write(mapper.writeValueAsString(new User(500, null, null, "用户名或密码错误")));
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
