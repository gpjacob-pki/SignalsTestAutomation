package com.signals.testrunnerandfeaturefile;


import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import io.cucumber.java.AfterStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)


@CucumberOptions(
 features = {"src/test/java/com/signals/feature"}
 ,glue={"com/signals/stepDefeniiton"},
		 tags = "@login",
 plugin={"json:target/json-report/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
 //plugin = { "json:target/json-report/cucumber.json"}"pretty", "html:test-output",
 ,monochrome = true
		 ,publish = true
		 
 )
 

@Test
public class Runner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();

	}

	
}
