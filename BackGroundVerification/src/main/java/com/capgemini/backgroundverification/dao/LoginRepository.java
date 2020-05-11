package com.capgemini.backgroundverification.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.backgroundverification.entity.LoginData;
import com.capgemini.backgroundverification.entity.Verification;

@Repository
public interface LoginRepository extends JpaRepository<LoginData, Serializable>
{
	@Query("select m.userType from LoginData m where m.userName=?1 and m.userPassword=?2")
	String findByuserType(String userName, String userPassword);

	
}
