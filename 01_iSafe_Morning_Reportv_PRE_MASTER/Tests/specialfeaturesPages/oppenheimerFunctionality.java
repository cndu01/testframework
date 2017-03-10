package specialfeaturesPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class oppenheimerFunctionality extends ApplicationKeywords{
	
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
		public oppenheimerFunctionality(BaseClass obj) {
			// TODO Auto-generated constructor stub
			super(obj);
			this.obj = obj;
		}

		/**
		 * Instantiates BV SF Page Functions.
		 */
		public oppenheimerFunctionality() {

			// TODO Auto-generated constructor st ub
		}
		
		public void verifyOppenmhiemerSFpageContents(){
			testStepInfo("*********************************SF Page validation**********************************");
			waitTime(5);
			if (currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {

				verifyoppenheimerContentsInDesktop();

			} else {
				verifyoppenheimerContentsInMobile();
			}
		}
		
	/*	public void verifyoppenheimerContentsInDesktop(){
			verifySFBVLogoInDesktop();
			waitTime(3);
			checkads("//div[@csf-ad-unit='top']");
			checkSections();
			
			
		}
		
		public void checkads(String strXpath){
			try{
				this.scrollBy(0, 30);
				List<WebElement> elements = driver.findElements(By.xpath(strXpath));
				int count =elements.size();
				 for(int i = 0; i < count; i++){
					 if(elements.get(i).isDisplayed()){
						 testStepPassed("Ad "+i+" is displayed");
						 scrollBy(0,1200);
					 }
					 else{
						 testStepPassed("Ad "+i+" is not displayed");
					 }
				 }
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
		
		public void checkSections(){
			try{
			testStepInfo("*******validating sections********");
			for(int i=0;i<8;i++){
				String sections="#xpath=//section[@id='row-"+i+"']";
				if(elementPresent(sections)){
					testStepPassed("OppenheimerFunds SF >> Section-"+i+" is loaded and displayed");
				}
				else{
					testStepFailed("OppenheimerFunds SF >> Section-"+i+" is not loaded and not displayed");
				}
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}
		*/
		public void verifyoppenheimerContentsInMobile(){
			
		}

}
