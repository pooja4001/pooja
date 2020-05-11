package com.capgemini.backgroundverification.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.backgroundverification.entity.Verification;


@Repository
public interface VerificationRepository extends JpaRepository<Verification,Serializable>
{
	@Query("select v from Verification v where v.logindata.userId=?1")
	Verification findByuserid(int userId);

}



