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
<td>考勤日期</td>
<td>考勤类型</td>
</tr>

<c:forEach  var="stu" items="${all}" >
	       <tr>
	       <td>${stu.getDate() }</td>
	       <td>${stu.getAttendancetype() }</td>
		   </tr>
</c:forEach>

</table>
</body>
</html>