package com.bfw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bfw.domain.MeetingUserinfo;
import com.bfw.domain.MeetingroomBespeak;
import com.bfw.mapper.MeetingUserinfoMapper;
import com.bfw.mapper.MeetingroomBespeakMapper;
import com.bfw.service.BespeakService;
import com.bfw.utils.DBFactoryUtils;

public class BespeakServiceImpl implements BespeakService {

	@Override
	public boolean addMeetingroomBespeak(MeetingroomBespeak meetbe,
			String userIds) {

		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			// ԤԼ���ݷ��ʽӿ�
			MeetingroomBespeakMapper bespeakmapper = session
					.getMapper(MeetingroomBespeakMapper.class);

			int i = bespeakmapper.addBespeak(meetbe);

			int x = -1;

			if (userIds != null && !userIds.equals("")) {

				MeetingUserinfoMapper meetingUsermapper = session
						.getMapper(MeetingUserinfoMapper.class);
				String[] ids = userIds.split(",");

				for (String userId : ids) {

					MeetingUserinfo meetuserinfo = new MeetingUserinfo();
					meetuserinfo.setUserId(userId);
					meetuserinfo.setBespeakId(meetbe.getBespeakId());

					x = meetingUsermapper.addMeetingUserinfo(meetuserinfo);
					if (x == 0) {
						break;
					}
				}

			}

			if (i > 0 && x == -1) {
				session.commit();
				return true;
			} else if (i > 0 && x > 0) {
				session.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

		return false;
	}

	@Override
	public List<MeetingroomBespeak> getAllMeetingroomBespeak(
			MeetingroomBespeak meetbe) {

		try {
			MeetingroomBespeakMapper mapper = DBFactoryUtils
					.getMapper(MeetingroomBespeakMapper.class);

			if (meetbe != null && meetbe.getMeetingName() != null
					&& !meetbe.getMeetingName().equals("")) {
				meetbe.setMeetingName("%" + meetbe.getMeetingName() + "%");
			}

			return mapper.getAllMeetingroomBespeak(meetbe);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MeetingroomBespeak getMeetingroomBespeak(Integer bespeakId) {
		// System.out.println("ҵ���߼���"+bespeakId);
		try {
			if (bespeakId != null) {
				MeetingroomBespeakMapper mapper = DBFactoryUtils
						.getMapper(MeetingroomBespeakMapper.class);

				return mapper.getMeetingroomBespeak(bespeakId);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateMeetingroomBespeak(MeetingroomBespeak meetbe,
			String userIds) {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			MeetingroomBespeakMapper mapper = session
					.getMapper(MeetingroomBespeakMapper.class);

			// �Ȳ�ѯ ���޸�
			MeetingroomBespeak bespeak = mapper.getMeetingroomBespeak(meetbe
					.getBespeakId());

			if (bespeak != null) {
				bespeak.setMeetingroomNote(meetbe.getMeetingroomNote());
				bespeak.setMeetingroomId(meetbe.getMeetingroomId());
				bespeak.setMeetingName(meetbe.getMeetingName());
				bespeak.setStratTime(meetbe.getStratTime());
				bespeak.setEndTime(meetbe.getEndTime());
			}

			int i = mapper.updateBespeak(bespeak);

			int x = -1;
			// ����μ���Ա
			if (userIds != null && !userIds.equals("")) {

				MeetingUserinfoMapper meetingUsermapper = session
						.getMapper(MeetingUserinfoMapper.class);
				String[] ids = userIds.split(",");

				for (String userId : ids) {

					MeetingUserinfo meetuserinfo = new MeetingUserinfo();
					meetuserinfo.setUserId(userId);
					meetuserinfo.setBespeakId(meetbe.getBespeakId());

					x = meetingUsermapper.addMeetingUserinfo(meetuserinfo);
					if (x == 0) {
						break;
					}
				}

			}

			if (i > 0 && x == -1) {
				session.commit();
				return true;
			} else if (i > 0 && x > 0) {
				session.commit();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateMeetingroomBespeak(MeetingroomBespeak meetbe) {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {
			MeetingroomBespeakMapper mapper = session
					.getMapper(MeetingroomBespeakMapper.class);

			// ���ݱ�Ų�ѯԤԼ��Ϣ
			MeetingroomBespeak bespeak = mapper.getMeetingroomBespeak(meetbe
					.getBespeakId());
			if (bespeak != null) {
				// �����
				bespeak.setUseUserId(meetbe.getUseUserId());
				// ���ʱ��
				bespeak.setAuditingTime(meetbe.getAuditingTime());
				// ���״̬:0 δ��� 1 ���ͨ�� 2 ���δͨ��
				bespeak.setBespeakState(meetbe.getBespeakState());
				// ��˱�ע��Ϣ
				bespeak.setAuditingInfo(meetbe.getAuditingInfo());

				int i = mapper.updateBespeak(bespeak);

				if (i > 0) {
					session.commit();
					return true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}

		return false;
	}

}
