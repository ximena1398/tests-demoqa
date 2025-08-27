package co.com.screenplay.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/progressbarcompleted.feature",
        glue = "co.com.screenplay.project.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@progressbar_complete"
)
public class ProgressBarCompletedTest {
}
