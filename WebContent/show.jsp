<%@ page contentType="text/html;charset=GB2312"%>
<head>
<a href=login.jsp>µÇÂ½</a>
<a href=show.jsp>¿´Í¼</a>
<a href=exit.jsp>ÍË³ö</a>
</head>
<HTML><body bgcolor=yellow>
<%
String name=(String)session.getAttribute("login_name");
if(name==null||name.length()==0){
response.sendRedirect("login.jsp");
}
%>
<image src="D:/siyuan.jpg" width=200 height=178></image>
</body></HTML>