package cn.zz.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import cn.zz.domain.News;
import cn.zz.domain.User;
import cn.zz.service.NewsService;
import cn.zz.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserHandleNews extends ActionSupport
{
    //用户对新闻的一些操作
    //获取传值来的新闻id
    private int newsID;
    
    private UserService userService;
    
    
    //点赞
   
    public void goodNews()
    {    //ajax不要页面,,只需要数据,,所以需要从response中write一串数据
        System.err.println("点赞");
        
        User u=getSessionUse();
        
        //add & remove
        String isok = userService.goodNews(u.getId(), newsID);
        System.out.println("ok:"+isok);
        
        try
        {
            PrintWriter writer = ServletActionContext.getResponse().getWriter();
            //这里返回给ajax一串信息
            writer.print(isok);
        } catch (IOException e)
        {
            System.err.println("发生错误:"+isok);
        }

       
    }
    //评论
    
    public String comment()
    {
        return null;

    }
    
    //收藏
    public void collect()
    {
        User u=getSessionUse();
        
        //add & remove
        String isok = userService.collect(u.getId(), newsID);
        
        try
        {
            PrintWriter writer = ServletActionContext.getResponse().getWriter();
            //这里返回给ajax一串信息
            writer.print(isok);
        } catch (IOException e)
        {
            System.err.println("发生错误:"+isok);
        }
    }
    
    
    
    //通用的从session获取用户方法
    private User getSessionUse()
    {
        return (User) ActionContext.getContext().getSession().get("use");
        
    }
    public int getNewsID()
    {
        return newsID;
    }
    public void setNewsID(int newsID)
    {
        this.newsID = newsID;
    }
  
    public UserService getUserService()
    {
        return userService;
    }
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
    

}
