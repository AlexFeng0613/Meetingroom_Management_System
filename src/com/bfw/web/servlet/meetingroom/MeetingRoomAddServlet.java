package com.bfw.web.servlet.meetingroom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfw.domain.EnzhequipmentInfo;
import com.bfw.domain.MeetingRoom;
import com.bfw.service.EnquipmentService;
import com.bfw.service.MeetingRoomService;
import com.bfw.service.impl.EnquipmentServiceImpl;
import com.bfw.service.impl.MeetingRoomServiceImpl;
import com.my.web.servlet.RequestBeanUtils;

/**
 * Servlet implementation class MeetingRoomAddServlet
 */
@WebServlet("/meetingRoomAddServlet")
public class MeetingRoomAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingRoomAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�豸��Ϣ��ҵ����ʵ����
		EnquipmentService service = new EnquipmentServiceImpl();
		
		List<EnzhequipmentInfo> list = service.queryEnzhequipmentInfo();
		
		request.setAttribute("eninfolist", list);
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//��ҳ���ȡ��Ϣ
		MeetingRoom meetingroom = RequestBeanUtils.requestToSimpleBean(request,
				MeetingRoom.class);
		
		//�豸��� �����������豸
		String enzhequipmentIds = request.getParameter("enzhequipmentIds");
		
		
		System.out.println(meetingroom);
		System.out.println(enzhequipmentIds);
		
		//�����ҹ����ҵ���߼�����
		MeetingRoomService service = new MeetingRoomServiceImpl();
		
		boolean mark = service.addMeetingRoom(meetingroom, enzhequipmentIds);
		
		if(mark){
			request.setAttribute("info", "��ӻ�������Ϣ�ɹ�");
		}else{
			request.setAttribute("info", "��ӻ�������Ϣʧ��");
		}
		
		request.getRequestDispatcher("/view/meetingroom/meetingroom_add.jsp").forward(request, response);
	}

}
