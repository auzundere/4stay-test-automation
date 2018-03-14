package com.fourstay.tests;

import org.testng.annotations.Test;

import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS002 extends TestBaseClass{
	
	@Test 
	public void Test2() {
		driver.get(Configuration.getProperty("url"));
	}
	
}
