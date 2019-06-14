package cn.zz.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.zz.domain.News;
import cn.zz.domain.NewsStrong;
import cn.zz.domain.User;
import cn.zz.service.UserService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
//主要用于获取用户操作过的新闻数据,,需要合并到showNewsAction中
public class UserAction extends ActionSupport
{
    private UserService userService;
    private String numPage="1";
    private int type=0;
    
    
    public String showNewsByType()
    { 
        //先获取用户
        User use = (User) ActionContext.getContext().getSession().get("use");
        if(use==null)
        {//用户未登录,跳回首页
            return Action.LOGIN;
        }
        //用户已经登录,,根据type,numPage,use来获取当前的新闻列表
        List<News> newsLists = userService.FindMyNewsByType(use, type, Integer.parseInt(numPage));
        //计算页码是否正确
        
        int newsNum = newsLists.size();//总新闻条数
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
        
        //分页查询
        List<News> List;
        if(num*7>newsNum)
        {
            List =newsLists.subList((num-1)*7, newsNum);
        }
        else {
           List = newsLists.subList((num-1)*7, num*7);
        }
        
        
        
        List<NewsStrong> newsList=new ArrayList<NewsStrong>();
        for (News news : List)
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
        

        
        Map<String, Object> contextMap = ActionContext.getContext().getContextMap();
        //放入加强的新闻列表和计算好的分页
        contextMap.put("newsList", newsList);
        contextMap.put("fyList", fyList);
        ActionContext.getContext().getValueStack().set("newsNum", newsNum);
     
        return Action.SUCCESS;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public UserService getUserService()
    {
        return userService;
    }

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    public String getNumPage()
    {
        return numPage;
    }

    public void setNumPage(String numPage)
    {
        this.numPage = numPage;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }
    
    
}
