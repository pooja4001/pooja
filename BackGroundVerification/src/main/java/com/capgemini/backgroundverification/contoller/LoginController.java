
package com.capgemini.backgroundverification.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.backgroundverification.entity.LoginData;
import com.capgemini.backgroundverification.exception.IdNotFoundException;
import com.capgemini.backgroundverification.service.LoginService;


@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class LoginController {
	 @Autowired
     LoginService loginservice;
	 
	@PostMapping(value="/addUser")
   public ResponseEntity<String> addUser(@RequestBody LoginData user)
	  {
	    LoginData  e= loginservice.addUser(user);
	     if (e == null) {
	      throw new IdNotFoundException("Enter Valid Id");
	       } else
	       {
	    	 return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
	   }	 
	     }
	    
	     @PutMapping("/Loginuser")
	 	public String LoginUser(@RequestBody LoginData u)
	 	{
	 		
	 		 String flag=loginservice.LoginUser(u);
	 		 return flag;
	 	}
	 	
}


