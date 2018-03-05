package com.icss.demo.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.demo.biz.MeetingBiz;

public class PersonRemoveSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PersonRemoveSvl() {
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
	 * 移除某个会议下的某个参会人员
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pid = request.getParameter("pid");
		if(pid != null){
			try {
				MeetingBiz biz = new MeetingBiz();
				biz.removeMeetingPerson(1, pid);
				request.getRequestDispatcher("MeetingPersonSvl").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
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
