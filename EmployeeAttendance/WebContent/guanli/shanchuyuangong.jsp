<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<table align="center" border="1">
<tr>
<td>工号</td>
<td>姓名</td>
<td>性别</td>
<td>部门</td>
<td>角色</td>
<td>删除</td>
</tr>

<c:forEach  var="stu" items="${all}" >
	       <tr>
	       <td>${stu.getJobID() }</td>
	       <td>${stu.getName() }</td>
	       <td>${stu.getSex() }</td>
	       <td>${stu.getDepartment() }</td>
	       <td>${stu.getRole() }</td>
	       <td><a href="${pageContext.request.contextPath}/DeleteServlet?method=delete1&JobID=${stu.getJobID() }">删除</a></td>
		   </tr>
</c:forEach>

</table>
</body>
</html>