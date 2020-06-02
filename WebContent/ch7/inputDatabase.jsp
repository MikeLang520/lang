<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="recordBean" class="mybean.data.Shiyan1_Bean" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor=yellow><font size=2>
<form action="Shiyan1_Servlet" method=post>
<b>数据库:<input type="text" name="dataBase" size=22 value=warehouse>
<br>表名:<input type="text" name="tableName" size=23 value=product>
<br>用户名(默认root):<input type="text" name="user" size=10 value=root>
<br>用户密码(默认空):<input type="text" name="password" size=10>
<br><input type="submit" name="b" value="提交">
</form>
<table border=1>
<%
String[][]table=recordBean.getTableRecord();
if(table==null){
	out.print("没有记录");
	return;
}
String []columnName=recordBean.getColumnName();
if(columnName!=null){
	out.print("<tr>");
	for(int i=0;i<columnName.length;i++){
	out.print("<th>"+columnName[i]+"</th>");
}
out.print("</tr>");
}
out.println("全部记录数"+table.length);
for(int i=0;i<table.length;i++){
	out.print("<tr>");
	for(int j=0;j<columnName.length;j++){
		out.print("<td>"+table[i][j]+"</td>");
	}
	out.print("</tr>");
}

%>
</table>
</font>
</body>
</html>