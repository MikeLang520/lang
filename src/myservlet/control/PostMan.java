package myservlet.control;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/ch5/postman")
public class PostMan extends HttpServlet{
	private static final long serialVersionUID = 4557103380658377142L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("gb2312");
		String name=request.getParameter("name");
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("/ch5/showName.jsp");
		if(name!=null&&name.length()>=1)
			dispatcher.forward(request, response);
		}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		doPost(request,response);
		}
	}


