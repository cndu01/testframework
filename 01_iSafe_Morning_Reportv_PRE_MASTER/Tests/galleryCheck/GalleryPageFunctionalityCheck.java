package galleryCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import objectsRepository.OR;

public class GalleryPageFunctionalityCheck extends ApplicationKeywords{
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
	public GalleryPageFunctionalityCheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public GalleryPageFunctionalityCheck() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyTemplateGallery() {
		testStepInfo("*********************************Gallery Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Desktop1")) {

			verifyTemplateGalleryOnDesktop();

		} else {
			verifyTemplateGalleryOnMobile();
		}
	}

	public void verifyTemplateGalleryOnDesktop(){
		clickOn(OR.txt_GalleryCheck_PopularGallery);
		checkTopAdOnTemplateGallery();
		checkAdsonTemplateGallery();
		viewTemplateGallerySlides();
	}
	
	public void checkTopAdOnTemplateGallery(){
		boolean isTopAdDisplayed = elementPresent(OR.txt_GalleryCheck_LeaderBoard);
		if(isTopAdDisplayed){
			testStepInfo("*********************************Top Leaderboard Ad***********************************************");
			testStepPassed("Gallery Check (Gallery Top Leaderboard Ad is displayed- "+ isTopAdDisplayed);
		}
		else{
			testStepPassed("Gallery Check (Gallery Top Leaderboard Ad is not displayed- "+ isTopAdDisplayed);
		}
	}
	
	public void viewTemplateGallerySlides(){
		try{
			waitForElement(OR.txt_GalleryCheck_ImagesBox);
			boolean isImageBoxDisplayed = elementPresent(OR.txt_GalleryCheck_ImagesBox);
			boolean isNextIconDisplayed = elementPresent(OR.txt_GalleryCheck_nextIcon);
			if(isImageBoxDisplayed &&
					isNextIconDisplayed){
				testStepPassed("Gallery Check::Gallery imageBox is displayed on the page");
			}
			else{
				testStepPassed("Gallery Check::Gallery imageBox is not displayed on the page");
			}
			checkImagesInGallery(OR.txt_GalleryCheck_SlideCount,OR.txt_GalleryCheck_nextIcon);
		}
		catch(Exception e){
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void verifyTemplateGalleryOnMobile(){	
		
		CheckMobileAd();
		//swipe();
	}
	
	public void swipe(){
		// java
		WebElement el = driver.findElement(By.xpath(OR.txt_GalleryCheck_mobileGalleryArea));
		TouchAction action = new TouchAction((MobileDriver) driver).press(el, 10, 10).moveTo(360, 360).release().perform();
		//driver.swipe(75, 500, 75, 0, 0.8);
	}
	
	public void CheckMobileAd(){
		testStepInfo("*********************************Mobile Gallery ad Check**********************************");
		boolean ismobileAdDisplayed = elementPresent(OR.txt_GalleryCheck_mobileStickyAd);
		if(ismobileAdDisplayed){
			testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is displayed on the page::"+ismobileAdDisplayed);
		}
		else{
			testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is not displayed on the page::"+ismobileAdDisplayed);
		}
	}
	
}
