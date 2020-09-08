package cucumber.java.jms.tests;

import javax.jms.JMSException;

import cucumber.api.junit.Cucumber;
import cucumber.java.jms.steps.JmsStepDefs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options( features = {"src/test/resources/cucumber/java/jms/jms-test.feature"},
		//dryRun = true,
		//monochrome = true,
		glue = {"cucumber.java.jms.steps"},
		format = {"html:target/cucumber-html-report", "json-pretty:target/cucumber-json-report.json"})
public class RunCukesTest {
	
	@BeforeClass
	public static void startTestServer() throws JMSException {
		JmsStepDefs.startUpServer();
	}

	@AfterClass
	public static void closeDownServer() throws JMSException {
		JmsStepDefs.closeDownServer();
	}
}
