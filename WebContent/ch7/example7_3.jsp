<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<form 
action="example7_3_Servlet?dataBase=warehouse&tableName=product" method=post>

添加新记录:

<table border=1>

<tr><td> 产品号：</td><td><Input type="text" name="number"></td></tr>

<tr><td>名称：</td><td><Input type="text" name="name"></td></tr>

<tr><td>生产日期：</td><td><Input type="text" 
name="madeTime"></td></tr>

<tr><td>价格：</td><td><Input type="text" name="price"></td></tr>

</table>

<br><input type="submit" name="b" value="提交">

</font>
</html>