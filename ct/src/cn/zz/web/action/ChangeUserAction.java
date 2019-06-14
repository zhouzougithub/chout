package cn.zz.web.action;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import cn.zz.domain.User;
import cn.zz.service.UserService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChangeUserAction extends ActionSupport implements
        ModelDriven<User>
{
    User use = new User();
    private UserService userService;// 注入service
    // 上传图片的的字段
    private File useImg;
    private String useImgFileName;
    private String useImgContentType;
    private String oldPassword;


    // 上传图片
    public String upload()
    {
        // 1.指定图片存放的位置
        String path = ServletActionContext.getServletContext().getRealPath(
                "/img/useImg");
        String picpath = "/img/useImg";
        // 用uuid将图片进行份文件夹保存
        String uuid = UUID.randomUUID().toString();

        String[] split = uuid.split("-");
        for (String s : split)
        {
            picpath = picpath + "/" + s;
            path = path + "/" + s;
        }

        // 将上传的图片路径保存在news对象中
        use.setHeadimgurl(picpath + "/" + useImgFileName);

        File file = new File(path);
        if (!file.exists())
        {
            file.mkdirs();
        }
        useImg.renameTo(new File(path, useImgFileName));

        return "success";

    }

    public String changeUser()
    {// 修改用户信息
        User u = (User) ActionContext.getContext().getSession().get("use");
        if (u == null)
        {
            return Action.LOGIN;
        }
        // 判断传没传图片
        if (useImg != null)
        {
            upload();
        }
        //如果旧密码不正确,那么就返回
        if(oldPassword!=null && !oldPassword.equals(u.getPassword()))
        {
            return Action.ERROR;
        }
        
        use.setId(u.getId());
        // 拿到修改后的用户信息,,对用户进行修改
        userService.changeUse(use);
        //修改後获取
        User ruse = userService.findUseByID(u.getId());
        // 设置session中的use
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("use",ruse);
        return SUCCESS;
    }

    @Override
    public User getModel()
    {
        // TODO Auto-generated method stub
        return use;
    }

   

    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

 

    public void setUseImg(File useImg)
    {
        this.useImg = useImg;
    }

 

    public void setUseImgFileName(String useImgFileName)
    {
        this.useImgFileName = useImgFileName;
    }

  

    public void setUseImgContentType(String useImgContentType)
    {
        this.useImgContentType = useImgContentType;
    }

    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }

}
