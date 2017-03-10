package specialfeaturesPages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class dellSFFunctionality extends ApplicationKeywords{
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
		public dellSFFunctionality(BaseClass obj) {
			// TODO Auto-generated constructor stub
			super(obj);
			this.obj = obj;
		}

		/**
		 * Instantiates BV SF Page Functions.
		 */
		public dellSFFunctionality() {

			// TODO Auto-generated constructor st ub
		}
		
		public void verifydellSFpageContents(){
			testStepInfo("*********************************SF Page validation**********************************");
			waitTime(5);
			if (currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {

				verifydellContentsInDesktop();

			} else {
				verifydellContentsInMobile();
			}
		}
		/*public void verifydellContentsInDesktop(){
			boolean islogo = elementPresent(OR.txt_bvlogo);
			if(islogo==true){
				testStepPassed("BV SF >>BV Logo is displayed");
			}
			else{
				testStepFailed("BV SF >> BV tag line is displayed");
			}
			boolean istag = elementPresent(OR.txt_bvtag);
			if(istag==true){
				testStepPassed("BV SF >>BV Logo is displayed");
			}
			else{
				testStepFailed("BV SF >> BV tag line is displayed");
			}
			checkAdsOnBVCSF();
			boolean isdisplayed = elementPresent(OR.txt_DellVoice);
			if(isdisplayed==true){
				testStepPassed("Dell  SF >> Dell Voice text is displayed upon scroll");
			}
			else{
				testStepFailed("Dell  SF >> Dell Voice text is not displayed upon scroll");
			}
			waitTime(3);
			checkSections();
			
		}
		
		public void checkAdsOnBVCSF(){
			boolean isad1displayed = elementPresent(OR.ad_ColehaanFirstTopad);
			
			if(isad1displayed==true){
				testStepPassed("Dell SF >> First Ad is loaded and displayed");
			}
			else{
				testStepFailed("Dell SF >> First Ad is not loaded and not displayed");
			}
			scrollBy(0,6000);
			waitTime(5);
			boolean isad2displayed = elementPresent(OR.ad_DellSecondAd);
			
			if(isad2displayed==true){
				testStepPassed("Dell SF >> Second Ad is loaded and displayed");
			}
			else{
				testStepFailed("Dell SF >> Second Ad is not loaded and not displayed");
			}
		}
		
		public void checkSections(){
			try{
			testStepInfo("*******validating sections********");
			for(int i=0;i<11;i++){
				String sections="#xpath=//section[@id='row-"+i+"']";
				if(elementPresent(sections)){
					testStepPassed("Dell SF >> Section-"+i+" is loaded and displayed");
				}
				else{
					testStepFailed("Dell SF >> Section-"+i+" is not loaded and not displayed");
				}
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}*/
		public void verifydellContentsInMobile(){
			
		}
		
}
