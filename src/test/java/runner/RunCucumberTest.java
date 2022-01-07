package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue = "lucas.steps",
//		tags = "~@ignore",
		plugin = {"pretty", "html:\\target\\report-html", "json:\\target\\report-json"},
		monochrome = true)
public class RunCucumberTest {

}
