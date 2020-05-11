package com.capgemini.backgroundverification.test;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.backgroundverification.dao.VerificationRepository;
import com.capgemini.backgroundverification.entity.Verification;
import com.capgemini.backgroundverification.service.VerificationService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;
	import org.mockito.junit.MockitoJUnitRunner;

	@RunWith(MockitoJUnitRunner.class)
	public class BackGroundVerificationApplicationTests {
		@InjectMocks
		VerificationService service;
		
		@Mock
		@Autowired
		VerificationRepository dao;
		
		@Before(value = "")
		public void init() {
			MockitoAnnotations.initMocks(this);
		}
		
			@Test
		public void testsetStatus() {
			/*Verification v = new Verification();
			v.setVerId(1);
			v.setStatus("Green");
			
			service.setStatus(v);
			//dao.save(emp); <--Using this method when you want to test from dao layer
			Mockito.verify(dao, Mockito.times(1)).save(v); */
			
				Verification v = new Verification(1,"Green");
				when(dao.save(v)).thenReturn(v);
				Verification v1=service.setStatus(v, 1);
				assertEquals(1,v1.getVerId());
				assertEquals("Green",v1.getStatus());
				
		} 
		
		@Test
		public void testcheckstatus() {
			Verification vtest = new Verification(1,"Green");
			Mockito.when(dao.getOne(1)).thenReturn(vtest);
			
			Verification v1 = service.checkStatus(1);
			assertEquals(v1,vtest);
			assertEquals("Green", v1.getStatus());
			assertNotEquals("xyz", v1.getStatus());
		}
}