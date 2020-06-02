package myservlet.control;
import mybean.data.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
@WebServlet("/ch10/loginServlet")
public class HandleLogin extends HttpServlet {
private static final long serialVersionUID = 1L;
public HandleLogin() {
super();
 }
public void init(ServletConfig config) throws ServletException {
super.init(config);
try{ 
Class.forName("com.mysql.jdbc.Driver");
 }
catch(Exception e){} 
}
public String handleString(String s){
 try{  byte bb[]=s.getBytes("iso-8859-1");
 s=new String(bb,"gb2312");
}
catch(Exception ee){} 
return s;  
 }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Connection con;       Statement sql; 
 String logname=request.getParameter("logname").trim(),
password=request.getParameter("password").trim();
 logname=handleString(logname);
password=handleString(password);
String uri="jdbc:mysql://127.0.0.1/shop?"+
"user=root&password=123456&characterEncoding=UTF-8";
 boolean boo=(logname.length()>0)&&(password.length()>0);  
 try{        con=DriverManager.getConnection(uri);
String condition="select * from user where logname = '"+logname+
"' and password ='"+password+"'";
sql=con.createStatement();  
if(boo){    ResultSet rs=sql.executeQuery(condition);
boolean m=rs.next();
 if(m==true){                 //���õ�¼�ɹ��ķ���:
success(request,response,logname,password); 
 RequestDispatcher dispatcher=
request.getRequestDispatcher("login.jsp");//ת��
dispatcher.forward(request,response);
} else{   String backNews="��������û��������ڣ������벻����";
 //���õ�¼ʧ�ܵķ���:
fail(request,response,logname,backNews); 
} }
else{      String backNews="�������û���������";
fail(request,response,logname,backNews);
 }
con.close();
}   catch(SQLException exp){           String backNews=""+exp;
 fail(request,response,logname,backNews);
}     }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
}
public void success(HttpServletRequest request,HttpServletResponse response,String logname,String passwoed)
	{
Login loginBean=null;
HttpSession session=request.getSession(true);
try{  loginBean=(Login)session.getAttribute("loginBean");
if(loginBean==null){
 loginBean=new Login();  //�����µ�����ģ�� 
 session.setAttribute("loginBean",loginBean);
loginBean=(Login)session.getAttribute("loginBean");
  }      
String name =loginBean.getLogname();
if(name.equals(logname)) { loginBean.setBackNews(logname+"�Ѿ���¼��");
loginBean.setLogname(logname);
 }  else {  //����ģ�ʹ洢�µĵ�¼�û�
loginBean.setBackNews(logname+"��¼�ɹ�");
loginBean.setLogname(logname);
 }        }
catch(Exception ee){ loginBean=new Login();  
session.setAttribute("loginBean",loginBean);
loginBean.setBackNews(logname+"��¼�ɹ�");
 loginBean.setLogname(logname);
} }
public void fail(HttpServletRequest request,HttpServletResponse response
 ,String logname,String backNews) {
response.setContentType("text/html;charset=UTF-8");
try {
PrintWriter out=response.getWriter();
out.println("<html><body>");
out.println("<h2>"+logname+"��¼�������<br>"+backNews+"</h2>") ;
out.println("���ص�¼ҳ�����ҳ<br>");
out.println("<a href =login.jsp>��¼ҳ��</a>");
out.println("<br><a href =index.jsp>��ҳ</a>");
out.println("</body></html>");
}
catch(IOException exp){}	
}
}