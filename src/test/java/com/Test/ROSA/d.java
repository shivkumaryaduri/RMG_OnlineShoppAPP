package com.Test.ROSA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class d {
	@Test
	public void demo() {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.youtube.com/");
	}

}
