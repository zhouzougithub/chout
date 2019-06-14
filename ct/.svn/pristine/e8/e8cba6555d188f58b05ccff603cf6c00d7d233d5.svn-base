package cn.zz.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.inject.Container;

//`id` int(11) NOT NULL AUTO_INCREMENT,
//`patname` varchar(20) DEFAULT NULL,
//`usename` varchar(50) DEFAULT NULL,
//`password` varchar(50) DEFAULT NULL,
//`headimgurl` varchar(200) DEFAULT NULL,
//`explain` varchar(200) DEFAULT NULL,
//PRIMARY KEY (`id`)

public class User
{

    private int id;
    private String usename;
    private String password;
    private String patname;//昵称
    private String headimgurl;//头像url
    private String explains;//个性签名
    private String sex;
    private Date birthday;//创建账户时间
    //一对多
    private Set<News> newsSet=new HashSet<News>();//发布的新闻
    private Set<Comment> commentSet=new HashSet<Comment>();//评论
    //多对多
    private Set<News> collect=new HashSet<News>();//收藏
    private Set<News> goodNews=new HashSet<News>();//点赞
    
    
    

    
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof User)
        {
            User inu=(User)obj;
            if(inu.getId()==this.id)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        // TODO Auto-generated method stub
        return this.id;
    }

    public User()
    {
        birthday=new Date();
    }
    public User(String usename, String password, String patname,
            String headimgurl, String explain,String sex)
    {
        
        birthday=new Date();
        this.usename = usename;
        this.password = password;
        this.patname = patname;
        this.headimgurl = headimgurl;
        this.explains = explain;
        this.sex=sex;
    }
    public Set<News> getCollect()
    {
        return collect;
    }
    public void setCollect(Set<News> collect)
    {
        this.collect = collect;
    }
    public Set<News> getGoodNews()
    {
        return goodNews;
    }
    public void setGoodNews(Set<News> goodNews)
    {
        this.goodNews = goodNews;
    }
    public Set<News> getNewsSet()
    {
        return newsSet;
    }
    public void setNewsSet(Set<News> newsSet)
    {
        this.newsSet = newsSet;
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
    public String getUsename()
    {
        return usename;
    }
    public void setUsename(String usename)
    {
        this.usename = usename;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPatname()
    {
        return patname;
    }
    public void setPatname(String patname)
    {
        this.patname = patname;
    }
    public String getHeadimgurl()
    {
        return headimgurl;
    }
    public void setHeadimgurl(String headimgurl)
    {
        this.headimgurl = headimgurl;
    }
    public String getExplains()
    {
        return explains;
    }
    public void setExplains(String explains)
    {
        this.explains = explains;
    }
    public String getSex()
    {
        return sex;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    @Override
    public String toString()
    {
        return "User [id=" + id + ", usename=" + usename + ", password="
                + password + ", patname=" + patname + "]";
    }
    public Date getBirthday()
    {
        return birthday;
    }
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    
}
