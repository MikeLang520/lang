<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <html>
<body bgcolor=pink><font size=2>
	尽管example5_6.jsp没有直接请求我<br>
	我能获得example5_6.jsp提交的非负数，
	<br>但不能获得example5_6.jsp提交的负数。
	<%
		String number=request.getParameter("number");
	%>
	<b>
	<br>用户在example5_6.jsp输入的非负数是<%=number %>
	</b>
</font>
</html>