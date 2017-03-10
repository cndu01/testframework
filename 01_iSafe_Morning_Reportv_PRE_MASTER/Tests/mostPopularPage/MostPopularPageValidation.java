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

package mostPopularPage;

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
public class MostPopularPageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Most Popular Page Validation
	// Created by :Shakira
	// Created on :13 June 2016

	/**
	 * Instantiates a new most popular page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	// ///////////////////////////////////////////////////////////////////////////////
	public MostPopularPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	
	public void verifyMostPopularPage() throws Exception {
		testStepInfo("************************************MOST POPULAR PAGE******************************************");
		// waitTime(10);
		if (currentExecutionMachineName
				.equalsIgnoreCase("NewPosts_MostPopular_Angular")) {
			
			/*boolean continueToSite=elementPresent(OR.txt_Home_Forbes_Continue_site);
			if(continueToSite==true)
			{
			
				clickOn(OR.txt_Home_Forbes_Continue_site);
			}
			else
			{
				testStepFailed("falied");
			}*/
			
			
			validatePageLoadTime("http://www.forbes.com/most-popular/stats",15,"Most Popular Page");
			this.scrollBy(0, 1500);
			verifySocialWeb();

			waitTime(3);
			verifyRealTimeAds();
			validateTrendingStories();
			// refreshPage();

			validateSocialconnect();
			validateMostRead();
			validateMostPopularGallery();
			
			

		} else {
			validatePageLoadTime("http://www.forbes.com/most-popular/stats",9,"Most Popular Page");
			waitTime(3);
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			verifyTopForbesWriterInMobile();
			verifySocialslidersInMobile();

			verifyRelatedTopicsInMob();
			verifyMostReadOnForbesInMobile();
			verifySwitchToFullWebsiteInMobile();
			// validatePopularGalleries();

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
	 * Gets the contributor details.
	 *
	 * @return the contributor details
	 */
	public void getContributorDetails() {
		testStepInfo("************************Contributor Avatars**********************************");
		waitTime(2);
		int authorCount = getElementCount(OR.txt_Most_Popular_Page_Author);
		testStepPassed("Total Authors/contributors" + authorCount);
		waitTime(2);

		WebElement menu = driver
				.findElement(By
						.xpath("//section[@class='top_writers']//form//div[@class='leaderboard_holder']//ul//li//a"));
		actions.moveToElement(menu).perform();

		waitTime(2);
		String contributorDetails = getText(OR.txt_Most_Popular_Page_Contributor_Details);
		testStepPassed("Contributor Details---" + contributorDetails);
	}

	/**
	 * Mobile Script Created On : 22 June 2016.
	 */
	public void verifySocialslidersInMobile() {
		testStepInfo(" ************************* Social Web ***************");
		try {
			this.scrollToElement(OR.img_Most_Popular_FacebookIcon);
			this.scrollBy(0, -60);
			boolean checkFacebook = elementPresent(OR.img_Most_Popular_FacebookIcon);
			if (checkFacebook == true) {
				clickOn(OR.img_Most_Popular_FacebookIcon);

				boolean facebookLinks = elementPresent(OR.txt_Most_Popular_FacebookLists);
				if (facebookLinks == true) {
					int facebookCount = getElementCount(OR.txt_Most_Popular_FacebookLists);
					testStepPassed("Total Links Present on Facebook--"
							+ facebookCount);
					String facebook = getText(OR.txt_Most_Popular_FacebookLists);
					testStepPassed(facebook);
					testStepPassed("Facebook links are displayed");
				} else {
					testStepFailed("Facebook links are not displayed");
				}

			} else {
				testStepFailed("Facebook Tab is not displayed");
			}

			boolean checkTwitter = elementPresent(OR.img_Most_Popular_TwitterIcon);
			if (checkTwitter == true) {
				clickOn(OR.img_Most_Popular_TwitterIcon);
				boolean twitterLinks = elementPresent(OR.txt_Most_Popular_TwitterLists);
				if (twitterLinks == true) {
					int twitterCount = getElementCount(OR.txt_Most_Popular_TwitterLists);
					testStepPassed("Total Links Present on Twitter--"
							+ twitterCount);
					String twitter = getText(OR.txt_Most_Popular_TwitterLists);
					testStepPassed(twitter);
					testStepPassed("Twitter Links are displayed");
				} else {
					testStepFailed("Twitter links are not displayed");
				}

			} else {
				testStepFailed("Twitter Tab is not displayed");
			}
			
			boolean checkLinkedIn = elementPresent(OR.img_Most_Popular_LinkedInIcon);
			if (checkLinkedIn == true) {
				clickOn(OR.img_Most_Popular_LinkedInIcon);
				boolean linkedInLinks = elementPresent(OR.txt_Most_Popular_LinkedInLists);
				if (linkedInLinks == true) {
					int linkedInCount = getElementCount(OR.txt_Most_Popular_LinkedInLists);
					testStepPassed("Total Links Present on LinkedIn--"
							+ linkedInCount);
					String linkedIn = getText(OR.txt_Most_Popular_LinkedInLists);
					testStepPassed(linkedIn);
					testStepPassed("LinkedIn links are displayed");

				} else {
					testStepFailed("LinkedIn links are not Displayed");
				}

			} else {
				testStepFailed("LinkedIn tab is not displayed");
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
