package com.bfw.service;

import java.util.List;

import com.bfw.domain.MeetingUserinfo;

/**
 * �μӻ�����Ա��ϵ�� ҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface MeetingUserinfoService {

	/**
	 * ���ݵ��۲�ѯ�μӻ�����Ա��Ϣ
	 * @param meetinguserinfo ��ѯ����
	 * @return
	 */
	public List<MeetingUserinfo> getAllMeetingUserinfo(MeetingUserinfo meetinguserinfo);
}
