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

@CucumberOptions(features={"src//test//java//features"}
					,glue={"stepDef","utility"}
					,plugin = {"pretty", "html:target/cucumber"}
					, tags ={"@debug"}
		)
@Test
public class RunTest extends AbstractTestNGCucumberTests {

}
