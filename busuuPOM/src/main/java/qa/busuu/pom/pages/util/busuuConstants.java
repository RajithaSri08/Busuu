package qa.busuu.pom.pages.util;

import java.util.Hashtable;

public class busuuConstants {

	
	//paths
	public static final String FIREFOX_DRIVER_EXE="BrowserFiles/geckodriver";
	public static final String CHROME_DRIVER_EXE="BrowserFiles/chromedriver";
	
	// locators
	public static final String LOGIN_USERNAME = "//*[@id='login-form-email']";
	public static final String LOGIN_PASSWORD = "//*[@id='login-form-password']";
	public static final String PROFILEPAGE_LINK = "//*[@id=\"tour-step-5\"]/a";
	public static final String MENUSETTINGS_LINK = "//*[@id='tour-step-5']/a";
	public static final String SETTINGS_LINK ="//*[@id='tour-step-5']/ul/li[2]/a";
	
	
	public static final String NEW_PASSWORD = "//*[@id='newPassword']";
	public static final String CONFIRM_CHANGE = "//*[@id='confirmPassword']";
	public static final String SAVE_CHANGES = "//*[@id='main-viewport-area']/main/div/div/div[2]/div/div/form/button";
	
	public static final String LOGINBUTTON="//*[@id='login-form-submit']";
	public static final String PROMO ="/html/body/div[1]/div/div/section/div/a[2]/translate";
	public static final String PROMOBOX ="/html/body/div[1]/div/div/section";
	// URLs-prod
	public static final String PROD_HOMEPAGE_URL = "https://www.busuu.com/en/login";
	public static final String PROD_USERNAME = "rajitha.sri08@gmail.com";
	public static final String PROD_PASSWORD = "qqqq1111";
	
	// URLs-uat
	public static final String UAT_HOMEPAGE_URL = "https://www.busuu.com/en/login";
	public static final String UAT_USERNAME = "rajitha.sri08@gmail.com";
	public static final String UAT_PASSWORD = "qqqq1111";
		
	
	public static final String ENV="PROD"; //PROD, UAT,SAT 
			

	//paths
	public static final String REPORT_PATH = "ExtentReports/";

	public static final String DATA_XLS_PATH = System.getProperty("user.dir") + "//data//Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";
	
	public static Hashtable<String,String> table;
	
	public static Hashtable<String,String> getEnvDetails(){
		if(table==null){
			table = new Hashtable<String,String>();
			if(ENV.equals("PROD")){
				table.put("url", PROD_HOMEPAGE_URL);
				table.put("username", PROD_USERNAME);
				table.put("password", PROD_PASSWORD);
			}else if(ENV.equals("UAT")){
				table.put("url", UAT_HOMEPAGE_URL);
				table.put("username", UAT_USERNAME);
				table.put("password", UAT_PASSWORD);
			}
			
		}
		return table;
		 
	}




	


	


	




	



	

}
