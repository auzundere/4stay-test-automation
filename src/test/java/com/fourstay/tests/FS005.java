package com.fourstay.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS005 extends TestBaseClass{
	
	@Test 
	public void Test5() {
		driver.get(Configuration.getProperty("url"));
	}
	
}
