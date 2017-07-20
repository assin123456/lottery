package com.dgd.lottery.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dgd.lottery.user.api.UserService;
import com.dgd.lottery.user.dao.User;

import net.sf.json.JSONArray;


/**
 * 获取所有用户信息
 * 
 * @author dgd
 *
 */
@WebServlet("/user/getlist")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletConfig().getServletContext());
		userService = ctx.getBean("userServiceImpl", com.dgd.lottery.user.api.UserService.class);
		PrintWriter write = response.getWriter();
		// 从前台获取参数
		// 获取用户名
		request.getParameter("username");
		// 获取密码
		request.getParameter("password");
		
		List<User> list = userService.FindAll();
		JSONArray jsonArry = JSONArray.fromObject(list);
		//JSONObject json = JSONObject.fromObject(jsonArry);
		write.println(jsonArry);
	}
}
