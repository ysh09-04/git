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
import com.icss.demo.entity.TurnPagePara;
import com.icss.demo.util.JsonUtil;

public class TurnPageSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TurnPageSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		request.getRequestDispatcher("/main/TurnPage.jsp").forward(request, response);
		
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json; charset=gbk");
		response.setCharacterEncoding("gbk"); 
		String uname = request.getParameter("uname");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		uname = new String(uname.getBytes("ISO-8859-1"),"gbk" );
		if(uname != null && !uname.equals("")){
			TurnPagePara tp = new TurnPagePara();
			tp.CurrentPageNo = Integer.parseInt(page);
			tp.OnePageCount = Integer.parseInt(rows);
			PersonBiz biz = new PersonBiz();
			try {
				List<Person> person = biz.getSeachPerson(1,uname,tp);
				System.out.println(person);
				request.setAttribute("persons", person);
				JSONArray jsonArray = JSONArray.fromObject(person);				
				PrintWriter out = response.getWriter();
				String personstr = jsonArray.toString();
				personstr = JsonUtil.getDatagridJSON(tp.RecordAllCount,personstr);
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
