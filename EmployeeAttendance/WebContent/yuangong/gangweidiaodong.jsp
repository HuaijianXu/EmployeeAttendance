<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<%@ page language="java" import="Bean.Yuangong_static" %>
<title>员工调动</title>
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
<form action="${pageContext.request.contextPath}/DiaodongServlet?method=diaodong&JobID=<%=Yuangong_static.getJobID()%>"method="post">
<table>
	
	<tr>
		<td>工号</td>
		<td><%=Yuangong_static.getJobID() %></td>
	</tr>
	<tr>
		<td>姓名</td>
		<td><%=Yuangong_static.getName() %></td>
	</tr>
	<tr>
		<td>性别</td>
		<td><%=Yuangong_static.getSex() %></td>
	</tr>
	<tr>
		<td>出生日期</td>
		<td><%=Yuangong_static.getBirthday() %></td>
	</tr>
	<tr>
		<td>部门</td>
		<td><%=Yuangong_static.getDepartment() %></td>
	</tr>
	<tr>
		<td>请输入调入部门名称</td>
		<td><input type="text" name="department" ></td>
	</tr>
</table>
<p><button type="submit" style="border:0px solid;background-color:#6495ED;margin-left:40%;width:200px;height:35px;">调入</button></p>
</form>
</body>
</body>
</html>