package specialfeaturesPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class kpmgSFFunctionality extends ApplicationKeywords{
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
		 * Instantiates  BV SF Page Functions
		 *
		 * @param obj
		 *            the obj
		 */
		public kpmgSFFunctionality(BaseClass obj) {
			// TODO Auto-generated constructor stub
			super(obj);
			this.obj = obj;
		}

		/**
		 * Instantiates BV SF Page Functions.
		 */
		public kpmgSFFunctionality() {

			// TODO Auto-generated constructor st ub
		}
		
		public void verifyKPMGSFpageContents(){
			testStepInfo("*********************************SF Page validation**********************************");
			waitTime(5);
			if (currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {

				verifyKPMGContentsInDesktop();

			} else {
				verifyKPMGContentsInMobile();
			}
		}
		
		/*public void verifyKPMGContentsInDesktop(){
			boolean islogo = elementPresent(OR.txt_bvlogo);
			if(islogo==true){
				testStepPassed("BV SF >>BV Logo is displayed");
			}
			else{
				testStepFailed("BV SF >> BV Logo is not displayed");
			}
			boolean istag = elementPresent(OR.txt_bvtag);
			if(istag==true){
				testStepPassed("BV SF >>BV tag line is displayed");
			}
			else{
				testStepFailed("BV SF >> BV tag line is not displayed");
			}
			waitTime(3);
			boolean isheader = elementPresent(OR.txt_KPMGVoice);
			if(isheader==true){
				testStepPassed("BV SF >>BV Header Label is displayed");
			}
			else{
				testStepFailed("BV SF >> BV Header label is not displayed");
			}
			waitTime(3);
			boolean isMissionLinkDisplayed = elementPresent(OR.txt_KPMGVoiceMission);
			boolean isChapterLinkDisplayed = elementPresent(OR.txt_KPMGVoiceChapters);
			if(isMissionLinkDisplayed==true && isChapterLinkDisplayed == true){
				testStepPassed("KPMG SF SF >>Mission and Chapters is displayed");
				clickOn(OR.txt_KPMGVoiceMission);
				boolean isadDisplayed = elementPresent(OR.txt_KPMGVoiceSFAd);
				boolean issectionDisplayed = elementPresent(OR.txt_KPMGMission_Section);
				if(isadDisplayed ==true){
					testStepPassed("KPMG SF >>Ad is displayed");
				}
				else{
					testStepPassed("KPMG SF>>Ad is not displayed");
				}
				if(issectionDisplayed ==true){
					testStepPassed("KPMG SF >>sexction is displayed");
				}
				else{
					testStepPassed("KPMG SF >>Section is not displayed");
				}
			}
			else{
				testStepPassed("KPMG SF >>Mission and Chapters is not displayed");
			}
			clickOnBackButton();
			checktheChapters("//ul[@class='ww-chapters__menu__items']/li");
			
		}
		
		public void checktheChapters(String strXpath){
			try{
				//this.scrollBy(0, 30);
				List<WebElement> elements = driver.findElements(By.xpath(strXpath));
				int count =elements.size();
				 for(int i = 0; i <count; i++){
					 if(elements.get(i).isDisplayed()){
						 testStepPassed("Chpater "+i+" is displayed");
					 }
					 else{
						 testStepPassed("Chapter "+i+" is not displayed");
					 }
				 }
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
		*/
		public void verifyKPMGContentsInMobile(){
			
		}
}
