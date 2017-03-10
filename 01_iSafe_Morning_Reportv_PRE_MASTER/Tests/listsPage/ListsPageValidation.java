/**
 * Verify the list is displayed - Check for Billionaire as reference
 * Verify the user can view the complete list by clicking 'View Complete List' button
 * Verify the user is able to scroll down to the list and check for all Ads 
 * Verify the Ad is displayed for every 10 profiles
 * Verify each and every tab is clickable and details are displayed
 * Verify the images are displayed in all pages
 * Verify the profile page is displayed with the following options:NEXT, PREV, PROFILE GALLERY, LOAD MORE" 

 * 
 */

package listsPage;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ListsPageValidation. class names are written in mixed case with the
 * first letter of each internal word capitalized
 */
public class ListsPageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Lists Page Validation
	// Created by :Shakira
	// Created on :14 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new lists page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public ListsPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new lists page validation.
	 */
	public ListsPageValidation() {

	}

	/**
	 * Verify lists page.
	 */
	public void verifyListsPage() {
		testStepInfo("*********************************** LISTS **************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")) {

			validatePageLoadTime("http://www.forbes.com/billionaires/",20,"Lists Page");
			validateProfile();
			verifyFullList();
			verifyAdsInLsits();

		} else {
			validatePageLoadTime("http://www.forbes.com/billionaires/",13,"Lists Page");
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);

			verifyNextPrevoiusNavigationInMobile();
			validateSocialnetworks(OR.img_Mob_Lists_Page_Share);

			verifyRichListsInMobile();
			verifyProfileInMobile();

		}
	}

	public void verifyTopAdsInLists() {
		boolean topAds = elementPresent(OR.ads_Lsits_Page_Topa_Ads);
		if (topAds == true) {

			// manualScreenshot(OR.ads_Lsits_Page_Topa_Ads);
			testStepPassed("Top Ads is present---" + topAds);

		} else {
			testStepFailed("Top Ads is not present");
		}
	}

	
	

	/** The actions. */
	Actions actions = new Actions(driver);

	/**
	 * Verify rich lists.
	 */
	public void verifyRichLists() {
		testStepInfo("******************************* Rich Lists ***********************************");

		try {
			WebElement menu = driver.findElement(By.xpath("//div[@class='col--3-1 lists--block lists--rich']"));
			actions.moveToElement(menu).perform();
			waitTime(2);

			driver.findElement(By.linkText("World's Billionaires")).click();

			validateTopAds();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}





	/**
	 * Author : Shakira Created on : 27 June 2016
	 */

	/**
	 * Verifying Social Share are displayed
	 */

	public void verifySocialShareInMobile() {
		testStepInfo("******************************** Social Share  **********************************");
		try {
			boolean share = elementPresent(OR.img_Mob_Lists_Page_Share);
			if (share == true) {

				testStepPassed("Social Share are displayed");
			} else {
				testStepFailed("Social Share are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify Worlds Billionaires are present
	 */
	public void verifyRichListsInMobile() {
		testStepInfo("******************************** Rich Lists  **********************************");
		try {
			waitTime(2);
			boolean billionaires = elementPresent(OR.img_Mob_Lists_Page_Profile);
			if (billionaires == true) {
				clickOn(OR.img_Mob_Lists_Page_Profile);
				String profileName = getText(OR.txt_Mob_Lists_Page_Profile_Body);
				testStepPassed("Worlds Billionaire is --" + profileName);
			} else {
				testStepFailed("Worlds Billionaires is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify worlds Billionaires Profile by getting details and by names
	 */
	public void verifyProfileInMobile() {
		testStepInfo("******************************** Profile **********************************");
		try {
			scrollBy(0, 150);
			boolean profileDetails = elementPresent(OR.txt_Mob_Lists_Page_Profile_Details);
			if (profileDetails == true) {

				String profile = getText(OR.txt_Mob_Lists_Page_Profile_Details);
				testStepPassed(profile);
			} else {
				testStepFailed("Profile Details not displayed");
			}

		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * verify View complete lists is displayed
	 */

	public void verifyViewCompleteLists() {
		testStepInfo("******************************** View complete List **********************************");
		try {
			waitTime(3);
			boolean completeList = elementPresent(OR.btn_Mob_Lists_Page_View_Complete_List);
			if (completeList == true) {
				clickOn(OR.btn_Mob_Lists_Page_View_Complete_List);

				scrollBy(0, 100);
				String profileName = getText(OR.txt_Mob_Lists_Page_Profile_Name);
				testStepPassed("Worlds Billionaires is ---" + profileName);
			} else {
				testStepFailed("Worlds Billionaires is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * verify Next and Previous Navigations
	 */

	public void verifyNextPrevoiusNavigationInMobile() {
		testStepInfo(
				"******************************** Next and Previous Navigations **********************************");

		try {
			waitTime(3);
			boolean nextNav = elementPresent(OR.btn_Mob_Lists_Page_Next);
			if (nextNav == true) {

				clickOn(OR.btn_Mob_Lists_Page_Next);
				testStepPassed("Next Navigation is working");
			} else {
				testStepFailed("Next Navigation is not working");
			}
			boolean previousNav = elementPresent(OR.btn_Mob_Lists_Page_Previous);
			if (previousNav == true) {

				clickOn(OR.btn_Mob_Lists_Page_Previous);
				testStepPassed("Previous Navigation is working");
			} else {
				testStepFailed("Previous Navigation is not working");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

}
