package com.neoteric.it.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */

// Extends HttpServlet 
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String strJspPage="/jsp/welcome.jsp";
	
	public void init(ServletConfig servletConfig){
		
		System.out.println("^%^ Company Name ^%^"+servletConfig.getInitParameter("CompanyName"));
		System.out.println("^%^ Country ^%^"+servletConfig.getInitParameter("Country"));
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher(strJspPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("^%^ Modify User Action ^%^"+request.getParameter("useraction"));
		
		if(request.getParameter("useraction")!=null && request.getParameter("useraction").equals("createuser")){
			
			request.getRequestDispatcher("/jsp/createuser.jsp").forward(request, response);
			
		}else{
			
			System.out.println("^%^% User Name  ^%^"+request.getParameter("name"));
			System.out.println("^%^% Password  ^%^"+request.getParameter("pwd"));
			request.getSession().setAttribute("username", request.getParameter("name"));
			request.getSession().setAttribute("pwd", request.getParameter("pwd"));
			request.getRequestDispatcher("/jsp/userdetails.jsp").forward(request, response);
			
		}
		//doGet(request, response);
	}

}
