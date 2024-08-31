package com.bit.CucumberPOMSeries.runners;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features/automationpractice")
//@ConfigurationParameter(key = F)
public class MyTestRunner
{

}