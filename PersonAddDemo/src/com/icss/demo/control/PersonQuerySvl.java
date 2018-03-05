package com.icss.demo.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.icss.demo.biz.PersonBiz;
import com.icss.demo.entity.Person;
import com.icss.demo.util.JsonUtil;

public class PersonQuerySvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PersonQuerySvl() {
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
	 * 根据条件搜索人员，查询到的人员列表返给PersonAdd.jsp
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/json; charset=gbk");
		response.setCharacterEncoding("gbk"); 
		String uname = request.getParameter("uname");
		uname = new String(uname.getBytes("ISO-8859-1"),"gbk" );
		if(uname != null && !uname.equals("")){
			PersonBiz biz = new PersonBiz();
			try {
				List<Person> persons = biz.getSeachPerson(1,uname);
				request.setAttribute("persons", persons);
				JSONArray jsonArray = JSONArray.fromObject(persons);				
				PrintWriter out = response.getWriter();
				String personstr = jsonArray.toString();
				personstr = JsonUtil.getDatagridJSON(persons.size(),personstr);
				System.out.println(personstr);	
				out.print(personstr);								
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}			
		}else{
			request.getRequestDispatcher("/main/PersonQuery.jsp").forward(request, response);
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
