package myservlet.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import mybean.data.Shiyan1_Bean;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Shiyan1_Servlet
 */
@WebServlet("/ch7/Shiyan1_Servlet")
public class Shiyan1_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		try {Class.forName("com.mysql.jdbc.Driver");}
		catch(Exception e) {}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shiyan1_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
	     String dataBase = request.getParameter("dataBase");
	     String tableName = request.getParameter("tableName");
	     String user=request.getParameter("user");
	     String password=request.getParameter("password");
	     boolean boo = (dataBase==null||dataBase.length()==0);
	     boo = boo||(tableName==null||tableName.length()==0);
	     boo = boo||(user==null||user.length()==0);
	     if(boo) {fail(request,response,"查询失败");}
	     HttpSession session=request.getSession(true);
	     java.sql.Connection con=null;
	     Shiyan1_Bean recordBean=null;
	     try {
	    	 recordBean=(Shiyan1_Bean)session.getAttribute("recordBean");
	    	 if(recordBean==null) {
	    		 recordBean=new Shiyan1_Bean();
	    		 session.setAttribute("recordBean", recordBean);}
	    	 }
	     catch(Exception exp) {recordBean=new Shiyan1_Bean();
	     session.setAttribute("recordBean", recordBean);}
	     String uri="jdbc:mysql://127.0.0.1/"+dataBase;
	     try {
	    	 con=DriverManager.getConnection(uri,user,password);
	         java.sql.Statement sql=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        ResultSet rs=sql.executeQuery("SELECT * FROM "+ tableName);
	   	java.sql.ResultSetMetaData metaData=rs.getMetaData();
	   	int columnCount=metaData.getColumnCount();
	   	String columnName[]=new String[columnCount];
	   	for(int i=0;i<columnName.length;i++){
	   		columnName[i]=metaData.getColumnName(i+1);
	   	     }
	   	recordBean.setColumnName(columnName);
	   	rs.last();
	   	int rowNumber=rs.getRow();
	   	String [][] tableRecord=recordBean.getTableRecord();
        tableRecord = new String[rowNumber][columnCount];
        rs.beforeFirst();
        int i=0;
        while(rs.next()){
          for(int k=0;k<columnCount;k++) 
            tableRecord[i][k] = rs.getString(k+1);
          i++; 
        }
        recordBean.setTableRecord(tableRecord); //更新Javabean数据模型
        con.close();
        response.sendRedirect("inputDatabase.jsp");
	     }catch(SQLException e){
	          System.out.println(e);  
	     }  
	     }
	public void fail(HttpServletRequest request,HttpServletResponse response,String backNews) {
   		response.setContentType("text/html;charset=utf-8");
   		try {
   			PrintWriter out=response.getWriter();
   			out.println("<html><body>");
   			out.println("<h2>"+backNews+"</h2>") ;
   			out.println("返回");
   			out.println("<a href =inputDatabase.jsp>输入正确信息</a>");
   			out.println("</body></html>");
   		}
   		catch(IOException exp){} 
   	}
	     
		
	}


