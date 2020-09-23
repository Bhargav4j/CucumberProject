package com.project.runners;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.project.stepdefs.BlazeDemoStepDefs;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "FeatureFiles", plugin = { "json:target/cucumber.json",
		"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "html:target/cucumber.html" }, glue = {
				"com.project.stepdefs" }, monochrome = true, tags = { "@Sanity" })
//@parallelTestNG

public class CucumberRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeSuite
	public void setup() {
		System.out.println("I am in Before suite");
	}

	
	
	@AfterSuite
	public void teardown() {
		System.out.println("I am in After suite");
		BlazeDemoStepDefs.driver.close();
		BlazeDemoStepDefs.driver.quit();
	}
}
