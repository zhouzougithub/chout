package cn.zz.service;

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
    public void register(User u)
    {
        userDao.addUser(u);
        
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
    public void comment()
    {
        
        
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
    
    
    

    
    
    //设置注入
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
}
