package com.wordpress.login;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.wordpress.AbstractTest;

public class Login_12_AssertnVerify extends AbstractTest {

	private SoftAssert sa = new SoftAssert();
	
	@BeforeClass
	public void beforeClass() {

	}

	//@Test
	public void TC_01_Hard_Assert() {
		System.out.println("Hard assert 1: ");
		Assert.assertEquals("Automation Testing", "Automation Testing");
		System.out.println("Hard assert 2: ");
		Assert.assertTrue(true);
		System.out.println("Hard assert 3: ");
		Assert.assertFalse(false);
		System.out.println("Hard assert 4: ");
		Assert.assertTrue(false);
		System.out.println("Hard assert 5: ");
		Assert.assertFalse(true);
	}

	//@Test
	public void TC_02_Soft_Assert() {
		System.out.println("Soft assert 1: ");
		sa.assertEquals("Automation Testing", "Automation Testing");
		System.out.println("Soft assert 2: ");
		sa.assertTrue(true);
		System.out.println("Soft assert 3: ");
		sa.assertFalse(false);
		System.out.println("Soft assert 4: ");
		sa.assertTrue(false);
		System.out.println("Soft assert 5: ");
		sa.assertFalse(true);
		sa.assertAll();
		
	}

	@Test
	public void TC_03_Custom_Assert() {
		System.out.println("Custom assert 1: ");
		verifyEquals("Automation Testing", "Automation Testing");
		System.out.println("Custom assert 2: ");
		verifyTrue(true);
		System.out.println("Custom assert 3: ");
		verifyFalse(false);
		System.out.println("Custom assert 4: ");
		verifyTrue(false);
		System.out.println("Custom assert 5: ");
		verifyFalse(true);
	}

//	private boolean verifyTrue(boolean condition) {
//		//boolean status = false;
//		try {
//			Assert.assertTrue(condition);
//			return true;
//		}catch(Throwable e) {
//			e.printStackTrace();
//			return false;
//		}
//		//return status;
//	}
//	
//	private boolean verifyFalse(boolean condition) {
////		boolean status = false;
//		try {
//			Assert.assertFalse(condition);
//			return true;
//		}catch(Throwable e) {
//			e.printStackTrace();
//			return false;
//		}
////		return status;
//	}
//	
//	private boolean verifyEquals(Object actualObject, Object expectObject) {
////		boolean status = false;
//		try {
//			Assert.assertEquals(actualObject, expectObject);
//			return true;
//		}catch(Throwable e) {
//			e.printStackTrace();
//			return false;
//		}
////		return status;
//	}
//	
	
	@AfterClass
	public void afterClass() {
	}

}
