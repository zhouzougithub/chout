package cn.zz.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import cn.zz.dao.UserDao;
import cn.zz.domain.Comment;
import cn.zz.domain.News;
import cn.zz.domain.User;
@Transactional
public class UserService
{
    private UserDao userDao;
    //注册
    public boolean register(User u)
    {
        User reUse = userDao.findUserByUsename(u.getUsename());
        
        if(reUse==null)
        {
            userDao.addUser(u);
            return true;
        }
        else {
            return false;
        }
        
    }
    //登录
    public User login(User u)
    {
        User user = userDao.findUserByUsename(u.getUsename());
        
        if(user!=null && user.getPassword().equals(u.getPassword()))
        {
            return user;
        }
        
        return null;
    }
    //1.3发布
    public void sendNews(News n)
    {
        userDao.addnews(n);
        
    }
    
    //1.4*修改信息

    //    2.1评论========================
    public void comment(int newsId,int userId,Comment comment)
    {
        if(comment.getText()!="")
        {
            userDao.comment(newsId, userId, comment);
        }
    }
    
    //    2.2点赞
    public String goodNews(int uid,int nid)
    {
        
        return userDao.saveGoodNews(uid, nid);
       
    }
    
    
    //    2.3收藏
    public String collect(int uid,int nid)
    {
        return userDao.saveCollect(uid, nid);
        
    }
    
    //   获取用户操作过的新闻数据列表,私藏,发布,推荐,评论
    public List<News> FindMyNewsByType(User u,int type,int numPage)
    {
       Set<News> newSet = null;
        switch (type)
        {
        case 0:
            newSet=userDao.findCollectByUse(u);
            
            break;
       case 1:
                newSet=userDao.findSendNews(u);
            break;
       case 2:
               newSet=userDao.findGoodNewsByUse(u);
           break;
       case 3:
               newSet=userDao.findCommentNews(u);
           break;
      
        }
        
        
        List<News> newsList=new ArrayList<News>();
        newsList.addAll(newSet);
        //抽取当前显示的部分新闻,,做一个假的分页效果
        //默认一页七条新闻
        
        //根据id排序
        newsList.sort(new Comparator<News>()
        { @Override
            public int compare(News o1, News o2)
            {
                int diff=o1.getId()-o2.getId();
                if(diff>0)
                {
                   return -1;
                }
                else if(diff<0)
                {
                    return 1;
                }
                
                return 0;
            }
         });
      
        //操作新闻集合,让数据进行加载
       
        for (News news : newsList)
        {
            //System.err.println(news);
            news.getGoodUser().size();
            news.getCollect().size();
            news.getCommentSet().size();
        }
        
        
        return newsList;    
    }
    //修改用户账户信息
    public void changeUse(User u)
    {//如果修改密码的话,,那么其他信息不改动
        if(u.getPassword()!=null && !u.getPassword().equals(""))
        {//修改用户密码
            userDao.updataUserPassword(u);
        }
        else
        {//没有修改密码,,那么就是修改账户的其他信息,包括 昵称,性别,头像,签名;
            userDao.updataUserData(u);
        }
        
        
        
        
    }
    
    
    //设置注入
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
    public User findUseByID(int id)
    {
        
        return userDao.findUserByID(id);
        
        
    }
   
}
