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
<form action="${pageContext.request.contextPath}/AddServlet?method=yuangong"method="post">
<table>
	
	<tr>
		<td>姓名：</td>
		<td><input type="text"name="Name"style="width:150px;height:30px"></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td><input type="radio"name="sex"value="男">男<input type="radio"name="sex"value="女">女</td>
	</tr>
	<tr>
		<td>出生日期：</td>
		<td><input type="text"name="birthday"style="width:150px;height:30px"></td>
	</tr>
	<tr>
		<td>部门：</td>
		<td><input type="text"name="department"></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password"name="password"style="width:150px;height:30px"></td>
	</tr>
</table>
<p><button type="submit" style="border:0px solid;background-color:#6495ED;margin-left:40%;width:200px;height:35px;">确定</button></p>
</form>
</body>
</body>
</html>