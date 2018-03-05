package com.icss.demo.biz;

import java.util.List;

import com.icss.demo.dao.PersonDao;
import com.icss.demo.entity.Person;
import com.icss.demo.entity.TurnPagePara;

public class PersonBiz {
	
	/**
	 * 返回指定会议的所有参会人员
	 * @param mid  会议ID
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
	 * 获得没有参加指定会议的人员---后期加入翻页
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
	 * 根据用户名，模糊查找符合条件的用户列表
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
