package com.jquery.datatable;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class JQuery_02_AssertnVerify {

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void TC_01() {
		System.out.println("Verify 1: ");
		Assert.assertEquals("Automation Testing", "Automation Testing");
		System.out.println("Verify 2: ");
		Assert.assertEquals("Automation Testing", "Manual Testing");
		System.out.println("Verify 3: ");
		Assert.assertEquals("Automation Testing", "API Testing");
	}

	@Test
	public void TC_02() {
		System.out.println("Check 1: ");
		Assert.assertEquals("Automation Testing", "Automation Testing");
		System.out.println("Check 2: ");
		Assert.assertEquals("Automation Testing", "Manual Testing");
		System.out.println("Check 3: ");
		Assert.assertEquals("Automation Testing", "API Testing");
	}

	@AfterClass
	public void afterClass() {
	}

}
