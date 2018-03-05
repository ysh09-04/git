package com.icss.demo.biz;

import com.icss.demo.dao.MeetingDao;

public class MeetingBiz {
	
	/**
	 * 给指定的会议，添加参会人员
	 * @param mid
	 * @param persons 人员pid
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
	 * 移除某个会议的参会人员
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
