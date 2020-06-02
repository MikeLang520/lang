<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=cyan><font size=3>
<jsp:useBean id="circle" class="circle.Circle" scope="page"/>
<p>圆的初始半径是：<%=circle.getRadius() %>
<% double newRadius =100;
circle.setRadius(newRadius);
%>
<p>修改半径为<%=newRadius %>
<br><b>目前圆的的半径是：<%=circle.getRadius() %>
<br><b>圆的周长是：<%=circle.circlLength() %>
<br><b>圆的面积是：<%=circle.circleArea() %>

</body>
</html>