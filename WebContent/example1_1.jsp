<%@ page contentType="text/html;charset=GB2312" %>

<HTML><BODY BGCOLOR=blue>

<h3>����һ���򵥵���˼ԶJSPҳ��</h3>
   
<% int i, sum = 0;
      
for(i= 1; i <= 100;i++){
        
sum = sum+i;
      
}
   
%>

<h5>  1��100���������ǣ�
 
<%=sum %> 

</h5>

</BODY></HTML>
