package myservlet.control;
import mybean.data.example6_1_Bean;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class example6_1_Servlet
 */
@WebServlet("/ch6/example6_1_Servlet")
public class example6_1_Servlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public example6_1_Servlet() {
super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
example6_1_Bean seriesData=new example6_1_Bean();
request.setAttribute("seriesData", seriesData);
double a=Double.parseDouble(request.getParameter("firstItem"));
double d=Double.parseDouble(request.getParameter("var")); //公比
int n=Integer.parseInt(request.getParameter("number"));
seriesData.setFirstItem(a);
seriesData.setVar(d);
seriesData.setNumber(n);
double sum=0,item=a;
int i=1;
while(i<=n){sum=sum+item;
i++;       
item=item*d;}
seriesData.setSum(sum);
RequestDispatcher dispatcher=request.getRequestDispatcher("example6_1_show.jsp");
dispatcher.forward(request, response);}
 protected void doPost(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
example6_1_Bean seriesData=new example6_1_Bean(); //创建JavaBean对象
request.setAttribute("seriesData", seriesData);
double a=Double.parseDouble(request.getParameter("firstItem"));
double d=Double.parseDouble(request.getParameter("var")); //公差
int n=Integer.parseInt(request.getParameter("number"));
seriesData.setFirstItem(a);  //将数据存储在数据模型seriesData中
seriesData.setVar(d);
seriesData.setNumber(n);
double sum=0,item=a;
int i=1;
seriesData.setName("等差数列的公差");
while(i<=n){
sum=sum+item;
i++;
item=item+d;
}
seriesData.setSum(sum);
RequestDispatcher dispatcher=request.getRequestDispatcher("example6_1_show.jsp");
dispatcher.forward(request, response);
}
}
