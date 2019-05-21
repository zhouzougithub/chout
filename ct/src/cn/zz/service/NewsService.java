package cn.zz.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.transaction.annotation.Transactional;

import cn.zz.dao.NewsDao;
import cn.zz.dao.UserDao;
import cn.zz.domain.Comment;
import cn.zz.domain.News;
import cn.zz.domain.User;
@Transactional
public class NewsService
{
    private NewsDao newsDao;
    

    //分页查找新闻
    public List<News> findNews(int offset)
    {
        System.err.println(offset+"     "+(offset-1)*9+1);
        List<News> newsList = newsDao.pagingNews((offset-1)*9, 9);
        //查询点赞的人数,,service负责事务,,所以需要先进行查询,防止懒加载;
        for (News news : newsList)
        {
            //在service中获取到新闻点赞的数量,如果没有在事务中读取,那么在action中session将关闭
            news.getGoodUser().size();
            news.getCollect().size();
            news.getCommentSet().size();
        }
        
        
        
        return newsList;
    }
    
    //查找共有多少条新闻
    public int findNewNum()
    {
        return newsDao.findNewsSum();
        
    }
    //查找一个新闻的评论
    public Set<Comment> findCommentByNewsId(int id)
    {   //System.err.println("服务层id:"+id);
        Set<Comment> commentSet = newsDao.findCommentByNewsId(id);
        
        Set<Comment> comments=new TreeSet<Comment>(new Comparator<Comment>()
        {
            @Override
            public int compare(Comment o1, Comment o2)
            {
                // TODO Auto-generated method stub
                return o1.getId()-o2.getId();
            }
        });
         comments.addAll(commentSet);
        //遍历评论,,取出评论中指定的user对象
         for (Comment comment : comments)
        {
            comment.getUser();
            comment.getNews();
        }
        
        return comments;
    }
    
    
    
    
    
   

    public void setNewsDao(NewsDao newsDao)
    {
        this.newsDao = newsDao;
    }



  

 
 
}
