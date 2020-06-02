package mybean.data;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class example6_1_Bean
 */
@WebServlet("/example6_1_Bean")
public class example6_1_Bean extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double firstItem;

	double var;

	int number;

	double sum;

	String name="";

	public double getFirstItem() {

	return firstItem;

	}

	public void setFirstItem(double firstItem) {

	this.firstItem = firstItem;

	}

	public double getVar() {

	return var;

	}

	public void setVar(double var) {

	this.var = var;

	}

	public int getNumber() {

	return number;

	}

	public void setNumber(int number) {

	this.number = number;

	}

	public double getSum() {

	return sum;

	}

	public void setSum(double sum) {

	this.sum = sum;

	}

	public String getName() {

	return name;
	}

	public void setName(String name) {

	this.name = name;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public example6_1_Bean() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
