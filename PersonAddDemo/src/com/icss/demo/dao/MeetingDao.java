package com.icss.demo.dao;

import java.sql.PreparedStatement;

public class MeetingDao extends BaseDao{
	
	/**
	 * 给指定的会议，添加参会人员
	 * @param mid
	 * @param persons
	 * @throws Exception
	 */
	public void addMeetingPerson(int mid,String[] persons) throws Exception{		
		this.openconnection();
		for(String pid: persons ){
			String sql = "insert into meetingperson(pid,mid) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);	
			ps.setString(1,pid);
			ps.setInt(2, mid);
			ps.executeUpdate();
		}		
	}
	
	/**
	 * 移除某个会议的参会人员
	 * @param mid
	 * @param pid
	 * @throws Exception
	 */
	public void removeMeetingPerson(int mid,String pid) throws Exception{
		this.openconnection();
		String sql = "delete from meetingperson where pid=? and mid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pid);
		ps.setInt(2, mid);
		ps.executeUpdate();		
	}

}
