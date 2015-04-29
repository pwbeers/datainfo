package coreservlets;

import java.io.IOException;
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        //Instantiate the model 
        WelcomePageBean bean = new WelcomePageBean();
        bean.setTitle(title);
        bean.setUrl(request.getContextPath());
        
        //Insert "model" object to request
        request.setAttribute("welcome",bean);

        //forward the request to welcomePage.jsp
        request.getRequestDispatcher("/WEB-INF/welcomePage.jsp").forward(request,response);
	}
}
