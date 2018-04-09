package qa.busuu.pom.pages.session.settings;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import qa.busuu.pom.base.BasePage;
import qa.busuu.pom.pages.util.busuuConstants;

public class GeneralSettingsPage extends BasePage{

	
	
	@FindBy(xpath=busuuConstants.NEW_PASSWORD)
	public WebElement newPassword;
	
	@FindBy(xpath=busuuConstants.CONFIRM_CHANGE)
	public WebElement confirmPassword;
	
	@FindBy(xpath=busuuConstants.SAVE_CHANGES)
	public WebElement saveChanges;
	
	
	public GeneralSettingsPage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public String doPasswordChange(String oPassword,String nPassword) {
		test.log(LogStatus.INFO, "Changing password");
		
		newPassword.sendKeys(nPassword);
		confirmPassword.sendKeys(nPassword);
		saveChanges.click();
		test.log(LogStatus.INFO, "Changed Password Successfully");
		return "Success";
	}
}
