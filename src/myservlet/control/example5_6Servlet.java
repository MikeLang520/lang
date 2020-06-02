package myservlet.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class example5_6Servlet
 */
@WebServlet("/ch5/example5_6Servlet")
public class example5_6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public example5_6Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number=request.getParameter("number");
		try{	double n=Double.parseDouble(number);
		   if(n<0)
		        response.sendRedirect("example5_6show.jsp");  //重定向
		else{   RequestDispatcher  
	             dispatcher=request.getRequestDispatcher("example5_6show.jsp");
		dispatcher.forward(request, response); //转发到example5_6_show.jsp;
	}}
			catch(NumberFormatException e){
				response.sendRedirect("example5_6.jsp");
			}
	}

}
