package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/roverNavigation.feature",
        glue = {"steps", "hooks"},
        plugin = {"pretty",
                "html:build/html-reports.html"
        },
        tags = "",
        dryRun = false,
        publish = true)
public class TestRunner {
}

