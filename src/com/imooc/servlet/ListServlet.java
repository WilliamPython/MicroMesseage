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
		//���ñ���
		request.setCharacterEncoding("UTF-8");
		//��ȡҳ�����
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		String currentPage = request.getParameter("currentPage");
		// ������ҳ����
		Page page = new Page();
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		QueryService listService = new QueryService();
		// ��ѯ��Ϣ�б�����ҳ��
		//request.setAttribute("messageList", listService.queryMessageList(command, description,page));
		//ʹ�����������в�ѯ��Ϣ�б�����ҳ��
		request.setAttribute("messageList", listService.queryMessageListByPage(command, description,page));
		// ��ҳ�洫ֵ
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		request.setAttribute("page", page);
		
		System.out.println("----------------------------------------");
		
		//��תҳ��
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
