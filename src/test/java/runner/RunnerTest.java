package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"usage:target/usage",
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/report/index.html"}
        , features = {"src/test/resources/features/"}
        , glue = {"stepDefinitions"})

public class RunnerTest {

}
