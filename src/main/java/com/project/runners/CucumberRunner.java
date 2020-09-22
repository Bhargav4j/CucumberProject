package com.project.runners;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;

//import com.scripted.configurations.SkriptmateConfigurations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "FeatureFiles", plugin = { "json:target/cucumber.json",
		"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "html:target/cucumber.html" }, glue = {
				"com.project.stepdefs" }, monochrome = true, tags = { "@TestProject,@TestProject2" })
//@parallelTestNG

public class CucumberRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	/*
	 * @Override *commented code for cucumber parallel execution"
	 * 
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 * 
	 * @BeforeClass public void setupClassName(ITestContext context) {
	 * context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(2);
	 * context.getCurrentXmlTest().getSuite().setPreserveOrder(false); }
	 */
	@BeforeSuite
	public void setup() {
		System.out.println("i am in before suite of mobile test runner");
		// SkriptmateConfigurations.beforeSuite();
	}

	
	
	@AfterSuite
	public void teardown() {
		System.out.println("i am in after suite of mobile test runner");

		// SkriptmateConfigurations.afterSuite();
	}
}
