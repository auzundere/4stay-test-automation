package com.fourstay.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS006 extends TestBaseClass{
	
	@Test 
	public void Test6() {
		driver.get(Configuration.getProperty("url"));
	}
	
}
