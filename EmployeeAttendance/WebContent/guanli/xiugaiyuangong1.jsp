<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<%@ page language="java" import="Bean.Yuangong_static" %>
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
<form action="${pageContext.request.contextPath}/ChangeServlet?method=yuangong"method="post">
<table>
	
	<tr>
		<td>工号</td>
		<td><%=Yuangong_static.getJobID() %></td>
	</tr>
	<tr>
		<td>姓名</td>
		<td><input type="text"name="Name"value=<%=Yuangong_static.getName() %>></td>
	</tr>
	<tr>
		<td>性别</td>
		<td><input type="text"name="sex"value=<%=Yuangong_static.getSex() %>></td>
	</tr>
	<tr>
		<td>出生日期</td>
		<td><input type="text"name="birthday"value=<%=Yuangong_static.getBirthday() %>></td>
	</tr>
	<tr>
		<td>部门</td>
		<td><%=Yuangong_static.getDepartment() %></td>
	</tr>
	<tr>
		<td>角色</td>
		<td><%=Yuangong_static.getRole() %></td>
	</tr>
</table>
<p><button type="submit" style="border:0px solid;background-color:#6495ED;margin-left:40%;width:200px;height:35px;">确定</button></p>
</form>
</body>
</body>
</html>