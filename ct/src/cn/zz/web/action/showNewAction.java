package cn.zz.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.components.Select;

import cn.zz.domain.News;
import cn.zz.domain.NewsStrong;
import cn.zz.domain.User;
import cn.zz.service.NewsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class showNewAction extends ActionSupport
{

    private NewsService newsService;
    private String numPage="1";
    private String type="";
    private String day="";
    
    public String showNewsList()
    {
        //需要获取一个type,实现分类查询
        //获取一个time,,可以根据发布时间分类查询
        //把条件放到map中..
        
        
        //================实现页码数据=======================

        
        
        //计算页码是否正确
        int newsNum = newsService.findNewNum();//总新闻条数
        int sumPage=newsNum/7;//一共有几页新闻
        if(newsNum%7>0){sumPage+=1;}
        System.err.println("一共的页数"+sumPage);
        
        int num = Integer.parseInt(numPage);//当前页数
        if(num>=sumPage)
        {
            numPage=sumPage+"";
        }
        if(num<1)
        {
            numPage="1";
        }
        num = Integer.parseInt(numPage);
        
        
      //设置当前页码是多少
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.set("numPage", numPage);

        //设置底部的分页栏显示内容
        List<Integer> fyList=new ArrayList<Integer>();
        //计算当前应该显示的页码
            
        if(sumPage<=5)
        {
            for (int i = 1; i < sumPage; i++)
            {
                fyList.add(i+1);
            }
        }
        else
        {//总页数大于5
            for (int i = 1; i <= 4; i++)
            {
                if(num<5)
                {
                    fyList.add(i+1);//从第二页开始
                }
                else
                {
                    if(num-2+i<=sumPage)
                    {
                        
                        fyList.add(num-2+i);
                    }
                }
            }
        }
        
        //=======================实现分页===============================
        //添加条件
        Map<String, String> condition=new HashMap<String, String>();
        if(!type.equals(""))
        {
            condition.put("type", type);
        }
        if(!type.equals(""))
        {
            condition.put("day", day);
        }
        
        List<News> list=null;
        if(condition.isEmpty())
        {
          //不带条件的分页查询
             list = newsService.findNews(num);
        }
        else
        {//带条件的分页查询
            list = newsService.findNews(num, condition);
        }
        
        
        //获取当前登录状态
        User use = (User) ActionContext.getContext().getSession().get("use");
        
        List<NewsStrong> newsList=new ArrayList<NewsStrong>();
        for (News news : list)
        {
            
            NewsStrong ns=new NewsStrong(news);
            //放入点赞数,评论数
            ns.setGoodNewsNum(news.getGoodUser().size());
            ns.setCommentNum(news.getCommentSet().size());
            //放入当前用户是否点赞,收藏状态
            if(use!=null){
                ns.setIsGoodNews(news.getGoodUser().contains(use)+"");
                
                ns.setIsCollect(news.getCollect().contains(use)+"");
             }
            
            newsList.add(ns);
            ns.getNews().getUse();
        }

       

        //======================放到值栈中============================
        Map<String, Object> contextMap = ActionContext.getContext().getContextMap();
        //放入加强的新闻列表和计算好的分页
        contextMap.put("newsList", newsList);
        contextMap.put("fyList", fyList);

        
        //判断有没有登录
        if(use!=null)
        {
            System.err.println("现在跳转到了登录成功页面");
            return "login";
        }else
        {
            return "index";
        }
        
        
    }

    

    public void setNewsService(NewsService newsService)
    {
        this.newsService = newsService;
    }


    public String getNumPage()
    {
        
        return numPage;
    }


    public void setNumPage(String numPage)
    {
        
        this.numPage = numPage;
    }



    public String getType()
    {
        return type;
    }



    public void setType(String type)
    {
        this.type = type;
    }



    public String getDay()
    {
        return day;
    }



    public void setDay(String day)
    {
        this.day = day;
    }



  


 
    
}
