package com.icss.demo.biz;

import com.icss.demo.dao.MeetingDao;

public class MeetingBiz {
	
	/**
	 * ��ָ���Ļ��飬��Ӳλ���Ա
	 * @param mid
	 * @param persons ��Աpid
	 * @throws Exception
	 */
	public void addMeetingPerson(int mid,String[] persons) throws Exception{
		
		MeetingDao dao = new MeetingDao();
		try {
			dao.beginTransaction();
			dao.addMeetingPerson(mid, persons);
			dao.commit();
		} catch (Exception e) {			
			dao.rollback();
			throw e;
		}finally{
			dao.closeResource();
		}		
	}
	
	/**
	 * �Ƴ�ĳ������Ĳλ���Ա
	 * @param mid
	 * @param pid
	 * @throws Exception
	 */
	public void removeMeetingPerson(int mid,String pid) throws Exception{
		
		MeetingDao dao = new MeetingDao();		
		try {			
			dao.removeMeetingPerson(mid, pid);			
		} catch (Exception e) {			
			throw e;
		}finally{
			dao.closeResource();
		}		
	}
	

}
