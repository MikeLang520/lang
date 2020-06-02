<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor=cyan><font size=2>
	
<form action="example7_2_Servlet?dataBase=warehouse&tableName=product" method=post>
	
查询warehouse数据库product表中
    
<br>price值大于<input type=text name="price" value=1500 size=6>的记录
    
<br>输入用户名：<input type=text name="user" value=root size=5>（默认root）
    
<br>输入密码：<input type=password name="password" size=3>（默认空）
    
<br><input type=submit name="sub" value="提交">
  
</form>
</font>
</html>