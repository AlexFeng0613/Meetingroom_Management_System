package com.bfw.web.servlet.bespeak;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.domain.MeetingRoom;
import com.bfw.domain.MeetingroomBespeak;
import com.bfw.domain.UserInfo;
import com.bfw.service.BespeakService;
import com.bfw.service.MeetingRoomService;
import com.bfw.service.UserInfoService;
import com.bfw.service.impl.BespeakServiceImpl;
import com.bfw.service.impl.MeetingRoomServiceImpl;
import com.bfw.service.impl.UserInfoServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomBespeakServlet
 */
@WebServlet("/meetingRoomBespeakServlet")
public class MeetingRoomBespeakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetingRoomBespeakServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ��������Ϣ
		MeetingRoomService meetservice = new MeetingRoomServiceImpl();
		List<MeetingRoom> meetingroomlist = meetservice
				.getAllMeetingRoooms(null);
		request.setAttribute("meetingroomlist", meetingroomlist);

		// �μӻ�����Ա
		UserInfoService userService = new UserInfoServiceImpl();
		List<UserInfo> userlist = userService.getAllUser(null);
		request.setAttribute("userlist", userlist);

		request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ������ԤԼ��Ϣ
		MeetingroomBespeak meeingBespeak = RequestBeanUtils
				.requestToSimpleBean(request, MeetingroomBespeak.class);

		// �μӻ�����Ա��Ϣ
		String userIds = request.getParameter("userIds");

		/*System.out.println("�μӻ�����Ա:" + userIds);*/

		// ʱ��yyyy-MM-dd HH:mm:ss
		String stratTimeStr = request.getParameter("stratTimeStr");
		String endTimeStr = request.getParameter("endTimeStr");

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			if (meeingBespeak != null) {

				meeingBespeak.setStratTime(sdf.parse(stratTimeStr));
				meeingBespeak.setEndTime(sdf.parse(endTimeStr));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// ��ǰ��¼�û���Ϣ(������)
		HttpSession session = request.getSession();
		UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
		meeingBespeak.setUserId(userinfo.getUserId());
		
		BespeakService serivce = new BespeakServiceImpl();
		boolean mark = serivce.addMeetingroomBespeak(meeingBespeak, userIds);
		
		if(mark){
			request.setAttribute("info", "ԤԼ�����ҳɹ�");
		}else{
			request.setAttribute("info", "ԤԼ������ʧ��");
		}
		
		//request.getRequestDispatcher("/view/bespeak/meetingroom_bespeak.jsp").forward(request, response);
		doGet(request, response);
	}

}
