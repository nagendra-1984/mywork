package com.neoteric.it.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("^%^ Request from Ajax^%^");
        //response.setContentType("text/html;charset=UTF-8");
        //response.getWriter().write("<?xml version='1.0' encoding='UTF-8'?><RESPONSEXML><CD><ARTIST>Bob Dylan</ARTIST><TITLE>Empire</TITLE></CD></RESPONSEXML>");
        //Creating response XML document request using DOM
        
        StringBuffer sfXml = new StringBuffer();
        response.setContentType("text/xml");
        sfXml.append("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n");
        sfXml.append("<RESPONSEXML>\n");
        sfXml.append("\t<CD>\n");
        sfXml.append("\t<ARTIST>Nagendra Reddy</coinid>\n");
        sfXml.append("\t<TITLE>Empire</TITLE>\n");
        sfXml.append("</CD>\n");
        sfXml.append("</RESPONSEXML>\n");
        System.out.println("^%^ Final String ^%^"+sfXml.toString());
        response.getWriter().println(sfXml.toString());
        response.getWriter().flush();
        response.getWriter().close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
