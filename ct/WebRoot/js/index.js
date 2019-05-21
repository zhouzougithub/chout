//鼠标点击 ul li 下的 active 样式切换
//入口函数
$(function () {
	 var basePath =$('#path').val();
	 //默认不收藏,不点赞

	 
	 
	//加载后就判断点赞和收藏按钮是否被点亮
	 $(".my-list-content").each(function() {
	 	var isCollect=$(this).find("p .newsIsCollect").val();
	 	var isGoodNews=$(this).find("p .newsIsGoodNews").val();
	 	
	 	//alert("收藏状态"+isCollect+"    点赞状态:"+isGoodNews)
	 	if(isGoodNews=='true')
	 		{
	 		//alert("被点赞");
	 		 	var butGoodNews=$(this).find("p .span_click1");
	            butGoodNews.css({'background':'url(../images/icon_18_118.png) no-repeat 8px -20px','color':'#58cb05'});
	            butGoodNews.attr('title','取消推荐');
	          
	            //$(this).find("p .newsIsGoodNews").val("false");
	            
	            //isFlag1 = false;
	 		}
	 	if(isCollect=='true')
	 		{
	 		//alert("被收藏");
 		 	var butGoodNews=$(this).find("p .span_click3");
          
            
            
 		 	butGoodNews.css({'background':'url(../images/icon_18_118.png) no-repeat 8px -139px','color':'orange'});
 		 	butGoodNews.attr('title','移除私藏');
            //isFlag3 = false;
 		 	//全部的值都改了
 		 	//$(this).find("p .newsIsCollect").val("false");
            //alert($(this).find("p .newsIsCollect").prop("outerHTML"));
	 		
	 		}
	 	
	 	
	 })
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	//分页------ 鼠标点击 ul li 下的 active 样式切换
	$(".pagination li").click(function(){
		$(this).addClass('active').siblings('li').removeClass('active');
	})
	
	
	
	//上传按钮被点击
	$(".a-upload").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
	        $(".fileerrorTip").html("").hide();
	        var arr=filePath.split('\\');
	        var fileName=arr[arr.length-1];
	        $(".showFileName").html(fileName);
	    }else{
	        $(".showFileName").html("");
	        $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
	        return false 
	    }
	})
	
  //导航栏------ 鼠标点击 ul li 下的 active 样式切换
    $('.navbar-nav li').click(function () {
        //添加类名addclass、siblings查找所有兄弟元素---不包括自己
        $(this).addClass('active').siblings('li').removeClass('active');
    });

    //中心内容导航区
    $('.top-navbar-nav li').click(function () {
        $(this).addClass('active').siblings('li').removeClass('active');
    });
    $('.top-navbar-nav2 li').click(function () {
        $(this).addClass('active').siblings('li').removeClass('active');
    });

    // 登录注册时------模态窗中的标签样式切换
    $('.pull-left .my-modal-body ul li').click(function () {
        $(this).addClass('active').siblings('li').removeClass('active');
        $($('.my-modal-body ul').siblings('div')[$(this).index()]).show().siblings('div').hide();

    });


    //注册 选择中国/海外时，区域下拉框的变化
    $('.my-country').change(function () {
        if($('.my-country option:selected').val() === '1'){
            $('.my-info-register .form-inline').hide();
        }else{
            $('.my-info-register .form-inline').show();
        }
    });




  //监听页面滚动
    $(document).scroll(function () {
        $(document).scrollTop() > 0 ? $('.move-top').show() : $('.move-top').hide();
    });

//中心内容
     //鼠标移入到内容中，显示分享的小图标
    $('.my-list-content a').each(function (index,ele) {
        $(this).hover(function () {
            $($('.pull-left p.my-p-right')[index]).css('display','block');
        },function () {
            $($('.pull-left p.my-p-right')[index]).css('display','none');
        })
    });

    //鼠标移入到内容的图片上，将小图片变成大图片
    $('.pull-right img').each(function (index,ele) {
        $(this).click(function () {
            if($(this).hasClass('big')){
                $(this).animate({width:'64px',height:'64px'},500);
                $(this).removeClass('big');

            }else {
                $(this).animate({width:'120px',height:'120px'},500);
                $(this).addClass('big');
            }
        })
    });

    //推荐-点赞-的点击事件
    $('.span_click1').each(function (index,ele) {

    	
    	
    	//newsIsGoodNews   newsIsCollect
       // var isFlag1 = true;
        $(this).click(function () {
        	
    		//点击之后执行ajax代码
        	var newsid=$(this).parent().children().last().val();
        	alert(basePath);
    		$.ajax({
    			async : true,    //表示请求是否异步处理
    			type : "post",    //请求类型
    			url :basePath +"/do/goodNews",//请求的 URL地址
    			data:{newsID:newsid},
    			dataType : "text",//返回的数据类型
    			
    			success: function (data) 
    			{//发送成功
    				if("add"==data)
    				{//点赞成功,,点赞按钮变亮
    					//alert(data);
    					isFlag1=false;	
    				}
    				else{
    					//否则取消点赞
    					isFlag1=true;	
    				}
    				
    			},
    			error:function (data) 
    			{
    				alert("bbbb");
    				//alert(data.result);	
    			}

    		})
        	
        	
        	//改变按钮狀態
            var count1 = $($('.span_count1')[index]).text();
    		var isFlag1=$($('.newsIsGoodNews')[index]).val();
    		//alert('旧的点击状态是:'+isFlag1);
    		
            if(isFlag1=='false'){
                $($('.span_count1')[index]).text(Number(count1)+1);
                $(this).css({'background':'url(../images/icon_18_118.png) no-repeat 8px -20px','color':'#58cb05'});
                $(this).attr('title','取消推荐');
                //isFlag1 = false;
                $($('.newsIsGoodNews')[index]).val("true");
            }else{
                $($('.span_count1')[index]).text(Number(count1)-1);
                $(this).css({'background':'url(../images/icon_18_118.png) no-repeat 8px -40px','color':'#9d9d9d'});
                $(this).attr('title','推荐');
                $($('.newsIsGoodNews')[index]).val('false');
               // isFlag1 = true;
            }
        });
    });

    //评论的点击事件
    $('.span_click2').each(function (index,ele) {
        var isFlag2 = true;
        $(this).click(function () {
        	var newsid=$(this).parent().children().last().val();
        	//alert();
        	
        	
        	
        	
        	
        	
            //console.log($(this).index());
            if(isFlag2){
            	//如果需要显示,,那么就请求评论内容,,收回时候不需要请求
            	$.ajax({
            		async:true, 
            		data:{newsid:newsid}, 
            		dataType:"json" ,
            		type:"post",
            		url:basePath +"/json/findCommentAll",
            		success: function(date)
            		{
            			//处理获取成功的json对象
            			var commentList=eval(date).commentList;
            			console.log(JSON.stringify(commentList));
            			var addLi="";
            			$.each(commentList, function(index,comment){
            				//添加到新闻评论列表中,每次添加一条新闻
            				var time="";
            				 
           				 //处理时间
           				 var dateTime=new Date(comment.date);
           				 var newDate=new Date()
           				 var ms=newDate.getTime()-dateTime.getTime();
           				 if(ms/86400000>=1)
           				 {
           					 time= Math.floor(ms/86400000)+"天前";
           				 }
           				 else 
           				{
           					 if(ms/3600000>=1)
           					 {time= Math.floor(ms/3600000)+"小时前";}
           				 	else
           				 	{if(Math.floor(ms/60000)<1)
           				 		{time="刚刚"}
           				 		else
           				 		{time= Math.floor(ms/60000)+"分前"}
           				 	}
           				}
           				// console.log(time);
            				
           				 
           				 //添加的内容
            				 addLi=addLi+"<li class='list-group-item'><small>"
            					 +"<span class='com-span1' style='style='background: url('"+".."+comment.user.headimgurl+"');''></span>"
            					 +"<span class='com-span2'>"+comment.user.patname+"</span>"
            					 +"<span class='com-span3'>"+comment.text+"</span>"
            					 +"<span class='com-span4'>"+time+"&nbsp;发布</span>"
            					 +"</small></li>"; 
            			
            			
            			})
            			var ul=$($('.my-comment')[index]).find('ul');
            			ul.html(addLi);	
            		},
            		error: function(date)
            		{
            			alert(JSON.stringify(date));
            		}
            		
            	})
            	
            	
                $($('.my-comment')[index]).show();
                $(this).css({'background':'url(../images/icon_18_118.png) no-repeat 8px -79px','color':'#63c8ff'});
                isFlag2 = false;
            }else{
                $($('.my-comment')[index]).hide();
                $(this).css({'background':'url(../images/icon_18_118.png) no-repeat 8px -99px','color':'#9d9d9d'});
                isFlag2 = true;
            }
        })
    });

    //关闭评论框
    $('.my-comment .close').each(function (index,ele) {
        $(this).click(function () {
            $($('.my-comment')[index]).hide();
            $($('.span_click2')[index]).css({'background':'url(../images/icon_18_118.png) no-repeat 8px -99px','color':'#9d9d9d'});
        })
    });

    //私藏的 点击事件
    $('.span_click3').each(function (index,ele) {
        //var isFlag3 = true;
        $(this).click(function () {
        	//收藏的ajax代码
        	var newsid=$(this).parent().children().last().val();
        	//alert(newsid);
    		$.ajax({
    			async : true,    //表示请求是否异步处理
    			type : "post",    //请求类型
    			url :basePath +"/do/collect",//请求的 URL地址
    			data:{newsID:newsid},
    			dataType : "text",//返回的数据类型
    			
    			success: function (data) 
    			{//发送成功
    				if("add"==data)
    				{//收藏成功,,收藏按钮变亮
    					
    					isFlag3=true;	
    				}
    				else{
    					//否则取消收藏
    					isFlag3=false;	
    				}
    				
    			},
    			error:function (data) 
    			{
    				//alert("bbbb");
    				//alert(data.result);	
    			}

    		})
        	
        	var isFlag3=$($('.newsIsCollect')[index]).val();
        	
            if(isFlag3=="false"){
                $(this).css({'background':'url(../images/icon_18_118.png) no-repeat 8px -139px','color':'orange'});
                $(this).attr('title','移除私藏');
                //isFlag3 = false;
                $($('.newsIsCollect')[index]).val("true");
                //alert($($('.newsIsCollect')[index]).prop("outerHTML"));
            }else{
                $(this).css({'background':'url(../images/icon_18_118.png) no-repeat 8px -159px','color':'#9d9d9d'});
                $(this).attr('title','加入私藏');
                //isFlag3 = true;
                $($('.newsIsCollect')[index]).val("false");
            }
        });
    });

    //评论内容追加到 ul li 中
    $('.my-comment button').each(function (index,ele) {
        $(this).bind('click',function () {
            var date = new Date();
            var strDate = date.getFullYear() + '-' + (Number(date.getMonth())+1)+ '-' + date.getDate()
                + '&nbsp;&nbsp;' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
            var comCount = $($('.com-count')[index]).text();
            var comment = $($('.my-comment textarea')[index]).val();

            var str = "<li class=\"list-group-item\"> <small>" +
                "<span class=\"com-span1\"></span>" +
                "<span class=\"com-span2\">victor</span> " +
                "<span class=\"com-span3\">"+comment+"</span> " +
                "<span class=\"com-span4\">"+strDate+"&nbsp;发布</span> " +
                "</small></li> ";

            $($('.my-comment ul.list-group')[index]).append(str);
            $($('.com-count')[index]).text(Number(comCount)+1);
            $($('.span_count2')[index]).text(Number(comCount)+1);
            $($('.my-comment textarea')[index]).val('');
        })
    });

   //回到顶部 点击事件
    $('.move-top img').click(function () {
          $("html,body").animate({scrollTop:0}, 500);
          return false;
    });
//======================
	$('.login-option').click(function(){
		
		$('.login-option').removeClass('active');
		$(this).addClass('active');
		
		
		if($('.login-option').first().is($(this)))//如果相同,那么就是点击了按钮1,否者就是按钮2
		{
			console.log("执行login1");
			login1();
			
		}
		else
		{
			console.log("执行login2");
			login2();
		}
	})
	
	

});

//注册登录页面
//点击的时候触发和当前模态窗口状态相反的操作
function login() {
    $('#myModal').modal({
        show:true
    });
    /* 为了弹出框 弹出时滚动条不消失 背景不影响*/
    $('body').css('padding-right','0');
    //刚开始把注册是填写资料隐藏
    $('.my-info-register').hide();
    //先把用户名登录隐藏起来
    $('.my-user-login').hide();

}

//点击注册1时候显示填手机号界面
function login1()
{
	/* 为了弹出框 弹出时滚动条不消失 背景不影响*/
	// $('body').css('padding-right','0');
	//刚开始把注册是填写资料隐藏
	$('.my-info-register').hide();
	//先把用户名登录隐藏起来
	$('.my-phone-register').show();

}




function login2()
{
// 	$('.my-phone-register').hide();
// 	$('.my-info-register').show();
// 	$('.my-btn-next').hide();
// 	$('.my-btn-submit').show();
// 	$('.pull-right .my-modal-body ul li').last().addClass('active').siblings('li').removeClass('active');
	$('.my-info-register').show();
	//先把用户名登录隐藏起来
	$('.my-phone-register').hide();
}






//注册 选择下一步时的操作
function btnNext() {
    $('.my-phone-register').hide();
    $('.my-info-register').show();
    $('.my-btn-next').hide();
    $('.my-btn-submit').show();
    $('.pull-right .my-modal-body ul li').last().addClass('active').siblings('li').removeClass('active');
}

//发布
function publish() {
	//判断有没有登录,,通过判断有没有用户区
	$('#bs-example-navbar-collapse-1 .userlist')
	
	
    $('.modal-publish').modal({
       show:true
    });
    /* 为了弹出框 弹出时滚动条不消失 背景不影响*/
    $('body').css('padding-right','0');
    $('.my-modal-body2 ul li').click(function () {
           $(this).addClass('active').siblings('li').removeClass('active');
            $($('.my-modal-body2 ul').siblings('div')[$(this).index()]).show().siblings('div').hide();
       });
    $('.publish2').hide()
    $('.publish3').hide()

}
