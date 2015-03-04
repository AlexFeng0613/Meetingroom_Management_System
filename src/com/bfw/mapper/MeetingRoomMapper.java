package com.bfw.mapper;

import java.util.List;

import com.bfw.domain.MeetingRoom;

/**
 * �����ҵ����ݷ��ʽӿ�
 * @author Administrator
 *
 */
public interface MeetingRoomMapper {
	
	/**
	 * ��ѯ��������Ϣ
	 * @param meetroom ��ѯ����
	 * @return ������Ч�����ң������
	 */
	public List<MeetingRoom> getAllMeetingRoom(MeetingRoom meetroom);

	/**
	 * ��ӻ�������Ϣ
	 * @param meetroom ��������Ϣ
	 * @return ����Ӱ������
	 */
	public int addMeetingRoom(MeetingRoom meetroom);
	
	/**
	 * ���ݱ�Ų�ѯ��������Ϣ
	 * @param meetingroomId �����ұ��
	 * @return
	 */
	public MeetingRoom getMeetingRoom(Integer meetingroomId); 
	
	/**
	 * �޸Ļ�������Ϣ
	 * @param meetroom ��������Ϣ
	 * @return ����Ӱ�������
	 */
	public int updateMeetingRoom(MeetingRoom meetroom);
	
}
