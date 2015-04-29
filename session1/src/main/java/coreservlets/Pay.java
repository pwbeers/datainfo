package coreservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Pay extends HttpServlet	{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("shoppingCart");
		response.sendRedirect("welcomePage");
	}
}
