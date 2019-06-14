package cn.zz.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.zz.domain.Comment;
import cn.zz.service.NewsService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ShowCommentByJson extends ActionSupport
{
    private NewsService newsService;
    
    //传入的值
    private int newsid;
    //返回的值
    //private Set<Comment> commentSet;
    private List<Comment> commentList;
  //获取当前新闻的评论并且排序
    public String getcommentAll()
    {
        //获取当前新闻的评论并且排序
        // Hibernate中如果出现了级联查询，就可能出现懒加载问题，因为评论中有对新闻和用户的引用
        //System.err.println("action中newsid的值是"+newsid);
        Set<Comment> commentSet = newsService.findCommentByNewsId(newsid);
        commentList=new ArrayList<Comment>();
        commentList.addAll(commentSet);
       //System.err.println(commentList);
        return Action.SUCCESS;
    }

    public void setNewsid(int newsid)
    {
        this.newsid = newsid;
    }



    public void setNewsService(NewsService newsService)
    {
        this.newsService = newsService;
    }
    public List<Comment> getCommentList()
    {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList)
    {
        this.commentList = commentList;
    }
    
}
