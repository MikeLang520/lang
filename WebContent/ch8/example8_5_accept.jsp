<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><body>
<%@ try{InputStream in=request.getInputStream();
File dir=new File("C:/1000");
dir.mkdir();
File f=new File(dir,"B.tet");
FileOutputStream o=new FileOutputStream(f);
byte b[]=new byte[1000];
int n;
while((n=in.read(b))!=-1)
o.write(b,o,n);
o.close();
in.close();
out.print("�ļ����ϴ�");
}
catch(IOException ee){
out.print("�ϴ�ʧ��"+ee);
}
%>
</body></html> 