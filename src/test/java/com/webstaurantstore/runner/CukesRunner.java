package com.webstaurantstore.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/feautures" ,
        glue = "com/cydeo/step_definitions2" ,
        dryRun = false,
        tags = "@wip",
        publish = true
)
public class CukesRunner {

}