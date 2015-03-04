package com.bfw.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bfw.domain.MeetingroomBespeak;
import com.bfw.utils.DBFactoryUtils;

public class MeetingroomBespeakMapperTest {

	@Test
	public void addBespeak(){
		SqlSession session = DBFactoryUtils.getSqlSession();
		
		try {
			MeetingroomBespeakMapper mapper = session.getMapper(MeetingroomBespeakMapper.class);
			
			MeetingroomBespeak bespeak = new MeetingroomBespeak();
			bespeak.setMeetingroomId(2);
			bespeak.setUserId("admin");
			bespeak.setMeetingName("��Ҫ����");
			bespeak.setStratTime(new Date());
			bespeak.setEndTime(new Date());
			bespeak.setMeetingroomNote("����");
			
			int x = mapper.addBespeak(bespeak);
			
			
			/*MeetingUserinfoMapper mappermu = session.getMapper(MeetingUserinfoMapper.class);
			MeetingUserinfo meetinguserinfo = new MeetingUserinfo();
			meetinguserinfo.setUserId("admin");
			meetinguserinfo.setBespeakId(1);
			
			int y = mappermu.addMeetingUserinfo(meetinguserinfo);*/
			
			if(x>0){
				session.commit();
				
				System.out.println("��ӳɹ�");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void getAll(){
		
		MeetingroomBespeakMapper mapper = DBFactoryUtils.getMapper(MeetingroomBespeakMapper.class);
		MeetingroomBespeak bespeak = new MeetingroomBespeak();
		bespeak.setUserId("admin");
		bespeak.setMeetingName("%��Ҫ%");
		
		List<MeetingroomBespeak> list = mapper.getAllMeetingroomBespeak(bespeak);
		
		for(MeetingroomBespeak bespeaks:list){
			System.out.println(bespeaks);
		}
		
	}
	
	@Test
	public void update(){
		SqlSession session = DBFactoryUtils.getSqlSession();
		
		
		try {
			MeetingroomBespeakMapper mapper = session.getMapper(MeetingroomBespeakMapper.class);
		
			
			//�Ȳ�ѯ ���޸�
			MeetingroomBespeak bespeak = mapper.getMeetingroomBespeak(2);

			bespeak.setMeetingroomNote("������Ϣ");
			bespeak.setMeetingroomId(2);
			bespeak.setUserId("admin");
			
			
			
			int i = mapper.updateBespeak(bespeak);
			if(i>0){
				session.commit();
				System.out.println("�޸ĳɹ�");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getBespeak(){
		
		try {
			
			MeetingroomBespeakMapper mapper = DBFactoryUtils.getMapper(MeetingroomBespeakMapper.class);
			
			MeetingroomBespeak bespeak = mapper.getMeetingroomBespeak(1);
			
			System.out.println(bespeak);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
