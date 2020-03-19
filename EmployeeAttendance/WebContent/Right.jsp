<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<p style="margin-top:300px;margin-left:500px">信1805-1班、徐怀建、20183603</p>
</body>
</html>