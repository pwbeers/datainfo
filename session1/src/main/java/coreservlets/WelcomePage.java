package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomePage extends HttpServlet	{

	private static final long serialVersionUID = 1L;
	private String title;
	
	public void init() {
		title = "Welcome to our online store!";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML>\n";
		out.println(docType + "<HTML>\n" + "<HEAD><TITLE>" + title
				+ "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n"
				+ "<H1 ALIGN=\"CENTER\">" + title + "</H1>"
				+ "<HR>\n");
		//body functionality
		out.println("<h2>We have the following functions:</h2>\n"
				+ "<p><a href=" + request.getContextPath() + "/kidsBooksPage>Kids Books</a></p>\n"
				+ "<p><a href=" + request.getContextPath() + "/techBooksPage>Tech Books</a></p>\n"
				+ "<p><a href=" + request.getContextPath() + "/orderPage>Order Page</a></p>\n");
		out.println("</BODY></HTML>");
	}

}
