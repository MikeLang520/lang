package myservlet.control;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

import mybean.data.Example7_2_Bean;
@SuppressWarnings("deprecation")
@WebServlet("/ch7/example7_2_Servlet")
public class example7_2_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public example7_2_Servlet() {
        super();
      
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, 
	IOException {  Example7_2_Bean resultBean=null;
	     
	try{resultBean=(Example7_2_Bean)request.getAttribute("resultBean");
	         
	if(resultBean==null){   resultBean=new Example7_2_Bean();
				
	request.setAttribute("resultBean", resultBean);
		
	}}
	catch(Exception exp){ resultBean=new Example7_2_Bean();
	request.setAttribute("resultBean",resultBean);
			}
		
	try{Class.forName("com.mysql.jdbc.Driver");
		
	}   catch(Exception e){}
			
	String number=request.getParameter("price");
			
	if(number==null||number.length()==0) return;
			
	String dataBase=request.getParameter("dataBase");
			
	String tableName=request.getParameter("tableName");
			
	String user=request.getParameter("user");
			
	String password=request.getParameter("password");
			
	float p=Float.parseFloat(number);
	Connection con;

	Statement sql;

	ResultSet rs;

	try{String uri="jdbc:mysql://127.0.0.1/"+dataBase;
	      
	con=(Connection) DriverManager.getConnection(uri,user,password);
	      
	sql=(Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
	ResultSet.CONCUR_READ_ONLY);
	     
	String condition="select * from "+tableName+" where price>"+p;
		
	rs=sql.executeQuery(condition);
		
	ResultSetMetaData metaData=(ResultSetMetaData) rs.getMetaData();
		
	int columnCount=metaData.getColumnCount();
		
	String columnName[]=new String[columnCount];
		
	for(int i=0;i<columnName.length;i++){
			
	columnName[i]=metaData.getColumnName(i+1);
		     
	}
		
	resultBean.setColumnName(columnName);
		
	rs.last();
		
	int rowNumber=rs.getRow();
	String tableRecord[][]=resultBean.getTableRecord();
		
	tableRecord=new String[rowNumber][columnCount];
		rs.beforeFirst();
		
	int i=0;
		
	while(rs.next()){
			
	for(int k=0;k<columnCount;k++)
				
	tableRecord[i][k]=rs.getString(k+1);
				
	i++;
			
	}
			
	resultBean.setTableRecord(tableRecord);
			
	con.close();
			
	 javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("showRecord.jsp");
			
	dispatcher.forward(request, response);
			
	}
			
	catch(SQLException e){
				
	System.out.println(e);
		
	}}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}



