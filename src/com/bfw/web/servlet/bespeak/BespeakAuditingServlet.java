package com.bfw.web.servlet.bespeak;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.domain.MeetingUserinfo;
import com.bfw.domain.MeetingroomBespeak;
import com.bfw.domain.UserInfo;
import com.bfw.service.BespeakService;
import com.bfw.service.MeetingUserinfoService;
import com.bfw.service.impl.BespeakServiceImpl;
import com.bfw.service.impl.MeetingUserinfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class BespeakAuditingServlet
 */
@WebServlet("/bespeakAuditingServlet")
public class BespeakAuditingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BespeakAuditingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ԤԼ���
		String bespeakId = request.getParameter("bespeakId");

		// ������ԤԼ��service
		BespeakService bespeakService = new BespeakServiceImpl();
		MeetingroomBespeak bespeak = bespeakService
				.getMeetingroomBespeak(Integer.valueOf(bespeakId));
		request.setAttribute("bespeak", bespeak);

		// ����μӻ�����Ա
		MeetingUserinfoService muservice = new MeetingUserinfoServiceImpl();
		MeetingUserinfo mu = new MeetingUserinfo();
		mu.setBespeakId(Integer.parseInt(bespeakId));
		List<MeetingUserinfo> mulist = muservice.getAllMeetingUserinfo(mu);
		request.setAttribute("mulist", mulist);

		request.getRequestDispatcher("/view/bespeak/bespeak_auditing.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ҳ���ȡ����
		MeetingroomBespeak bespeak = RequestBeanUtils.requestToSimpleBean(
				request, MeetingroomBespeak.class);

		// ��ȡ��ǰ�û���Ϣ �������
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("userinfo");

		if (user != null && user.getUserId() != null) {
			// �����������Ϣ
			bespeak.setUseUserId(user.getUserId());
			bespeak.setAuditingTime(new Date());
		}

		System.out.println(bespeak);

		// ҵ���߼�
		BespeakService bespeakService = new BespeakServiceImpl();

		boolean mark = bespeakService.updateMeetingroomBespeak(bespeak);

		if (mark) {
			request.setAttribute("info", "�����ɹ�");
		} else {
			request.setAttribute("info", "����ʧ��");
		}

	
		MeetingroomBespeak 	bespeaks = new MeetingroomBespeak();
		//��ѯδ���״̬
		bespeaks.setBespeakState("0");
		
		List<MeetingroomBespeak> list = bespeakService.getAllMeetingroomBespeak(bespeaks);
		
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher(
				"/view/bespeak/meetingroom_bespeak_auditing.jsp").forward(
				request, response);

	}

}
