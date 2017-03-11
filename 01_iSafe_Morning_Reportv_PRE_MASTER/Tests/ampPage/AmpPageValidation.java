package ampPage;

import org.openqa.selenium.Keys;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class AmpPageValidation extends ApplicationKeywords{
	

	/** The obj. */
	BaseClass obj;
	String url1 = "http://www.forbes.com/sites/parmyolson/2016/09/16/facebook-apple-messaging-spam/amp/?d";
	String url2 = "http://www.forbes.com/sites/danalexander/2016/05/25/meet-the-richest-person-in-every-state-2016-billionaires/amp/?d";
	String url3 = "http://www.forbes.com/sites/wesgay/2016/09/16/how-creating-a-culture-around-coffee-can-boost-millennial-engagement-at-work/amp/?d";
	String url4 = "http://www.forbes.com/sites/joelkotkin/2016/09/15/californias-boom-is-poised-to-go-bust-and-liberals-dream-of-scandinavia-on-the-pacific/amp/?d";
	String url5 = "http://www.forbes.com/sites/aarontilley/2016/09/16/inside-iphone-7-teardown-intel-modem/amp/?d";
		

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates  BVPage Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public AmpPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public AmpPageValidation() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyAMPpageContents(){
		testStepInfo("*********************************AMP Page validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("AMP")) {

			validateAMPPage(url1);
			validateAMPPage(url2);
			validateAMPPage(url3);
			validateAMPPage(url4);
			//validateAMPPage(url5);

		} else {
			
		}
	}
	
	public void validateAMPPage(String url){
	try{
		clearEditBox(OR.txtBox_AMPPage);
		typeIn(OR.txtBox_AMPPage,url);
		clickOn(OR.button_AMPPage);
		waitTime(7);
		testStepInfo(getText(OR.txt_AMPPageStatus));
		if(getText(OR.txt_AMPPageStatus).equals("PASS")){
			testStepPassed("AMP URL "+url +"-Passed the validation ");
		}
		else{
			testStepFailed("AMP URL "+url+"-Failed the validation");
		}
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void validateAMPContents(){
		try{
		waitForElement(OR.txt_Home_Forbes_Continue_site);
		clickOn(OR.txt_Home_Forbes_Continue_site);
		waitTime(3);
		clickOnMainArticle();
		String url = getCurrentPageURL();
		String[] urlparts = url.split("#");
		String urlpart1 = urlparts[0];
		String ampurl = urlpart1+"amp";
		navigateTo(ampurl);
		boolean isLabel = elementPresent(OR.txt_AMPPageForbeslabel);
		boolean issocialshare = elementPresent(OR.icon_AMPPageSocialShare);
		if(isLabel==true){
			testStepPassed("Forbes label on AMP page header is displayed");
		}
		else{
			testStepFailed("Forbes label on AMP page header is not displayed");
		}
		if(issocialshare==true){
			testStepPassed("Social share bar on AMP page is displayed");
			int count = getElementCount(OR.icon_AMPPageSocialShareOptions);
			if(count==5){
				testStepPassed("Fb,Twitter,Linkedin,google share icons are displayed on AMP page");
			}
			else{
				testStepFailed("Fb,Twitter,Linkedin,google share icons are not displayed on AMP page");
			}
		}
		else{
			testStepFailed("Social share bar on AMP page is not displayed");
		}
		
		scrollBy(0, 4000);
		waitTime(3);
		int numofads = getElementCount(OR.txt_AMPPageAds);
		if(numofads!=0){
			testStepPassed("Number of Ads loaded on AMP page are : "+numofads);
		}
		else{
			testStepFailed("Ads are not loaded on AMP Page");
		}
		boolean isStickyad= elementPresent(OR.txt_AMPStickyAds);
		if(isStickyad==true){
			testStepPassed("AMP Article sticky ad is displayed on AMP page");
		}
		else{
			testStepFailed("AMP Article sticky ad is not displayed on AMP page");
		}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	}
}
