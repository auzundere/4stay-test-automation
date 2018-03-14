package com.fourstay.tests;

import org.testng.annotations.Test;

import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS001 extends TestBaseClass{
	
	@Test 
	public void Test1() {
		driver.get(Configuration.getProperty("url"));
	}
	
}
