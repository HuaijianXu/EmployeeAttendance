<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<%
	//
	//接收servlet传过来的那个message的参数
	//alert是js语句中的弹出警示框，也就是弹出message中的参数
	Object message=request.getAttribute("message");
	if(!(message==null||message.equals("")))
	{
		%>
		<script type="text/javascript">alert('<%=message%>')</script>
		<%
	}
%>
<body>
<form action="${pageContext.request.contextPath}/ChangeServlet?method=xiugaimima"method="post">
<table>
	
	<tr>
		<td>请输入原密码：</td>
		<td><input type="text"name="password"></td>
	</tr>
	<tr>
		<td>请输入新密码：</td>
		<td><input type="text"name="password_new"></td>
	</tr>
</table>
<p><button type="submit" style="border:0px solid;background-color:#6495ED;margin-left:40%;width:200px;height:35px;">确定</button></p>
</form>
</body>
</body>
</html>