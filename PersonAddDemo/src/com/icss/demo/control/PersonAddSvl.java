package com.icss.demo.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.demo.biz.MeetingBiz;
import com.icss.demo.biz.PersonBiz;
import com.icss.demo.entity.Person;

public class PersonAddSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PersonAddSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * 进入PersonAdd.jsp页面前，提取所有“未参加指定会议的人员”
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PersonBiz biz = new PersonBiz();
		try {
			List<Person> persons = biz.getNotMeetingPerson(1);
			request.setAttribute("persons", persons);
			request.getRequestDispatcher("/main/PersonAdd.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}	
	}
	
	
	/**
	 * 接收PersonAdd.jsp页面提交过来的数据，写入数据库-->>显示参会人员
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
		
		String[] pids = request.getParameterValues("pid");		
		if(pids != null){
			MeetingBiz biz = new MeetingBiz();
			try {
				biz.addMeetingPerson(1, pids);
				request.getRequestDispatcher("/MeetingPersonSvl").forward(request, response);
			} catch (Exception e) {
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}			
		}
		
   }

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
