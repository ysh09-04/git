package com.icss.demo.biz;

import java.util.List;

import com.icss.demo.dao.PersonDao;
import com.icss.demo.entity.Person;
import com.icss.demo.entity.TurnPagePara;

public class PersonBiz {
	
	/**
	 * ����ָ����������вλ���Ա
	 * @param mid  ����ID
	 * @return
	 * @throws Exception
	 */
	public List<Person> getMeetingPerson(int mid) throws Exception{
		List<Person> persons = null;
		
		PersonDao dao = new PersonDao();
		try {
			persons = dao.getMeetingPerson(mid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeResource();
		}
		
		return persons;
	}
	
	/**
	 * ���û�вμ�ָ���������Ա---���ڼ��뷭ҳ
	 * @param mid
	 */
	public List<Person> getNotMeetingPerson(int mid) throws Exception{
		List<Person> persons = null;
		
		PersonDao dao = new PersonDao();
		try {
			persons = dao.getNotMeetingPerson(mid);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeResource();
		}
		
		return persons;		
		
	}
	
	/**
	 * �����û�����ģ�����ҷ����������û��б�
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	public List<Person> getSeachPerson(int mid,String uname) throws Exception{
		List<Person> persons = null;
		
		PersonDao dao = new PersonDao();
		try {
			persons = dao.getSeachPerson(mid,uname);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeResource();
		}
		
		return persons;		
	}
	
	public List<Person> getSeachPerson(int mid,String uname,TurnPagePara tp) throws Exception{
		List<Person> persons = null;
		
		PersonDao dao = new PersonDao();
		try {
			persons = dao.getSeachPerson(mid,uname,tp);
		} catch (Exception e) {
			throw e;
		}finally{
			dao.closeResource();
		}
		
		return persons;		
	}

}
