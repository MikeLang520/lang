<%@ page contentType="text/html;charset=GB2312"%>
<head>
<a href=login,jsp>登陆</a>
<a href=show.jsp>看图</a>
<a href=exit.jsp>退出</a>
</head>
<HTML><body bgcolor=yellow>
<%
session.invalidate();
%>
<b>session会话失败
</b></body></HTML>