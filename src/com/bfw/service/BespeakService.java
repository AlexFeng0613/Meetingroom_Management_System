package com.bfw.service;

import java.util.List;

import com.bfw.domain.MeetingroomBespeak;

/**
 * ԤԼҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface BespeakService {

	/**
	 * ���ԤԼ��Ϣ
	 * @param meetbe ԤԼ��Ϣ
	 * @param userIds �μӻ�����Ա
	 * @return true �ɹ� falseΪʧ��
	 */
	public boolean addMeetingroomBespeak(MeetingroomBespeak  meetbe,String userIds);
	
	/**
	 * ��ѯԤԼ��������Ϣ
	 * @param meetbe ��ѯ����
	 * @return
	 */
	public List<MeetingroomBespeak> getAllMeetingroomBespeak(MeetingroomBespeak meetbe);
	
	/**
	 * ���ݱ�Ų�ѯԤԼ��Ϣ
	 * @param bespeakId
	 * @return
	 */
	public MeetingroomBespeak getMeetingroomBespeak(Integer bespeakId);
	
	/**
	 * �޸�ԤԼ��Ϣ
	 * @param meetbe ԤԼ��Ϣ
	 * @param userIds �μӻ�����Ա
	 * @return
	 */
	public boolean updateMeetingroomBespeak(MeetingroomBespeak  meetbe,String userIds);
	
	/**
	 * �޸�ԤԼ��Ϣ��ԤԼ��ˣ�
	 * @param meetbe �����Ϣ
	 * @return
	 */
	public boolean updateMeetingroomBespeak(MeetingroomBespeak  meetbe);
	
}
