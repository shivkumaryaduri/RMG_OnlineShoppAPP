package com.Test.ROSA;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;


public class Practice  {

	@Test(groups= {"smoke","regression"})
	public void testscript3_Test()
	{
		System.out.println("----testscript3_Test----");
 	}
	
	@Test(groups = "smoke")
	public void testscript4_Test()
	{
		System.out.println("----testscript4_Test----");
	}
}
