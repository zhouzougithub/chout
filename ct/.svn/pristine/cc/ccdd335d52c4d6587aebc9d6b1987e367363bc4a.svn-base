package cn.zz.web.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
//拦截器,,负责登录拦截,,不登录都需要跳回到登录页
public class LoginInterceptor extends MethodFilterInterceptor
{

 

    @Override
    protected String doIntercept(ActionInvocation ai) throws Exception
    {
        Map<String, Object> session = ServletActionContext.getContext().getSession();
        Object use = session.get("use");
        if (use!=null)
        {   //登录过,,那么就放行,,返回该返回的结果
            String invoke = ai.invoke();
            return invoke;
            
        }
        else
        {
          //没登录过,,那么就回到登录界面
            
            System.err.println("方法被拦截");
            return "login";
        }
        
        
    }

}
