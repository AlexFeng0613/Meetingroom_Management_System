package com.bfw.web.servlet.userinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.domain.UserInfo;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.UserInfoServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//ɾ����ǰ�û���¼��Ϣ
		session.removeAttribute("userinfo");
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ҵ���߼���
		UserInfoService service = new UserInfoServiceImpl();

		
		//��ȡ�˺�����
		String userId = request.getParameter("userId");
		String passWord = request.getParameter("passWord");
		
		UserInfo user = service.isLogin(userId, passWord);
	//	System.out.println("�˺�"+userId+"����:"+passWord);
		if(user!=null){
			//��ȡsession
			HttpSession session = request.getSession();
			
			session.setAttribute("userinfo", user);
			//ת��
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			
			request.setAttribute("info", "�˺Ż������������������");
			//ת��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

}
