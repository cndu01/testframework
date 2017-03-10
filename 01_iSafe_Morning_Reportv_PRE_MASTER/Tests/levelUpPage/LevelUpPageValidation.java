/**
 * Check Contributor Home page
 * Check on Contributor Image & Name
 * Click on Follow button
 * Click on Full Bio
 * Click on Show More

 */

package levelUpPage;

import iSAFE.ApplicationKeywords;

import java.util.List;

import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class LevelUpPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Contributor Page Validation
	// Created by :Shakira
	// Created on :6 June 2016

	// ///////////////////////////////////////////////////////////////////////////////
	/** The obj. */
	BaseClass obj;

	/**
	 * Instantiates a new contributor page validation.
	 *
	 * @param obj the obj
	 */
	public LevelUpPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new contributor page validation.
	 */
	public LevelUpPageValidation() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate contributor page.
	 */
	public void validateLevelUpPage() {
		testStepInfo("************************************************** LevelUp Page ****************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Welcome_Home_Article"))
		{
			driver.get("http://www.forbes.com/sites/levelup");
			waitTime(10);
			verifyAuthorName();
			validatecontributorDetails(OR.img_Reg_Groupcontributor_Logo,OR.txt_Reg_Contributor_Page_TypeOFContributor);
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			validateContributorImage(OR.img_Reg_Contributor_Page_Image);
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			//verifyFullBio();
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
			
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validatePromoVideoBlock();
			this.scrollBy(0, -600);
			clickingAllLatestPosts();
			validateArchiveContributor();
			//validateLatestPostsImages();
			
			validateMostPopularArticles();
			
		}
		else
		{
		
			verifyContributorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor);
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			
			//verifyAuthorNameInMobile();
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			this.scrollBy(0, -10);
			//validateTopAds(OR.ads_Welcome_Page_Ads);
			validateLatestPostsInMobile();
			validateArchiveContributor();
			
			//validateRecAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
			
		
		}
		
	}
	
	public void validateLevelUpIconInMobile()
	{
		try {
			waitForElement(OR.img_Mob_Reg_LevelUp_Page_LevelIcon);
			scrollBy(0, 1200);
			scrollBy(0, -200);
			boolean levelUpIcon=elementPresent(OR.img_Mob_Reg_LevelUp_Page_LevelIcon);
			if(levelUpIcon==true)
			{
				this.scrollToElement(OR.img_Mob_Reg_LevelUp_Page_LevelIcon);
				this.scrollBy(0, -60);
				clickOn(OR.img_Mob_Reg_LevelUp_Page_LevelIcon);
				testStepPassed("Clicked on LevelUp icon");
			}
			else
			{
				testStepFailed("LevelUp Icon is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateLevelUp()
	{
		try {
			boolean levelUp=elementPresent(OR.img_Reg_Home_Page_LevelUp);
			if(levelUp==true)
			{
				this.scrollToElement(OR.img_Reg_Home_Page_LevelUp);
				this.scrollBy(0, -60);
				clickOn(OR.img_Reg_Home_Page_LevelUp);
				
				boolean levelup=elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
				if(levelup==true)
				{
					String getLevelUp=getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
					if(getLevelUp.equals("Level Up"))
					{
						testStepPassed("Navigated to Level Up page-"+getLevelUp);
						verifyAuthorName();
						validateByLine();
						verifyFullBio();
						verifyFollowInDeskyop();
						validateContriCarousel();
						
						validateTopAds(OR.ads_Contributor_Page_Top_Ads);
						validateRecAds(OR.ads_BrandVoice_Page_Ads1);
						validateRecAds(OR.ads_BrandVoice_Page_Ads2);
						validateTopxAds(OR.ads_BrandVoice_Page_Ads3);
						
						
						validateContributorTopFeatures();
						verifyDoNotMissLayout();
						
						verifyMostPopular();
					}
					else
					{
						testStepFailed("Not redirected to correct page");
					}
				}
				else
				{
					testStepFailed("Level Up text is not present");
				}
			}
			else
			{
				testStepFailed("Failed to navigate Level Up page");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateByLine()
	{
		
		try {
			boolean byline=elementPresent(OR.txt_LevelUP_Page_Byline);
			if(byline==true)
			{
				String getByline=getText(OR.txt_LevelUP_Page_Byline);
				testStepPassed("Byline is Displayed-"+getByline);
			}
			else
			{
				testStepFailed("Byline is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
}
