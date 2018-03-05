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
	 * ����PersonAdd.jspҳ��ǰ����ȡ���С�δ�μ�ָ���������Ա��
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
	 * ����PersonAdd.jspҳ���ύ���������ݣ�д�����ݿ�-->>��ʾ�λ���Ա
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
