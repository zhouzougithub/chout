package cn.zz.test;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zz.domain.News;
import cn.zz.domain.User;
import cn.zz.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class T
{
    //��service�����Զ�ע��
    @Autowired
    private UserService lgservice;

    public void setLgservice(UserService lgservice)
    {
        this.lgservice = lgservice;
    }
    @Test
    public void test()
    {
        User u=new User("zhangsan", "12345", "aaa", "#", "good boy","");
        
        u.setPassword("123");
        u.setUsename("张三");
        Set<News> newsSet = u.getNewsSet();
        News news=new News("标题", "#", "好新闻", "www.baidu.com","图片区");
        
        
        newsSet.add(news);
        
        u.setNewsSet(newsSet);
        lgservice.register(u);
        
        
      
    }

}
