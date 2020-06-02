<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<p>选择要上传的文件:<BR>
<form ection="upFile" method="post"ENCTYPE="multipart/form-data">
<input type=FILE name="boy" size="45">
<br><input type="submit"name="boy" value="提交">
</form>
<br> 上传的文件名字:
<jsp:getProperty name="fileBean" property="fileName"/>
<br>上传反馈:
<jsp:getProperty name="fileBean" property="mess"/>
</body>
</html>