package com.icss.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {
	
	protected Connection conn;                //数据库连接句柄
	
	/*
	 * 获取数据库连接
	 */
	protected void openconnection() throws ClassNotFoundException,SQLException{		
		try {
			if( conn == null || conn.isClosed() ){
				Class.forName("com.mysql.jdbc.Driver");  //使用反射技术动态加载数据库的驱动
				conn = DriverManager.getConnection("jdbc:mysql:///mysql","root","ysh09-04");
			}			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		    throw e;
		} catch (SQLException e) {	
			e.printStackTrace();
			throw e;
		}
	}	
	
	public void closeResource(){
		
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
	}
	
	public void beginTransaction() throws Exception{
		this.openconnection();                   //开始事务前，必须保证connetion存在
		if(conn != null){
			conn.setAutoCommit(false);
		}
			
	}
	
	public void commit() throws Exception{
		if(conn != null){
			conn.commit();
		}	
	}
	
	public void rollback() throws Exception{
		if(conn != null){
			conn.rollback();
		}
		
	}
	
	/**
	 * 根据输入的sql，获得所有查询结果的记录数
	 * @param strSql
	 * @return
	 * @throws Exception
	 */
	public  int getRecCount(String strSql) throws Exception{
		int iRec = 0;		
		
		String strExe = "SELECT count(*) count FROM (" + strSql + ") w";
		try {
			Statement st = this.conn.createStatement();						
			ResultSet rs = st.executeQuery(strExe);
			if( rs != null ){
				while( rs.next() ){				
						iRec = rs.getInt("count");
						break;										
				}
				rs.close();
			}	
		} catch (Exception e) {
			throw e;
		}		
		
		return iRec;
	}	
	
	public  ResultSet executeQuery(String strSql,int iStart,int iEnd) throws Exception{	
		ResultSet rs = null;			
		try{
			Statement st = this.conn.createStatement();	
			if(st != null){				
				String strNew = "" + strSql + " limit "+(iStart-1)+","+ iEnd+" " ;					
				rs = st.executeQuery(strNew);
			}				
		}catch(SQLException e){			
			throw e;
		}
		
		return rs;
	}  

}
