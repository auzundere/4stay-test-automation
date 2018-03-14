package com.fourstay.tests;

import org.testng.annotations.Test;

import com.fourstay.utilities.Configuration;
import com.fourstay.utilities.TestBaseClass;

public class FS004 extends TestBaseClass{
	
	@Test 
	public void Test4() {
		driver.get(Configuration.getProperty("url"));
		
		//@findBy(xpath='.....')
	}
	
}
