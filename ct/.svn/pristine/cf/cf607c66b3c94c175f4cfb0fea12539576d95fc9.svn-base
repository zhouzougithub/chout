package cn.zz.domain;

import java.util.Date;

//补充新闻类的时间
public class NewsStrong extends News
{
    private News news;
    private String time="";
    private int commentNum;//记录评论的条数
    private int goodNewsNum;//记录点赞的条数
    private String isGoodNews;//当前新闻是否已经被当前用户点赞了
    private String isCollect;//当前新闻是否被当前用户收藏了
    
    public NewsStrong(News news)
    {
        if(news.getDate()!=null)
        {
            Date d = news.getDate();
            d.getTime();
            Date d2 = new Date();
            long t=d2.getTime()-d.getTime();
            
            long dd=t/86400000;
            long tt=(t-dd*86400000)/3600000;
            long mm=(t-tt*3600000-dd*86400000)/60000;
                if(dd>0)
                {
                    
                    setTime(dd+"天"+tt+"小时前");
                   
                }
                else
                {
                    if(tt>0)
                    {
                        setTime(tt+"小时"+mm+"分钟前");  
                    }
                    else
                    {
                        setTime(mm+"分钟前");
                    }
                }
        }
        this.news=news;
    }

    public News getNews()
    {
        return news;
    }

    public void setNews(News news)
    {
        this.news = news;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

   

    public int getGoodNewsNum()
    {
        return goodNewsNum;
    }

    public void setGoodNewsNum(int goodNewsNum)
    {
        this.goodNewsNum = goodNewsNum;
    }

    

    public int getCommentNum()
    {
        return commentNum;
    }

    public void setCommentNum(int commentNum)
    {
        this.commentNum = commentNum;
    }

    public String getIsGoodNews()
    {
        return isGoodNews;
    }

    public void setIsGoodNews(String isGoodNews)
    {
        this.isGoodNews = isGoodNews;
    }

    public String getIsCollect()
    {
        return isCollect;
    }

    public void setIsCollect(String isCollect)
    {
        this.isCollect = isCollect;
    }
    
    
    
    
}
