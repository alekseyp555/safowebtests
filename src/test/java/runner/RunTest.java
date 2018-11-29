package runner;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;

/**
 * @author ME
 *
 */

// Uncomment @RunWith if you are using Junit to run Test
// @RunWith(Cucumber.class)
/*@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
		retryCount = 3,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		jsonUsageReport = "target/cucumber-usage.json",
		usageReport = true,
		toPDF = true,
		outputFolder = "target")
*/

@CucumberOptions(features={"src//test//java//features"}
					,glue={"stepDef","utility"}
					//,plugin = {"pretty", "html:target/cucumber"}
					//,plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm", "pretty", "json:target/cucumber-report/report.json"}
					,plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm", "pretty", "html:target/cucumber", "rerun:target/rerun.txt"}
					,tags ={"@deb"}
		)

@Test
public class RunTest extends AbstractTestNGCucumberTests {

}