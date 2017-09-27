package com.imooc.servlet;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.entity.Page;
import com.imooc.service.QueryService;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("UTF-8");
		//获取页面参数
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		String currentPage = request.getParameter("currentPage");
		// 创建分页对象
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		QueryService listService = new QueryService();
		// 查询消息列表并传给页面
		//request.setAttribute("messageList", listService.queryMessageList(command, description,page));
		//使用拦截器进行查询消息列表并传给页面
		request.setAttribute("messageList", listService.queryMessageListByPage(command, description,page));
		// 向页面传值
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		request.setAttribute("page", page);
		
		System.out.println("----------------------------------------");
		
		//跳转页面
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
