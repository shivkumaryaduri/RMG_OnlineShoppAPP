package com.Test.ROSA;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class assertTest {
	
	@Test
	public void asserttest() {
		WebDriver driver=new  ChromeDriver();
		driver.get("https://www.cricbuzz.com//");
		String eTitle = "Live cricket score,schelude";
		String aTitle = driver.getTitle();
		SoftAssert s=new SoftAssert();
		s. assertEquals(aTitle, eTitle);
		driver.quit();
	}

}
