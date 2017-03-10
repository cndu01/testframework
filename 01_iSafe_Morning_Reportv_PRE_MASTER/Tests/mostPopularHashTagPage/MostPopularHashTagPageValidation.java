/**
 * Check the ads on the page 
 * Check Market to form display
 * Trending Stories display
 * Most Read Stories display
 * Active on Social Web 
 * Popular Galleries
 * Active Converstation
 * Inside Forbes 

 */

package mostPopularHashTagPage;

import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;

// TODO: Auto-generated Javadoc
/**
 * The Class MostPopularPageValidation. class names are written in mixed case
 * with the first letter of each internal word capitalized
 */
public class MostPopularHashTagPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Most Popular Hashtag Page Validation
	// Created by :Shakira
	// Created on : Jan 2017

	/**
	 * Instantiates a new most popular page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	// ///////////////////////////////////////////////////////////////////////////////
	public MostPopularHashTagPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify most popular page. Methods are written in mixed case with the
	 * first letter lower case, with the first letter of each internal word
	 * capitalized. variables are written in mixed case with the first letter
	 * lower case, with the first letter of each internal word capitalized.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void verifyMostPopularHashTagPage() throws Exception {
		testStepInfo("************************************MOST POPULAR PAGE******************************************");
		// waitTime(10);
		if (currentExecutionMachineName
				.equalsIgnoreCase("NewPosts_MostPopular_Angular")) {
			

			//validatePageLoadTime("http://www.forbes.com/most-popular/?view=prod/",15,"Most Popular Page");
			
			validateTopAds(OR.ad_ColehaanFirstTopad);
			
			validateTopAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validateTopAds(OR.ad_ColehaanSecondTopad);
			scrollBy(0, 2000);
			scrollBy(0, -100);
			waitForElement(OR.ads_Most_Popular_HashTag_Ads);
			waitTime(8);
			validateTopAds(OR.ads_Most_Popular_HashTag_Ads);
			
			//validateMostPopularAds();
			//validateHashtag();
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag1, OR.txt_Most_Popular_HashTag_PromoLists1);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag2, OR.txt_Most_Popular_HashTag_PromoLists2);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag3, OR.txt_Most_Popular_HashTag_PromoLists3);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag4, OR.txt_Most_Popular_HashTag_PromoLists4);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag5, OR.txt_Most_Popular_HashTag_PromoLists5);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag6, OR.txt_Most_Popular_HashTag_PromoLists6);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag7, OR.txt_Most_Popular_HashTag_PromoLists7);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag8, OR.txt_Most_Popular_HashTag_PromoLists8);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag9, OR.txt_Most_Popular_HashTag_PromoLists9);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag10, OR.txt_Most_Popular_HashTag_PromoLists10);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag11, OR.txt_Most_Popular_HashTag_PromoLists11);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag12, OR.txt_Most_Popular_HashTag_PromoLists12);
			
			/*validateHashTagBlocks("HashTagName#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//div[@class='csr-common-stream-header ng-binding']","PromoBlockLists#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//ul[@class='edittools-stream']//h2");
			
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//ul[@class='edittools-stream']//h2");
			
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//ul[@class='edittools-stream']//h2");
			
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix']/li[3]//ul[@class='edittools-stream']//h2");
			*/
			

		} else {
			//validatePageLoadTime("http://www.forbes.com/most-popular/?view=prod/",9,"Most Popular Page");
			//validateMostPopularAdsInMobile();
			waitTime(15);
			validateBottomAds(OR.ad_MobileCSFPageCheck_Stickymobilead);
			validateTopAds(OR.ad_ColehaanFirstTopad);
			this.scrollToElement(OR.ads_Reg_Contributor_Page_TopxAds);
			this.scrollBy(0, 1500);
			validateTopAds(OR.ads_Reg_Contributor_Page_TopxAds);
			this.scrollToElement(OR.ad_ColehaanSecondTopad);
			this.scrollBy(0, 2000);
			validateTopAds(OR.ad_ColehaanSecondTopad);
			this.scrollToElement(OR.ad_ColehaanSecondTopad);
			this.scrollBy(0, 2500);
			validateTopAds(OR.ad_ColehaanSecondTopad);
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag1, OR.txt_Most_Popular_HashTag_PromoLists1);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag2, OR.txt_Most_Popular_HashTag_PromoLists2);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag3, OR.txt_Most_Popular_HashTag_PromoLists3);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag4, OR.txt_Most_Popular_HashTag_PromoLists4);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag5, OR.txt_Most_Popular_HashTag_PromoLists5);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag6, OR.txt_Most_Popular_HashTag_PromoLists6);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag7, OR.txt_Most_Popular_HashTag_PromoLists7);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag8, OR.txt_Most_Popular_HashTag_PromoLists8);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag9, OR.txt_Most_Popular_HashTag_PromoLists9);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag10, OR.txt_Most_Popular_HashTag_PromoLists10);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag11, OR.txt_Most_Popular_HashTag_PromoLists11);
			validateHashTagBlocks(OR.txt_Most_Popular_HashTag_Page_HashTag12, OR.txt_Most_Popular_HashTag_PromoLists12);
			
			
			/*validateHashTagBlocks("HashTagName#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix'or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//div[@class='csr-common-stream-header ng-binding']","PromoBlockLists#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-2']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//ul[@class='edittools-stream']//h2");
			
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-4']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//ul[@class='edittools-stream']//h2");
			
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-6']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//ul[@class='edittools-stream']//h2");
			
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[1]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[2]//ul[@class='edittools-stream']//h2");
			validateHashTagBlocks("HashTagName#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//div[@class='csr-common-stream-header ng-binding hashtag-title']","PromoBlockLists#xpath=//section[@id='row-8']//ul[@class='promo-block-list csf-row-list clearfix' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[3]//ul[@class='edittools-stream']//h2");
			*/
			
			
			
		}

	}
	public void validateMostPopularAds()
	{
		testStepInfo("******************************* Validating Ads ************************************");
		try {
			boolean ads=elementPresent("Ads#xpath=//section//div[contains(@id,'google_ads_iframe')]");
			if(ads==true)
			{
				int count=getElementCount("Ads#xpath=//div[contains(@id,'google_ads_iframe')]");
				//testStepPassed("Total number of Ads present ---"+count);
				for (int i = 2; i <=8; i+=2) 
				{
				
					takeAdScreenshot("Ads#xpath=//section["+i+"]//div[contains(@id,'google_ads_iframe')]", "Ads");
					testStepPassed("Most Popular Ad is Present---"+ads);
				}
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Most Popular Ads are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	
	public void validateMostPopularAdsInMobile()
	{
		testStepInfo("******************************* Validating Ads ************************************");
		try {
			boolean ads=elementPresent("Ads#xpath=//section//div[contains(@id,'google_ads_iframe')]");
			if(ads==true)
			{
				int count=getElementCount("Ads#xpath=//div[contains(@id,'google_ads_iframe')]");
				//testStepPassed("Total number of Ads present ---"+count);
				for (int i = 1; i <=8; i+=2) 
				{
					this.scrollToElement("Ads#xpath=//section["+i+"]//div[contains(@id,'google_ads_iframe')]");
					this.scrollBy(0, -50);
					takeAdScreenshot("Ads#xpath=//section["+i+"]//div[contains(@id,'google_ads_iframe')]", "Ads");
					testStepPassed("Most Popular Ad is Present---"+ads);
				}
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Most Popular Ads are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateHashTagBlocks(String hashTagName,String promoBlockLists)
	{
		testStepInfo("**************************************** Validating Hash Tag *****************************************");	
		
		try {
			this.scrollToElement(hashTagName);
			this.scrollBy(0, -60);
			boolean hashTag=elementPresent(hashTagName);
			if(hashTag==true)
			{
				String getHashTagName=getText(hashTagName);
				testStepPassed("Hash tag name ---"+getHashTagName);
				boolean promoBlock=elementPresent(promoBlockLists);
				if(promoBlock==true)
				{
					int countPromoLists=getElementCount(promoBlockLists);
					testStepPassed("Total Number of Promo Block Lists---"+countPromoLists);
					if(countPromoLists>=3)
					{
						
						testStepPassed("Hash Tag articles are present");
					}
					else
					{
						testStepFailed(" Less than 3 Hash tag articles present");
					}
				}
				else
				{
					testStepFailed("Hash tag articles are not present");
				}
								
					
				/*int countPromoBlockLists=	getElementCount("Section#xpath=//section[@id='row-"+sectionNum+"']//ul[@class='promo-block-list csf-row-list clearfix']/li//h2");
				testStepPassed("Total number of Promo Block lists---"+countPromoBlockLists);*/
				
			}
			else
			{
				testStepFailed("Hash tag is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
	
	
	public void validateMostPopularGallery()
	{
		testStepInfo("********************************* Most Popular Gallery **************************************");
		try {
			
			boolean gallery=elementPresent(OR.txt_Reg_MostPopular_Gallery);
			if(gallery==true)
			{
				int galleryCount=getElementCount(OR.txt_Reg_MostPopular_Gallery);
				testStepPassed("Total number of Galleries"+galleryCount);
				testStepPassed("Most Popular Gallery is displayed");
				
			}
			else
			{
				testStepFailed("Most Popular Gallery is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	/**
	 * Validate socialconnect.
	 */
	public void validateSocialconnect() {

		testStepInfo("******************************** Social connection **************************************");
		waitTime(3);
		try {
			waitForElement(OR.img_Most_Popular_Social_Facebook);
			scrollToElement(OR.img_Most_Popular_Social_Facebook);
			scrollBy(0, -70);
			clickOn(OR.img_Most_Popular_Social_Facebook);
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				waitTime(2);

			}

			driver.close();
			driver.switchTo().window(winHandleBefore);
			testStepPassed("Social Connects are available");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate gallery.
	 *
	 * @throws Exception
	 *             the exception
	 */
	public void validateTrendingStories() throws Exception {
		testStepInfo("*************************************** Trending Stories **************************");
		waitTime(5);
		scrollToElement(OR.txt_Most_Popular_links);
		scrollBy(0, -60);
		waitForElement(OR.txt_Most_Popular_links);
		boolean mostPopular = elementPresent(OR.txt_Most_Popular_links);
		if (mostPopular == true) {
			String mostPopularLink = getText(OR.txt_Most_Popular_links);
			testStepPassed(mostPopularLink);
			testStepPassed("Recently posted Most Popular are displayed");
		} else {
			testStepFailed("Recently posted Most Popular are not displayed");
		}

	}

	/**
	 * Gets the most popular article text.
	 *
	 * @return the most popular article text
	 */
	public String getMostPopularArticleText() {
		String strXpath = "Most Popular Article heading#xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		return this.getText(strXpath);
	}

	/**
	 * Click on most popular article.
	 */
	Actions actions = new Actions(driver);

	/**
	 * Click on most popular article.
	 */
	public void clickOnMostPopularArticle() {
		String strXpath = "Most Popular Article #xpath=//div[@class='stories_wrapper']//ol[@class='all']/li//a";
		this.clickOn(strXpath);
	}

	

	/**
	 * Mobile Script Created On : 22 June 2016.
	 */
	public void verifySocialslidersInMobile() {
		testStepInfo("*************************** Social Sliders ******************************************");
		scrollBy(0, 500);
		waitForElement(OR.img_Mob_Most_Popular_Page_Socialsliders_Twitter);
		try {
			boolean twitter = elementPresent(OR.img_Mob_Most_Popular_Page_Socialsliders_Twitter);
			if (twitter == true) {
				testStepPassed("Twitter is displayed");
			} else {
				testStepFailed("Twitter is not displayed");
			}

			boolean facebook = elementPresent(OR.img_Mob_Most_Popular_Page_Socialsliders_Facebook);
			if (facebook == true) {
				testStepPassed("Facebook is displayed");
			} else {
				testStepFailed("Facebook is not displayed");
			}

			boolean linkedIn = elementPresent(OR.img_Mob_Most_Popular_Page_Socialsliders_LinkedIn);
			if (linkedIn == true) {
				testStepPassed("LinkedIn is displayed");
			} else {
				testStepFailed("LinkedIn is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate popular galleries.
	 */
	/*
	 * public void validatePopularGalleries() { testStepInfo(
	 * "*************************** Popular Gallery ******************************************"
	 * ); try { scrollBy(0, -650); boolean
	 * gallery=elementPresent(OR.btn_Mob_Most_Popular_Page_Galleries);
	 * 
	 * //waitTime(10); if(gallery==true) { waitTime(3);
	 * 
	 * 
	 * swipeToLeft(); waitTime(3);
	 * testStepPassed("Popular Galleries is swipped"); } else {
	 * testStepFailed("Popular Galleries can not be swipped"); }
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * writeToLogFile("ERROR", "Exception: " + e.toString()); } }
	 */

	/**
	 * Verify switch to full website in mobile.
	 */
	public void verifySwitchToFullWebsiteInMobile() {
		testStepInfo("*************************** Switch To Full Website ******************************************");
		scrollBy(0, 150);
		boolean switchToFullWeb = elementPresent(OR.txt_Mob_Most_Popular_Switch_Full_Website);
		if (switchToFullWeb == true) {
			testStepPassed("Switch to full website is displayed");
		} else {
			testStepFailed("Switch to full website is not displayed");
		}
	}

	/**
	 * Author : Shakira Created On : 23 June 2016.
	 */

	public void verifyTopForbesWriterInMobile() {
		testStepInfo("*************************** Top Forbes Writers ******************************************");
		scrollBy(0, 500);
		scrollToElement(OR.img_Mob_Most_Popular_Top_Forbes_Writers);
		boolean topForbesWriters = elementPresent(OR.img_Mob_Most_Popular_Top_Forbes_Writers);
		if (topForbesWriters == true) {
			String writersDetails = getText(OR.txt_Mob_Most_Popular_Top_Forbes_Writers_Details);
			testStepPassed(writersDetails);
			testStepPassed("Top Forbes Writers label is displayed");
		} else {
			testStepFailed("Top Forbes Writers label is not displayed");
		}
	}

}
