package qa.busuu.pom.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import qa.busuu.pom.pages.session.settings.GeneralSettingsPage;
import qa.busuu.pom.pages.util.busuuConstants;

public class TopMenu {
	
	
	@FindBy(xpath=busuuConstants.MENUSETTINGS_LINK)
	public WebElement mainsettings;
	@FindBy(xpath=busuuConstants.SETTINGS_LINK)
	public WebElement settings;
	@FindBy(xpath=busuuConstants.PROMOBOX)
	public WebElement promobox;
	@FindBy(xpath=busuuConstants.PROMO)
	public WebElement ignorepromo;
	
	ExtentTest test;
	
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public void logout(){
	// here we give logout code.	
	}
	
	public GeneralSettingsPage gotoSettings(){
		test.log(LogStatus.INFO, "Going to settings");
		//navigationLabel.click();
		
		//ignoring promotion popup
		if(promobox.isDisplayed()){
			ignorepromo.click();
		}	
		//clicking settings icons
		mainsettings.click();//this  clicking profile icon link
		settings.click();
		
		test.log(LogStatus.INFO, "Settings page opened");
		GeneralSettingsPage settings =new GeneralSettingsPage(driver,test);
		PageFactory.initElements(driver, settings);
		return settings;
	}
	
	public void search(){
		//if we need to search any parameters 
	}
	
	
}
