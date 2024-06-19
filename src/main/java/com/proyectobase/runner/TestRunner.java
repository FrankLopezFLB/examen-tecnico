package com.proyectobase.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        stepNotifications = true,
        glue = {"com.proyectoBase.stepDefinition", "com.proyectoBase.utils"},
        plugin = {"pretty","html:target/cucumber-reports/cucumber-html-report.html","json:cucumber.json","timeline:target/cucumber-reports/CucumberTimeline"},
        tags = "@escenario-login"
)
public class TestRunner {


}
