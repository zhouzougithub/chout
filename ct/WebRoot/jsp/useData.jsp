<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<!--设置屏幕宽度为设备宽度-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!--告诉IE浏览器以最高级模式渲染当前网页-->
<meta http-equiv="x-ua-compatible" content="IE=edge">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>抽屉新热榜</title>
<link rel="icon" href="<%= this.getServletContext().getContextPath() %>/images/chouti.ico">

<!-- 链接 Bootstrap 必须引入bootstrap -->
<!--<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">-->
<link rel="stylesheet" type="text/css"
	href="<%= this.getServletContext().getContextPath() %>/bootstrap-3.3.7/css/bootstrap.css">
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--兼容IE9以下的版本-->
<!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!--外链接css-->
<link type="text/css" rel="stylesheet" href="<%= this.getServletContext().getContextPath() %>/css/index.css">


</head>
<body>
	<script type="text/javascript" src="<%= this.getServletContext().getContextPath() %>/jQuery/jquery-3.3.1.js"></script>
	<!--外链接js-->
	<script type="text/javascript" src="<%= this.getServletContext().getContextPath() %>/js/index.js">
		
	</script>
	<!-- 获取项目路径 -->
	<input type="hidden" id="path" value="<%= this.getServletContext().getContextPath() %>">
	
	
		<!-- 1 固定导航栏 自定义my-navbar-->
		<%@ include file="/jsp/head_login.jsp"%>
		<!--模态框　登陆注册发布功能-->
		<%@ include file="/jsp/pop.jsp"%>


		<!--中心内容　　栅格系统   	左側新聞-->
		<%@ include file="/jsp/Mydate.jsp"%>
		
		

		<!--底部内容-->
		<%@ include file="/jsp/food.jsp"%>

	<!--回到顶部图标-->
	<div class="move-top" title="回到顶部">
		<img src="<%= this.getServletContext().getContextPath() %>/images/move-top.png">
	</div>
	<s:debug></s:debug>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>

	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
