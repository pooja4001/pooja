package com.capgemini.backgroundverification.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.backgroundverification.dao.LoginRepository;
import com.capgemini.backgroundverification.entity.LoginData;

@Service
public class LoginService {
	
	 @Autowired
     LoginRepository udao;
 

	public void setUdao(LoginRepository udao) { this.udao=udao; }

    @Transactional
    public LoginData addUser(LoginData user)
    {
   	 return udao.save(user);
    }
    
    @Transactional
    public String LoginUser(LoginData u)
    {
   	 String flag="null";
   	
    	String userType=udao.findByuserType(u.getUserName(),u.getUserPassword());
    	if(userType.equalsIgnoreCase("employee"))
    			{
    				 return "employee";
    			}
    	else if(userType.equalsIgnoreCase("bgv"))
    			{
    			 return "bgv";
    			}
    	else
    		 return "none";
    
    }
}
