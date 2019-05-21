package cn.zz.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.zz.domain.User;


public class LoginDao 
{
    //��Ҫһ��hibernateTemplate������ݲ���,��springע��
    private HibernateTemplate hbTemp;

    public void setHbTemp(HibernateTemplate hbTemp)
    {
        this.hbTemp = hbTemp;
    }
    
    public void save(User u)
    {
        hbTemp.save(u);
        
    }
}
