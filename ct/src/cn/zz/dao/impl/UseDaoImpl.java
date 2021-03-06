package cn.zz.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.FinderException;

import org.springframework.orm.hibernate3.HibernateTemplate;





import cn.zz.dao.UserDao;
import cn.zz.domain.Comment;
import cn.zz.domain.News;
import cn.zz.domain.User;

public class UseDaoImpl implements UserDao
{
    //注入一个temp,操作数据库
    private HibernateTemplate hbTemp;
    
    //创建用户
    @Override
    public void addUser(User u)
    {
        hbTemp.save(u);
        
    }
    //通过用户名查找用户
    @Override
    public User findUserByUsename(String username)
    {
        System.err.println(username);
        String hql="FROM User u WHERE u.usename = ?";
        
        List<?> find = hbTemp.find(hql, username);
        User u=null;
        if(find.size()!=0){
            u = (User) find.get(0);
            System.err.println(u.toString());
        }
        
        

        return u;
    }
    
    //修改用户信息
    @Override
    public void updataUserData(User u)
    {//通过更新持久态对象的属性,,来修改数据库
        User user = hbTemp.get(User.class, u.getId());
        
        user.setSex(u.getSex());
        user.setPatname(u.getPatname());
        user.setExplains(u.getExplains());
        if(u.getHeadimgurl()!=null && u.getHeadimgurl().length()>0) 
        {
            user.setHeadimgurl(u.getHeadimgurl());
        }
        
    }
    
    //发布新闻
    /* (non-Javadoc)
     * @see cn.zz.dao.impl.UserDao#addnews(cn.zz.domain.User, cn.zz.domain.News)
     */
    @Override
    public void addnews(News n)
    {
       
        hbTemp.save(n);
        
    }

   
    //根据id查找用户
    public User findUserByID(int id)
    {
       return hbTemp.get(User.class,id);
        
    }
    
    //查找用户点赞的新闻
    @Override
    public Set<News> findGoodNewsByUse(User u)
    {
        // TODO Auto-generated method stub
        User user = hbTemp.get(User.class,u.getId());
        Set<News> goodNews = user.getGoodNews();
       return goodNews;
    }
    //查找用户收藏的新闻
    @Override
    public Set<News> findCollectByUse(User u)
    {
        User user = hbTemp.get(User.class,u.getId());
        Set<News> collectNews = user.getCollect();
        return collectNews;
    }
    //查找用户评论的新闻
    public Set<News> findCommentNews(User u)
    {
        User user = hbTemp.get(User.class,u.getId());
        Set<Comment> commentSet = user.getCommentSet();
        Set<News> newsSet=new HashSet<News>();
        for (Comment comment : commentSet)
        {//将查询出来的不重复元素添加到新闻集合中
            News news = comment.getNews();
            if(!newsSet.contains(news))
            {
                newsSet.add(news);
            }
        }
       
        return newsSet;
    }
    //查找用户发布的新闻
    public Set<News> findSendNews(User u)
    {
        User user = hbTemp.get(User.class,u.getId());
        Set<News> collectNews = user.getNewsSet();
        return collectNews;
        
    }
    //保存用户的收藏信息
    @Override
    public String saveCollect(int uid, int nid)
    {
        User u = hbTemp.get(User.class, uid);
        News n = hbTemp.get(News.class, nid);
        //System.err.println("查询成功");
     
        
        //维护关系,,不需要update
        
        
        if(u.getCollect().contains(n))
        {
            u.getCollect().remove(n);
            return "remove";
        }
        else
        {
            u.getCollect().add(n);
            return "add";
        }
    
        
    }
  //保存用户的点赞信息
    @Override
    public String saveGoodNews(int uid, int nid)
    {
       
        User u = hbTemp.get(User.class, uid);
        News n = hbTemp.get(News.class, nid);
        
        //维护关系,,不需要update
        if(u.getGoodNews().contains(n))
        {
            u.getGoodNews().remove(n);
            return "remove";
        }
        else{
            u.getGoodNews().add(n);
            return "add";
        }
        
        
    }
   //保存用户的评论信息
    public void comment(int newsID,int userId,Comment comment)
    {
        News news = hbTemp.get(News.class, newsID);
        User user = hbTemp.get(User.class, userId);
        comment.setNews(news);
        comment.setUser(user);
        hbTemp.save(comment);
        

    }
    
    //修改用户密码
    @Override
    public void updataUserPassword(User u)
    {
        User user = hbTemp.get(User.class, u.getId());
        user.setPassword(u.getPassword());

    }
    //注入方法
    public void setHbTemp(HibernateTemplate hbTemp)
    {
        this.hbTemp = hbTemp;
    }
 

  


}
