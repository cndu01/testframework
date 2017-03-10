/**
 * Check ads on whole page
 * Hamburger menu
 * Home, newposts, Popular tabs
 * Search icon
 * Top Stories
 * Most polular section with see more popular stories link
 * ForbesBrandVoice 
 * Featured
 * Video
 * Forbes Lists section
 * Login
 */

package homePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import objectsRepository.OR;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

// TODO: Auto-generated Javadoc
/**
 * class names are written in mixed case with the first letter of each internal
 * word capitalized.
 */
public class HomePageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Home Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new home page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public HomePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new home page validation.
	 */
	public HomePageValidation() {

		// TODO Auto-generated constructor st ub
	}

	/**
	 * Verify links in home page. methods are written in mixed case with the
	 */
	public void verifyHomePage() {

		if (currentExecutionMachineName.equalsIgnoreCase("Welcome_Home_Article")) {
			validatePageLoadTime("http://www.forbes.com/home_usa/", 16, "Home Page");
			verifyUSUserZone();
			verifyEuropeUserZone();
			verifyAsiaUserZone();
			validateTabs();
			verifyAdDisplayedInHomePage();

			verifyFollowForbes();
			verifyTopStory();
			
			verifyVideoOnHomePage();
			validateSignUpInLevelUp();
			validateLevelUpLogo(OR.img_Reg_Home_Page_LevelUp);
			validateLevelUpLinks();
			getMostPopularLinks();
			verifySocialWeb();

			verifyForbesBrandVoice();
			verifyForbesList();
			verifyFooter();
			verfiyLogin();

		} else {

			validatePageLoadTime("http://www.forbes.com/home_usa/", 17, "Home Page");
			waitTime(5);
			validateGeographyDropDown();
			//validateGeography();
			validateHamburgerMenu();
			validateMobileAdsInHomePage();
			validatePromoSection(OR.img_Mob_Article_Page_PromoSection);

			verifyTopStoryInMobile();
			
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			validateLevelUpLogo(OR.img_Mob_Reg_LevelUp_Page_LevelIcon);
			validateLevelUpLinks();
			getMostPopularLinks();
			verifyMostPopularSeeMoreStories();
			verifyHomePageForbesBrandVoice();
			verifyHomePageFeatures();
			verifyVideoOnHomePage();
			validateForbesListsInMobile();
			
			verifyRelatedTopicsInMob();
		}

	}
	
	

}
