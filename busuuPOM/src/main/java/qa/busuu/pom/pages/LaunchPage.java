package qa.busuu.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import qa.busuu.pom.base.BasePage;
import qa.busuu.pom.pages.util.busuuConstants;

public class LaunchPage extends BasePage{
	
	
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver,test);
		
		
		
	}
	
	
	public LoginPage gotoLoginPage(){
		// log
		test.log(LogStatus.INFO, "Opening the url - "+busuuConstants.getEnvDetails().get("url"));
		driver.get(busuuConstants.getEnvDetails().get("url"));
		
		test.log(LogStatus.PASS, "URL Opened - "+busuuConstants.getEnvDetails().get("url"));
		
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

	

}
