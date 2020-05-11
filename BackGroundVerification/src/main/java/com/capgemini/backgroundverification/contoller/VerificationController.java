package com.capgemini.backgroundverification.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.backgroundverification.entity.Verification;
import com.capgemini.backgroundverification.exception.IdNotFoundException;
import com.capgemini.backgroundverification.service.VerificationService;


@RestController
@RequestMapping("/ver")
@CrossOrigin("http://localhost:4200")
public class VerificationController {
	@Autowired
	VerificationService serviceobj;

	// Add user
	@PostMapping("/addVer/{userId}")
	public ResponseEntity<String> setStatus(@RequestBody Verification u, @PathVariable int userId) {
		Verification e = serviceobj.setStatus(u,userId);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Data entered successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/checkStatus/{userId}")
	public Verification checkStatus(@PathVariable int userId)
	{	
		 Verification flag=serviceobj.checkStatus(userId);
		 return flag;
	}
}