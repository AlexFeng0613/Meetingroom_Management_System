package com.bfw.web.servlet.userinfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.UserInfo;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class UserInfListServlet
 */
@WebServlet("/userInfListServlet")
public class UserInfListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ������
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		
		//�����ݷŵ�UserInfo������
		UserInfo user = new UserInfo();
		user.setUserName(userName);
		user.setUserSex(userSex);
		
		//ҵ���߼�����
		UserInfoService service = new UserInfoServiceImpl();
		List<UserInfo> list= service.getAllUser(user);
	
		
		
		
		request.setAttribute("list", list);
		
		//ת��
		request.getRequestDispatcher("/view/userinfo/userinfo_list.jsp").forward(request, response);
		
		
	}

}
