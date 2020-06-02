<%@ page contentType="text/html;charset=gb2312" %>
<html>
<BODY BGCOLOR=yellow><FONT Size=3>
<%! int count;
StringBuffer personList;
public void judge(){
if(count==0)
personList=new StringBuffer();
}
public void addPerson(String p){
if(count==0)
personList.append(p);
else
personList.append(","+p);
count++;
}  
%>
<% String name=request.getParameter("name");
byte bb[] = name.getBytes("gb2312");
name=new String(bb);
if(name.length()==0||name.length()>10)   { 
%>
<jsp:forward page="inputName.jsp" />
<%   }
judge();
addPerson(name);
%>
<BR> 目前共有<%=count%>人浏览了该页面,他们的名字是:
<BR> <%=personList %>
</FONT></BODY>
</html>