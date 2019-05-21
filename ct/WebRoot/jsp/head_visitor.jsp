<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  
  <!-- 1 固定导航栏 自定义my-navbar-->
        <nav class="navbar navbar-default navbar-fixed-top my-navbar">
          <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#"><img src="<%= this.getServletContext().getContextPath() %>/images/logo2.png" alt="logo"></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">全部<span class="sr-only">(current)</span></a></li>
                <li><a href="#">42区</a></li>
                <li><a href="#">段子</a></li>
                <li><a href="#">图片</a></li>
                <li><a href="#">挨踢1024</a></li>
                <li><a href="#">你问我答</a></li>
              </ul>
                <!--搜索框-->
              <form class="navbar-form navbar-right">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">
                      <span class="glyphicon glyphicon-zoom-in"></span>
                </button>
              </form>
                <!--注册栏-->
              <ul class="nav navbar-nav navbar-right ">
                <li><a href="javascript:login()" >注册</a></li>
                <li><a href="javascript:login()">登录</a></li>
              </ul>
            </div><!-- /.navbar-collapse -->
          </div><!-- /.container-fluid -->
        </nav>
  	
  </body>
</html>
