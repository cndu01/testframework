/**
 * Check Contributor Home page
 * Check on Contributor Image & Name
 * Click on Follow button
 * Click on Full Bio
 * Click on Show More

 */

package contributorPage;

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
public class ContributorPageValidation extends ApplicationKeywords {

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
	public ContributorPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new contributor page validation.
	 */
	public ContributorPageValidation() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate contributor page.
	 */
	public void validateContributorPage() {
		testStepInfo("************************************************** Contributor Page ****************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Contributor_BrandVoice"))
		{
			//clickOn(OR.txt_Home_User_Zone_US);
			//clickOnMainArticle();
			/*clickOn(OR.img_Article_Page_Contributor);
			verifyAuthorName();
			clickOnBackButton();*/
			boolean articleLink=elementPresent(OR.txt_Home_Page_Top_Stories1);
			if(articleLink==true)
			{
				clickOn(OR.txt_Home_Page_Top_Stories1);
				boolean authorName=elementPresent(OR.txt_Article_Page_Author_Name);
				if(authorName==true)
				{
				String getUrl=getAttributeValue(OR.txt_Article_Page_Author_Name, "href");
				//String appendedURL=getUrl.concat("?view=csf_contrib");
				testStepPassed("Contributor Page Url is -"+getUrl);
				
				validatePageLoadTime(getUrl, 14, "Contributor Page");
				
				verifyAuthorName();
				validateContributorImage();
				validatecontributorDetails(OR.img_Reg_Groupcontributor_Logo,OR.txt_Reg_Contributor_Page_TypeOFContributor);
				validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
				
				validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
				verifyFullBio();
				
				verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
				validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
				/*validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
				validateRecAds(OR.ads_Podcasts_Page_TopAds);
				validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
				validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);*/
				validatePromoVideoBlock();
				validateArchiveContributor();
				//validateLatestPostsImages();
				clickingAllLatestPosts();
				validateMostPopularArticles();
				}
				else
				{
					testStepFailed("Author Name is not displayed");
				}
			}
			else
			{
				testStepFailed("Top Stories First Link is not Displayed");
			}
			
		}
		else
		{
		
			waitTime(3);
			clickOn(OR.txt_Mob_Contributor_Page_Article);
			boolean authorName=elementPresent(OR.txt_Mob_Contributor_Page_Author_Name);
			if(authorName==true)
			{
			String getUrl=getAttributeValue(OR.txt_Mob_Contributor_Page_Author_Name, "href");
			testStepPassed("Contributor Page Url is -"+getUrl);
			
			validatePageLoadTime(getUrl, 16	,"Contributor Page");
			verifyContributorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor);
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			//verifyAuthorNameInMobile();
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			//validateTopAds(OR.ads_Welcome_Page_Ads);
			validateArchiveContributor();
			validateLatestPostsInMobile();
			//validateRecAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
			}
			else
			{
				testStepFailed("Author name is not Displayed");
			}
		
		}
		
	}
	
	

	
}
