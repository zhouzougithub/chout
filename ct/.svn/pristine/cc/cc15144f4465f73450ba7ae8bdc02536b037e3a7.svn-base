package cn.zz.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//id` int(11) NOT NULL AUTO_INCREMENT,
//`title` varchar(50) DEFAULT NULL,
//`pic` varchar(200) DEFAULT NULL,
//`text` varchar(200) DEFAULT NULL,
//`url` varchar(200) DEFAULT NULL,
//`user_id` int(11) DEFAULT NULL,
//`goodnum` int(11) DEFAULT NULL,
//`type` varchar(50) DEFAULT NULL,
//`date` datetime DEFAULT NULL,
public class News
{
    private int id;
    private String title;
    private String pic;
    private String text;
    private String url;
    private String type;
    private Date date;
    
    @Override
    public String toString()
    {
        return "News [id=" + id + ", title=" + title + ", text=" + text + "]";
    }
    private User use;//��������˭������
    private Set<Comment> commentSet=new HashSet<Comment>();//���ž��ж������
    private Set<User> collect=new HashSet<User>();//���ű�������ղ�
    private Set<User> goodUser=new HashSet<User>();//���ű�����˵���

    public News(String title, String pic, String text, String url, String type)
    {
        super();
        this.title = title;
        this.pic = pic;
        this.text = text;
        this.url = url;
        this.type = type;
        
        this.date = new Date();
    }
    public News()
    {
        
        this.date = new Date();
    }


    public User getUse()
    {
        return use;
    }
    public void setUse(User use)
    {
        this.use = use;
    }
    public Set<User> getCollect()
    {
        return collect;
    }
    public void setCollect(Set<User> collect)
    {
        this.collect = collect;
    }
    public Set<User> getGoodUser()
    {
        return goodUser;
    }
    public void setGoodUser(Set<User> goodUser)
    {
        this.goodUser = goodUser;
    }
    public Set<Comment> getCommentSet()
    {
        return commentSet;
    }
    public void setCommentSet(Set<Comment> commentSet)
    {
        this.commentSet = commentSet;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getPic()
    {
        return pic;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
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
