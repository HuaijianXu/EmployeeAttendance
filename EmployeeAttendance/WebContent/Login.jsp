<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script type="text/javascript">
	function check(form) {			
		//非空
		with(form){
			/*if(code.value!='rightcode'){
				alert('请输入正确的验证码');
				return false;
			}
			else*/ 
			if(username.value == "") {
				alert("姓名为空");
				return false;
			}
			else if(password.value == '') {
				alert('密码为空');					
				return false;
			}
			else 
				return true;
		}
	}
</script>
<style>
.a {
	border: 2px solid #a1a1a1;
	padding: 10px 40px;
	/* 	background:#dddddd; */
	width: px;
	border-radius: 25px;
}
#bk {
	border: 3px solid #a1a1a1;
	padding: 10px 60px;
	/* 	background:#dddddd; */
	width: px;
	border-radius: 25px;
}
 .button {
    background-color:  #ff8433;
    border: none;
    color: white;
    padding: 5px 10px;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 2px 2px;
    cursor: pointer;
}
table{
margin: auto;
}
</style>
</head>
<body>
	<%
	     Object message = request.getAttribute("message");
	     if(message!=null && !"".equals(message)){
	 
	%>
	     <script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	     </script>
	<%} %>
	<div align="center">
		<h1 style="color: red;">登录</h1>
		<form action="${pageContext.request.contextPath}/LoginServlet?method=login" method="post" onsubmit="return check(this)">
		<table>
			<tr>
				<td>用户名</td>
				<td><input id="bk" type="text" name="username" ></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input id="bk" type="password" name="password"></td> 
			</tr>		
				<td><input class ="button" type="submit" value="登录">
				<input class ="button" type="reset" value="重置"></td>
		</table>
		</form>
	</div>
</body>
</html>