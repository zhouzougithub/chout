package cn.zz.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    
    public String showNewsList()
    {
      
        
        
        //分页查询
        List<News> List = newsService.findNews(Integer.parseInt(numPage));
        if(List.size()==0)
        {
            //查询数据为0;需要处理
        }
        //获取当前登录状态
        User use = (User) ActionContext.getContext().getSession().get("use");
        
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
        
        
//        for (NewsStrong newsStrong : newsList)
//        {
//            System.err.println("是否点赞"+newsStrong.getIsGoodNews()+"是否收藏"+newsStrong.getIsCollect());
//            
//        }
        
        
       //设置当前页码是多少
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        valueStack.set("numPage", numPage);
        
        
        
        
        //设置底部的分页栏显示内容
        List<Integer> fyList=new ArrayList<Integer>();
        //计算当前应该显示的页码
        int num = Integer.parseInt(numPage);
        for(int i=0;i<4;i++)
        {       //如果页码小于五,直接显示
            if(Integer.parseInt(numPage)<5){
                fyList.add(i+2);//从第二页开始
            }
            else
            {//如果是大于五的页码,保持当前选中的页码在中间
                
                fyList.add(num-2+i);
            }
            
        }
        
        
        
        
        Map<String, Object> contextMap = ActionContext.getContext().getContextMap();
        //放入加强的新闻列表和计算好的分页
        contextMap.put("newsList", newsList);
        contextMap.put("fyList", fyList);
//        News nn = newsList.get(1).getNews();
//      
//        System.err.println(nn.getUse());
        
        
        //判断有没有登录
        //Object use = ActionContext.getContext().getSession().get("use");
        if(use!=null)
        {
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






    
    

    
    
    
}
