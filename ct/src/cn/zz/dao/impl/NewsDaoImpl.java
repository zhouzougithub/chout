package cn.zz.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.zz.dao.NewsDao;
import cn.zz.domain.Comment;
import cn.zz.domain.News;
import cn.zz.domain.User;

public class NewsDaoImpl implements NewsDao
{
    private HibernateTemplate hbTemp;

    // 添加一条评价到新闻
    /* (non-Javadoc)
     * @see cn.zz.dao.impl.NewsDao#addComment(cn.zz.domain.Comment)
     */
    @Override
    public void addComment(Comment c)
    {
        hbTemp.save(c);
    }

    // 查找新闻
    /* (non-Javadoc)
     * @see cn.zz.dao.impl.NewsDao#pagingNews(int, int)
     */
    //分页查询
    @Override
    public List<News> pagingNews(int offset,int length)
   {
       List<News> Newslist = getListForPage("from News", offset, length);
       
       return Newslist;
   }
    //查询共有多少条新闻
    public int findNewsSum()
    {
        String hql = "select count(*) from News";
        return ((Integer)hbTemp.iterate(hql).next()).intValue();
    }
  
    //第几个开始查,查几个
    private List<News> getListForPage(final String hql, final int offset,

    final int length)
    {

        List list = hbTemp.executeFind(

        new HibernateCallback()
        {
            public Object doInHibernate(Session session)

            throws HibernateException, SQLException
            {

                Query query = session.createQuery(hql);

                query.setFirstResult(offset);

                query.setMaxResults(length);

                List list = query.list();
                
                
                //System.err.println(news.getUse().toString());
                return list;
                
            }

        });

        return list;

    }
    //根据id查找新闻的评论
    @Override
    public Set<Comment> findCommentByNewsId(int id)
    {
        //System.err.println("当前查找的id是"+id);
        News news = hbTemp.get(News.class, id);
       
       if(news!=null)
       {
        Set<Comment> commentSet = news.getCommentSet();
       
        return commentSet;
       }
       return null;
    }
//    //收藏
//    public void collect(User u,News n)
//    {
//        u.getCollect().add(n);
//        
//        hbTemp.save(u);
//    }
//    //点赞
//    public void goodNews(User u,News n)
//    {
//        u.getGoodNews().add(n);
//        
//        hbTemp.save(u);
//    }
    //根据id获取新闻
    public News findNewsById(int id)
    {
        
        return hbTemp.get(News.class, id);
        
    }
   
    
    
    
    // 注入方法
    public void setHbTemp(HibernateTemplate hbTemp)
    {
        this.hbTemp = hbTemp;
    }



}
