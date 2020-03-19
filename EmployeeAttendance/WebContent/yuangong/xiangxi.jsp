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
<td>出生日期</td>
<td>部门</td>
<td>调动</td>
</tr>

<c:forEach  var="stu" items="${bumen}" >
	       <tr>
	       <td>${stu.getJobID() }</td>
	       <td>${stu.getName() }</td>
	       <td>${stu.getSex() }</td>
	       <td>${stu.getBirthday() }</td>
	       <td>${stu.getDepartment() }</td>
	       <td><a href="${pageContext.request.contextPath}/DiaodongServlet?method=xiangxi&JobID=${stu.getJobID()}">调动</a></td>
		   </tr>
</c:forEach>

</table>
</body>
</html>