package qa.busuu.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import qa.busuu.pom.base.BasePage;
import qa.busuu.pom.pages.session.LandingPage;
import qa.busuu.pom.pages.util.busuuConstants;

public class LoginPage extends BasePage{
	
	@FindBy(xpath=busuuConstants.LOGIN_USERNAME)
	public WebElement email;
	
	@FindBy(xpath=busuuConstants.LOGIN_PASSWORD)
	public WebElement password;
	
	@FindBy(xpath=busuuConstants.LOGINBUTTON)
	public WebElement LoginButton;
	
	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	
	public Object doLogin(String usName,String pWord){
		
		//logging into the busuu website
		test.log(LogStatus.INFO, "Logging in -"+usName+"/"+pWord);
		email.click();
		email.sendKeys(usName);
		password.click();
		password.sendKeys(pWord);
		LoginButton.click();
		
		// logic - validate
		boolean loginSuccess=isElementPresent(busuuConstants.PROFILEPAGE_LINK);
		
		if(loginSuccess){
			test.log(LogStatus.INFO, "Login Success");
			LandingPage landingPage = new LandingPage(driver,test);
			PageFactory.initElements(driver, landingPage);
			return landingPage;
		}
		else{
			test.log(LogStatus.INFO, "Login Not Success");
			LoginPage loginPage = new LoginPage(driver,test);
			PageFactory.initElements(driver, loginPage);
			return loginPage;
		}

		
	}
	

	
	

}
