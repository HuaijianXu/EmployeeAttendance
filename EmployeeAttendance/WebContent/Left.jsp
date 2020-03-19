
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ page language="java" import="Login.Power"%>
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-size: 12px;
	font-family: "Microsoft Yahei", Verdana, Arial, Helvetica, sans-serif
}
.leftMenu {
	min-width:220px;
    width:268px;
	margin:40px auto 0 auto;
}
.menu {
	border: #bdd7f2 1px solid;
	border-top: #0080c4 4px solid;
	border-bottom: #0080c4 4px solid;
	background: #f4f9ff repeat-y right;
	margin-left: 10px;
}
.menu .ListTitle {

	border-bottom: 1px #98c9ee solid;
	display: block;
	text-align: center;
	/*position: relative;*/
	height: 38px;
	line-height: 38px;
	cursor: pointer;
	/*+min-width:220px;*/

	+width:100%;
}
.ListTitlePanel {
	position: relative;
}
.leftbgbt {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 52px;
	left: -11px;
	top: -4px;
}
/*.leftbgbt {
	float:left;
	background: no-repeat;
	width: 11px;
	height: 52px;
	left: 0px;
	top: 0px;
	zoom:1;
	z-index:200px;
}
*/
.leftbgbt2 {
	position: absolute;
	background: no-repeat;
	width: 11px;
	height: 48px;
	left: -11px;
	top: -1px;
}
.menuList {
	display: block;
	height: auto;
}
.menuList div {
	height: 28px;
	line-height: 24px;
	border-bottom: 1px #98c9ee dotted;
}
.menuList div a {
	display: block;
	background: #fff;
	line-height: 28px;
	height: 28px;
	
	color: #185697;
	text-decoration: none;
}
.menuList div a:hover {
	color: #f30;
	background: #0080c4;
	color: #fff;
}
</style>
</head>
<%
	//
	//接收servlet传过来的那个message的参数
	//alert是js语句中的弹出警示框，也就是弹出message中的参数
	int message=Power.getPower();
	
%>
<body style="margin-top:-30px">
<input type="hidden" name="message"value=<%=message %>>
<div class="leftMenu">
	<div class="menu">
		<div class="menuParent">
			<div class="ListTitlePanel">
				<div class="ListTitle">
					<h1><strong>管理</strong></h1>
					<div class="leftbgbt2"> </div>
				</div>
			</div>
			<div class="menuList" style="text-align:center">
			<%
				if(message==0)
				{
			%>
				<div> <a href="guanli/tianjiabumen.jsp" target="right">新添加部门基本信息</a></div>
				<div> <a href="guanli/xiugaibumen.jsp" target="right">修改部门基本信息</a></div>
				<div> <a href="DeleteServlet?method=bumen" target="right">删除部门基本信息</a></div>
				<div> <a href="guanli/tianjiayuangong.jsp" target="right">新添加员工基本信息</a></div>
				<div> <a href="guanli/xiugaiyuangong.jsp" target="right">修改员工基本信息</a></div>
				<div> <a href="DeleteServlet?method=yuangong" target="right">删除员工基本信息</a></div>
				<div> <a href="guanli/shezhijuese.jsp" target="right">角色管理</a></div>
				<div> <a href="guanli/chongzhimima.jsp" target="right">密码重置</a></div>
			<%
				}
			%>
			<%
				if(message==1)
				{
			%>
				<div> <a href="QianDaoServlet?method=liulanbumen" target="right">查询部门考勤记录</a></div>
				<div> <a href="DiaodongServlet?method=submit" target="right">员工调动</a></div>
				<div> <a href="yuangong/xiugaimima.jsp" target="right">个人密码修改</a></div>
				
			<%
				}
			%>
			<%
				if(message==2)
				{
			%>
				<div> <a href="QianDaoServlet?method=submit" target="right">打卡</a></div>
				<div> <a href="QianDaoServlet?method=liulangeren" target="right">浏览个人考勤记录</a></div>
				<div> <a href="yuangong/xiugaimima.jsp" target="right">个人密码修改</a></div>
			<%
				}
			%>
			</div>
		</div>
</div>

</body>
</html>