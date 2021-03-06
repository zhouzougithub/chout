package cn.zz.web.action;

import java.util.Map;

import cn.zz.domain.User;
import cn.zz.service.UserService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class LoginUserAction extends ActionSupport implements ModelDriven<User>
{
    //创建模型
    private User u=new User();
    private UserService userService;//注入service
    private String yzm;

    
    

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public User getModel()
    {
        // TODO Auto-generated method stub
        return u;
    }
    //注册
    public String registerUser()
    {
      
            //这里可以获取服务器生成的验证码
            System.out.println("验证码是:"+yzm);
            if(u!=null )
            {
                boolean register = userService.register(u);
                if(register){
                    //注册成功后直接登录
                    ActionContext context = ActionContext.getContext();
                    Map<String, Object> session = context.getSession();
                    session.put("use", u);
                    System.err.println("注册并登录成功");
                    return "success";
                }
                else {
                  return "err";
                }
            }
     
        
        return "err";
       
       
        
    }
   //登錄
    public String login()
    {
        if(u!=null)
        {
        //System.err.println("开始登录aaa"+u.toString());
        User reU = userService.login(u);
            if(reU!=null)
            {
                ActionContext context = ActionContext.getContext();
               Map<String, Object> contextMap = context.getContextMap();
               contextMap.put("use", reU);
               Map<String, Object> session = ActionContext.getContext().getSession();
               session.put("use", reU);
               //System.err.println("登录成功");
                return "success";
            }
            else
            {
                return "input";
            }
        
        }
        //System.err.println("登录完成aaa");
        return "input";
    }


    
    //退出
    public String logout()
    {
        ActionContext.getContext().getSession().remove("use");
        
        
        return Action.SUCCESS;
    }
    
    public void setYzm(String yzm)
    {
        this.yzm = yzm;
    }
    
    
}
