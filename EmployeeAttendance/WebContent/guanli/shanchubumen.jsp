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
<table align="center" border="1">
<tr>
<td>部门编号</td>
<td>部门名称</td>
<td>操作</td>
</tr>

<c:forEach  var="stu" items="${all}" >
	       <tr>
	       <td>${stu.getDepartmentID() }</td>
	       <td>${stu.getDepartment() }</td>
	       <td><a href="${pageContext.request.contextPath}/DeleteServlet?method=delete2&department=${stu.getDepartment()}">删除</a></td>
		   </tr>
</c:forEach>

</table>
</body>
</html>