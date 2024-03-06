package com.Test.ROSA;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class Demo1 {
	
	@Test (groups = "smoke")
	public void testscript1_Test()
	{
		System.out.println("----testscript1_Test----");
	}
	
	@Test (groups = "regression")
	public void testscript2_Test()
	{
		System.out.println("----testscript2_Test----");
	}
	
	
	
	
}
