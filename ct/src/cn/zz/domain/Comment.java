package cn.zz.domain;

import java.util.Date;

//`id` int(11) NOT NULL AUTO_INCREMENT,
//`fatherID` int(11) DEFAULT NULL,
//`userID` int(11) DEFAULT NULL,
//`newsID` int(11) DEFAULT NULL,
//`tier` int(11) DEFAULT NULL,
//`text` varchar(200) CHARACTER SET gb2312 DEFAULT NULL,
//`date` datetime DEFAULT NULL,

public class Comment
{
    private int id;
    private int fatherID;
 
    private int tier;//�㼶
    private String text;
    private Date date;
    
    //һ�����۶�Ӧһ���û���һ������
    private User user;
    private News news;
    
    
    
   
    @Override
    public String toString()
    {
        return "Comment [tier=" + tier + ", text=" + text + ", user=" + user
                + ", news=" + news + "]";
    }
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    public News getNews()
    {
        return news;
    }
    public void setNews(News news)
    {
        this.news = news;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getFatherID()
    {
        return fatherID;
    }
    public void setFatherID(int fatherID)
    {
        this.fatherID = fatherID;
    }

    public int getTier()
    {
        return tier;
    }
    public void setTier(int tier)
    {
        this.tier = tier;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    
}
