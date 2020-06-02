package myservlet.control;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ch5/Decompose")
public class Decompose extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public Decompose() {
        super();}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out=response.getWriter();
		out.println("<html><body bgcolor=yellow>");
		String str=request.getParameter("english");
		if(str==null ||str.length()==0)
			return;
		String []word =str.split("[^a-zA-Z]+");
		int n=0;
		try {
			for(int i=0;i<word.length;i++) {
				if(word [i].length()>=1){
					n++;
					out.print("<br>"+word[i]);
				}}}
		catch(NumberFormatException e) {
			out.print(""+e);}
		out.print("<h2>句子中单词数目："+n);
		out.println("</body></html>");
	}}