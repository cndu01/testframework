package specialfeaturesPages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class colehaanCSFFunctionality extends ApplicationKeywords{
	
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
		public colehaanCSFFunctionality(BaseClass obj) {
			// TODO Auto-generated constructor stub
			super(obj);
			this.obj = obj;
		}

		/**
		 * Instantiates BVPage Functions.
		 */
		public colehaanCSFFunctionality() {

			// TODO Auto-generated constructor st ub
		}
		
		public void verifySFpageContents(){
			testStepInfo("*********************************SF Page validation**********************************");
			waitTime(5);
			if (currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {

				verifyColehaanContentsInDesktop();

			} else {
				verifyColehaanContentsInMobile();
			}
		}
		
		/*public void verifyColehaanContentsInDesktop(){
			boolean isdisplayed = elementPresent(OR.img_Colehaanimage);
			if(isdisplayed==true){
				testStepPassed("Cole haan SF >> Intro image is displayed");
			}
			else{
				testStepFailed("Cole haan SF >> Intro image is not displayed");
			}
			waitTime(3);
			checkAdsOnColeHaanCSF();
			scrollBy(0,1000);
		}
		
		public void checkAdsOnColeHaanCSF(){
			scrollBy(0,700);
			waitTime(5);
			boolean isad1displayed = elementPresent(OR.ad_ColehaanFirstTopad);
			if(isad1displayed==true){
				testStepPassed("Cole haan SF >> First Ad is loaded and displayed");
			}
			else{
				testStepFailed("Cole haan SF >> First Ad is not loaded and not displayed");
			}
			scrollBy(0,4000);
			boolean isad2displayed = elementPresent(OR.ad_ColehaanSecondTopad);
			
			if(isad2displayed==true){
				testStepPassed("Cole haan SF >> Second Ad is loaded and displayed");
			}
			else{
				testStepFailed("Cole haan SF >> Second Ad is not loaded and not displayed");
			}
		}
		
		public void checkSections(){
			try{
			testStepInfo("*******validating sections********");
			for(int i=2;i<10;i++){
				String sections="#xpath=//section[@id='row-"+i+"']/div[2]";
				if(elementPresent(sections)){
					testStepPassed("Cole haan SF >> Section-"+i+" is loaded and displayed");
				}
				else{
					testStepFailed("Cole haan SF >> Section-"+i+" is not loaded and not displayed");
				}
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}*/
		
		public void verifyColehaanContentsInMobile(){
			
		}

}
