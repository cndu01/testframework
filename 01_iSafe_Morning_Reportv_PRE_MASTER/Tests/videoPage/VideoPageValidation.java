/**
 * Check the page with ads
 * Check for the video played default.
 * Pause the video
 * Check all the social web icons
 * Check Recommended label with the video stream horizontal.
 * Check next and previous icons
 * Click on the previous and next buttons to check the videos
 * Click on any video from recommended section
 * Check for the featured section
 * Check Most popular section
 * Check Search Forbes Video with search tab and icon
 * Check for the latest videos label

 */

package videoPage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoPageValidation. class names are written in mixed case with the
 * first letter of each internal word capitalized
 */
public class VideoPageValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Video Page Validation
	// Created by :Shakira
	// Created on :14 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new video page validation.
	 *
	 * @param obj
	 *            the obj
	 */
	public VideoPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates a new video page validation.
	 */
	public VideoPageValidation() {

	}

	/**
	 * Verify video page. 
	 */
	public void verifyVideoPage() {
		testStepInfo("********************************** VIDEO *****************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Search_Video")) {
			
			//	String videoURL=getAttributeValue(OR.tab_Home_Page_Video,"href");
			
			
			
//				/String videoURL=getAttributeValue(OR.tab_Home_Page_VideoTab, "href");
				//testStepPassed(""+videoURL);
				validatePageLoadTime("http://www.forbes.com/video", 10,"Video Page");
				try {
					boolean autoPlayVideo = elementPresent(OR.vidHomePageVideo);
					if (autoPlayVideo) {
						waitTime(5);
						testStepPassed("Verified the first video in any landing page is autoplayed");
					} else {
						testStepFailed("Video is not autoplayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					testStepFailed("Video is not displayed");
				}

				validateVideo();
				validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
				validateSocialShares(OR.btn_Video_Page_Social_Web);
				verifyAds();
				verifyRecommended();
				//verifyLoadMoreInDesktop();
				validateFeaturedVideoBlock();
				
				validateMostPopularVideos();
				
				scrollBy(0, 2000);
				validateLatestVideos();
				//validateFeatured();
				
			
			
			
		}
		 else {
			validatePageLoadTime("http://www.forbes.com/video/",16,"Video Page");
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			verifyVideoOnHomePage();
			verifyRecommendedInMobile();
			verifyRelatedTopicsInMob();
			scrollBy(0, 100);
			validateMostReadOnForbes();
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
		}
	}

	
	
	public void validateLatestVideos()
	{
		testStepInfo("***************Latest Videos****************");
		
		try {
			scrollBy(0, 1500);
			boolean mostPopularImg=elementPresent(OR.txt_Reg_Videos_Latest_Videos_Image);
			boolean mostPopularText=elementPresent(OR.txt_Reg_Videos_Latest_Videos_Title);
			if(mostPopularImg==true && mostPopularText==true)
			{
				int countMostPopular=getElementCount(OR.txt_Reg_Videos_Latest_Videos_Title);
				testStepPassed("Total Number of Latest Videos "+countMostPopular);
				if(countMostPopular>=5)
				{
					verifyLoadMoreInDesktop(OR.btn_Reg_Videos_Latest_Videos_LoadMore,"Load More#xpath=//section[@class='latest_video col-sm-8 stream row load_more_container']//ul//li[6]//h4//a");
				}
				else if(countMostPopular<=5)
				{
					testStepPassed("Load More button is not present");
				}
				
			//	openVideoLinkInWindow(videoText);
			}
			else
			{
				testStepFailed("Latest Videos are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateMostPopularVideos()
	{
		testStepInfo("***************Most Popular Videos****************");
		try {
			scrollBy(0, 1500);
			boolean mostPopularImg=elementPresent(OR.img_Video_Most_PopularVideos);
			boolean mostPopularText=elementPresent(OR.txt_Video_Most_PopularVideos);
			if(mostPopularImg==true && mostPopularText==true)
			{
				int countMostPopular=getElementCount(OR.txt_Video_Most_PopularVideos);
				testStepPassed("Total Number of Most popular Videos "+countMostPopular);
				if(countMostPopular>=6)
				{
					verifyLoadMoreInDesktop(OR.btn_Video_Most_Popular_Video_LoadMore,"Load More#xpath=//div[@class='popular_videos row']//ul//li[7]//h4//a");
				}
				else if(countMostPopular<=6)
				{
					testStepPassed("Load More button is not present");
				}
				
			//	openVideoLinkInWindow(videoText);
			}
			else
			{
				testStepFailed("Most Popular Videos are not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void verifyLoadMoreInDesktop(String loadMore,String moreVideos) {
		testStepInfo("***************************** Load More *************************************");
		try {
			scrollBy(0, 1300);
			boolean videoloadMore = elementPresent(loadMore);
			if (videoloadMore == true) {
				clickOn(loadMore);
				boolean latestVideos=elementPresent(moreVideos);
				if (latestVideos==true) {
					String loadedVideo=getText(moreVideos);
					testStepPassed(""+loadedVideo);
					testStepPassed("Verified Load more button is working and loading videos ");
				} 
				else
				{
					testStepFailed("Its not loaded Videos");
				}
				//testStepPassed("Load More button is displayed");
			} else {
				testStepFailed("Load More button is not displayed");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateVideo() {
		testStepInfo("*************************************** Video **************************************");
		boolean video = elementPresent(OR.vidHomePageVideo);
		if (video == true) {
			waitTime(5);
			testStepPassed("Video is displayed");
		} else {
			testStepFailed("Video is not displayed");
		}
	}

	
	public void validateFeaturedVideoBlock()
	{
		testStepInfo("************ FEATURED **************");
		try {
			scrollBy(0, 1000);
			boolean videoPromoBlockImage=elementPresent(OR.img_Video_Page_VideoPromoblock);
			boolean videoPromoBlockText=elementPresent(OR.txt_Video_Page_VideoPromoText);
			if(videoPromoBlockImage==true &&videoPromoBlockText==true)
			{
				this.scrollToElement(OR.txt_Video_Page_VideoPromoText);
				this.scrollBy(0, -60);
				String getFeaturedVideoTitle=getText(OR.txt_Video_Page_VideoPromoText);
				testStepPassed("Featured Video Title is --"+getFeaturedVideoTitle);
				clickOn(OR.txt_Video_Page_VideoPromoText);
				waitTime(4);
				boolean checkVideoBlock=elementPresent(OR.vid_Reg_Home_Page_Video);
				boolean checkVideotitle=elementPresent(OR.txt_Reg_Home_Page_Videos_Title);
				if(checkVideoBlock==true &&checkVideotitle==true)
				{
					String getStandalonePageVideoTitle=getText(OR.txt_Reg_Home_Page_Videos_Title);
					testStepPassed("Standalone Page video is --"+getStandalonePageVideoTitle);
					boolean checkVideoTitle=elementPresent(OR.txt_Video_Page_Standalone_Video);
					boolean checkVideoImage=elementPresent(OR.img_Video_Page_Standalone_Video);
					if(checkVideoTitle==true && checkVideoImage==true)
					{
						String getStandaloneVideoTitle=getText(OR.txt_Video_Page_Standalone_Video);
						if(getStandaloneVideoTitle.equalsIgnoreCase(getStandalonePageVideoTitle))
						{
							testStepPassed("Standalone page side bar video title and video image is matched");
						}
						else
						{
							testStepPassed("Standalone page side bar video title and video image is not matched");
						}
					}
					else
					{
						testStepFailed("Standalone page side bar video title and video image is not displayed");
					}
					testStepPassed("Video is displayed in Standalone page");
					
					validateTopAds(OR.adsHomePageTopAds);
					validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
					
				}
				else
				{
					testStepFailed("Video is not displayed in the standalone page");
				}
				//openVideoLinkInWindow(OR.txt_Video_Page_VideoPromoText);
			}
			else
			{
				testStepFailed("Featured Video promo is not Displayed");
			}
			clickOnBackButton();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Validate featured.
	 */
	public void validateFeatured() {
		testStepInfo("************************************** Featured ****************************************");
		try {
			boolean checkFeaturedVideo=elementPresent(OR.img_Video_Page_Featured);
			if(checkFeaturedVideo==true)
			{
				clickOn(OR.img_Video_Page_Featured);
				waitTime(5);
				boolean checkFeaturelink=elementPresent(OR.txt_Video_Page_Featured_Link);
				if(checkFeaturelink==true)
				{
					String featured = getText(OR.txt_Video_Page_Featured_Link);
					testStepPassed("First video in the Feature" + featured);
				}
				else
				{
					testStepFailed("Featured video title is not present");
				}
			}
			else
			{
				testStepFailed("Feature video block is not present");
			}
			
			// clickOn(OR.vidHomePageVideo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	
	public void validateTopVideo()
	{
		try {
			//boolean videoBlock = elementPresent(OR.vidHomePageVideo);
			boolean autoplayedVideo=elementPresent(OR.vid_Home_Page_Autopalyed);
			boolean skipAds=elementPresent(OR.btn_Reg_Videos_Skip_ads);
			if (autoplayedVideo==true) {
				waitTime(5);
			
				testStepPassed("Video Section is displayed");
				/*if(skipAds==true)
				{
					clickOn(OR.btn_Reg_Videos_Skip_ads);
					testStepPassed("Clicked on the Skip Ads button");
				}
				else
				{
					testStepInfo("Skip Ads button is not Displayed");
				}*/
				testStepPassed("Verified the first video in any landing page is autoplayed");
				
			} else {
				testStepFailed("Video is not autoplayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Video is not displayed");
		}
	}
public void openVideoLinkInWindow(String strPropertykey) {
		
		try{
			String featuredVideoLink = getText(strPropertykey);
			testStepPassed("Featured Link is -"+featuredVideoLink);
			if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
				this.waitForElement(strPropertykey);
				WebElement link = this.driver.findElement(By.xpath((String) this.locator));
				Actions newTab = new Actions(driver);
				newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
				waitTime(5);
				testStepPassed("Openend the article in a new tab");
				//handle windows change
				String base = driver.getWindowHandle();
				Set<String> set = driver.getWindowHandles();
				 
				set.remove(base);
				assert set.size() == 1;
				driver.switchTo().window((String) set.toArray()[0]);
				
				/*String podcastsTitle = getText(strPropertykey);
				testStepPassed("Carousel Link is -"+podcastsTitle);*/
				String title=driver.getTitle();
				testStepPassed("Title of the page "+title);
				if(featuredVideoLink.equalsIgnoreCase(title) || !title.equals("404"))
				{
					testStepPassed("Navigated to correct Featured Page");
					validateTopVideo();
				}
				else
				{
					testStepFailed("Error: redirecting to 404 Page");
				}
			
				
				//close the window
				driver.close();
				driver.switchTo().window(base);
				testStepInfo("Closed the tab");
				// handle windows change and switch back to the main window
				Thread.sleep(2500);
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
						}
			}
		else {
			getCurrentPageURL();
			testStepFailed("No web element found");
			}
		}catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
			}
		
		}
	
	/*public void validateFeaturedVideoBlock()
	{
		testStepInfo("************ FEATURED **************");
		try {
			scrollBy(0, 1000);
			boolean videoPromoBlockImage=elementPresent(OR.img_Video_Page_VideoPromoblock);
			boolean videoPromoBlockText=elementPresent(OR.txt_Video_Page_VideoPromoText);
			if(videoPromoBlockImage==true &&videoPromoBlockText==true)
			{
				openVideoLinkInWindow(OR.txt_Video_Page_VideoPromoText);
			}
			else
			{
				testStepFailed("Featured Video promo is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	*/

	/**
	 * Verify social web.
	 */
	/*public void verifySocialWeb() {
		testStepInfo("************************************** Social Web ******************************************");
		try {
			clickOn(OR.btn_Video_Page_Social_Web);
			String winHandleBefore = driver.getWindowHandle();

			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				waitTime(2);

			}
			boolean email = elementPresent(OR.txt_Home_Page_Facebook_Email);
			if (email == true) {
				testStepPassed("Navigating to Facebook Page");
			} else {
				testStepFailed("Facebook is not available");
			}
			driver.close();

			driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}*/

	/**
	 * Verify ads.
	 */
	public void verifyAds() {
		testStepInfo("***************************************** Ads  *********************************************");
		try {
			boolean topAds = elementPresent(OR.adsHomePageTopAds);
			boolean topxAds = elementPresent(OR.adsHomePageTopxAds);
			if (topAds == true || topxAds == true) {
				testStepPassed("Top Ads in Video Page");
				testStepPassed("Topx Ads in Video Page");
			} else {
				testStepFailed("Top Ads is not present");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify recommended.
	 */
	public void verifyRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		try {
			waitForElement(OR.img_Video_Page_Recommended_Article);
			String varRecommended = getText(OR.img_Video_Page_Recommended_Article);
			testStepPassed("Recommended Article is --" + varRecommended);
			boolean recommNext=elementPresent(OR.btn_Video_Page_Recommended_Next);
			if(recommNext==true)
			{
			clickOn(OR.btn_Video_Page_Recommended_Next);
			// takeAdScreenshot(OR.btn_Video_Page_Recommended_Next,
			// "Next Recommended");
			String varNextRecommended = getText(OR.img_Video_Page_Recommended_Next_Article);
			testStepPassed("Recommended Next Article is --"
					+ varNextRecommended);

			testStepPassed("Verified the first video in any landing page is autoplayed");
			}
			else
			{
				testStepFailed("Recommended Next Button is not working");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Verify load more in desktop.
	 */
	public void verifyLoadMoreInDesktop() {
		testStepInfo("***************************** Load More *************************************");
		try {
			boolean video = elementPresent(OR.txt_Video_Page_Most_Popular_videos);
			if (video == true) {
				testStepPassed("Video is displayed");
			} else {
				testStepFailed("Video is not displayed");
			}
			String loadMore = getText(OR.txt_video_Page_Load_More_Next_Events);
			testStepPassed("Verified the LOAD MORE option is displayed to load more details of the page"
					+ loadMore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate recommended.
	 */
	public void validateRecommended() {
		testStepInfo("*********************************** Recommended **************************************************");
		try {
			String varNext;
			String varXpath = null;
			String varRecom = getText(OR.txt_Video_Page_Recommended);
			testStepPassed(varRecom);
			int nextButton = 2;
			for (nextButton = 2; nextButton <= 3; nextButton++) {

				varNext = "Next#xpath=//ol[@class='flex-control-nav flex-control-paging']//li//a[text()="
						+ nextButton + "]";
				clickOn(varNext);
				takeAdScreenshot(varNext, "recom");
				int profile = 1;
				for (profile = 1; profile < 15; profile++) {
					varXpath = "Recommended Profile#xpath=//div[@class='flex-viewport']//ul[@class='slides clearfix']//li["
							+ profile + "]//a/..//h4";
					if (profile >= 1 || profile <= 15) {
						String recom = getText(varXpath);
						testStepPassed("Recommended Article is--" + recom);
					}

				}

			}

			testStepPassed("Verified the Forbes RECOMMENDED articles are displayed in the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify recommended in mobile.
	 */
	public void verifyRecommendedInMobile() {
		testStepInfo("*********************************** Recommended **************************************************");

		try {
			scrollBy(0, 600);
			String varRecom = getText(OR.txt_Video_Page_Recommended);
			testStepPassed(varRecom);
			boolean nextButton = elementPresent(OR.btn_Mob_Video_Page_Next);
			if (nextButton == true) {
				clickOn(OR.btn_Mob_Video_Page_Next);
				testStepPassed("Recommended Swipe is working");
			} else {
				testStepFailed("Recommended Swipe is working");
			}
		} catch (Exception e) {
			testStepFailed("Recommended Swipe is working");
		}

	}

}
