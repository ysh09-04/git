package com.icss.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.icss.demo.entity.Person;
import com.icss.demo.entity.TurnPagePara;

public class PersonDao extends BaseDao {
	/**
	 * ����ָ����������вλ���Ա
	 * @param mid  ����ID
	 * @return
	 * @throws Exception
	 */
	public List<Person> getMeetingPerson(int mid) throws Exception{
		List<Person> persons = null;
		
		this.openconnection();
		String sql = "select p.address, p.birthday,p.name,p.sex,p.pid,m.autoid " +
				     " from meetingperson t,tperson p,tmeeting m " +
				     " where p.pid = t.pid and m.autoid = t.mid and mid=? order by p.pid";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, mid);
		ResultSet rs = ps.executeQuery();
		if(rs != null){                                                    
			persons = new ArrayList<Person>();
			while(rs.next()){
				Person p = new Person();
				p.setPid(rs.getString("pid"));
				p.setBirthday(rs.getDate("birthday"));
				p.setAddress(rs.getString("address"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex"));
				persons.add(p);
			}
		}
		
		return persons;
	}
	
	/**
	 * ���û�вμ�ָ���������Ա
	 * @param mid
	 */
	public List<Person> getNotMeetingPerson(int mid) throws Exception{
		
		
		List<Person> persons = null;
		
		this.openconnection();
		String sql = "select * from tperson where pid  not in  (select mp.pid " +
				   " from meetingperson mp, tmeeting m  where m.autoid = mp.mid and m.autoid=? ) order by pid";		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, mid);
		ResultSet rs = ps.executeQuery();
		if(rs != null){                                                    
			persons = new ArrayList<Person>();
			while(rs.next()){
				Person p = new Person();
				p.setPid(rs.getString("pid"));
				p.setBirthday(rs.getDate("birthday"));
				p.setAddress(rs.getString("address"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex"));
				persons.add(p);
			}
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
		
		this.openconnection();
		String sql = "select * from tperson where name like '%" + uname + "%' and  pid  not in  (select mp.pid " +
				   " from meetingperson mp, tmeeting m  where m.autoid = mp.mid and m.autoid=? ) order by name";		
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setInt(1, mid);
		ResultSet rs = ps.executeQuery();
		if(rs != null){                                                    
			persons = new ArrayList<Person>();
			while(rs.next()){
				Person p = new Person();
				p.setPid(rs.getString("pid"));
				p.setBirthday(rs.getTimestamp("birthday"));
				p.setAddress(rs.getString("address"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex"));
				persons.add(p);
			}
		}
		
		return persons;
	}
	
	public List<Person> getSeachPerson(int mid,String uname,TurnPagePara tp) throws Exception{
		List<Person> persons = null;
		
		this.openconnection();
		String sql = "select * from tperson where name like '%" + uname + "%' and  pid  not in  (select mp.pid " +
				   " from meetingperson mp, tmeeting m  where m.autoid = mp.mid and m.autoid=" + mid + " ) order by name ";		
		tp.RecordAllCount = this.getRecCount(sql);         						//�����ܼ�¼������ҳ��		
		int iStart = (tp.CurrentPageNo-1)*tp.OnePageCount + 1;
		int iEnd = iStart + tp.OnePageCount;
		ResultSet rs = executeQuery(sql,iStart,iEnd);
		if(rs != null){                                                    
			persons = new ArrayList<Person>();
			while(rs.next()){
				Person p = new Person();
				p.setPid(rs.getString("pid"));
				p.setBirthday(rs.getTimestamp("birthday"));
				p.setAddress(rs.getString("address"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getString("sex"));
				persons.add(p);
			}
		}
		
		return persons;
	}
}
