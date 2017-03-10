/**
 * Check the Welcome ads
 * Check the quote
 * Check the continue to button

 */
package welcomePage;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class WelcomePageValidation. 
 * class names are written in mixed case with
 * the first letter of each internal word capitalized
 */
public class WelcomePageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Welcome Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	
	/**
	 * Instantiates a new welcome page validation.
	 *
	 * @param obj the obj
	 */
	public WelcomePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new welcome page validation.
	 */
	public WelcomePageValidation() {

		// TODO Auto-generated constructor st ub
	}

	/**
	 * Verify welcome page.
	 */
	public void verifyWelcomePage() {
		testStepInfo("******************************Welcome Page**************************************");
		try {
			
			
			// manualScreenshot(OR.txt_Welcome_Page);
			if (currentExecutionMachineName.equalsIgnoreCase("Welcome_Home_Article")|| currentExecutionMachineName.startsWith("iPad")) {
				
	          
				validatePageLoadTime("http://www.forbes.com/forbes/welcome/?autoforward=false", 7,"Welcome page");
				verifyQuoteOfTheDay();
				verifyWelcomeAds();
				verifyContinueToSite();
				
			} else {
				validatePageLoadTime("http://www.forbes.com/forbes/welcome/?autoforward=false", 7,"Welcome page");
				verifyQuoteOfTheDay();
				verifyWelcomeAds();
				verifyContinueToSite();

			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	public void verifyContinueToSite()
	{
		try {
			String button = getText(OR.txt_Home_Forbes_Continue_site);
			testStepPassed("CONTINUE TO SITE-" + button);

			if(button.contains("CONTINUE TO SITE"))
			{
				//clickOn(OR.txt_Home_Forbes_Continue_site);
				testStepPassed("Continue to site button is  displayed");
			
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Continue to site button is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Continue to site button is not displayed");
		}
	}
	/**
	 * Verify welcome ads.
	 * Validate welcome Ads is present
	 */
	public void verifyQuoteOfTheDay()
	{
		boolean quote=elementPresent(OR.txt_Home_Forbes_Quote);
		try {
			if(quote==true)
			{
			String txtQuote = getText(OR.txt_Home_Forbes_Quote);
			testStepPassed("Forbes Quote of the Day- is displayed---" + txtQuote);
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Forbes Quote of the day is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Forbes Quote of the day is not displayed");
		}
	}
	public void verifyWelcomeAds() {
		testStepInfo("******************************* Welcome Ads ****************************************");
		try {
			boolean welcomeAds = elementPresent(OR.ads_Welcome_Page_Ads);
			if (welcomeAds == true) {
				testStepPassed(" Welcome Ads is displayed");
				//manualScreenshot(OR.ads_Welcome_Page_Ads);
			} else {
				getCurrentPageURL();
				testStepFailed("Welcome Ads is not present");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		testStepFailed("Welcome Ads is not displayed");
		}

	}

}
