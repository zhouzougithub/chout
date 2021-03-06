<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<head>

</head>
<body>

	<!--中心内容　　栅格系统-->
	<div class="container my-container">

		<div class="row">
			<!--左侧列表内容-->
			<div class="col-md-8">

				<!-- 分类栏 -->
				<ul class="nav nav-tabs">
					
					<li role="presentation" class='<s:if test="type==0">active</s:if>'><a href="<%=this.getServletContext().getContextPath()%>/news/myNews?type=0">私藏</a></li>
					<li role="presentation" class='<s:if test="type==1">active</s:if>'><a href="<%=this.getServletContext().getContextPath()%>/news/myNews?type=1">发布</a></li>
					<li role="presentation" class='<s:if test="type==2">active</s:if>'><a href="<%=this.getServletContext().getContextPath()%>/news/myNews?type=2">推荐</a></li>
					<li role="presentation" class='<s:if test="type==3">active</s:if>'><a href="<%=this.getServletContext().getContextPath()%>/news/myNews?type=3">评论</a></li>
				</ul>
				<!-- 显示条数 -->
				<div class="showLenth" style="height: 20px;padding-top: 5px" >
					<span class="pull-right">共<s:property value="newsNum"/>条</span>
				</div>
				<!-- 这里显示收藏的内容 -->
				<s:iterator value="#newsList" var="news">
					<!--内容1-->
					<div class="list-group my-list-content my-news"
						title="<s:property value="#news.news.id"/>">
						<div class="list-group-item clearfix">
							<div class="pull-left clearfix">
								<a href="http://<s:property value="#news.news.url"/>"> <s:if
										test="<s:property value='#news.news.title'/>!=''">

									</s:if>
									<h5>
										<s:property value="#news.news.title" />
										&nbsp;&nbsp;<small><s:property value="#news.news.url" /><span>&nbsp;42区</span></small>
									</h5>
									<p>
										<s:property value="#news.news.text" />
									</p>
								</a>
								<p class="clearfix my-p-left pull-left" style="width: 70%">

									<span class="span1 span_click1" title="推荐"><span
										class="span_count1"><s:property
												value="#news.goodNewsNum" /></span></span> <span
										class="span2 span_click2" title="评论"><span
										class="span_count2"><s:property
												value="#news.commentNum" /></span></span> <span class="span3 span_click3"
										title="加入私藏"><span>私藏</span></span> <span class="span4"
										style="background: url(<%=this.getServletContext().getContextPath()%><s:property value="#news.news.use.headimgurl"/>) no-repeat left center/19px;"></span>
									<span class="span6"><s:property
											value="#news.news.use.patname" /></span> <span class="span5"
										style="white-space:nowrap;width: 65px"><s:property
											value="#news.time" /></span> <small class="span7">入热榜</small> <input
										type="hidden" class="newsIsCollect"
										value="<s:property  value="#news.isCollect"/>"> <input
										type="hidden" class="newsIsGoodNews"
										value="<s:property  value="#news.isGoodNews"/>"> <input
										type="hidden" value="<s:property  value="#news.news.id"/>">

								</p>
								<p class="clearfix my-p-right pull-right">
									<span class="span1_1">分享到</span> <span class="span2_1"></span>
									<span class="span3_1"></span> <span class="span4_1"></span> <span
										class="span5_1"></span>

								</p>
							</div>

							<!--文章图片-->
							<div class="pull-right my-pull-right">
								<s:if test="#news.news.pic!=null">
									<img
										src="<%=this.getServletContext().getContextPath()%><s:property value="#news.news.pic"/>"
										alt="小图">
								</s:if>
							</div>
						</div>

						<!--评论区域-->
						<div class="panel panel-default my-comment">
							<div class="panel-heading">
								最热评论(<span class="com-count"><s:property
										value="#news.commentNum" /></span>)<span class="close">X</span>
							</div>
							<div class="panel-body">
								<ul class="list-group">
									<li class="list-group-item"><small> <span
											class="com-span1"></span> <span class="com-span2">网名1</span>
											<span class="com-span3">赞同这个</span> <span class="com-span4">1分钟前&nbsp;发布</span>
									</small></li>

									<li class="list-group-item"><small> <span
											class="com-span1" style="style='background: url('');'"></span>
											<span class="com-span2">js:name</span> <span
											class="com-span3">js:text</span> <span class="com-span4">js:发布时间,前&nbsp;发布</span>
									</small></li>

								</ul>
								<div class="form-inline">
									<textarea class="form-control" rows="2"></textarea>
									<button type="button" class="btn btn-info">评论</button>
								</div>

							</div>
						</div>

					</div>

				</s:iterator>
				<!-- 分页 -->
				<nav aria-label="Page navigation" style="text-align: center;">
					<ul class="pagination">
						<li><a
							href="<%= this.getServletContext().getContextPath() %>/news/myNews?numPage=${numPage-1}&type=${type}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>



						<!-- 如果等于当前页,,那么就设置选中状态 -->
						<li class="<s:if test="1==numPage">active</s:if>"><a
							href="<%=this.getServletContext().getContextPath()%>/news/myNews?numPage=1&type=${type}">
								1 </a></li>

						<!-- 当前页大于五那么就显示... -->
						<s:if test="numPage>=5">
							<li class="disabled"><span>...</span>
							<li>
						</s:if>

						<s:iterator value="#fyList" var="o">
							<!-- 如果等于当前页,,那么就设置选中状态 -->
							<li class="<s:if test="#o==numPage">active</s:if>"><a
								href="<%=this.getServletContext().getContextPath()%>/news/myNews?numPage=<s:property value="#o"/>&type=${type}">
									<s:property value="#o" />
							</a></li>
						</s:iterator>
						<li><a
							href="<%= this.getServletContext().getContextPath() %>/news/myNews?numPage=${numPage+1}&type=${type}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>

			</div>

		

<s:debug></s:debug>
</body>
</html>
