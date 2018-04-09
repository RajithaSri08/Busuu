package qa.busuu.pom.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import qa.busuu.pom.pages.LaunchPage;
import qa.busuu.pom.pages.LoginPage;
import qa.busuu.pom.pages.session.LandingPage;
import qa.busuu.pom.pages.session.settings.GeneralSettingsPage;
import qa.busuu.pom.pages.util.DataUtil;

public class ChangePasswordTest extends qa.busuu.pom.testcases.base.BaseTest {
	String testCaseName = "ChangePasswordTest";

	@Test(dataProvider = "getData")
	public void changePasswordTest(Hashtable<String, String> data) {
		// Extent Reports Test Case naming
		test = extent.startTest(testCaseName);

		// Verifying the run mode
		if (!DataUtil.isTestExecutable(xls, testCaseName)
				|| data.get(qa.busuu.pom.pages.util.busuuConstants.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}

		// Logging into busuu
		test.log(LogStatus.INFO, "Starting test"); // extent logging
		init(data.get("Browser"));
		LaunchPage launchPage = new LaunchPage(driver, test);
		PageFactory.initElements(driver, launchPage);

		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(LogStatus.INFO, "Logging in");
		Object page = loginPage.doLogin(data.get("Username"), data.get("OldPassword"));

		if (page instanceof LoginPage)
			reportFailure("Could not login");

		// Starting Change Password Test
		LandingPage landingPage = (LandingPage) page;
		GeneralSettingsPage settings = landingPage.getMenu().gotoSettings();

		//changing the password
		String actualResult = settings.doPasswordChange(data.get("OldPassword"), data.get("NewPassword"));
		test.log(LogStatus.INFO, "Result of changing password - " + actualResult);

		// validation
		if (!actualResult.equals(data.get("ExpectedResult")))
			reportFailure("Got password change result as - " + actualResult);

		test.log(LogStatus.PASS, "Test Passed");

	}

	@AfterMethod
	public void quit() {
		if (extent != null) {
			extent.endTest(test);
			extent.flush();
		}
		if (driver != null)
			driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		return qa.busuu.pom.pages.util.DataUtil.getData(xls, testCaseName);
	}

}
