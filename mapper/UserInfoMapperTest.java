package com.bfw.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bfw.domain.UserInfo;
import com.bfw.utils.DBFactoryUtils;

public class UserInfoMapperTest {

	@Test
	public void getAllUser() {

		UserInfoMapper mapper = DBFactoryUtils.getMapper(UserInfoMapper.class);

		UserInfo user = new UserInfo();
		user.setUserName("����");
		user.setUserSex("��");

		List<UserInfo> list = mapper.getAllUser(user);

		for (UserInfo userinfo : list) {
			System.out.println(userinfo);
		}

	}

	@Test
	public void getUserInfo() {

		UserInfoMapper mapper = DBFactoryUtils.getMapper(UserInfoMapper.class);

		UserInfo user = mapper.getUserInfo("admin");
		System.out.println(user);

	}

	@Test
	public void updateUser() {
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);

			UserInfo userInfo = new UserInfo();
			userInfo.setUserId("243");
			userInfo.setUserName("��ΰ");
			userInfo.setUserSex("��");
			userInfo.setUserAge(17);
			

			int i = mapper.updateUser(userInfo);
			
			if(i>0){
				session.commit();
				System.out.println("�޸ĳɹ���");
			}else{
				System.out.println("�޸�ʧ��");
			}

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}

	}
	
	@Test
	public void delete(){
		
		SqlSession session = DBFactoryUtils.getSqlSession();

		try {

			UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);

			
/*
			int i = mapper.deleteUser("admin");
			
			if(i>0){
				session.commit();
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ��");
			}*/

		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
	}

}
