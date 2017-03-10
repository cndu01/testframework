package csrPageCheck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class CSRPageFunctionality extends ApplicationKeywords{
	/** The obj. */
	BaseClass obj;

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
	public CSRPageFunctionality(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public CSRPageFunctionality() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyCSRpageContents(){
		testStepInfo("*********************************CSR Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")) {

			verifyCSRPageContentsInDesktop();

		} else {
			verifyCSRPageContentsInMobile();
		}
	}
	
	public void verifyCSRPageContentsInDesktop(){
		validatePageLoadTime("http://www.forbes.com/business/?nowelcome",15,"Business CSR Page");
		checkTopAdCSR();
		checkRecAdsCSR();
		checkLogeAdCSR();
		checkLeaderBoardAdCSR();
		checkCSRpageContents();
	}
	
	public void verifyCSRPageContentsInMobile(){
		//checkIconsOnMobileView();
		CheckMobileAd(OR.ad_MobileCSFPageCheck_Stickymobilead);
		checkTopAdCSR();
		checkRecAdsCSR();
		checkLogeAdCSR();
		checkLeaderBoardAdCSR();
		checkCSRpageContents();
	}
	

	
	public void checkTopAdCSR(){
		try{
			boolean isDisplayed=elementPresent(OR.txt_CSRPageCheck_topAd);
			if(isDisplayed=true){
				testStepPassed(isDisplayed+" Top ad is displayed on the CSR page");
			}
			else{
				testStepFailed(isDisplayed+" Top Ad is not displayed on the CSR page");
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void checkRecAdsCSR(){
		try{
			boolean isDisplayed=elementPresent(OR.txt_CSRPageCheck_RecAd);
			boolean isRecStickyAdDisplayed=elementPresent(OR.txt_CSRPageCheck_RecStickyAd);
			if(isDisplayed=true){
				testStepPassed(isDisplayed+" Rec ad is displayed on the CSR page");
			}
			else{
				testStepFailed(isDisplayed+" Rec Ad is not displayed on the CSR page");
			}
			if(isRecStickyAdDisplayed=true){
				testStepPassed(isRecStickyAdDisplayed+" Rec Sticky ad is displayed on the CSR page");
			}
			else{
				testStepFailed(isRecStickyAdDisplayed+" Rec Sticky Ad is not displayed on the CSR page");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void checkLogeAdCSR(){
		try{
			boolean isDisplayed=elementPresent(OR.txt_CSRPageCheck_LogeAd);
			if(isDisplayed=true){
				testStepPassed(isDisplayed+" Loge ad is displayed on the CSR page");
			}
			else{
				testStepFailed(isDisplayed+" Loge Ad is not displayed on the CSR page");
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void checkLeaderBoardAdCSR(){
		try{
			boolean isDisplayed=elementPresent(OR.txt_CSRPageCheck_LeaderBoardAd);
			if(isDisplayed=true){
				testStepPassed(isDisplayed+" Leader board ad is displayed on the CSR page");
			}
			else{
				testStepFailed(isDisplayed+" Leader board Ad is not displayed on the CSR page");
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void checkIconsOnMobileView(){
		try{
		testStepInfo("*********************************Mobile Search/Share icons check**********************************");
		if(elementPresent(OR.txt_CSRPageCheck_hamburgerIcon) &&
			elementPresent(OR.icon_MobileCheck_shareSymbol) &&
			elementPresent(OR.icon_MobileCheck_searchSymbol)){
			testStepPassed("Mobile Page Check (mobile icons Check- Search and share icons are displayed");
		}
		else{
			testStepFailed("Mobile Page Check (mobile icons Check- Search and share icons are not displayed");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void checkCSRpageContents(){
		try{
		this.scrollBy(0, 1000);
		List<WebElement> articleStream = driver.findElements(By.xpath("//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']"));
		int streamcount = articleStream.size();
		if(elementPresent(OR.txt_CSRPageCheck_hamburgerIcon) &&  
			elementPresent(OR.txt_CSRPageCheck_seemorebutton)){
			testStepPassed("CSR Page Check:: See More Button is displayed after "+streamcount+"  posts");
		}
		else{
			testStepFailed("CSR Page Check:: See More Button is not displayed");
		}
		if(elementPresent(OR.txt_CSRPageCheck_trendingNow) && elementPresent(OR.txt_CSRPageCheck_trendingNowNextScroll)){
			testStepPassed("CSR Trending now is scrolled next");
			clickOn(OR.txt_CSRPageCheck_trendingNowNextScroll);
		}
		else{
			testStepInfo("CSR Trending now cannot be scrolled");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

}
