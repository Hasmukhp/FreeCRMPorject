package com.crm.qa.testcases;

import org.testng.TestNG;
import org.testng.TestListenerAdapter;
import ExtentReportListener.ExtentReportListener;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

public class TestRunner {
	static TestNG testNg;
	
	public static void main(String[] args) {
	
			//@SuppressWarnings("deprecation")
		ExtentReportListener ext=new ExtentReportListener();
	     testNg = new TestNG();
	
	     testNg.setTestClasses(new Class[] {LoginPageTest.class});
	//	setTestClasses(new Class[] {LoginPageTest.class});
		testNg.addListener(ext);		
		testNg.run();
	}
}