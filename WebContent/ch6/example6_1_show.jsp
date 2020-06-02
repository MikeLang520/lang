 <%@ page contentType="text/html;charset=gb2312" %>
 <jsp:useBean id="seriesData" 
 type="mybean.data.example6_1_Bean" scope="request"/>
 <HTML>
<body=bgcolor=#EEFF88>
<table border=1>
 <tr>
 <th>数列的首项</th>
       
<th><jsp:getProperty property="name" name="seriesData"/></th>
	
<th>所求项数</th>
	
<th>求和结果</th>
   
</tr>
   
<tr>
      
<td><jsp:getProperty property="firstItem" 
name="seriesData"/></td>
      
<td><jsp:getProperty property="var" name="seriesData"/></td>
      
<td><jsp:getProperty property="number" name="seriesData"/></td>
     
<td><jsp:getProperty property="sum" name="seriesData"/></td>
   
</tr>
</table>
</body></HTML>