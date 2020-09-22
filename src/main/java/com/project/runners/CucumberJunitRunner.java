//package com.project.runners;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
////import com.scripted.configurations.SkriptmateConfigurations;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = "FeatureFiles", plugin = { "json:target/cucumber.json","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
//		"html:target/cucumber.html" }, glue = { "com.project.stepdefs" }, monochrome = true, tags = { "@TestProject" }) 
////@parallelTestNG
//
//public class CucumberJunitRunner {
//	/*@Override     *commented code for cucumber parallel execution"
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
//	
//	@BeforeClass
//	public void setupClassName(ITestContext context) {
//	    context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(2);
//	    context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
//	}*/
////	@Before
////	public void setup() {
////		System.out.println("i am in before suite of mobile test runner");
////		//SkriptmateConfigurations.beforeSuite();
////	}
////
//////	@Test
//////	public void test() {
//////		System.out.println("this is test");
//////	}
//////	
////	@After
////	public void teardown() {
////		System.out.println("i am in after suite of mobile test runner");
////
////		//SkriptmateConfigurations.afterSuite();
////	}
//}
