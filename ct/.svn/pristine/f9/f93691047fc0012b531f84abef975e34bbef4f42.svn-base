package cn.zz.dao;

import java.util.Set;

import cn.zz.domain.Comment;
import cn.zz.domain.News;
import cn.zz.domain.User;

public interface UserDao
{

    public abstract void addUser(User u);

    //通过用户名查找用户
    /* (non-Javadoc)
     * @see cn.zz.dao.UserDao#findUserByUsename(java.lang.String)
     */
    public abstract User findUserByUsename(String username);

    //修改用户信息
    /* (non-Javadoc)
     * @see cn.zz.dao.UserDao#updataUser(cn.zz.domain.User)
     */
    public abstract void updataUser(User u);

    //发布新闻
    public abstract void addnews(News n);
    //查找用户点赞的新闻
    public abstract Set<News> findGoodNewsByUse(User u);
    
    //查找用户收藏的新闻
    public abstract Set<News> findCollectByUse(User u);
    
    //通过id查找用户
    public abstract User findUserByID(int id);
   
    //保存用户和收藏的关系
    public  abstract String saveCollect(int uid, int nid);

    //保存用户和点赞的关系
    public abstract String saveGoodNews(int uid, int nid);

}