<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*" %>

<%Connection con;     Statement sql;     ResultSet rs;
	
try{	Class.forName("com.mysql.jdbc.Driver");
	
}  catch(Exception e){   out.println("驱动程序没有加载");}
	
try{
		
String uri="jdbc:mysql://127.0.0.1/warehouse";
		
String user="root";
		
String password="123456";
	
con=DriverManager.getConnection(uri+"?user=root&password=123456");
		
sql=con.createStatement();
		
rs=sql.executeQuery("select * from product");
		
out.print("<table border=2>");
		
out.print("<tr>");
			
out.print("<th width=100>"+"产品号");
			
out.print("<th width=100>"+"名称");
			
out.print("<th width=50>"+"生产日期");
			
out.print("<th width=50>"+"价格");
		
out.print("</tr>");
while(rs.next()){
			
out.print("<tr>");
				
out.print("<td>"+rs.getString(1)+"</td>");
				
out.print("<td>"+rs.getString(2)+"</td>");
		             
out.print("<td>"+rs.getDate("madeTime")+"</td>");
		             
out.print("<td>"+rs.getFloat("price")+"</td>");
			
out.print("</tr>");
		}
		
out.print("</table>");
		
con.close();
	}
	
catch(SQLException e){
		
out.print(e);
	}
%>

</html>