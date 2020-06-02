package myservlet.control;
import mybean.data.Example7_2_Bean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch7/Shiyan2_Servlet")
public class Shiyan2_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Shiyan2_Servlet() {
        super();
    }
    public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Example7_2_Bean resultBean=null;
	     try{  resultBean=(Example7_2_Bean)request.getAttribute("resultBean");
	     	if(resultBean==null){
	     		resultBean=new Example7_2_Bean(); //创建Javabean对象
	            request.setAttribute("resultBean",resultBean);
	     	}
	     }
	     catch(Exception exp){
	    	 resultBean=new Example7_2_Bean();  //创建Javabean对象
	         request.setAttribute("resultBean",resultBean);
	     } 
	     try{  Class.forName("com.mysql.jdbc.Driver");
	     }
	     catch(Exception e){} 
	     request.setCharacterEncoding("gb2312");
	     String dataBase = request.getParameter("dataBase");
	     String tableName = request.getParameter("tableName");
	     String number=request.getParameter("number");
	     String name=request.getParameter("name");
	     String ageStr=request.getParameter("age");
	     if(number==null||number.length()==0) {
	        fail(request,response,"添加记录失败,必须给出记录");
	        return;
	     }
	     if(ageStr==null || ageStr.length()==0)
	    	 ageStr="-1";
	     int age=Integer.parseInt(ageStr);
	     Connection con;
	     java.sql.PreparedStatement sql;
	     ResultSet rs;
	     try{ 
	    	 String uri="jdbc:mysql://127.0.0.1/"+dataBase+"?"+"user=root&password=123456&characterEncoding=gb2312";
	    	 con=DriverManager.getConnection(uri);
	    	 sql=con.prepareStatement("insert message VALUES(?,?,?)");
	    	 sql.setString(1,number);
	    	 sql.setString(2,name);
	    	 sql.setInt(3,age);
	    	 sql.executeUpdate();
	    	 sql=con.prepareStatement("SELECT * FROM "+tableName);
	    	 rs=sql.executeQuery();
	    	 java.sql.ResultSetMetaData metaData = rs.getMetaData();
	    	 int columnCount = metaData.getColumnCount(); //得到结果集的列数
	    	 String []columnName = new String[columnCount];
	    	 for(int i=0;i<columnName.length;i++) {
	    		 columnName[i] = metaData.getColumnName(i+1); //得到列名
	    	 }
	    	 resultBean.setColumnName(columnName);   //更新Javabean数据模型
	    	 rs.last();
	    	 int rowNumber=rs.getRow();  //得到记录数
	    	 String [][] tableRecord=resultBean.getTableRecord();
	    	 tableRecord = new String[rowNumber][columnCount];
	    	 rs.beforeFirst();
	         int i=0;
	         while(rs.next()){
	        	 for(int k=0;k<columnCount;k++) 
	        		 tableRecord[i][k] = rs.getString(k+1);
	        	 i++; 
	          }
	          resultBean.setTableRecord(tableRecord); //更新Javabean数据模型
	          con.close();
	          RequestDispatcher dispatcher=
	          request.getRequestDispatcher("showRecord.jsp");
	          dispatcher.forward(request,response);
	     	}
	     	catch(SQLException e){
	    	System.out.println(e);
	    	fail(request,response,"添加记录失败:"+e.toString());
	     	}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	public void fail(HttpServletRequest request,HttpServletResponse response,String backNews) {
		response.setContentType("text/html;charset=gb2312");
		try {
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			out.println("<h2>"+backNews+"</h2>") ;
			out.println("返回");
			out.println("<a href =insert.jsp>输入记录</a>");
			out.println("</body></html>");
		}
		catch(IOException exp){} 
	}
}
