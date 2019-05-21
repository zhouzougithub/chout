<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <div class="footer-band">
		<div class=" foot-nav">
			<a href="#">关于我们</a><span>|</span> <a href="#">联系我们</a><span>|</span>
			<a href="#">服务条款</a><span>|</span> <a href="#">隐私政策</a><span>|</span>
			<a href="#">抽屉新热榜工具</a><span>|</span> <a href="#">下载客户端</a><span>|</span>
			<a href="#">意见与反馈</a><span>|</span> <a href="#">友情链接</a><span>|</span>
			<a href="#">公告</a> <a href="#"><img
				src="<%= this.getServletContext().getContextPath() %>/images/foot-photo1.png"></a>
		</div>
		<div class=" foot-nav2">
			<a href="#"><img src="<%= this.getServletContext().getContextPath() %>/images/foot-photo2.png"></a> <span
				class="foot_d">旗下站点</span> <span class="foot_a">©2018chouti.com</span>
			<span class="foot_d">京ICP备09053974号-3 京公网安备 110102004562</span>
			<div class="foot-nav3">
				<span>违法和不良信息举报： 电话：010-58302039 </span> <a href="#">邮箱：jubao@chouti.com</a>
			</div>
			<div class="foot-nav4">
				<span>版权所有：北京格致璞科技有限公司</span>
			</div>
		</div>
	<s:debug></s:debug>
	</div>
  </body>
</html>
