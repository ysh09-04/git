package com.icss.demo.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.demo.biz.PersonBiz;
import com.icss.demo.entity.Person;

public class MeetingPersonSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MeetingPersonSvl() {
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
     * ��ȡ�μ�ָ���������Ա��Ϣ
     */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		 
		
		 PersonBiz biz = new PersonBiz();
		 try {
			 List<Person> persons = biz.getMeetingPerson(1);  //α����
			 request.setAttribute("allPersons",persons);
			 request.getRequestDispatcher("/main/mperson.jsp").forward(request, response);
		 } catch (Exception e) {
			 e.printStackTrace();			 
			 request.getRequestDispatcher("/error.jsp").forward(request, response);
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
