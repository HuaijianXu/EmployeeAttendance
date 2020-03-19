<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>部门员工考勤记录</title>
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
<table align="center" border="1">
<tr>
<td>考勤日期</td>
<td>工号</td>
<td>姓名</td>
<td>性别</td>
<td>部门</td>
<td>考勤类型</td>
</tr>

<c:forEach  var="stu" items="${all}" >
	       <tr>
	       <td>${stu.getDate() }</td>
	       <td>${stu.getJobID() }</td>
	       <td>${stu.getName() }</td>
	       <td>${stu.getSex() }</td>
	       <td>${stu.getDepartment() }</td>
	       <td>${stu.getAttendancetype() }</td>
		   </tr>
</c:forEach>

</table>
</body>
</html>