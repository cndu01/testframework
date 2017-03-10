package specialfeaturesPages;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class johnhancockSFFunctionality extends ApplicationKeywords {
	
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
		public johnhancockSFFunctionality(BaseClass obj) {
			// TODO Auto-generated constructor stub
			super(obj);
			this.obj = obj;
		}

		/**
		 * Instantiates BV SF Page Functions.
		 */
		public johnhancockSFFunctionality() {

			// TODO Auto-generated constructor st ub
		}
		
		public void verifyjohnhancockSFpageContents(){
			testStepInfo("*********************************SF Page validation**********************************");
			waitTime(5);
			if (currentExecutionMachineName.equalsIgnoreCase("SFCheck")) {

				verifyjohnhancockContentsInDesktop();

			} else {
				verifyjohnhancockContentsInMobile();
			}
		}
		
		/*public void verifyjohnhancockContentsInDesktop(){
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
			waitTime(3);
			scrollBy(0,2000);
			checkads();
			checkSections();
		}
		
		public void checkads(){
			try{
			testStepInfo("*******validating Ads********");
			isListDisplayedOnMobile(OR.ads_JohnHancockVoice);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}
		
		public void checkSections(){
			try{
			testStepInfo("*******validating sections********");
			for(int i=0;i<10;i++){
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
			
		}
		*/
		
		public void verifyjohnhancockContentsInMobile(){
			
		}

}
