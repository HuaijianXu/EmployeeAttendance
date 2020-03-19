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
<div align="center">
	<h1 style="color: red;">日常考勤管理</h1>
	<table>
	<tr>
		<td>当前时间</td>
		<td>${time }</td>
	</tr>
	</table>
	<form action="${pageContext.request.contextPath}/QianDaoServlet?method=shangban"method="post">
	<p><button type="submit" style="border:0px solid;background-color:#6495ED;margin-left:40%;width:200px;height:35px;">上班</button></p>
	</form>
	<form action="${pageContext.request.contextPath}/QianDaoServlet?method=xiaban"method="post">
	<p><button type="submit" style="border:0px solid;background-color:#6495ED;margin-left:40%;width:200px;height:35px;">下班</button></p>
	</form>
</div>
</body>
</body>
</html>