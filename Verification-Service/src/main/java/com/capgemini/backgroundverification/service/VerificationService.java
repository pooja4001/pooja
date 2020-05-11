package com.capgemini.backgroundverification.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.backgroundverification.dao.LoginRepository;
import com.capgemini.backgroundverification.dao.VerificationRepository;
import com.capgemini.backgroundverification.entity.LoginData;
import com.capgemini.backgroundverification.entity.Verification;
import com.capgemini.backgroundverification.exception.UserNotFoundException;


@Service
public class VerificationService {
	

	@Autowired
	VerificationRepository vdao;
	public void setAdao(VerificationRepository vdao) { this.vdao=vdao;}
	

	@Autowired
	LoginRepository ldao;
	
	@Transactional(readOnly=true)
	public Verification checkStatus(int userId)
	{
		return vdao.findByuserid(userId);
	}
	
	
	@Transactional
	public Verification setStatus(Verification v,int userId)
	{
		LoginData ld=ldao.findById(userId).get();
		if(ld==null)
			return null;
		if(v.getLogindata()==null)
		{
			Verification v1=vdao.save(v);
			v1.setLogindata(ld);
			return v1;
		}
		else
			throw new UserNotFoundException("invalid user");
	}

	
}
