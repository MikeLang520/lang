<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="fileBean" type="mybean.data.Example8_4_Bean" scope="request"/>
<HTML><body bgcolor=#EEFFAE><font size=2>
�ļ���λ��: <jsp:getProperty name="fileBean" property="filePath"/>,
�ļ������֣�<jsp:getProperty name="fileBean" property="fileName"/>,
�ļ��ĳ��ȣ�<jsp:getProperty name="fileBean" property="fileLength"/> �ֽڡ�
<br>�ļ������ݣ�
<br><TextArea  rows="6" cols="60">
<jsp:getProperty name="fileBean" property="fileContent"/>
</TextArea>
</font></body></HTML>s