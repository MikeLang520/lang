<jsp:useBean id="tri" class="red.star.Triangle" scope="request"/>
<%@ page contentType="text/html;charset=gb2312" %>

<HTML><body bgcolor=#AAFF99><font size=3>

<form action="" method="post">
�������������ߣ�
��A:<input type= text name="sideA"value=0 size=5>
��B:<input type=text name="sideB"value=0 size=5>
��C:<input type=text name="sideC"value=0 size=5>
<input type=submit value="�ύ">
</form>

<jsp:setProperty name="tri" property="*"/>
�����ε�������:
<jsp:getProperty property="sideA" name="tri"/>
<jsp:getProperty property="sideB" name="tri"/>
<jsp:getProperty property="sideC" name="tri"/>
<br><b>���������ܹ���һ����������<jsp:getProperty property="triangle" name="tri"/>
<br>����ǣ�<jsp:getProperty property="area" name="tri"/></b>
</font></body></HTML>