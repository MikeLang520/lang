<jsp:useBean id="tri" class="red.star.Triangle" scope="request"/>
<%@ page contentType="text/html;charset=gb2312" %>

<HTML><body bgcolor=#AAFF99><font size=3>

<form action="" method="post">
输入三角形三边：
边A:<input type= text name="sideA"value=0 size=5>
边B:<input type=text name="sideB"value=0 size=5>
边C:<input type=text name="sideC"value=0 size=5>
<input type=submit value="提交">
</form>

<jsp:setProperty name="tri" property="*"/>
三角形的三边是:
<jsp:getProperty property="sideA" name="tri"/>
<jsp:getProperty property="sideB" name="tri"/>
<jsp:getProperty property="sideC" name="tri"/>
<br><b>这三个边能构成一个三角形吗？<jsp:getProperty property="triangle" name="tri"/>
<br>面积是：<jsp:getProperty property="area" name="tri"/></b>
</font></body></HTML>