package cn.zz.web.action;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import cn.zz.domain.News;
import cn.zz.domain.User;
import cn.zz.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NewsAction extends ActionSupport implements ModelDriven<News>
{
    private News news=new News();
    private UserService userService;
    //上传图片的的字段
    private File newsImg;
    private String newsImgFileName;
    private String newsImgContentType;


    //上传图片
    public String upload()
    {
        //1.指定图片存放的位置
        String path = ServletActionContext.getServletContext().getRealPath("/img/newsImg");
        String picpath="/img/newsImg";
        //用uuid将图片进行份文件夹保存
        String uuid = UUID.randomUUID().toString();
        
        String[] split = uuid.split("-");
        for (String s : split)
        {
            picpath=picpath+"/"+s;
            path=path+"/"+s;
        }
        
        
        
        //将上传的图片路径保存在news对象中
        news.setPic(picpath+"/"+newsImgFileName);
        
        File file=new File(path);
        if(!file.exists())
        {
           file.mkdirs();
        }
        newsImg.renameTo(new File(path,newsImgFileName));
        
        return "success";
 
    }
    
    
    
    //发送新闻
    public String sendNews()
    {
        //判断用户有没有传图片
        if(newsImg!=null)
        {
            upload();
        }
      
        
        
        //当用户登录时才可以发新闻,,如果没有就先登录
         Map<String, Object> session = ActionContext.getContext().getSession();
         User u = (User) session.get("use");
        
        
        
        
        //System.err.println("用户信息"+u.getId());
        news.setUse(u);
       
        //保存新闻
        
        //System.err.println("保存的id是"+news.getUse().getId());
        userService.sendNews(news);
        return "success";
        
    }
    
    
    
    
    
    public void setNewsImg(File newsImg)
    {
        this.newsImg = newsImg;
    }

    public void setNewsImgFileName(String newsImgFileName)
    {
        this.newsImgFileName = newsImgFileName;
    }


    public void setNewsImgContentType(String newsImgContentType)
    {
        this.newsImgContentType = newsImgContentType;
    }

    
    @Override
    public News getModel()
    {
        // TODO Auto-generated method stub
        return news;
    }
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }


}
