/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  AutomationFramework.APIKeywords
 *  baseClass.BaseClass
 *  org.openqa.selenium.By
 *  org.openqa.selenium.WebElement
 *  org.openqa.selenium.remote.RemoteWebDriver
 */
package iSAFE;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourspaces.couchdb.test.TestSession;

import AutomationFramework.APIKeywords;
import AutomationFramework.GenericKeywords;
import Utilities.Mailing;
import Utilities.ZipReportFile;
import baseClass.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import objectsRepository.OR;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationKeywords.
 *
 * @author indium
 */

public class ApplicationKeywords extends APIKeywords {

	/**
	 * Instantiates a new application keywords.
	 *
	 * @param obj
	 *            the obj
	 */
	public ApplicationKeywords(BaseClass obj) {
		super(obj);
	}

	/**
	 * Instantiates a new application keywords.
	 */
	public ApplicationKeywords() {
	}

	public static String executionReportStatus = "Pass";
	public static void sendMailOnFailure()
	 {
	  if(executionReportStatus.equals("Fail") && GenericKeywords.getConfigProperty("SendMailOnFailure").equalsIgnoreCase("yes"))
	  {
	   ZipReportFile.zipReport();
	   Mailing.sendMail(".//TestResults//"+GenericKeywords.timeStamp+".zip");
	  }
	 }

	
	
	public void swipeToLeft(int startx,int endx,int starty) 
	{   
	 try {
		/*int startx = 990;  
		  int endx = 40;  
		  int starty = 960;*/
		  writeToLogFile("INFO", "startx = " + startx + " ,endx = " + endx + " , starty = " + starty); 
		  //Swipe from Right to Left. 
		  waitTime(2);
		  ((AndroidDriver)driver).context("NATIVE_APP");
		  testStepPassed("Before Swipe");
		  ((AndroidDriver<WebElement>) driver).swipe(startx, starty, endx, starty, 4000);
		  ((AndroidDriver)driver).context("WEBVIEW");
		  testStepPassed("Swiped to Left");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	/**
	 * Verify social web.
	 */
	public void validateSocialShares(String socialShares) {
		testStepInfo("************************************** Social Web ******************************************");
		try {
			boolean social =elementPresent(socialShares);
			if(social==true)
			{
				int count=getElementCount(socialShares);
				testStepPassed("Social Networks Present"+count);
			}
			else
			{
				testStepFailed("Social Networks are not present");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}
	
	public void validatePageLoadTime(String url,long acceptedLoadTime,String pageName)
	{
		try {
			long start =System.currentTimeMillis();
			driver.get(url);
			long finish=System.currentTimeMillis();
			long totalTime = (finish - start)/1000; 
			//testStepPassed(""+totalTime);
			  testStepPassed("Total Time for page load - "+totalTime+" secs");
			if(totalTime<=acceptedLoadTime)
			{
				testStepPassed(pageName+" Takes Accepted Page Load Time");
			}
			else
			{
				testStepInfo("Warning: "+pageName+" Takes More Than Accepted Page Load time (Accepted Page Load time "+acceptedLoadTime+") secs");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
      
	}
	/**
	 * Take ad screenshot.
	 *
	 * @param element
	 *            the element
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(WebElement element, String screenshotName) {
		try {
			this.driver.executeScript("arguments[0].scrollIntoView();",
					new Object[] { element });
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Take ad screenshot.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @param screenshotName
	 *            the screenshot name
	 */
	public void takeAdScreenshot(String objLocator, String screenshotName) {
		try {
			this.scrollToElement(objLocator);
			this.scrollBy(0, -60);
			this.waitTime(3);
			this.manualScreenshot(screenshotName);
		} catch (Exception e) {
			this.testStepFailed(e.toString());
		}
	}

	/**
	 * Scroll to element.
	 *
	 * @param objLocator
	 *            the obj locator
	 */
	public void scrollToElement(String objLocator) {
		this.waitForElement(objLocator);
		this.driver.executeScript("arguments[0].scrollIntoView();",
				new Object[] { this.webElement });
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) ("Scroll to " + this.locatorDescription));
	}

	/**
	 * Scroll by.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void scrollBy(int x, int y) {
		this.driver.executeScript("window.scrollBy(" + x + "," + y + ")",
				new Object[0]);
		ApplicationKeywords.writeToLogFile((String) "INFO",
				(String) "Scroll to location: ");
	}

	/**
	 * Verify ad.
	 *
	 * @param adNumber
	 *            the ad number
	 */
	public void verifyAd(int adNumber) {
		this.scrollToElement("Ad place holder#id=article-0-ad-" + adNumber);
		this.takeAdScreenshot("Ad " + adNumber + "#id=inline-article-0-ad-"
				+ adNumber, "Ad No:" + adNumber);
	}

	/**
	 * Test step info.
	 *
	 * @param message
	 *            the message
	 */
	public void testStepInfo(String message) {
		this.writeHtmlTestStepReport("<font style='color:blue'>stepNo"
				+ message + "</font><br/>", this.currentExecutionMachineName,
				this.currentTestCaseName);
	}

	/**
	 * Gets the article heading.
	 *
	 * @param articleNumber
	 *            the article number
	 * @return the article heading
	 */
	public String getArticleHeading(int articleNumber) {
		String strXpath = "Article(" + articleNumber
				+ ")#xpath=//article[@id='article-container-" + --articleNumber
				+ "']//h1[@class='article-headline ng-binding ng-scope']";
		return this.getText(strXpath);
	}

	/**
	 * Gets the main article text.
	 *
	 * @return the main article text
	 */
	public String getMainArticleText() {
		String strXpath = "Main Article heading#xpath=//article[@class='feature promostory promostory-1']/div[@class='feature-headline']/h3/a";
		return this.getText(strXpath);
	}

	/**
	 * Click on main article.
	 */
	public void clickOnMainArticle() {
		String strXpath = "Main Article #xpath=//article[@class='feature promostory promostory-1']";
		this.clickOn(strXpath);
	}

	/**
	 * Click on top stories.
	 *
	 * @param topStoryNumber
	 *            the top story number
	 * @return the string
	 */
	public String clickOnTopStories(int topStoryNumber) {
		String strXpath = "Top Stories (" + topStoryNumber
				+ ") #xpath=//li[@class='promostory promostory-"
				+ (topStoryNumber += 2) + " ']/h4/a";
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		strXpath = "Top Story - " + articleLinkText
				+ "#xpath=//li[@class='promostory promostory-" + topStoryNumber
				+ " ']/h4/a";
		this.clickOn(strXpath);
		return articleLinkText;
	}

	/**
	 * Click on most popular.
	 *
	 * @param mostPopularNumber the most popular number
	 * @return the string
	 */
	public String clickOnMostPopular(int mostPopularNumber) {
		String strXpath = "Top Stories ("
				+ mostPopularNumber
				+ ") #xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3[mostPopularNumber]";

		// section[@class='popular_top_stories' or
		// @id='stackMostPopular']//ol//li//h3
		this.scrollToElement(strXpath);
		this.scrollBy(0, -60);
		String articleLinkText = this.getText(strXpath);
		/*
		 * strXpath = "Most Popular- " + articleLinkText +
		 * "#xpath=//li[@class='promostory promostory-" + mostPopularNumber +
		 * " ']/h4/a"; this.clickOn(strXpath);
		 */
		return articleLinkText;
	}

	/**
	 * Go to home page.
	 */
	public void goToHomePage() {
		String strXpath = "Forbes logo#xpath=//article[@id='article-container-0']//header[@class='article-header ng-scope']//a[@href='http://www.forbes.com/']/h1";
		this.clickOn(strXpath);
	}

	/**
	 * Gets the element count.
	 *
	 * @param objLocator
	 *            the obj locator
	 * @return the element count
	 */
	public int getElementCount(String objLocator) {
		int elementCount = 0;
		try {
			this.waitForElement(objLocator);
			elementCount = this.driver.findElements(
					By.xpath((String) this.locator)).size();
			ApplicationKeywords.writeToLogFile((String) "INFO",
					(String) ("Total Elements found for "
							+ this.locatorDescription + ": " + elementCount));
		} catch (Exception e) {
			ApplicationKeywords.writeToLogFile((String) "ERROR",
					(String) ("Exception: " + e.toString()));
		}
		return elementCount;
	}

	/**
	 * Verify ads in mobile article.
	 * */
	public void verifyAdsInMobileArticle() {
		try {
			scrollBy(0, 500);
			boolean ads=elementPresent("Ad Placeholder#xpath=//div[@class='article-mobile-ad ng-scope ng-isolate-scope']");
			if(ads==true)
			{
				String adPlaceHolder = "Ad Placeholder#xpath=//div[@class='article-mobile-ad ng-scope ng-isolate-scope']";
				int adCount = getElementCount(adPlaceHolder);
				testStepPassed("Verifing (" + adCount + ") Ads in the Aritcle Page");
				int adsNum=1;
				for (adsNum = 1; adsNum <= adCount; adsNum++) {

					adCount = getElementCount(adPlaceHolder);
					verifyAd(adsNum);
				}
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Ads are not displayed in Article page");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify ads in desktop article.
	 */
	public void verifyAdsInDesktopArticle() {
		int topAdArticleNo = 0;
		int adRailArticleNo = 0;
		for (int i = 0; i <= 15; i++) {

			if (driver.getPageSource().contains(
					"top-ad-article-" + topAdArticleNo)
					|| driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
				if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)
						&& driver.getPageSource().contains(
								"ad-rail-article-" + adRailArticleNo)) {
					testStepPassed("Top Ad");
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1) + ","
									+ "SideAds" + (adRailArticleNo + 1));
					if (driver.getPageSource().contains(
							"ad-rail-article-" + adRailArticleNo)) {
						int railAdCount = driver
								.findElements(
										By.xpath("//*[@id='ad-rail-article-"
												+ adRailArticleNo
												+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
								.size();
						testStepPassed("Rail Ad Count: " + railAdCount);
						for (int j = 0; j < railAdCount; j++) {
							takeAdScreenshot(
									driver.findElements(
											By.xpath("//*[@id='ad-rail-article-"
													+ adRailArticleNo
													+ "']/div[@ng-repeat-start='ad_unit in ad_units']"))
											.get(j), "SideAds"
											+ (adRailArticleNo + 1));
						}
					}
					topAdArticleNo++;
					adRailArticleNo++;
				} else if (driver.getPageSource().contains(
						"top-ad-article-" + topAdArticleNo)) {
					takeAdScreenshot("Ad " + topAdArticleNo
							+ "#id=top-ad-article-" + topAdArticleNo,
							"topAdArticleNo" + (topAdArticleNo + 1));
					topAdArticleNo++;

				}

			} else {
				((JavascriptExecutor) driver)
						.executeScript("window.scrollBy(0,100)");
			}
		}

	}

	/**
	 * Verify top stories links.
	 */
	public void verifyTopStoriesLinks() {
		testStepInfo("*********************************Top Stories***********************************************");
		int topStoriesCount = getElementCount(OR.lnkTopStories);
		testStepPassed("Total Top Stories: " + topStoriesCount);
		String articleLinkText = clickOnTopStories(1);
		String articleHeading = getArticleHeading(1);
		if (articleHeading.contains(articleLinkText)) {

			testStepPassed("Article Page (" + articleLinkText
					+ ") is displayed");
		} else {
			testStepFailed("Article page (" + articleLinkText
					+ ") is not displayed, instead " + articleHeading
					+ " is displayed");
		}
		clickOnBackButton();
		int articleNo = 0;
		int topStory = 1;
		for (topStory = 1; topStory <= topStoriesCount; topStory++) {

			if (currentExecutionMachineName.startsWith("Desktop")) {
				articleNo = topStory + 1;

			} else {
				articleNo = topStory + 2;
			}

			String strXpath = "Top Stories (" + topStory
					+ ") #xpath=//li[@class='promostory promostory-"
					+ articleNo + " ']/h4/a";
			if (elementPresent(strXpath)) {
				articleLinkText = getText(strXpath);
				testStepPassed("Top Story :" + topStory + " - "
						+ articleLinkText);
			}
		}

	}

	/**
	 * Gets the most popular links.
	 *
	 * @return the most popular links
	 */
	public void getMostPopularLinks() {
		testStepInfo("****************************Most Popular********************************************");
		List<WebElement> allMostLinks = driver
				.findElements(By
						.xpath("//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3"));
		int linksCount = 0;
		for (linksCount = 0; linksCount < allMostLinks.size(); linksCount++) {

			String textMost = allMostLinks.get(linksCount).getText();
			testStepPassed("Most Popular- " + linksCount +  textMost);
			/*
			 * allMostLinks.get(k).click(); clickOnBackButton();
			 */

		}
		//scrollBy(0, 300);
		
	}

	/**
	 * Verify most popular links.
	 */
	public void verifyMostPopularLinks() {
		testStepInfo("*********************************Most Popular***********************************************");
		scrollToElement(OR.txt_Home_Most_Popular_Links);
		scrollBy(0, 300);
		int mostPopular = 1;
		for (mostPopular = 1; mostPopular <= 1; mostPopular++) {
			String strXpath = "Most Popular#xpath=//section[@class='popular_top_stories' or @id='stackMostPopular']//ol//li//h3]";
			clickOn(strXpath);
			String mostPopualrTitle1 = driver.getTitle();
			testStepPassed("Navigated to this page---" + mostPopualrTitle1);
			clickOnBackButton();
		}

	}

	/**
	 * Verify video on home page.
	 */
	public void verifyVideoOnHomePage() {

		testStepInfo("****************************Top Video***************************************");
		try {
			
			/*testStepPassed("Before Video plays");
			takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");*/
			waitTime(5);
			waitForElement(OR.vidHomePageVideo);
			scrollBy(0, 1000);
			scrollToElement(OR.vidHomePageVideo);
			boolean video=elementPresent(OR.vidHomePageVideo);
			if(video==true)
			{
				testStepPassed("Video is displayed");
			}
			else
			{
				testStepFailed("Video is not displayed");
			}
			try {
				boolean playButton = isElementDisplayed(OR.btn_Home_Page_Video_Play_button);
				if (playButton == true) {
					clickOn(OR.btn_Home_Page_Video_Play_button);
					waitTime(5);
					//testStepPassed("Video Played for 5 seconds");
					boolean video1=elementPresent(OR.vidHomePageVideo);
					if(video1==true)
					{
					takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
					//clickOn(OR.vidHomePageVideo);
					getCurrentPageURL();
					}
					else
					{
						testStepFailed("Error on the Video ");
					}
				} else {
					getCurrentPageURL();
					testStepFailed("Video Play button is not loaded");
				}
			} catch (Exception e) {
				testStepFailed("Video is not played");
			}


		} catch (Exception e) {
			testStepFailed("Error occured in the video");
		}
	}

	

	public void validatePromoSection(String promoSection)
	{
		testStepInfo("****************************************** Promo Section ***********************************************");
		try {
			boolean promoBlock=elementPresent(promoSection);
			if(promoBlock==true)
			{
				testStepPassed("Promo Section is displayed");
			}
			else
			{
				testStepFailed("Promo Section is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Verify ad displayed in home page.
	 */
	public void verifyAdDisplayedInHomePage() {

		boolean topAds = elementPresent(OR.adsHomePageTopAds);
		if (topAds == true) {
			testStepInfo("*********************************Top Ad***********************************************");
			waitForElement(OR.adsHomePageTopAds);
			//takeAdScreenshot(OR.adsHomePageTopAds, "Top Ads");
			testStepPassed("Top Ads is displayed");
		}
		else
		{
			testStepFailed("Top Ads is not displayed");
		}
		boolean recAds = elementPresent(OR.adsHomePageRecAds);
		if (recAds == true) {
			testStepInfo("*********************************Rec Ad***********************************************");
			waitForElement(OR.adsHomePageRecAds);
			//takeAdScreenshot(OR.adsHomePageRecAds, "Rec Ads");
			testStepPassed("Rec Ads is displayed");
		}
		else
		{
			testStepFailed("Rec Ads is not displayed");
		}
		boolean topxAds = elementPresent(OR.adsHomePageTopxAds);
		if (topxAds == true) {
			testStepInfo("*********************************Topx Ad***********************************************");
			waitForElement(OR.adsHomePageTopxAds);
			//takeAdScreenshot(OR.adsHomePageTopxAds, "Topx Ads");
			testStepPassed("Topx Ads is displayed");
		}
		else
		{
			testStepFailed("Topx Ads is not displayed");
		}

	}

	/**
	 * Validate most read.
	 */
	public void validateMostRead() {
		testStepInfo("********************************* Most Read **************************************");

		try {
			//waitForElement(OR.txt_Most_Popular_Page_Most_Read);
			//scrollToElement(OR.txt_Most_Popular_Page_Most_Read);
			scrollBy(0, 300);
			boolean varMostRead=elementPresent(OR.txt_Most_Popular_Most_Read);
			
			if(varMostRead==true)
			{
				testStepPassed("Most Read is displayed");
				
			}
			else
			{
				testStepFailed("Most Read is not displayed");
			}
			
			refreshPage();
			waitTime(10);
			scrollBy(0, 400);
			
			//clickOn(OR.txt_Most_Popular_Page_Most_Read);
			try {
				refreshPage();
				waitTime(10);
				boolean mostRead=elementPresent(OR.txt_Most_Popular_Page_Most_Read);
				if (mostRead==true) 
				{
					String mostReadLink=getText(OR.txt_Most_Popular_Page_Most_Read);
					testStepPassed("First Link of the Most Read---"+mostReadLink);
				testStepPassed("Most Read links are displayed");	
				}
				else
				{
					testStepInfo("WARNING:Most Read links are not displayed");	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				testStepInfo("WARNING:Most Read links are not displyed");
			}
			//clickOnBackButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		//testStepPassed("Most Read are displayed");

	}

	/**
	 * Gets the current window handle.
	 *
	 * @return the current window handle
	 */
	public String getCurrentWindowHandle() {
		String windowHandle = null;
		try {
			windowHandle = driver.getWindowHandle();
			writeToLogFile("INFO", "Get Current Window Handle: " + windowHandle);

		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return windowHandle;
	}

	/**
	 * Switch to window using title.
	 *
	 * @param windowTitle the window title
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingTitle(String windowTitle) {
		Boolean flag = false;
		String title = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				title = driver.getTitle();
				if (title.equals("Microsoft Dynamics CRM")) {
					new WebDriverWait(driver, elementLoadWaitTime)
							.until(ExpectedConditions
									.titleContains(" - Microsoft Dynamics CRM"));
				}
				title = driver.getTitle();
				writeToLogFile("INFO", "Window Title: " + title);
				if (title.equalsIgnoreCase(windowTitle)
						|| title.startsWith(windowTitle)) {
					writeToLogFile("INFO", "Switched to window: " + windowTitle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowTitle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Switch to window using handle.
	 *
	 * @param windowHandle the window handle
	 * @return the boolean
	 */
	public Boolean switchToWindowUsingHandle(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}

	/**
	 * Close window.
	 *
	 * @param windowHandle the window handle
	 * @return the boolean
	 */
	public Boolean closeWindow(String windowHandle) {
		Boolean flag = false;
		String handle = null;
		try {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
				handle = driver.getWindowHandle();
				writeToLogFile("INFO", "Window Title: " + handle);
				if (handle.equals(windowHandle)) {
					writeToLogFile("INFO", "Switched to window: "
							+ windowHandle);
					driver.close();
					writeToLogFile("INFO", windowHandle + "Window is closed");
					flag = true;
					break;
				}
			}
			if (!flag) {
				testStepFailed("Please check the window title. window with title("
						+ windowHandle + ") is not present");
			}
		} catch (Exception e) {
			testStepFailed("Window Handle Error :" + e.toString());
		}
		return flag;
	}
	
	public void validateTopAds()
	{
		
		try {
			boolean topAds=elementPresent(OR.adsHomePageTopAds);
			if(topAds==true)
			{
			//manualScreenshot(OR.adsHomePageTopAds);
				testStepPassed("Top Ads is present");
			}
			else {
				testStepFailed("Top Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateRecAds()
	{
		
		try {
			boolean recAds=elementPresent(OR.adsHomePageRecAds);
			if(recAds==true)
			{
			//takeAdScreenshot(OR.adsHomePageRecAds,"Rec Ads");
			testStepPassed("Rec Ads is present---"+recAds);
			}
			else {
				testStepFailed("Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
			writeToLogFile("ERROR", "Exception: " + e.toString());
			}
	}
	public void validateRailRecAds()
	{
		
		try {
			boolean railAds=elementPresent(OR.ads_New_Posts_RailRec_Ads);
			if(railAds==true)
			{
			//takeAdScreenshot(OR.ads_New_Posts_RailRec_Ads,"Rec Ads");
			testStepPassed(" Rail Rec Ads is present---"+railAds);
			}
			else {
				testStepFailed("Rail Rec Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateTextAds()
	{
		
		try {
			boolean topxAds=elementPresent(OR.ads_New_Posts_Text_Ads);
			if(topxAds==true)
			{
			//takeAdScreenshot(OR.ads_New_Posts_Text_Ads,"Rec Ads");
			testStepPassed(" Text Ads is present---"+topxAds);
			}
			else {
				testStepFailed("Text Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateLogeAds()
	{
		
		try {
			boolean logeAds=elementPresent(OR.ads_New_Posts_Loge_Ads);
			if(logeAds==true)
			{
			//takeAdScreenshot(OR.ads_New_Posts_Loge_Ads,"Rec Ads");
			testStepPassed(" Loge Ads is present----"+logeAds);
			}
			else {
				testStepFailed("Loge Ads is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateHeading() {
		try {
			boolean forbesLists = elementPresent(OR.txt_Most_Popular_Page_Heading);
			if (forbesLists == true) {
				String forbesListsHeading = getText(OR.txt_Most_Popular_Page_Heading);
				testStepPassed("" + forbesListsHeading);
				clickOnBackButton();
			} else {
				testStepFailed(" Page is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/*public void verifyBottomAdsInMobile()
	{
		testStepInfo("******************************** Bottom Ads *****************************************");
		waitTime(4);
		boolean mobileAds = elementPresent(OR.ads_Mob_Home_Page_Mobile_Ads);
		if (mobileAds == true) {
			//takeAdScreenshot(OR.ads_Mob_Home_Page_Mobile_Ads, "Mobile Ads");
			testStepPassed("Mobile Ads is present");
		} else {
			testStepFailed("Mobile Ads is not present");
		}
	}
	*/

	public String getCurrentPageURL()
	{
		String currentURL =null;
		try {
			 currentURL=driver.getCurrentUrl();
			testStepPassed("Current Page URL is ---"+currentURL);
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		return currentURL;
	}
	public void verifyQuoteOfTheDay()
	{
		testStepInfo("***************************** Quote of the Day **********************************");
		boolean quote=elementPresent(OR.txt_Home_Forbes_Quote);
		try {
			if(quote==true)
			{
			String txtQuote = getText(OR.txt_Home_Forbes_Quote);
			testStepPassed("Forbes Quote of the Day- is displayed---" + txtQuote);
			}
			else
			{
				testStepFailed("Forbes Quote of the day is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testStepFailed("Forbes Quote of the day is not displayed");
		}
	}
	public void verifyWelcomeAds() {
		testStepInfo("******************************* Welcome Ads ****************************************");
		try {
			boolean welcomeAds = elementPresent(OR.ads_Welcome_Page_Ads);
			if (welcomeAds == true) {
				testStepPassed(" Welcome Ads is displayed");
				//manualScreenshot(OR.ads_Welcome_Page_Ads);
			} else {
				testStepFailed("Welcome Ads is not present");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		testStepFailed("Welcome Ads is not displayed");
		}

	}
	public void validateMostReadOnForbes()
	{
		scrollBy(0,1800);
		scrollBy(0, -60);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes News  is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes News is not displayed");
			}
			boolean mostReadPeople=elementPresent(OR.tab_Mob_Home_Page_Most_Read_People);
			if (mostReadPeople==true) {
				testStepPassed("Most Read on Forbes People  is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes People is not displayed");
			}
			boolean mostReadPlace=elementPresent(OR.tab_Mob_Home_Page_Most_Read_Places);
			if (mostReadPlace==true) {
				testStepPassed("Most Read on Forbes Places  is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes Places is not displayed");
			}
			boolean mostReadCompanies=elementPresent(OR.tab_Mob_Home_Page_Most_Read_Companies);
			if (mostReadCompanies==true) {
				testStepPassed("Most Read on Forbes Places  is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes Places is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void verifyMostReadOnForbesInMobile()
	{
		testStepInfo("*************************** Most Read on Forbes ******************************************");
		scrollBy(0,1500);
		scrollBy(0, -50);
		scrollToElement(OR.txt_Mob_Most_Popular_Most_Read);
		takeAdScreenshot(OR.txt_Mob_Most_Popular_Most_Read, "Most Read");
		waitTime(3);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes News  is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes News is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_People);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes  People is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes People is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_Places);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes  Place is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes Place is  not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		clickOn(OR.tab_Mob_Home_Page_Most_Read_Companies);
		try {
			boolean mostReadNews=elementPresent(OR.txt_Mob_Most_Popular_Most_Read);
			if (mostReadNews==true) {
				testStepPassed("Most Read on Forbes Companies is displayed");
			}
			else
			{
				testStepFailed("Most Read on Forbes Companies is not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	/**
	 * Verify related topics in mob.
	 */
	public void verifyRelatedTopicsInMob()
	{
		testStepInfo("*************************** Related Topics ******************************************");
		try {
			scrollBy(0, 250);
			waitTime(3);
			boolean relatedTopics=elementPresent(OR.txt_Mob_Most_Popular_Related_Topics);
			if (relatedTopics==true) {
				testStepPassed("Related Topics are displayed");
			}
			else
			{
				testStepFailed("Related Topics are not displayed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	

	/**
	 * Verify real time ads.
	 */
	public void verifyRealTimeAds() {
		testStepInfo("************************************* Ads**********************************************");
		
		validateTopAds();
		validateRecAds();
		validateRailRecAds();
		validateTextAds();
		validateLogeAds();
		
		

	}
	
	//3 Aug 2016
	public void verifyLoadMoreInRealTime()
	{
		scrollBy(0, -300);
		
		try {
			int countLinks=getElementCount(OR.txt_New_Posts_Recent_Posts);
			
			testStepPassed("Total Posts displayed-"+countLinks);
			//scrollToElement(OR.btn_Mob_New_Posts_Load_More);
			
			waitTime(3);
			scrollBy(0, 200);
				boolean loadMore=elementPresent(OR.btn_Mob_New_Posts_Load_More);
				if(loadMore==true)
				{
					scrollBy(0, 700);
					//clickOn(OR.btn_Mob_New_Posts_Load_More); 
					testStepPassed("+Load More Button is present");
					/*int totalPosts=getElementCount(OR.txt_New_Posts_Recent_Posts);
				
					//testStepPassed("Total Posts displayed-"+totalPosts);
					if(totalPosts>countLinks)
					{
						testStepPassed("Load More is working");
					}*/
				}
				else
				{
					testStepFailed("+Load More Button is not present");
				}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
			
	
	}
	/**
	  * Verify social web.
	  */
	 public void verifySocialWeb() {
	  testStepInfo(" Social Web ***************");
	  try {
	   
		  this.scrollToElement(OR.icon_Most_Popular_Social_Web_Facebook);
		  this.scrollBy(0, -200);
	   boolean checkFacebook=elementPresent(OR.icon_Most_Popular_Social_Web_Facebook);
	   if(checkFacebook==true)
	   {
	   clickOn(OR.icon_Most_Popular_Social_Web_Facebook);
	   
	   boolean facebookLinks=elementPresent(OR.txt_Most_Popular_Social_Web_Facebook);
	   if(facebookLinks==true)
	   {
	    int facebookCount = getElementCount(OR.txt_Most_Popular_Social_Web_Facebook);
	    testStepPassed("Total Links Present on Facebook--" + facebookCount);
	    String facebook = getText(OR.txt_Most_Popular_Social_Web_Facebook);
	    testStepPassed(facebook);
	    testStepPassed("Facebook links are displayed");
	   }
	   else
	   {
	    testStepFailed("Facebook links are not displayed");
	   }
	   
	   }
	   else
	   {
	    testStepFailed("Facebook Tab is not displayed");
	   }
	   
	   boolean checkTwitter=elementPresent(OR.icon_Most_Popular_Social_Web_Twitter);
	   if(checkTwitter==true)
	   {
	   clickOn(OR.icon_Most_Popular_Social_Web_Twitter);
	   boolean twitterLinks=elementPresent(OR.txt_Most_Popular_Twitter);
	   if(twitterLinks==true)
	   {
	    int twitterCount = getElementCount(OR.txt_Most_Popular_Twitter);
	    testStepPassed("Total Links Present on Twitter--" + twitterCount);
	    String twitter = getText(OR.txt_Most_Popular_Twitter);
	    testStepPassed(twitter);
	    testStepPassed("Twitter Links are displayed");
	   }
	   else
	   {
	    testStepFailed("Twitter links are not displayed");
	   }
	   
	   }
	   else
	   {
	    testStepFailed("Twitter Tab is not displayed");
	   }
	   
	   boolean checkLinkedIn=elementPresent(OR.icon_Most_Popular_Social_Web_LinkedIn);
	   if (checkLinkedIn==true) {
	    clickOn(OR.icon_Most_Popular_Social_Web_LinkedIn);
	    boolean linkedInLinks=elementPresent(OR.txt_Most_Popular_Social_Web_LinkedIn);
	    if(linkedInLinks==true)
	    {
	     int linkedInCount = getElementCount(OR.txt_Most_Popular_Social_Web_LinkedIn);
	     testStepPassed("Total Links Present on LinkedIn--" + linkedInCount);
	     String linkedIn = getText(OR.txt_Most_Popular_Social_Web_LinkedIn);
	     testStepPassed(linkedIn);
	     testStepPassed("LinkedIn links are displayed");

	    }
	    else
	    {
	     testStepFailed("LinkedIn links are not Displayed");
	    }
	    
	   }
	   else
	   {
	    testStepFailed("LinkedIn tab is not displayed");
	   }
	   
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   writeToLogFile("ERROR", "Exception: " + e.toString());
	  }

	 }
	
	public void validateTabs()
	{
		testStepInfo("*************************************** Home Page Tabs ***********************************************");
		try {
			boolean editorsPick=elementPresent(OR.tab_Home_Page_EditorsPicks);
			boolean podCasts=elementPresent(OR.tab_Home_Page_Podcasts);
			boolean mostPopular=elementPresent(OR.tab_Most_Popular);
			boolean lists=elementPresent(OR.tab_Home_Page_Lists);
			boolean videos=elementPresent(OR.tab_Home_Page_Video);
			
			if(editorsPick==true)
			{
				testStepPassed("Editors Picks tab is present");
			}
			else
			{
				testStepFailed("Editors Picks tab is not present");
			}
			if(podCasts==true)
			{
				testStepPassed("Podcasts tab is present");
			}
			else
			{
				testStepFailed("Podcasts Picks tab is not present");
			}
			if(mostPopular==true)
			{
				testStepPassed("Most Popular tab is present");
			}
			else
			{
				testStepFailed("Most Popular tab is not present");
			}
			if(lists==true)
			{
				testStepPassed("Lists tab is present");
			}
			else
			{
				testStepFailed("Lists tab is not present");
			}
			if(videos==true)
			{
				testStepPassed("Video tab is present");
			}
			else
			{
				testStepFailed("Video tab is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	//**********************************Added Contributor Methods on 16/08/2016
	
			public void validateLatestPosts()
			{
				testStepInfo("*************************************** Latest Posts *******************************************");
				try {
					scrollBy(0,2000);
					waitForElement(OR.txt_Contributor_Page_Latest);

					int countPosts=getElementCount(OR.txt_Contributor_Page_Latest);
					testStepPassed("Total Number of Posts are --- "+countPosts);
					for (int i = 1; i <=countPosts; i++)
					{ scrollBy(0, 200);
						String countributorPosts="Contributor Posts#xpath=//span[@ng-controller='ContribNewsController']//div[2]//ul//li["+i+"]//div//div//h3";
						String textPosts=getText(countributorPosts);
						testStepPassed(textPosts);
					}
					if(countPosts==5)
					{
						scrollBy(0, 200);
						verifyShowMoreInDesktop();	
					}
					
				} catch (Exception e) {
					testStepInfo("Show more button is not displayed for this Contributor");
				}
				
			}


			/**
			 * Verify author name.
			 */
			public void verifyAuthorName() {
				try {
					boolean authorName = elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
					if (authorName == true) {
						String contributor = getText(OR.txt_Article_Page_contributor_Forbes_Staff_Name);

						testStepPassed("Navigated to " + contributor+" Page");
						//clickOnBackButton();
					} else {
						getCurrentPageURL();
						testStepFailed("Failed to navigate to the author page");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					testStepFailed("Contributor Name link is broke");
				}
			}
			
			public void verifyFullBio()
			{
				testStepInfo("******************************************** Full Bio *******************************************************");
				try {
					waitTime(3);
					boolean varFullBio=elementPresent(OR.btn_Contributor_Page_Full_Bio);
					if (varFullBio==true) {
						testStepPassed("Full Bio is displayed");
						clickOn(OR.btn_Contributor_Page_Full_Bio);
						String fullBio = getText(OR.txt_Contributor_Page_Full_Bio_Details);
						testStepPassed(fullBio);
						clickOn(OR.btn_Contributor_Page_Full_Bio);
						
					}
					else {
						getCurrentPageURL();
						testStepFailed("Full Bio is not displayed ");	
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
				
			}
			
			public void verifyFollowInDeskyop() {
				testStepInfo("******************************************** Follow *******************************************************");
				try {
					boolean follow = elementPresent(OR.btn_Contributor_Page_Follow);
					if (follow == true) {
						mouseOver(OR.btn_Contributor_Page_Follow);
						waitTime(5);
						validateFollowOnForbes();
						testStepPassed("Follow is displayed");
					} else {
						testStepFailed("Follow is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			public void verifyShowMoreInDesktop()
			{
				testStepInfo("******************************************** Show More *******************************************************");
				try {
					scrollBy(0, 700);
					waitTime(3);
					boolean showMore=elementPresent(OR.btn_Contributor_Page_Show_More);
					if (showMore==true)
					{
					
						//clickOn(OR.btn_Contributor_Page_Show_More);
						testStepPassed("Show More button is displayed");
					}
					else
					{
						testStepFailed("Show More button is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			/**
			 * 
			 */

			public int openArticleLinksInWindow(String strPropertykey,String getPageView) {
				int viewCounts=0;
				try{
					
					String articleLink = getText(strPropertykey);
					testStepPassed("Article Link is -"+articleLink);
					
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
						
waitTime(5);
						/*String getUrl=driver.getCurrentUrl();
						testStepPassed("Current URL------------->"+getUrl);
						String splitURL[]= getUrl.split("\\#");
						String firstPart=splitURL[0];
						String secPArt=splitURL[1];
						testStepPassed(firstPart);
						testStepPassed(secPArt);
						String appendedURL=firstPart.concat("?nobeta");
						driver.get(appendedURL);
						//validatePageLoadTime(appendedURL, 23, "Article Page");
*/						
						
						waitTime(5);
						boolean pageView=elementPresent(getPageView);
						if(pageView==true)
						{
							takeAdScreenshot(getPageView, "Page View count");
						String pageViewCount=getText(getPageView);
						String replaceComma=pageViewCount.replace(",","");
						testStepPassed(replaceComma);
						  viewCounts=Integer.parseInt(replaceComma);
						
						
						testStepPassed("First Time View Count is "+viewCounts);
						}
						else
						{
							testStepFailed("Page View Count is not Displayed");
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
			
				return viewCounts ; 
				}
			/**
			 * Author : Shakira
			 * Created on : 23 June 2016
			 * 
			 */
			public void verifyContributorDetailsInMobile()
			{
				testStepInfo("************************************* Contributor Details ************************************************");
				try {
					boolean authorName=elementPresent(OR.txt_Mob_Contributor_Page_Author_Name);
					if(authorName==true)
					{
						
						clickOn(OR.txt_Mob_Contributor_Page_Author_Name);
						testStepPassed("Author name is displayed");
					}
					else
					{
						testStepFailed("Author name is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			/**
			 * Validate hash tag.
			 */
			public void validateHashTag(String hashTagName) {
				testStepInfo("******************************* Hash Tag ****************************************");
				try {
					boolean hashTag = elementPresent(hashTagName);
					if (hashTag == true) {

						String getHashTag = getText(hashTagName);
						testStepPassed("Hash Tag is Present-" + getHashTag);
						validateHashTagVideo(OR.vid_Reg_Article_Page_HashTag_Video);
						validateVideoTitleOnLeftRail();
					} else {
						testStepInfo("Hash Tag is not Present");

					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());

				}
			}
			
			
			public void validateVideoTitleOnLeftRail()
			{
				testStepInfo("*****************************************Hash Tag Video Title*******************************************");
				
				try {
					boolean leftRailVideo=elementPresent(OR.vid_Reg_Article_Page_HashTag_Video);
					if(leftRailVideo==true)
					{
						mouseOver(OR.vid_Reg_Article_Page_HashTag_Video);
						waitTime(5);
						boolean videoTitle=elementPresent(OR.txt_Article_Page_LeftRailvideo_Title);
						if(videoTitle==true)
						{
							String hashTagVideoTitle=getText(OR.txt_Article_Page_LeftRailvideo_Title);
							testStepPassed("Video Title---> "+hashTagVideoTitle);
							testStepPassed("Video Title is displayed When we mouse hover on Video");
						}
						else
						{
							testStepFailed("Video Title is not Displayed");
						}
						
						
					}
					else
					{
						testStepInfo("Left Rail Video is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			/**
			 * Validate hash tag video.
			 */
			public void validateHashTagVideo(String hashTagVideo) {
				testStepInfo("******************************* Hash Tag Video ****************************************");
				try {
					boolean topVideo = elementPresent(hashTagVideo);
					if (topVideo == true) {
						getCurrentPageURL();
						takeAdScreenshot(hashTagVideo, "Video");
						testStepPassed("Hash Tag Video is Displayed");
					} else {
						testStepInfo("Hash Tag Video is not Displayed");
					}

				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			public void validateLeftRailArticleNavigation(String articleTitle,String LeftRailTitle)
			{
				testStepInfo("******************************* Left Rail Article ****************************************");
				
				try {
					String articleText=getText(articleTitle);
					System.out.println("article text is" +articleText);
					String leftRailText=getText(LeftRailTitle);
					System.out.println("left article text is" +leftRailText);
						if(leftRailText.contains(articleText))
						{
							testStepPassed("Left Rail Article is navigated ");
						}
						else
						{
							testStepInfo("Left Rail Article is not displayed");
						}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
				
			}

			/**
			 * Validate left stream article.
			 */
			public void validateLeftStreamArticle(String leftRailArticle) {
				testStepInfo("******************************* Left Rail Stream Article ****************************************");
				try {
					boolean leftRail=elementPresent(leftRailArticle);
					if(leftRail==true)
					{
					int count = getElementCount(leftRailArticle);
					testStepPassed("Total Number of Left Rail Article-" + count);
					
						testStepPassed("Left Rail Article Stream is Present");
					}
					else
					{
						testStepFailed("Left Rail Article Stream is not Present");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			public void validateFullBio()
			{
				testStepInfo("******************************* Full Bio ****************************************");
				try {
					boolean fullBio=elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
					if(fullBio==true)
					{
						clickOn(OR.btn_Mob_Article_Page_Full_Bio);
						String fullBioDetails=getText(OR.txt_Mob_Article_Page_Full_Bio_Details);
						testStepPassed(fullBioDetails);
						
						testStepPassed("Full Bio is displayed");
						validateFollowOnForbes();
						validateFullBioFilter();
						
						clickOn(OR.btn_Reg_Article_Page_Close);
					}
					else
					{
						testStepFailed("Full Bio is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			public void validateFullBioFilter()
			{
				testStepInfo("******************************* Full Bio Filter****************************************");
				boolean fullBioFilter=elementPresent(OR.tab_Reg_Article_Page_FullBio_Filter);
				if(fullBioFilter==true)
				{

					boolean recentPosts=elementPresent(OR.tab_Reg_Article_Page_RecentPosts);
					boolean popularPosts=elementPresent(OR.tab_Reg_Article_Page_PopularPosts);
					if(recentPosts==true && popularPosts==true)
					{
						testStepPassed("Recent Posts and Popular Posts tabs are present");
					}
					else
					{
						testStepFailed("Recent Posts tab is not present");
					}
							
					
				}
				else
				{
					testStepFailed("Full Bio Tabs are not Displayed");
				}
			}
			public void validateFollowOnForbes()
			{
				try {
					boolean followOnForbes=elementPresent(OR.txt_Reg_Article_Page_Follow_OnForbes);
					if(followOnForbes==true)
					{
						testStepPassed("Follow On Forbes is Displayed");
					}
					else
					{
						testStepFailed("Follow On Forbes is not Displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			public void verifyFollowInMobile()
			{
				testStepInfo("******************************************** Follow *******************************************************");
				try {
					boolean follow=elementPresent(OR.btn_Contributor_Page_Follow);
					if (follow==true) {
						testStepPassed("Follow button is displayed");
						clickOn(OR.btn_Contributor_Page_Follow);
						boolean socialShare=elementPresent(OR.img_Mob_Contributor_Page_Social_Share);
						if (socialShare==true) {
							testStepPassed("Social Shares are displayed");
							clickOn(OR.btn_Mob_Contributor_Page_Close);
						}
						else
						{
							testStepFailed("Social Shares are not displayed");
						}
						
					}
					else
					{
						testStepFailed("Follow button is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
				
			}
			public void verifyAuthorNameInMobile()
			{
				try {
					boolean auhtorImage=elementPresent(OR.img_Mob_Contributor_Page_Author_Image);
					if(auhtorImage==true)
					{
						testStepPassed("Author image is displayed");
					}
					else
					{
						testStepFailed("Author image is not displayed");
					}
					
					
					boolean author=elementPresent(OR.txt_Mob_Contributor_Page_Author);
					if (author==true) {
						String authorName=getText(OR.txt_Mob_Contributor_Page_Author);
						testStepPassed("Author Name is ---"+authorName);
						testStepPassed("Author Name is displayed");
					}
					else
					{
						testStepFailed("Author Name is not displayed");	
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			
			
			
			

			/**
			 * Verify switch to full website in mobile.
			 */
			public void verifySwitchToFullWebsiteInMobile()
			{
				testStepInfo("*************************** Switch To Full Website ******************************************");
				scrollBy(0, 150);
				boolean switchToFullWeb=elementPresent(OR.txt_Mob_Most_Popular_Switch_Full_Website);
				if (switchToFullWeb==true) 
				{
					testStepPassed("Switch to full website is displayed");
				}
				else
				{
					testStepFailed("Switch to full website is not displayed");
				}
			}
			/**
			 * Created On : 24 June 2016
			 */
			
			public void verifyNewPostsInMobile()
			{
				
				try {
					scrollToElement(OR.tab_Mob_Contributor_Page_Posts_Latest);
					scrollBy(0, -60);
					waitTime(3);
					boolean latest=elementPresent(OR.tab_Mob_Contributor_Page_Posts_Latest);
					if(latest==true)
					{
						testStepPassed("Latest tab is displayed");	
						
					}
					else
					{
						testStepFailed("Latest tab is not displayed");	
					}
					//scrollBy(0, 200);
					boolean archive=elementPresent(OR.tab_Mob_Contributor_Page_Posts_Archive);
					if (archive==true) {
						clickOn(OR.tab_Mob_Contributor_Page_Posts_Archive);
						testStepPassed("Archive tab is displayed");
					}
					else
					{
						testStepFailed("Archive tab is not displayed");	
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			
			
			public void validateContriCarousel()
			{
				testStepInfo("******************************************** Validating Carousel Layout *******************************************************");
				scrollBy(0, 300);
				boolean layoutCarousel=elementPresent(OR.img_Contributor_Page_Layout);
				
				if(layoutCarousel==true)
				{
					String title1=getText(OR.txt_Contributor_Page_Title_Post);
					testStepPassed("Cantributor Carousel Layoutis displayed-"+title1);
				try {
					
					boolean nextButton=elementPresent(OR.btn_Contributor_Page_Next);
					if (nextButton==true)
					{
					
						clickOn(OR.btn_Contributor_Page_Next);
						waitTime(3);
						String title=getText(OR.txt_Contributor_Page_Title_Post);
						testStepPassed("Top Feature Name is -"+title);
						testStepPassed("Contributor Carousel  Next Button is Displayed ");
					}
				
					
				} catch (Exception e) {
					testStepFailed("Contributor Carousel Previous & Next Button are not Displayed ");
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
				}
				else
				{
					testStepInfo("Carousel Layout is not Displayed  for this Contributor ");	
				}
			}
			
			public void validateContributorTopFeatures()
			{
				testStepInfo("****************************************** Validating Promo Blog ************************************************");
				try {
					scrollBy(0, 500);
					boolean contributorTopFeaturesLayout=elementPresent(OR.txt_contributor_Page_Top_Features);
					if (contributorTopFeaturesLayout==true)
					{
					
						int countTopFeatures=getElementCount(OR.txt_contributor_Page_Top_Features);
						testStepPassed("Total Top Features-"+countTopFeatures);
						
						for (int i = 1; i <=countTopFeatures; i++)
						{ scrollBy(0, 200);
							String countributorPosts="Contributor Posts#xpath=//div[@class='stack contrib-top-feature clearfix ng-scope']//ul//li["+i+"]//h3";
							String textPosts=getText(countributorPosts);
							testStepPassed(textPosts);
						}
						
						if(countTopFeatures>=1 || countTopFeatures==4)
						{
							validateLatestPosts();
						}
						
					}
					else
					{
						
						testStepInfo("Contributor Top Feature is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			public void verifyAdsContributorPage()
			{
				testStepInfo("******************************************** Validating Ads *******************************************************");
				try {
					boolean topAds=elementPresent(OR.ads_Contributor_Page_Top_Ads);
					if(topAds==true)
					{
						testStepPassed(" Top Ads is present");
					}
					else
					{
						testStepFailed(" Top Ads is not present");
					}
					scrollBy(0, 500);
					boolean recAds=elementPresent(OR.ads_BrandVoice_Page_Ads1);
					if(recAds==true)
					{
						testStepPassed(" Rec Ads is present");
					}
					else
					{
						testStepFailed(" Rec Ads is not present");
					}
					scrollBy(0, 600);
					boolean recAds2=elementPresent(OR.ads_BrandVoice_Page_Ads2);
					if(recAds2==true)
					{
						testStepPassed(" Rec Ads2 is present");
					}
					else
					{
						testStepFailed(" Rec Ads2 is not  present");
					}
					
					//scrollBy(0, 900);
					boolean topxAds=elementPresent(OR.ads_BrandVoice_Page_Ads3);
					if(topxAds==true)
					{
						testStepPassed(" Topx Ads is present");
					}
					else
					{
						testStepFailed(" Topx Ads is not  present");
					}
					
					
					
					
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			
			public void verifyDoNotMissLayout()
			{
				testStepInfo("************************************* Do Not Miss... ****************************************");	
				try {
					//scrollBy(0, 300);
					boolean doNotMiss=elementPresent(OR.txt_Contributor_Page_Do_Not_Miss);
					if (doNotMiss==true)
					{
					 testStepPassed("Do Not Miss Layout is displayed");	
					}
					else
					{
						testStepFailed("Do Not Miss Layout is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			public void verifyMostPopular()
			{
				testStepInfo("************************************* Most Popular ****************************************");
				try {
				
					scrollBy(0, 100);
					int countMostPopular=getElementCount(OR.txt_Contributor_Page_Most_Popular);
					testStepPassed("Total Most Popular Posts"+countMostPopular);
					
					for (int i = 1; i <=countMostPopular; i++)
					{ //scrollBy(0, 500);
						String countributorPosts="Contributor Posts#xpath=//div[@class='contrib-most-popular ng-scope']//ol//li["+i+"]//h3";
						String textPosts=getText(countributorPosts);
						testStepPassed(textPosts);
					} 
					//scrollBy(0,-200);
					boolean showMore=elementPresent(OR.btn_contributor_Page_Show_More);
					if(showMore==true)
					{
						waitTime(3);
						//clickOn(OR.btn_contributor_Page_Show_More);
						testStepPassed("Show More Button is Displayed");
					}
					else
					{
						testStepFailed("Show More Button is not Displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			
			
			
//Home Page
			
			public void validateTopInvestingStories()
			{
				testStepInfo("****************************Top Investing Stories ********************************************");
				try {
					scrollBy(0, 1000);
					boolean topInvestingStories=elementPresent(OR.txt_Home_Page_Top_Investing_Stories);
					if(topInvestingStories==true)
					{
						testStepPassed("Top Investing Stories Label is displayed");
						boolean investingStories=elementPresent(OR.txt_Reg_Home_Page_Top_Investing_Stories);
						if(investingStories==true)
						{
							int topInvestingStoriesCount=getElementCount(OR.txt_Reg_Home_Page_Top_Investing_Stories);
							testStepPassed("Total number of Top Investing Stories---"+topInvestingStoriesCount);
						}
						else{
							testStepFailed("Top Investing Stories Links are not Displayed");	
						}
						
					}
					else
					{
						testStepFailed("Top Investing Stories Label is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			/**
			 * Validate promo video.
			 */
			public void validatePromoVideo() {
				scrollBy(0, 50);
				try {
					boolean promoVideo = elementPresent(OR.txt_Mob_Reg_Home_Page_PromoVideo);
					if (promoVideo == true) {

						clickOn(OR.txt_Mob_Reg_Home_Page_PromoVideo);
						testStepPassed("Video is Displayed");
					} else {
						testStepFailed(" Video is not Displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			public void verifyTopStoryInMobile() {
				waitTime(4);
				scrollBy(0, 70);
				boolean topStory = elementPresent(OR.txt_Mob_Home_Page_Top_Stories);
				if (topStory == true) {
					String topStories = getText(OR.txt_Mob_Home_Page_Top_Stories);
					testStepPassed("First Link of Top Stories ---" + topStories);
				} else {
					testStepFailed("Top Story is not displayed");
				}
			}

			/**
			 * Verify forbes list.
			 */
			public void verifyForbesList() {
				testStepInfo("****************************Forbes List********************************************");
				try {
					scrollBy(0, 2500);
					scrollBy(0, -500);
					//elementPresent(OR.arw_Home_Page_Forbes_List_Prev);
					boolean varForbesList = elementPresent(OR.txt_Home_Page_Forbes_List);
					if(varForbesList==true)
					{
					testStepPassed("Verified the Forbes list is displayed---" + varForbesList);
					scrollBy(0, -200);
					boolean preBtn=elementPresent(OR.arw_Home_Page_Forbes_List_Prev);
					if(preBtn==true)
					{
						clickOn(OR.arw_Home_Page_Forbes_List_Prev);
						int totalCnt=getElementCount(OR.txt_Home_Page_Forbes_Lists_Links);
					
						testStepPassed("Total List of Forbes lists is--" + totalCnt);
					}
					scrollBy(0, -100);
					boolean nextBtn=elementPresent(OR.arw_Home_Page_Forbes_List_Next);

					if(nextBtn==true)
					{
					clickOn(OR.arw_Home_Page_Forbes_List_Next);
					boolean forbesLists = elementPresent(OR.txt_Home_Page_Forbes_List_Name);
					if (forbesLists == true) {
						testStepPassed("Forbes Lists ticker is working");
					} else {
						testStepFailed("Forbes Lists ticker is not working");
					}
					}
					}
					else
					{
						testStepInfo("Forbes Lists is not loaded");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			/**
			 * Verify footer.
			 */
			public void verifyFooter() {
				testStepInfo("******************************Footer**************************************");

				int channel = 1;
				for (channel = 1; channel <= 9; channel++) {
					String footerChannels = "Channels#xpath=//div[@class='channels']//ul[@class='edittools-list']//li["
							+ channel + "]";
					String getChannels = getText(footerChannels);
					testStepPassed("Footer Channels are " + getChannels);
				}

				boolean mediaLLC=elementPresent(OR.txt_Home_Page_Media_Forbes);
				
				if (mediaLLC==true) {
					String mediallc = getText(OR.txt_Home_Page_Media_Forbes);
					testStepPassed("Lower Footer is displayed--" + mediallc);

				} else {
					testStepFailed("Lower Footer is not displayed");
				}

			}

			/**
			 * Verfiy login.
			 */
			public void verfiyLogin() {
				testStepInfo("*******************************Login************************************************");
				try {
					clickOn(OR.img_Home_Page_Login);

					boolean loginButton = elementPresent(OR.btn_Home_Page_Login_Button);
					if (loginButton == true) {
						testStepPassed("Login form is available");
					} else {
						testStepFailed("Login form is not available");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}

			/**
			 * Verify logout.
			 */
			public void verifyLogout() {
				testStepInfo("*******************************Logout************************************************");
				clickOn(OR.btn_Home_Page_Logout);
				boolean logout = elementPresent(OR.btn_Home_Page_Login_Button);
				if (logout == true) {
					testStepPassed("Verified Logout Successfully");
				} else {
					testStepFailed("Failed  to Logout");
				}

			}

			public void verifyForbesBrandVoice() {
				testStepInfo(
						"****************************************** Forbes BrandVoice *****************************************");
				scrollBy(0, 700);
				try {
					waitTime(5);
					boolean brandVoice = elementPresent(OR.txt_Home_Page_BrandVoice);
					boolean brandVoiceLogo = elementPresent(OR.log_Home_Page_BrandVoice);

					scrollBy(0, 100);
					if (brandVoice == true && brandVoiceLogo == true) {
						String brandVoiceName = getText(OR.txt_Home_Page_BrandVoice);
						String getValue = driver.findElement(By.className("str-brand-header")).getAttribute("href");

						String[] brandVoiceValue = getValue.split("/");
						String getBrandVoiceValue = brandVoiceValue[4];
						//testStepPassed(getBrandVoiceValue+""+brandVoiceName);
						
						String bvName=brandVoiceName.replaceAll("\\s+","");
						
						
						//testStepPassed("**************"+bvName);
						//String[] name=brandVoiceName.split(" ");
					//	System.out.println("************************************************************" + getBrandVoiceValue);

						if (bvName.equalsIgnoreCase(getBrandVoiceValue)) {
							testStepPassed(brandVoiceName + "-" + "---Forbes Brand voice is matched---" + getBrandVoiceValue);
							boolean forbesBVlink=elementPresent(OR.txt_Home_Page_Forbes_Branvoice1);
							if(forbesBVlink==true)
							{
								String firstLink=getText(OR.txt_Home_Page_Forbes_Branvoice1);
								testStepPassed("First Link of Forbes BrandVoice is-"+firstLink);
							}
							
							
						}
						else
						{
							testStepFailed("Forbes Brand Voice is not matched");
						}
						
						
						}
					else
					{
						testStepFailed("Forbes Brandvoice Logo and Name is not displayed");
					}
				
					
				} catch (Exception e) {
					testStepFailed("WARNING:   Forbes BrandVoice is not loaded");
				}

			}
			// ************************************************************** MOBILE
			// SCRIPT
			// ********************************************************************

			/**
			 * Validate hamburger menu.
			 */
			public void validateHamburgerMenu() {
				testStepInfo("************************************ Hamburger Menu **************************************");
				boolean hamburgerMenu=elementPresent(OR.txt_Mob_Header_Navigation_Forbes);
				if(hamburgerMenu==true)
				{
				clickOn(OR.txt_Mob_Header_Navigation_Forbes);
				boolean channel = elementPresent(OR.txt_Mob_Header_Navigation_Business_Channel);
				if (channel == true) {
					testStepPassed("Channel is displayed");

					clickOn(OR.txt_Mob_Header_Navigation_Forbes);
				} else {
					testStepFailed("Channel is  not displayed");
				}
				}
				else
				{
					testStepFailed("Hamburger Menu is not Displayed");
				}

			}

			/**
			 * Validate mobile ads in home page.
			 */
			public void validateMobileAdsInHomePage() {
				testStepInfo("************************************ Ads **************************************");
				try {
					scrollBy(0, 600);
					waitTime(5);
					waitForElement(OR.ads_Mob_Home_Page_Top_ads);
					boolean topAds = elementPresent(OR.ads_Mob_Home_Page_Top_ads);
					if (topAds == true) {
						testStepPassed("Mobile Rec Ads is present");

					} else {
						testStepFailed("Mobile Rec Ads is not present");
					}
					validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			/**
			 * Verify home page tabs.
			 */
			public void verifyHomePageTabs() {
				testStepInfo("************************************* Home Page Tabs********************************");
				try {
					waitTime(3);
					clickOn(OR.tab_Mob_Home_Page_Home);
					boolean heading = elementPresent(OR.txt_Mob_Home_Page_Heading);
					if (heading == true) {
						String varHeading = getText(OR.txt_Mob_Home_Page_Heading);
						testStepPassed("Home Tab is working " + varHeading);

					} else {
						testStepFailed("Home Tab is not working ");
					}
					waitTime(5);
					waitForElement(OR.tab_Header_Navigation_New_Post);
					clickOn(OR.tab_Header_Navigation_New_Post);
					boolean newPostsHeading = elementPresent(OR.txt_Mob_Header_Navigation_New_Post);
					if (newPostsHeading == true) {

						String varNewPostsHeading = getText(OR.txt_Mob_Header_Navigation_New_Post);
						testStepPassed("New Posts Tab is working " + varNewPostsHeading);
					} else {
						testStepFailed("New Posts Tab is not working ");
					}
					waitTime(5);
					waitForElement(OR.tab_Mob_Header_Navigation_Most_Popular);
					clickOn(OR.tab_Mob_Header_Navigation_Most_Popular);
					boolean mostPopularHeading = elementPresent(OR.txt_Mob_Home_Page_Most_Popular_Heading);
					if (mostPopularHeading == true) {

						String varMostPopularHeading = getText(OR.txt_Mob_Home_Page_Most_Popular_Heading);
						testStepPassed("Most Popular Tab is working " + varMostPopularHeading);
					} else {
						testStepFailed("Most Popular Tab is not working ");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			/**
			 * Verify most popular see more stories.
			 */
			public void verifyMostPopularSeeMoreStories() {
				testStepInfo(
						"************************************* Most Popular See More Stories********************************");
				try {
					scrollBy(0, 200);
					waitTime(3);
					boolean seeMore = elementPresent(OR.txt_Mob_Home_Page_Most_Popular_See_More);
					if (seeMore == true) {

						testStepPassed("Most Popular See More Option is displayed");
					} else {
						testStepFailed("Most Popular See More Option is not displayed");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}

			/**
			 * Verify home page forbes brand voice.
			 */
			// 20 June 2016
			public void verifyHomePageForbesBrandVoice() {
				testStepInfo("************************************* Forbes BrandVoice********************************");
				try {
					refreshPage();
					scrollBy(0, 300);
					waitTime(4);
					boolean brandVoiceHeading = elementPresent(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
					if (brandVoiceHeading == true) {
						scrollBy(0, 100);
						String getHeading = getText(OR.txt_Mob_Home_Page_Forbes_BrandVoice);
						testStepPassed("Forbes Brandvoice is displayed" + getHeading);
					} else {
						testStepFailed("Forbes BrandVoice is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			/**
			 * Verify home page features.
			 */
			public void verifyHomePageFeatures() {
				testStepInfo("************************************* Features ********************************");

				try {
					scrollBy(0, 400);
					waitForElement(OR.txt_Mob_Home_Page_Feature);
					String feature = getText(OR.txt_Mob_Home_Page_Feature);
					testStepPassed("-" + feature + "-");
					boolean featureLink = elementPresent(OR.txt_Mob_Home_Page_Features_Link);
					if (featureLink == true) {
						String featureLinks = getText(OR.txt_Mob_Home_Page_Features_Link);
						testStepPassed("Feature First Link is ---" + featureLinks);
						testStepPassed("Feature Link is displayed");

					} else {
						testStepFailed("Feature Link is not displayed");
					}

				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			/**
			 * Validate forbes lists in mobile.
			 */
			public void validateForbesListsInMobile() {
				testStepInfo("************************************* Forbes Lists ********************************");
				scrollBy(0, 300);

				boolean forbesList = elementPresent(OR.txt_Mob_Home_Page_Forbes_Lists);
				if (forbesList == true) {
					String forbesLists = getText(OR.txt_Mob_Home_Page_Forbes_Lists);
					// testStepPassed("Forbes Lists First Link is ---" + forbesLists);
					testStepPassed("Forbes Lists is displayed");
				} else {
					testStepFailed("Forbes Lists is  not displayed");
				}

			}

			/**
			 * Validate related topics.
			 */
			public void validateRelatedTopics() {
				testStepInfo("************************************* Related Topics ********************************");
				try {
					scrollToElement(OR.txt_Mob_Home_Page_Related_Topics);
					scrollBy(0, 800);
					waitForElement(OR.txt_Mob_Home_Page_Related_Topics);
					String relatedTopics = getText(OR.txt_Mob_Home_Page_Related_Topics);
					testStepPassed(relatedTopics);
					int relatedTopicsCount = 1;
					for (relatedTopicsCount = 1; relatedTopicsCount <= 4; relatedTopicsCount++) {
						String relatedTopic = "Related Topics#xpath=//div[@id='unit']//ul//li[" + relatedTopicsCount + "]";
						String topic = getText(relatedTopic);
						testStepPassed(topic);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}

			/**
			 * Validate most read.
			 */
			public void validateMostReadInMobile() {
				testStepInfo("********************************* Most Read **************************************");

				try {
					waitForElement(OR.txt_Most_Popular_Page_Most_Read);
					scrollBy(0, 800);

					boolean mostRead = elementPresent(OR.txt_Most_Popular_Page_Most_Read);
					if (mostRead == true) {
						String mostReadLink = getText(OR.txt_Most_Popular_Page_Most_Read);
						testStepPassed(mostReadLink);
						testStepPassed("Most Read is displayed");
					} else {
						testStepFailed("Most Read is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}

			/**
			 * Author : Shakira Created On : 28 June 2016
			 */

			/**
			 * Verify US tab is clicking
			 */
			public void verifyUSUserZone() {
				testStepInfo("********************************* User Zone Tabs **************************************");
				try {
					boolean usTab = elementPresent(OR.txt_Home_User_Zone_US);

					if (usTab == true) {
						// clickOn(OR.txt_Home_User_Zone_US);
						testStepPassed("US tab is displayed");
					} else {
						testStepFailed("US tab is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}

			/**
			 * Verify Europe tab is clicking
			 */
			public void verifyEuropeUserZone() {

				try {
					boolean europeTab = elementPresent(OR.txt_Home_User_Zone_Europe);
					if (europeTab == true) {
						// clickOn(OR.txt_Home_User_Zone_Europe);
						testStepPassed("Europe tab is displayed");
					} else {
						testStepFailed("Europe tab is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}

			/**
			 * Verify Asia tab is clicking
			 */
			public void verifyAsiaUserZone() {

				try {
					boolean asiaTab = elementPresent(OR.txt_Home_User_Zone_Asia);
					if (asiaTab == true) {
						waitTime(3);
						// clickOn(OR.txt_Home_User_Zone_Asia);
						testStepPassed("Asia tab is displayed");
					} else {
						testStepFailed("Asia tab is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}

			/**
			 * Verifying first link of Top stories
			 */
			public void verifyTopStory() {
				testStepInfo("******************** Top Stories ****************************");
				try {
					boolean topStory = elementPresent(OR.txt_Home_Page_Top_Stories1);
					if (topStory == true) {
						String topStories = getText(OR.txt_Home_Page_Top_Stories1);
						testStepPassed("First Link of Top Stories ---" + topStories);
					} else {
						testStepFailed("Top Story is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			/**
			 * 
			 */

			public void verifyFollowForbes() {
				testStepInfo("********************************* Follow Forbes **************************************");
				try {
					int followAvatar = 1;
					for (followAvatar = 1; followAvatar <= 5; followAvatar++) {
						String followForbes = "Follow Forbes#xpath=//div[@class='follow_links']//ul//li[" + followAvatar + "]";
						getText(followForbes);
						boolean follow = elementPresent(followForbes);
						if (follow == true) {

							testStepPassed("Follow On Forbes Avataras are present--" + followAvatar + "-");
						} else {
							testStepFailed("Follow On Forbes Avataras are not present");
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			public void validateGeographyDropDown()
			{
				try {
					boolean geography = elementPresent(OR.txt_Reg_Home_Page_Geography);
					if(geography==true)
					{
						clickOn(OR.txt_Reg_Home_Page_Geography);
						
							testStepPassed("Europe Zone is Displayed");
							testStepPassed("Asia Zone is  Displayed");
							testStepPassed("Usa Zone is Displayed");
						
							
						}
					
					else
					{
						testStepFailed("Geograpgy Drop down is not Displayed");
						testStepFailed("Europe Zone is not Displayed");
						testStepFailed("Asia Zone is not Displayed");
						testStepFailed("Usa Zone is not Displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			/**
			 * Validate geography.
			 */
			public void validateGeography() {
				try {
					boolean geography = elementPresent(OR.txt_Reg_Home_Page_Geography);
					if (geography == true) {
						clickOn(OR.txt_Reg_Home_Page_Geography);

						clickOn(OR.txt_Reg_Home_Page_Eurepo);
						boolean topStories = elementPresent(OR.txt_Reg_Home_Page_TopStories);
						String url = driver.getCurrentUrl();
						if (topStories == true
								&& url.contains("http://www.forbes.com/home_europe/")) {
							testStepPassed("Europe zone is Displyed");
						} else {
							testStepFailed("Europe Zone is not Displayed");
						}

						clickOn(OR.txt_Reg_Home_Page_Geography);
						clickOn(OR.txt_Reg_Home_Page_Asia);
						boolean topStories1 = elementPresent(OR.txt_Reg_Home_Page_TopStories);
						String url1 = driver.getCurrentUrl();
						if (topStories1 == true
								&& url1.contains("http://www.forbes.com/home_asia/")) {
							testStepPassed("Asia zone is Displyed");
						} else {
							testStepFailed("Asia Zone is not Displayed");
						}

						clickOn(OR.txt_Reg_Home_Page_Geography);
						clickOn(OR.txt_Reg_Home_Page_Usa);
						boolean topStories2 = elementPresent(OR.txt_Reg_Home_Page_TopStories);
						String url2 = driver.getCurrentUrl();
						if (topStories2 == true
								&& url2.contains("http://www.forbes.com/home_usa/")) {
							testStepPassed("USA zone is Displyed");
						} else {
							testStepFailed("USA Zone is not Displayed");
						}
					} else {
						testStepFailed("Geography list is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			public void validateSignUpInLevelUp()
			{
				testStepInfo("************************************ Level Up ************************************");
				try {
					boolean signupFor=elementPresent(OR.txt_Reg_Home_Page_SignUpfor);
					if(signupFor==true)
					{
						String signUpfor=getText(OR.txt_Reg_Home_Page_SignUpfor);
						testStepPassed("Sign Up For is Displayed-"+signUpfor);
					}
					else
					{
						testStepFailed("Sign Up For is not Displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}

			public void validateLevelUpLogo(String levelUpIcon)
			{
				scrollBy(0, 300);
				
				try {
					boolean levelUpImg = elementPresent(levelUpIcon);
					
					if (levelUpImg == true) {
						testStepPassed("Level Up Icon is Displayed");
					} else {
						testStepFailed("Level Up Icon is not Displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			public void validateLevelUpLinks() {
				
				scrollBy(0, 200);
				boolean levelUpLinks = elementPresent(OR.txt_Reg_Home_Page_Level_Up_Article);
				if (levelUpLinks == true) {
					int count = getElementCount(OR.txt_Reg_Home_Page_Level_Up_Article);
					for (int i = 1; i <= count; i++) {

						String LeveUPArticle="Level Up article#xpath=//section[@class='level-up' or @class='stack level-up']//div[@class='headline_list']//ul//li["
										+ i + "]//h4//a";
						String getLevelUpArticle=getText(LeveUPArticle);
						testStepPassed(getLevelUpArticle);
					}
				} else {
					testStepFailed("Level Up Articles are not Displayed");
				}

			}
			/**
			 * Verify Video is played
			 */
			public void verifyVideoOnHomePageIniPad() {

				testStepInfo("****************************Top Video***************************************");
				try {

					testStepPassed("Before Video plays");
					takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
					waitTime(3);
					boolean playButton = elementPresent(OR.vidHomePageVideo);
					if (playButton == true) {
						clickOn(OR.vidHomePageVideo);
						waitTime(6);
						testStepPassed("Video Played for 6 seconds");
						takeAdScreenshot(OR.vidHomePageVideo, "Home Page Video");
					} else {
						testStepFailed("Video Play button is not loaded");
					}

				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			
			//Article page
			

			/**
			 * Validate author details.
			 */
			public void validateAuthorDetailsForDesktop() {
				testStepInfo("***************************Author Information*************************");
				try {
					String authorName = getText(OR.txt_Article_Page_Author_Name);
					boolean name=elementPresent(OR.txt_Article_Page_Author_Name);
					if(name==true)
					{
					testStepPassed("Author Name is displayed---" + authorName);
					}
					else
					{
						testStepFailed("Author Name is not displayed");
					}
				} catch (Exception e1) {
					testStepFailed("Author Name is not displayed");
				}
				try {
					boolean varContributor = elementPresent(OR.img_Article_Page_Contributor);
					if (varContributor == true) {
						testStepPassed("Image is displayed with Author Details");
					} else {
						testStepFailed("Image is not displayed");
					}
				} catch (Exception e) {
					testStepFailed("Image is not displayed");
				}

			}
			
			/**
			 * Validate share.
			 */
			public void validateShare() {
				testStepInfo("******************************* Share ****************************************");
				
				waitTime(3);
				try {
					
					boolean facebook=elementPresent(OR.img_Article_Page_Facebook_Share);
					if(facebook==true)
					{
						//clickOn(OR.img_Article_Page_Facebook_Share);
						testStepPassed("Social Share is displayed");
					}
					else
					{
						testStepFailed("Social Share is not displayed"); 
					}
				
					 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			
			}
			
			/**
			 * Validate ads.
			 */
			public void validateAds() {
				testStepInfo("***************************************Article Ads******************************");
				try {
					boolean topAds=elementPresent(OR.ads_Article_Page_Top_Ads);
					if(topAds==true)
					{
						scrollBy(0, 50);
						//takeAdScreenshot(OR.ads_Article_Page_Top_Ads, "TopAds");
						testStepPassed("Top Ads is displayed "+topAds);
					}
					else
					{
						testStepFailed("Top Ads is not displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					testStepFailed("Top Ads is not displayed");
				}

			}

			public void verifyAdsInArticle()
			{
				boolean ads=elementPresent(OR.txt_Article_Page_Ads);
				/*if(ads==true)
				{
					scrollBy(0, 100);
					testStepPassed("Article Ads is present");
				}
				else
				{
					testStepFailed("Article ads is not displayed");
				}*/
				
				try {
					List<WebElement> allAds=driver.findElements(By.xpath("//article[@id='article-container-0'][1]//div[@id='fbs-ad-rail-article-0']//div[@class='ng-scope']"));
					int countAds=allAds.size();
					testStepPassed("Total Number of Ads"+countAds);
					int scrollnum=100;
					for (int count = 1; count <=countAds; count++) {
						scrollBy(scrollnum+100, 100);
						String allArticleAds="Article Ads#xpath=//article[@id='article-container-0'][1]//div[@id='fbs-ad-rail-article-0']//div[@class='ng-scope']["+count+"]";
						boolean adPresent=elementPresent(allArticleAds);
						if (adPresent==true) {
							testStepPassed("Article Ads is displayed--"+count);
							
						}
						else
						{
							testStepFailed("Article Ads is not displayed");
						}
						
					}
				} catch (Exception e) {
					testStepFailed("Article Ads are not loaded properly");
				}
			}
			

			public void validateRevContentInDesktop()
			{
				testStepInfo("*************************************** Ads By RevContent ***************************************");
				scrollBy(0, 2000);
				waitTime(8);
				boolean revContent=elementPresent(OR.txt_Article_Page_RevContent_Desk);
				if(revContent==true)
				{
				testStepPassed("Ads By RevContent is Displayed");	
				}
				else
				{
					testStepFailed("Ads By Revcontent is not Displayed");
				}
				
			}
			
			//Login
			
			public void verifyLoginPage() {

				try {
					waitForElement(OR.txt_Login_Page_User_Name);
					boolean loginUsername=elementPresent(OR.txt_Login_Page_User_Name);
					boolean loginPassword=elementPresent(OR.txt_Login_Page_Password);
					if(loginUsername==true && loginPassword==true)
					{
					typeIn(OR.txt_Login_Page_User_Name, retrieve("txtUserName"));
					typeIn(OR.txt_Login_Page_Password, retrieve("txtPassword"));
					clickOn(OR.btn_Login_Page_Login);
					}
					else
					{
						testStepFailed("Login Page is not Opened");
					}
					waitTime(5);
					// boolean errorMsg =
					// elementPresent(OR.txt_Login_Page_Error_Message);
					// boolean fieldError =
					// elementPresent(OR.txt_Login_Page_Field_Req_Error);
					boolean user = elementPresent(OR.txt_Login_Page_User_Link);
					if (user == true) {

						String userName = getText(OR.txt_Login_Page_User_Link);
						testStepPassed("Logged into this user-" + userName);
						//clickOn(OR.txt_Login_Page_Logout);
						testStepPassed("Login is verified Successfully");

					} else {
						

						testStepFailed("Invalid User Name and Password");

					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			public void verifyLoginForm() {
				try {
					waitTime(5);
					boolean login = elementPresent(OR.txt_Login_Page_Login);
					if (login == true) {
						clickOn(OR.txt_Login_Page_Login);
						waitTime(5);
						// verifyLoginPage();

					} else {
						testStepFailed("Login Link is not displayed");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			//LISTS
			/**
			 * Validate profile.
			 */
			public void validateProfile() {
				testStepInfo("******************************** Profile **********************************");
				validateTopAds();

				try {
					waitForElement(OR.btn_Lists_Page_Next10);
					clickOn(OR.btn_Lists_Page_Next10);
					clickOn(OR.btn_Lists_Page_Previous10);
					waitTime(2);
					boolean billGatesProfile = elementPresent(OR.img_Lists_Page_Profile);
					if (billGatesProfile == true) {
						clickOn(OR.img_Lists_Page_Profile);
						String profileName = getText(OR.txt_Lists_Page_Profile_Name);
						testStepPassed("Profile name is --" + profileName);
						waitTime(2);
						clickOn(OR.btn_Lists_Page_Next);
						clickOn(OR.btn_Lists_Page_Previoust);
						waitTime(3);
						
						waitForElement(OR.btn_Lists_Page_See_Full_Profile);
					
						boolean seeFullProfile = elementPresent(OR.btn_Lists_Page_See_Full_Profile);
						if (seeFullProfile == true) {
							clickOn(OR.btn_Lists_Page_See_Full_Profile);
							String profile = getText(OR.txt_Lsits_Page_Profile_Details);
							testStepPassed("Profile name is --" + profile);
						} else {
							testStepFailed("See Full Profile button is not Dsiplayed");
						}
						waitForElement(OR.btn_Lists_Page_Load_More);
						boolean loadMore = elementPresent(OR.btn_Lists_Page_Load_More);
						if (loadMore == true) {

							testStepPassed("Load More button is Displayed");
							clickOn(OR.btn_Lists_Page_Load_More);
						} else {
							testStepFailed("Load More button is not displayed");
						}
					} else {
						testStepFailed("Profile is not Displayed");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
				clickOnBackButton();

			}
			/**
			 * Verify full list.
			 */
			public void verifyFullList() {
				testStepInfo("******************************** Full Lists **********************************");

				try {
					boolean titleOfPage=elementPresent(OR.txt_Lists_Page_Title);
					if(titleOfPage==true)
					{
						String title = getText(OR.txt_Lists_Page_Title);
						testStepPassed("Navigated to corresponding page --" + title);	
						/*scrollBy(0, 200);
						scrollBy(0, -100);*/
						waitForElement(OR.btn_Lists_Page_Full_List);
						boolean seeFullLists=elementPresent(OR.btn_Lists_Page_Full_List);
						if(seeFullLists==true)
						{
							this.scrollToElement(OR.btn_Lists_Page_Full_List);
							this.scrollBy(0, -60);
						clickOn(OR.btn_Lists_Page_Full_List);
						testStepPassed("See Full Lists button is displayed");
						}
						else
						{
							testStepFailed("See Full lists Button is not Displayed");
						}
					}

					
					waitTime(3);
					boolean lists = elementPresent(OR.txt_Lists_Page_Lists_Of_Ranking);
					if (lists == true) {
						testStepPassed("Verified the user can view the complete list by clicking 'See Full List' button");
					} else {
						testStepFailed("Not loaded the complete list");
					}
				} catch (Exception e) {
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
			
			
			/**
			 * Verify ads in lsits.
			 */
			public void verifyAdsInLsits() {
				testStepInfo("************************************** Topx Ads ********************************************");

				try {
					scrollBy(0, 1000);
					int adsCount = 1;
					for (adsCount = 1; adsCount <= 1; adsCount++) {
						scrollBy(0, 300);
						String varXpath = "Topx Ads#xpath=//tbody[@id='list-table-body']//tr[@class='ad'][" + adsCount + "]";

						scrollToElement(varXpath);

						// clickOn(varXpath);
						waitTime(1);

						takeAdScreenshot(varXpath, "Topx Ads");
						testStepPassed("Topx Ads displayed " + adsCount);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}

			}
			
			
			
	// ************************************************* Sindhu Methods **********************************************
	
			
			//Special Features
			public void verifyColehaanContentsInDesktop(){
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
			
			public void checkSections_ColehaanCSFF(){
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
				
			}
			
			
			public void verifydellContentsInDesktop(){
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
				checkSections_DellSFF();
				
			}
			
			public void checkAdsOnBVCSF(){
				boolean isad1displayed = elementPresent(OR.ad_ColehaanFirstTopad);
				
				if(isad1displayed==true){
					testStepPassed("Dell SF >> First Ad is loaded and displayed");
				}
				else{
					testStepFailed("Dell SF >> First Ad is not loaded and not displayed");
				}
				scrollBy(0,7000);
				waitTime(5);
				boolean isad2displayed = elementPresent(OR.ad_DellSecondAd);
				
				if(isad2displayed==true){
					testStepPassed("Dell SF >> Second Ad is loaded and displayed");
				}
				else{
					testStepFailed("Dell SF >> Second Ad is not loaded and not displayed");
				}
			}
			
			public void checkSections_DellSFF(){
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
				
			}
			
			
			
			public void verifyjohnhancockContentsInDesktop(){
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
				checkSections_JohnHancockSFF();
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
			
			public void checkSections_JohnHancockSFF(){
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
			
			public void verifyKPMGContentsInDesktop(){
				boolean islogo = elementPresent(OR.txt_bvlogo);
				if(islogo==true){
					testStepPassed("BV SF >>BV Logo is displayed");
				}
				else{
					testStepFailed("BV SF >> BV Logo is not displayed");
				}
				boolean istag = elementPresent(OR.txt_bvtag);
				if(istag==true){
					testStepPassed("BV SF >>BV tag line is displayed");
				}
				else{
					testStepFailed("BV SF >> BV tag line is not displayed");
				}
				waitTime(3);
				boolean isheader = elementPresent(OR.txt_KPMGVoice);
				if(isheader==true){
					testStepPassed("BV SF >>BV Header Label is displayed");
				}
				else{
					testStepFailed("BV SF >> BV Header label is not displayed");
				}
				waitTime(3);
				boolean isMissionLinkDisplayed = elementPresent(OR.txt_KPMGVoiceMission);
				boolean isChapterLinkDisplayed = elementPresent(OR.txt_KPMGVoiceChapters);
				if(isMissionLinkDisplayed==true && isChapterLinkDisplayed == true){
					testStepPassed("KPMG SF SF >>Mission and Chapters is displayed");
					clickOn(OR.txt_KPMGVoiceMission);
					boolean isadDisplayed = elementPresent(OR.txt_KPMGVoiceSFAd);
					boolean issectionDisplayed = elementPresent(OR.txt_KPMGMission_Section);
					if(isadDisplayed ==true){
						testStepPassed("KPMG SF >>Ad is displayed");
					}
					else{
						testStepPassed("KPMG SF>>Ad is not displayed");
					}
					if(issectionDisplayed ==true){
						testStepPassed("KPMG SF >>sexction is displayed");
					}
					else{
						testStepPassed("KPMG SF >>Section is not displayed");
					}
				}
				else{
					testStepPassed("KPMG SF >>Mission and Chapters is not displayed");
				}
				clickOnBackButton();
				checktheChapters("//ul[@class='ww-chapters__menu__items']/li");
				
			}
			
			public void checktheChapters(String strXpath){
				try{
					//this.scrollBy(0, 30);
					List<WebElement> elements = driver.findElements(By.xpath(strXpath));
					int count =elements.size();
					 for(int i = 0; i <count; i++){
						 if(elements.get(i).isDisplayed()){
							 testStepPassed("Chpater "+i+" is displayed");
						 }
						 else{
							 testStepPassed("Chapter "+i+" is not displayed");
						 }
					 }
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
				}
			
			
			public void verifyoppenheimerContentsInDesktop(){
				verifySFBVLogoInDesktop();
				waitTime(3);
				checkads("//div[@csf-ad-unit='top']");
				checkSections_OppenheimerSFF();
				
				
			}
			
			public void checkads(String strXpath){
				try{
					this.scrollBy(0, 30);
					List<WebElement> elements = driver.findElements(By.xpath(strXpath));
					int count =elements.size();
					 for(int i = 0; i < count; i++){
						 if(elements.get(i).isDisplayed()){
							 testStepPassed("Ad "+i+" is displayed");
							 scrollBy(0,1200);
						 }
						 else{
							 testStepPassed("Ad "+i+" is not displayed");
						 }
					 }
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						writeToLogFile("ERROR", "Exception: " + e.toString());
					}
				}
			
			public void checkSections_OppenheimerSFF(){
				try{
				testStepInfo("*******validating sections********");
				for(int i=0;i<8;i++){
					String sections="#xpath=//section[@id='row-"+i+"']";
					if(elementPresent(sections)){
						testStepPassed("OppenheimerFunds SF >> Section-"+i+" is loaded and displayed");
					}
					else{
						testStepFailed("OppenheimerFunds SF >> Section-"+i+" is not loaded and not displayed");
					}
				}
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
				
			}
		/**
		 * Verify ad displayed on BV home page.
		 */
		
	public void verifyBVPageAdsInDesktop() {
		try{
			testStepInfo("****************************Ads on Brand Voice Page********************************************");
			
			scrollBy(0, 900);
			List<WebElement> allAdLinks = driver
					.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe')]"));
			if(allAdLinks.size()==3){
			testStepPassed("BV Page validation (BV Ads - Top, Rec, loge ads are displayed)");
			}
			else if(allAdLinks.size()==4){
				testStepPassed("BV Page validation (BV Ads - Top, Rec, loge and mobile ads are displayed)");
				}
			else if(allAdLinks.size()==2){
				testStepInfo("BV Page validation (BV Ads - Two ads of Top, Rec, loge ads are displayed)");
			}
			else{
				testStepFailed("BV Page validation (BV Ads - Top, Rec, loge ads are not displayed)");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Verify show more buttons on BV Page
	 */
	public void checkShowMoreCircleButtons(){
		try{
		testStepInfo("****************************Show more Buttons in Brand Voice Page********************************************");
		scrollBy(0, -200);
		List<WebElement> allShowMoreButtons = driver
				.findElements(By
						.xpath("//div[@class='load-more']/div[@class='circle']"));
		for (int k = 0; k < allShowMoreButtons.size(); k++) {
			scrollBy(0, -100);
			boolean areShowMoreButtonsDisplayed = allShowMoreButtons.get(k).isDisplayed();
			if(areShowMoreButtonsDisplayed==true){
			testStepPassed("BV Page validation (BV ShowMore Buttons - " +""+(k+1)+") "
					+ areShowMoreButtonsDisplayed);
			scrollBy(0, 200);
			}
			else{
				testStepFailed("BV Page validation (BV ShowMore Buttons - " +""+(k+1)+") "
						+ areShowMoreButtonsDisplayed);
			}
		}	
	}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Verify mobile sticky ad
	 */
	public void CheckMobileAd(String strXpath){
		try{
		testStepInfo("*********************************Mobile Sticky Ad Check**********************************");
		boolean galleryAds=elementPresent(strXpath);
		if(galleryAds==true){
			testStepPassed("Mobile Gallery Check (Mobile Gallery sticky ad is displayed on the page");
		}
		else{
			testStepFailed("Mobile Gallery Check (Mobile Gallery sticky ad is not displayed on the page");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
		
		/**
		 * Verify ads displayed on template gallery page
		 */
		public void checkAdsonTemplateGallery(){
			testStepInfo("****************************Ads on Template gallery Page********************************************");
			List<WebElement> allAdLinks = driver
					.findElements(By
							.xpath("//iframe[contains(@id,'google_ads_iframe') and @title='3rd party ad content']"));	
			if(allAdLinks.size()>0){
				testStepInfo("*********************************Ads on the gallery page***********************************************");
				testStepPassed("Gallery Check (Gallery Ads check - "+ allAdLinks.size()+" ads are displayed on the page");
			}
			else{
				testStepFailed("Gallery Check (Gallery Ads check - "+ allAdLinks.size()+" ads are displayed on the page");
			}
		}
		/**
		 * Verify ads displayed on angular gallery page
		 */
		public void checkAdsonAngularGallery(){
			try{
				waitTime(4);
				waitForElement(OR.ads_AngularGalleryCheck_TopAd);
				boolean galleryAds1=elementPresent(OR.ads_AngularGalleryCheck_TopAd);
				if(galleryAds1==true)
				{
					testStepPassed("Angular Gallery --> Top Ad is displayed");
				}
				else
				{
					testStepFailed("Angular Gallery --> Top Ad is not displayed");
				}
				waitForElement(OR.ads_AngularGalleryCheck_RecAd);
				boolean galleryAds2=elementPresent(OR.ads_AngularGalleryCheck_RecAd);
				if(galleryAds2==true)
				{
					testStepPassed("Angular Gallery --> Rec Ad is displayed");
				}
				else
				{
					testStepFailed("Angular Gallery --> Rec Ad is not displayed");
				}
				waitForElement(OR.ads_AngularGalleryCheck_textAd);
				boolean galleryAds3=elementPresent(OR.ads_AngularGalleryCheck_textAd);
				if(galleryAds3==true)
				{
					testStepPassed("Angular Gallery --> Text Ad is displayed");
					
				}
				else
				{
					testStepFailed("Angular Gallery --> Text Ad is not displayed");
				}
				/*scrollBy(0, 300);
				waitForElement(OR.ads_AngularGalleryCheck_bottomAd);
				boolean galleryAds4=elementPresent(OR.ads_AngularGalleryCheck_bottomAd);
				if(galleryAds4==true)
				{
					testStepPassed("Angular Gallery --> Bottom Ad is displayed");
					
				}
				else
				{
					testStepInfo("Angular Gallery --> Bottom Ad is not displayed");
				}
				boolean galleryAds5=elementPresent(OR.ads_AngularGalleryCheck_googleAd);
				if(galleryAds5==true)
				{
					testStepPassed("Angular Gallery --> Google Ad is displayed");
				}
				else
				{
					testStepInfo("Angular Gallery --> Google Ad is not displayed");
				}*/
				}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		/**
		 * Check the images from gallery
		 */
		public void checkImagesInGallery(String slidecount, String nexticon){
			try{
			testStepInfo("*********************************Check the pictures from the gallery**********************************");
			waitTime(3);
			String SlideCount = getText(slidecount);
			String[] parts = SlideCount.split(" of ");
			int toalSlideCount = Integer.valueOf(parts[1]);
			if(toalSlideCount!=0){
				testStepPassed("Gallery Check (Gallery images slide check- "+toalSlideCount+" slides are present in the gallery");
			}
			else{
				testStepInfo("*********************************Number of pictures in gallery is "+toalSlideCount+"**********************************");
			}
			for (int i = 1; i <3; i++) {
				int currentSlideNum = Integer.valueOf(parts[0]);
				waitTime(5);
				waitForElement(nexticon);
				clickOn(nexticon);		
				testStepPassed("Clicked on the next icon of the gallery");
			}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void verifyCSFPageContentsInDesktop(){
			validatePageLoadTime("http://www.forbes.com/actors/?nowelcome",15,"Actors CSF Page");
			checkAdOnCSF();
			isListDisplayed();
			checkImagesOnCSF();
			checkvideosOnCSF();
		}
		public void checkImagesOnCSF(){
			try{
			testStepInfo("*********************************Images check on CSF Page***********************************************");
			List<WebElement> images = driver.findElements(By.xpath("//div[@class='block-image ratio16x9']"));
			for(int i=0;i<images.size();i++){
				if(images.get(i).isDisplayed()){
					 testStepPassed("CSF image" +i +" is displayed");
				}
				else{
					testStepFailed("CSF image" +i +" is not displayed");
				}
			}
			testStepPassed("Number of CSF images displayed: " +images.size());
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void checkvideosOnCSF(){
			try{
			testStepInfo("*********************************Videos check on CSF Page***********************************************");
			List<WebElement> videos = driver.findElements(By.xpath("//div[contains(@class,'video-thumb ratio16x9')]"));
			for(int i=0;i<videos.size();i++){
				if(videos.get(i).isDisplayed()){
					 testStepPassed("CSF video" +i+" is displayed");
				}
				else{
					testStepFailed("CSF video" +i+" is not displayed");
				}
			}	
			 testStepPassed("Number of CSF Videos displayed: "+videos.size());
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void checkAdOnCSF(){
			try{
				waitTime(3);	
				int adCount = getElementCount(OR.ads_CSFPageCheck_allAdsOnCSF);
				testStepInfo("AdCount Upon landing on  CSF Page is"+adCount);
				if(adCount!=0){
					testStepPassed("CSF Page Check : "+ adCount+" ads are displayed on the CSF page");
				}
				else{
					testStepFailed("CSF Page Check : Ads are displayed on the CSF page");
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			}
			
		/**
		 * Verify Lists and overlay on CSF page
		 */
		
		public void isListDisplayed(){
			try{
				testStepInfo("*********************************Top 5 List Check**********************************");
				this.scrollBy(0, 30);
				List<WebElement> elements = driver.findElements(By.xpath("//div[@class='overlay-item-info']"));
				int count =elements.size();
				 for(int i = 0; i < count; i++){
					 if(elements.get(i).isDisplayed()){
						 testStepPassed("Top 5 lists are displayed on the page:: List "+i+" is displayed");
					 }
					 else{
						 testStepFailed("Top 5 lists are not displayed on the page");
					 }
				 }
				 testStepInfo("Number of lists displayed on the page are "+count);
				 
				 elements.get(0).click();
				 
				 if(elementPresent((OR.txt_CSFPageCheck_overlayAd)) &&
						 elementPresent(OR.txt_CSFPageCheck_prevButtonOnOverlay) &&
				 elementPresent(OR.txt_CSFPageCheck_nextButtonOnOverlay))
				 
				 {
					 testStepPassed("CSF Overlay ad , next and prev buttons are displayed on the Overlay window ");
				 }
				 else{
					 testStepFailed("CSF Overlay ad , next and prev buttons are not displayed on the Overlay window ");
					 takeAdScreenshot(OR.txt_CSFPageCheck_overlayAd, "Overlay Ad");
				 }
				 clickOn(OR.closeButton);	
			}catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			}
		
		public void isListDisplayedOnMobile(String strXpath){
			try{
				this.scrollBy(0, 30);
				List<WebElement> elements = driver.findElements(By.xpath(strXpath));
				int count =elements.size();
				 for(int i = 0; i < count; i++){
					 if(elements.get(i).isDisplayed()){
						 testStepPassed("List Check (Displayed -:: "+i);
					 }
					 else{
						 testStepFailed("List Check (Not Displayed -:: "+i);
					 }
				 }
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					writeToLogFile("ERROR", "Exception: " + e.toString());
				}
			}
		//Added on 7/28 by Sindhu
		/**
		 * Fluent wait for the element to appear
		 */
		public void fluentwaitforVisibility(String strXpath){
		try{
			
			FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver);
			fwait.withTimeout(30, TimeUnit.SECONDS);
			fwait.pollingEvery(2, TimeUnit.SECONDS);
			fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strXpath)));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		}
		
		/**
		 * Fluent wait for the element to appear - Added by sindhu on 8/17
		 */
		public void WEBCLICK_ListElement(String strPropertykey, int i) {
		try{
			if(this.driver.findElements(
					By.xpath((String) this.locator))!=null){
			this.waitForElement(strPropertykey);
			this.driver.findElements(
					By.xpath((String) this.locator)).get(i).click();
			ApplicationKeywords.writeToLogFile((String) "INFO",
					(String) ("Clicked on the Element "
							+ this.locatorDescription + ": " + i));
			 testStepPassed("Clicked on -:: "+i +"element");
			 webElement.sendKeys(Keys.ENTER);
			 }else{
				 testStepPassed("No web element found");
			 }
		} catch (Exception e) {
		writeToLogFile((String) "ERROR",(String) ("Exception: " + e.toString()));
		}
		}
		
		public String openArticleInNewtab(String strPropertykey, String str2) throws InterruptedException{
			String textOnlandingpage = null;
		try{
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
				textOnlandingpage = getText(str2);
				waitTime(3);
				
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
		return textOnlandingpage;
		}
		
		public void verifyArticleTextsInNewtab(String articletext, String articletoclick,String validatearticletxt) {
			testStepInfo("**************************************Article Page******************************************");
			try {
				String str1 = getText(articletext);
				testStepPassed("Article Text is -"+str1);
				String str2 = openArticleInNewtab(articletoclick,validatearticletxt);
				testStepPassed("Landed Article Page is -"+str2); 
				
				 if(!str2.equals("4-0-"))
				{
					testStepPassed("Article is navigated to article page in a new tab");
					
				}
				
				else{
					getCurrentPageURL();
					testStepFailed("Article page is throwing 404 error ");
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		
		}
		public void verifySFBVLogoInDesktop(){
			try{
	
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
			}catch (Exception e) {
				writeToLogFile((String) "ERROR",(String) ("Exception: " + e.toString()));
				}
}
		
		
		//Redesign Page

		
		public void validateContributorImage()
		{
			try {
				boolean contribImage=elementPresent(OR.img_Reg_Contributor_Page_ContributorImage);
				if(contribImage==true)
				{
					testStepPassed("Contributor Image is Displayed");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Contributor Image is not Displayed");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		public void validateOurWriters()
		{
			testStepInfo("*********************************** Our Writer ************************************");
			try {
				//scrollBy(0, 200);
				boolean writerLabel=elementPresent(OR.txt_Reg_Group_Contributor_WriterLAbel);
				if(writerLabel==true)
				{
					testStepPassed("Our writer Label is Displayed");
				}
				else
				{
					testStepFailed("Our Writer Label is not Displayed");
				}
				boolean writerLists=elementPresent(OR.img_Reg_Group_Contributor_WritersList);
				if(writerLists==true)
				{
					int countWriters=getElementCount(OR.img_Reg_Group_Contributor_WritersList);
					testStepPassed("Total number of Writers --->"+countWriters);
					
					boolean loadMore=elementPresent(OR.btn_Reg_Group_Contributor_LoadMore);
					if(loadMore==true)
					{
						this.scrollToElement(OR.btn_Reg_Group_Contributor_LoadMore);
						this.scrollBy(0, -60);
						clickOn(OR.btn_Reg_Group_Contributor_LoadMore);
						
						int countOurWriters=getElementCount(OR.img_Reg_Group_Contributor_WritersList);
						testStepPassed("After clicking on Load More Total number of Writers --->"+countOurWriters);
						if(countOurWriters>countWriters)
						{
							testStepPassed("Writers are loaded after clicking on Load more button");
							//scrollBy(0, 500);
							boolean loadMoreLess=elementPresent(OR.btn_Reg_Group_Contributor_LoadMoreLess);
							if(loadMoreLess==true)
							{
								this.scrollToElement(OR.btn_Reg_Group_Contributor_LoadMoreLess);
								this.scrollBy(0, -60);
								clickOn(OR.btn_Reg_Group_Contributor_LoadMoreLess);
							}
							else
							{
								testStepFailed("Load more Less Button is not Displayed");
							}
						}
						else
						{
							testStepFailed("Writers are not loaded after clicking on Load more button");
						}
					}
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
				
			
		}
		
		public void validateWritersHomePage()
		{
			testStepInfo("********************************* Writer Page***********************************");
			try {
				boolean writerLists=elementPresent(OR.img_Reg_Group_Contributor_WritersList);
				if(writerLists==true)
				{
					for (int i = 1; i <=1; i++) {
						this.scrollToElement("Writers List#xpath=//div[@class='writers clearfix ng-scope']//ul//li[1]//img");
						this.scrollBy(0, -60);
						clickOn("Writers List#xpath=//div[@class='writers clearfix ng-scope']//ul//li[1]//img");
						boolean writerName=elementPresent(OR.txt_Reg_GroupContributor_WriterName);
						if(writerName==true)
						{
							String getWriterName=getText(OR.txt_Reg_GroupContributor_WriterName);
							testStepPassed("Writer Name is ---->"+getWriterName);
							
							scrollBy(0, 800);
							boolean writersBio=elementPresent(OR.txt_Reg_Group_Contributor_WriterBio);
							if(writersBio==true)
							{
								String getWritersBio=getText(OR.txt_Reg_Group_Contributor_WriterBio);
								testStepPassed("Writer's bio--->"+getWritersBio);
								boolean viewAllPosts=elementPresent(OR.btn_Reg_Group_Contributor_View_All_Posts);
								if(viewAllPosts==true)
								{
									scrollToElement(OR.btn_Reg_Group_Contributor_View_All_Posts);
									scrollBy(0, -60);
									clickOn(OR.btn_Reg_Group_Contributor_View_All_Posts);
									waitTime(5);
									String title=driver.getTitle();
									testStepPassed("Title of the Page-->"+title);
										//String getWriterName1=getText(OR.txt_Reg_GroupContributor_WriterName);
										//testStepPassed("Writer Name is ---->"+getWriterName1);
										/*if(title.contains(getWriterName))
										{
											testStepPassed("Writer Name is matching");
										}
										else
										{
											testStepFailed("Writer Name is not matched");
										}*/
									
									clickOnBackButton();
									waitTime(5);
								}
							}
						}
						
					}
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		
		public void validateVoiceLogo(String forbesLogo,String voiceLogo,String VoiceName)
		{
			testStepInfo("*********************************Validating Voice Logo********************************");
			try {
				boolean forbesCommVoiceLogo=elementPresent(forbesLogo);
				boolean communityVoiceLogo=elementPresent(voiceLogo);
				if(forbesCommVoiceLogo==true )
				{
					testStepPassed("Forbes "+VoiceName+" Logo is Displayed");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Forbes  "+VoiceName+" Logo is not Displayed");
				}
				if(communityVoiceLogo==true)
				{
					testStepPassed(""+VoiceName+" Logo is Displayed");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed(""+VoiceName+" Logo is not Displayed");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}

		public void validateContributorImage(String contribImage)
		{
			
			try {
				boolean contribImg=elementPresent(contribImage);
				if(contribImg==true)
				{
					testStepPassed("Contributor Image is Displayed");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Contributor Image is not Displayed");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		
		public void validatePromoSectionInBrandVoice()
		{
			testStepInfo("*********************************Validating Promo Section********************************");
			try {
				boolean promo = elementPresent(OR.txt_Reg_Brandvoice_Article_Page_Promo);
				if (promo == true) {
					testStepPassed("BV Promo block is displayed");
					//openArticlesInNewWindow(OR.txt_Reg_Brandvoice_Article_Page_Promo);
				} else {
					testStepInfo("Promo Section is not Displayed");
				}

				boolean promoRelatedArticles = elementPresent(OR.txt_Reg_Brandvoice_PromoBlockRelated_Articles);
				if (promoRelatedArticles == true) {

					int countRelatedArticles = getElementCount(OR.txt_Reg_Brandvoice_PromoBlockRelated_Articles);
					testStepPassed("Related Articles in Promo Section--->"
							+ countRelatedArticles);
					for (int i = 1; i <= countRelatedArticles; i++) {
						String relatedArticles=getText("Related Articles#xpath=//ul[@class='related-articles clearfix']//li["
								+ i + "]//h3/span");
						testStepPassed("Promo Block Articles are displayed");
						/*openArticlesInNewWindow("Related Articles#xpath=//ul[@class='related-articles clearfix']//li["
								+ i + "]//h3/span");*/
					}
				} else {
					testStepInfo("Related Articles are not Present in the Promo Section");
				}

			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}
		
		public void validateFilterTabs()
		{
			testStepInfo("******************************Validating BrandVoice Filter Tabs*********************");
			boolean tabs=elementPresent(OR.tab_Reg_BrandVoice_AllTab);
			if(tabs==true)
			{
				int countTabs=getElementCount(OR.tab_Reg_BrandVoice_AllTab);
				testStepPassed("Total number of Tabs--->"+countTabs);
				for (int i = 2; i <=countTabs; i++) {
					boolean checkTabs=elementPresent("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["+i+"]/a");
					if(checkTabs==true)
					{
						String tabNameInFilter=getText("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["+i+"]/a");
						testStepInfo("************************Validating the filter---->"+i+""+tabNameInFilter+"***************");
						this.scrollToElement("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["+i+"]/a");
						this.scrollBy(0, -60);
						clickOn("Brandvoice Tabs#xpath=//div[@class='sub-blogs-list ng-scope']//li["+i+"]/a");
						/*String url=driver.getCurrentUrl();
						testStepPassed(url);
						String[] splittedUrl= url.split("#");
						String firstPart=splittedUrl[0];
						String secPart=splittedUrl[1];
						testStepPassed(firstPart);
						//testStepPassed(secPart);
						String appenedURL=firstPart.concat("?view=csf_contrib");
						driver.get(appenedURL);
						scrollBy(0, 400);*/
						
						testStepInfo("*******************************Validating Tab name with Latest********************************");
						boolean tabName=elementPresent(OR.txt_Reg_BrandVoice_TabNameInLatest);
						if(tabName==true)
						{
							String getTabName=getText(OR.txt_Reg_BrandVoice_TabNameInLatest);
							testStepPassed("Tab Name in the Latest---->"+getTabName);
							String[] splitString=getTabName.split("LATEST IN");
							String sec=splitString[1];
							String removeSpace[]=sec.split("\\s");
							String s1=removeSpace[0];
							String s2=removeSpace[1];
							//testStepPassed(s1);
							//testStepPassed(s2);
							testStepPassed("-"+sec);
							
							if(tabNameInFilter.contains(s2))
							{
								testStepPassed("Filter Tab name is matching in Latest ");
							}
							else
							{
								getCurrentPageURL();
								testStepFailed("Filter Tab name is not matching in Latest ");
							}
						}
						else
						{
							testStepFailed("Tab Name is not Displayed");
						}
						
						clickOnBackButton();
					}
					else {
						getCurrentPageURL();
						testStepFailed("BrandVoice Tab is not Displayed-->"+i);
					}
					
				}
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("BrandVoice Tab is not Displayed");
			}
		}
		
		public void validateTabNameInLatest()
		{
			boolean tabName=elementPresent(OR.txt_Reg_BrandVoice_TabNameInLatest);
			if(tabName==true)
			{
				String getTabName=getText(OR.txt_Reg_BrandVoice_TabNameInLatest);
				testStepPassed("Tab Name in the Latest---->"+getTabName);
				String[] splitString=getTabName.split("LATEST IN");
				String sec=splitString[1];
				testStepPassed("-"+sec);
			}
			else
			{
				testStepFailed("Tab Name is not Displayed");
			}
		}
		
		
		
		
		public void validateLatestPostsInMobile()
		{
			testStepInfo("********************************Clicking on all the articles in Latest and Validating******************");
			try {
				//scrollBy(0, 300);
				
				boolean latestPosts=elementPresent(OR.txt_Reg_Contributor_Page_LatestPosts);
				if(latestPosts==true)
				{
					int count=getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
					testStepPassed("Total Number of Posts in Latest-"+count);
					
						for( int i=1;i<=count;i++){
							
							boolean latestPostslinks=elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']//h2//span");
							boolean latestPostsImages=elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
							//boolean latestGallery=elementPresent("Latest Gallery#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//a[@class='fs-bg-image article-image ratio1x1 stream-gallery']");
							if(latestPostslinks==true &&latestPostsImages==true )
							{
								
								
								String getLatestPostsLinks=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
								testStepPassed("Latest Posts Article Name--->"+i+"--->"+getLatestPostsLinks);
								this.scrollToElement("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
								this.scrollBy(0, -60);
								//takeAdScreenshot("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2", "Latest Posts");
							//clickOn("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
								//validateHeadLineArticleInMobile();
								
								
								
								//scrollBy(0, 80);
							}
						
							else
							{
								getCurrentPageURL();
								String latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream' or @class='promo-block-list csf-row-list clearfix csf-mobile-row']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
								testStepPassed("Name of the Latest Post --->"+latestPostsLinkName);
								testStepInfo("Latest Posts Image is not displayed--->"+i);
							}
						}
						
						testStepInfo("***************************************** Validating Show More Button********************************************");
						boolean showMore=elementPresent(OR.btn_Reg_Contributor_Page_SeeMore);
						if(showMore==true)
						{
							this.scrollToElement(OR.btn_Reg_Contributor_Page_SeeMore);
							this.scrollBy(0, -60);
							clickOn(OR.btn_Reg_Contributor_Page_SeeMore);
							waitTime(5);
							int countLatest=getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
							testStepPassed("Total Number of Posts in Latest-"+countLatest);
							if(countLatest>count)
							{
								testStepPassed("Latest Posts are displayed after clicking on Show more button");
							}
							else
							{
								testStepFailed("Latest Posts are not displayed after clicking on Show more button");
							}
							
						}
						else
						{
							testStepFailed("Show More Button is not Displayed");
						}
				}
				else
				{
					testStepFailed("Latest Posts are not present");
				}
				
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
					
		}
		
		
		/**
		 * Validate head line article in mobile.
		 */
		public void validateHeadLineArticleInMobile() {
			testStepInfo("******************************************** Article Page********************************************************");
			waitTime(3);
			/*boolean headLine = elementPresent(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
			boolean galleryTitle=elementPresent("Gallery Title#xpath=//p[@class='image-title']");
			if (headLine == true ||galleryTitle==true) {*/
				String getTitle = driver.getTitle();
				//String headLineArticle = getText(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
				//String galleryName = getText(OR.txt_Mob_Reg_Home_Page_TopStories_Title);
				if(!getTitle.equals("404"))
				{
					testStepPassed(getTitle );
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Error:404 on Forbes Page");
				}
				
				clickOnBackButton();
			/*} else {
				testStepFailed("Failed to navigate to Article ");
			}*/
		}
		public void validateMostPopularArticlesInMobile()
		{
			testStepInfo("********************************Clicking on all the articles in Most Popular*****************************");
			try {
				this.scrollBy(0, -60);
				boolean mostPopularLabel=elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_Label);
				if(mostPopularLabel==true)
				{
					testStepPassed("Most Popular Label is Present");
				}
				else
				{
					testStepFailed("Most Popular Label is not Present");
				}
				boolean mostPopularLinks=elementPresent("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']//article[@class='trending-article']//h2//span");
				if (mostPopularLinks==true)
				{
					int getCount=getElementCount("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']//article[@class='trending-article']//h2//span");
					testStepPassed("Total Number of Most Popular Articles--->"+getCount);
					for (int i = 1; i <=getCount; i++) {
						
						String getMostPopularLinks=getText("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']["+i+"]//article[@class='trending-article']//h2//span");
						testStepPassed("Most Popular Article Name--->"+i+"--->"+getMostPopularLinks);
						//this.scrollToElement("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']["+i+"]//article[@class='trending-article']");
						//this.scrollBy(0, -80);
						//clickOn("Most Popular Articles#xpath=//div[@class='trending-item ng-scope']["+i+"]//article[@class='trending-article']");
						//validateHeadLineArticleInMobile();
					}
					
				}
				else
				{
					testStepFailed("Most Popular Articles are not displayed");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		
		}
		
		public void validateWhatIsThisLabel()
		{
			testStepInfo("*******************************************What Is this Link*************************************");
			boolean whatIsThis = elementPresent(OR.link_BVHomePage_whatisthis);
			if (whatIsThis == true) {
				testStepPassed("What is this Link is displayed");
				
				mouseOver(OR.link_BVHomePage_whatisthis);
				testStepPassed("What Is This is displayed");
				/*this.scrollToElement(OR.link_BVHomePage_whatisthis);
				this.scrollBy(0, -60);
				clickOn(OR.link_BVHomePage_whatisthis);
				waitTime(5);
				boolean whatIsThisDescr=elementPresent(OR.txt_Reg_BrandVoice_What_Is_This_Description);
				if(whatIsThisDescr==true)
				{
					testStepPassed("What Is This Description is displayed");
				}
				else
				{
					testStepFailed("What Is This Description is not Displayed");
				}
				this.scrollToElement(OR.link_BVHomePage_whatisthis);
				this.scrollBy(0, -60);
				clickOn(OR.link_BVHomePage_whatisthis);*/
				//clickOn(OR.link_BVHomePage_whatisthisCloseButton);
				
			} else {
				getCurrentPageURL();
				testStepFailed("What is this is not displayed");
			}
		}
		
		public void validateAboutSection()
		{
			testStepInfo("*******************************************About Section*************************************");
			try {
				boolean aboutLabel=elementPresent(OR.txt_Reg_Group_Contributor_AboutLabel);
				
				if(aboutLabel==true)
				{
					testStepPassed("Group Contributor Page-->About Label is displayed");
				}
				else
				{
					testStepFailed("Group Contributor Page-->About Label  is not displayed");
				} 
				boolean aboutDescription=elementPresent(OR.txt_Reg_Group_Contributor_AboutDescription);
				if(aboutDescription==true)
				{
					String getAboutDescription=getText(OR.txt_Reg_Group_Contributor_AboutDescription);
					testStepPassed("About Description is Displayed--->"+getAboutDescription);
					boolean readMore=elementPresent(OR.icons_readmoreInAbout);
					if(readMore==true)
					{
						this.scrollToElement(OR.icons_readmoreInAbout);
						this.scrollBy(0, -60);
						clickOn(OR.icons_readmoreInAbout);
						
						boolean readLess=elementPresent(OR.icons_readlessInAbout);
						if(readLess==true)
						{
							this.scrollToElement(OR.icons_readlessInAbout);
							this.scrollBy(0, -60);
							clickOn(OR.icons_readlessInAbout);
						}
						else
						{
							getCurrentPageURL();
							testStepInfo("Read Less Button is not displayed");
						}
					}
					else
					{
						testStepInfo("Read More button is not Displayed");
					}
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("About Description is not Displayed");
				}
				
				
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}


		public void openArticlesInNewWindow(String strPropertykey)
				throws InterruptedException {

			try {
				String articleName = getText(strPropertykey);
				testStepPassed("Article Link is -" + articleName);
				if (this.driver.findElements(By.xpath((String) this.locator)) != null) {
					this.waitForElement(strPropertykey);
					WebElement link = this.driver.findElement(By
							.xpath((String) this.locator));
					Actions newTab = new Actions(driver);
					newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT)
							.build().perform();
					waitTime(5);
					testStepPassed("Openend the article in a new window");
					// handle windows change
					String base = driver.getWindowHandle();
					Set<String> set = driver.getWindowHandles();

					set.remove(base);
					assert set.size() == 1;
					driver.switchTo().window((String) set.toArray()[0]);

					/*
					 * String podcastsTitle = getText(strPropertykey);
					 * testStepPassed("Carousel Link is -"+podcastsTitle);
					 */
					String title = driver.getTitle();
					testStepPassed("Title of the page " + title);
					if (articleName.equalsIgnoreCase(title)
							|| !title.contains("404")) {
						testStepPassed("Navigated to correct Article Page");
					} else {
						testStepFailed("Failed to navigate Article Page");
					}

					// close the window
					driver.close();
					driver.switchTo().window(base);
					testStepInfo("*********Closed the New Window*********");
					// handle windows change and switch back to the main window
					Thread.sleep(2500);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
				} else {
					getCurrentPageURL();
					testStepFailed("No web element found");
				}
			} catch (Exception e) {
				ApplicationKeywords.writeToLogFile((String) "ERROR",
						(String) ("Exception: " + e.toString()));
			}

		}
		
public void clickingAllLatestPosts(){
	try{
		
		testStepInfo("**********************************Validating Ads ****************************");
		boolean ads=elementPresent(OR.ads_Reg_Contributor_Page_All_Ads);
		int countAds=0;
		if(ads==true)
		{
			countAds=getElementCount(OR.ads_Reg_Contributor_Page_All_Ads);
			testStepPassed("Total number of Ads Present on the Page--->"+countAds);
		}
		else
		{
			testStepFailed("Ads are not Displayed");
		}
		testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
		
		boolean latestPost=elementPresent(OR.txt_Reg_Contributor_Page_LatestPosts);
		if(latestPost==true)
		{
			int count=getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
			testStepPassed("Total Number of Posts in Latest-"+count);
			
			if(count==1 ||count<5)
			{
				for( int i=1;i<=count;i++){
					
					boolean latestPostslinks=elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
					boolean latestPostsImages=elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
					if(latestPostslinks==true &&latestPostsImages==true)
					{
						String getLatestArticles=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
						testStepPassed("Latest Articles-----"+getLatestArticles);
					}
					else
					{
						getCurrentPageURL();
						String latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
						testStepPassed("Name of the Latest Post --->"+latestPostsLinkName);
						testStepInfo("Latest Posts Image is not displayed--->"+i);
					}
					
					
				
				
				}
			}
			else if(count==5)
			{
				testStepInfo("************************************ Do Not Miss ******************************************** ");
				boolean dontMiss=elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[5]");
				if(dontMiss==true)
				{
					testStepPassed("Do not Miss Section is Displayed");
				}
				else
				{
					testStepFailed("Do Not Miss Section is not Displayed");
				}
				
				testStepInfo("******************************************Validating Latest Posts By Clicking on the See More Button************************************");
				//scrollBy(0, 1000);
				boolean seeMore=elementPresent(OR.btn_Reg_Contributor_Page_SeeMore);
				if(seeMore==true)
				{
					this.scrollToElement(OR.btn_Reg_Contributor_Page_SeeMore);
					this.scrollBy(0, -50);
					clickOn(OR.btn_Reg_Contributor_Page_SeeMore);
					//refreshPage();
					waitTime(5);
				
					
					this.scrollToElement(OR.txt_Reg_Contributor_Page_LatestPosts);
					this.scrollBy(0, -100);
					int countPosts=getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
					testStepPassed("Total number of Posts--->"+countPosts);
					if(countPosts>count)
					{
						testStepPassed("Latest Posts are Displayed after Clicking on See More Button");
						
						
						}
					else
					{
						testStepFailed("Latest Posts are not Displayed after clicking on See More Button");
					}
				}
				else
				{
					testStepFailed("See More Button is not Present");
				}
			}
			else
			{
				testStepFailed("Latest Articles are not present");
			}
			
			
				
		}
		else
		{
			getCurrentPageURL();
			testStepFailed("Latest Posts are not present");
		}
		
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

		public void validateAlLatestPosts(){
			try{
				
				/*testStepInfo("**********************************Validating Ads ****************************");
				boolean ads=elementPresent(OR.ads_Reg_Contributor_Page_All_Ads);
				int countAds=0;
				if(ads==true)
				{
					countAds=getElementCount(OR.ads_Reg_Contributor_Page_All_Ads);
					testStepPassed("Total number of Ads Present on the Page--->"+countAds);
				}
				else
				{
					testStepFailed("Ads are not Displayed");
				}*/
				testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
				
				boolean latestPost=elementPresent(OR.txt_Reg_Contributor_Page_LatestPosts);
				if(latestPost==true)
				{
					int count=getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
					testStepPassed("Total Number of Posts in Latest-"+count);
					
					if(count==1 ||count<5)
					{
						for( int i=1;i<=count;i++){
							
							boolean latestPostslinks=elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
							boolean latestPostsImages=elementPresent("Latest Posts Images#xpath=//li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//a[contains(@class,'fs-bg-image article-image ratio1x1')]");
							if(latestPostslinks==true &&latestPostsImages==true)
							{
								String getLatestArticles=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
								testStepPassed("Latest Articles-----"+getLatestArticles);
							}
							else
							{
								getCurrentPageURL();
								String latestPostsLinkName=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope']["+i+"]//h2");
								testStepPassed("Name of the Latest Post --->"+latestPostsLinkName);
								testStepInfo("Latest Posts Image is not displayed--->"+i);
							}
							
							
						
						
						}
					}
					else if(count==5)
					{
						
						
						testStepInfo("******************************************Validating Latest Posts By Clicking on the See More Button************************************");
						//scrollBy(0, 1000);
						boolean seeMore=elementPresent(OR.btn_Reg_Contributor_Page_SeeMore);
						if(seeMore==true)
						{
							this.scrollToElement(OR.btn_Reg_Contributor_Page_SeeMore);
							this.scrollBy(0, -50);
							clickOn(OR.btn_Reg_Contributor_Page_SeeMore);
							//refreshPage();
							waitTime(5);
						
							
							this.scrollToElement(OR.txt_Reg_Contributor_Page_LatestPosts);
							this.scrollBy(0, -100);
							int countPosts=getElementCount(OR.txt_Reg_Contributor_Page_LatestPosts);
							testStepPassed("Total number of Posts--->"+countPosts);
							if(countPosts>count)
							{
								testStepPassed("Latest Posts are Displayed after Clicking on See More Button");
								
								
								}
							else
							{
								testStepFailed("Latest Posts are not Displayed after clicking on See More Button");
							}
						}
						else
						{
							testStepFailed("See More Button is not Present");
						}
					}
					else
					{
						testStepFailed("Latest Articles are not present");
					}
					
					
						
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Latest Posts are not present");
				}
				
			
			}catch (Exception e) {
				// TODO Auto-generated catch block
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
		}

		
		public void validateBadge(String badge,String titleOfThePage,String name)
		{
			testStepInfo("********************* Validating Badge**********************");
			try {
				boolean isBadge=elementPresent(badge);
				if(isBadge==true)
				{
					waitTime(5);
					waitForElement(badge);
					/*WebElement badgeIcon=driver.findElement(By.xpath(badge));
					badgeIcon.click();*/
					clickOn(badge);
					testStepPassed(name+" - Badge is present");
					boolean titleOfPage=elementPresent(titleOfThePage);
					if(titleOfPage==true)
					{
						testStepPassed("Directed to -"+name+" -page on clikcing the badge"); 
					}
					else
					{
						testStepFailed("Not Directed to "+name+" on clikcing the badge");
					}
				}
				else
				{
					getCurrentPageURL();
					testStepFailed(name+" Badge is not present");
				}
			} catch (Exception e) {
				writeToLogFile("ERROR", "Exception: " + e.toString());
			}
			
		}
public void validateMostPopularArticles()
{
	testStepInfo("*****************************************Validating Most Popular Articles*************************************");
	try {
		scrollBy(0, 1500);
		boolean mostPopularLabel=elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_Label);
		if(mostPopularLabel==true)
		{
			testStepPassed("Most Popular Label is Present");
			
			boolean mostPopular=elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_Total_Articles);
			if(mostPopular==true)
			{
				int countMostPopular=getElementCount(OR.txt_Reg_Contributor_Page_MostPopular_Total_Articles);
				testStepPassed("Total number of Most Popular Articles --->"+countMostPopular);
				
				boolean currentArticles=elementPresent(OR.txt_Reg_Contributor_Page_MostPopular_CurrentArticles);
				if(currentArticles==true)
				{
					int countCurrentArticles=getElementCount(OR.txt_Reg_Contributor_Page_MostPopular_CurrentArticles);
				
					for (int i = 1; i <=1; i++)
					{
						String getMostPopular=getText("Most Popular Current Articles#xpath=//div[@class='slick-list draggable']//div[@class='slick-track']/div[contains(@class,'slick-active')]["+i+"]//article[@class='trending-article']//h2//span");
						testStepPassed("Most Popular Article ---"+getMostPopular);
					}
					scrollBy(0, 100);
					boolean nextButton=elementPresent(OR.btn_Reg_Contributor_Page_MostPopular_NextButton);
					if(nextButton==true)
					{
						clickOn(OR.btn_Reg_Contributor_Page_MostPopular_NextButton);
						waitTime(3);
						String getNextMostPopular=getText("Most Popular Current Articles#xpath=//div[@class='slick-list draggable']//div[@class='slick-track']/div[contains(@class,'slick-active')][1]//article[@class='trending-article']//h2//span");
						testStepPassed("After Next button Article is present---"+getNextMostPopular);
					}
					else
					{
						getCurrentPageURL();
						testStepInfo("Validating Next Slide Article: Next Button is not Present");
					}
					
				}
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Most Popular Articles are not Present");
			}
		}
		else
		{
			testStepFailed("Most Popular Label is not Present");
		}
		
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	
	
	
	
	
}
	
public void validateTagLine(String contributorTagLine)
{
	try {
		boolean tagLine=elementPresent(contributorTagLine);
		if(tagLine==true)
		{
			String getTagLine=getText(contributorTagLine);
			testStepPassed("Contributor Tag Line is present-"+getTagLine);
		}
		else
		{
			testStepFailed("Contributor Tag Line is not present");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}




public void verifyFollowInDeskyop(String followOnForbes) {
	testStepInfo("******************************************** Follow *******************************************************");
	try {
		boolean follow = elementPresent(followOnForbes);
		if (follow == true) {
			
			testStepPassed("Follow is displayed");
		} else {
			testStepFailed("Follow is not displayed");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}


public void validateNetworkShares(String socialShares)
{
	try {
		boolean socialNet=elementPresent(socialShares);
		if(socialNet==true)
		{
			int count= getElementCount(socialShares);
			testStepPassed("Social Networks are displayed");
			testStepPassed("Total Social networks are-"+count);
			boolean rss=elementPresent(OR.img_Reg_Contributor_Page_Network_RSS);
			if(rss==true)
			{
				testStepPassed("RSS Network share is Displayed");
			}
			else
			{
				testStepFailed("RSS Network share is not Displayed");
			}
		}
		else
		{
			testStepFailed("Social Networks are not displayed");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}


public void validateTopAds(String topAd) {

	try {
		waitForElement(topAd);
		this.scrollToElement(topAd);
		this.scrollBy(0, -60);
		boolean topAds = elementPresent(topAd);
		if (topAds == true) {
			takeAdScreenshot(topAd,"Top Ads");
			testStepPassed("Top Ads is present");
		} else {
			//takeAdScreenshot(topAd,"Top Ads");
			testStepInfo("Top Ads is not loaded properly");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

public void validateRecAds(String recAd) {

	try {
		this.scrollToElement(recAd);
		this.scrollBy(0, -60);
		boolean recAds = elementPresent(recAd);
		if (recAds == true) {
			 //takeAdScreenshot(recAd,"Rec Ads");
			testStepPassed("Rec Ads is present---" + recAds);
		} else {
			// takeAdScreenshot(recAd,"Rec Ads");
			testStepInfo("Rec Ads is not loaded properly");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block

		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

public void validateRailRecAds(String railRecAds) {

	try {
		this.scrollToElement(railRecAds);
		this.scrollBy(0, -60);
		boolean railAds = elementPresent(railRecAds);
		if (railAds == true) {
			//OR.ads_New_Posts_RailRec_Ads
			// takeAdScreenshot(railRecAds,"Rail Ads");
			testStepPassed(" Rail Rec Ads is present---" + railAds);
		} else {
			// takeAdScreenshot(railRecAds,"Rec Ads");
			testStepInfo("Rail Rec Ads is not loaded properly");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

public void validateTopxAds(String topxAd)
{
	try {
		this.scrollToElement(topxAd);
		this.scrollBy(0, -60);
		boolean topxAds=elementPresent(topxAd);
		if(topxAds==true)
		{
			//takeAdScreenshot(topxAd, "Topx Ads");
			testStepPassed("Topx Ads ia displayed");
		}
		else
		{
			//takeAdScreenshot(topxAd, "Topx Ads");
			testStepInfo("Topx Ads is not displayed");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}


public void validateSocialnetworks(String socialShares)
{
	try {
		boolean socialNet=elementPresent(socialShares);
		if(socialNet==true)
		{
			int count= getElementCount(socialShares);
			testStepPassed("Social Networks are displayed");
			testStepPassed("Total Social networks are-"+count);
		}
		else
		{
			getCurrentPageURL();
			testStepFailed("Social Networks are not displayed");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}


public void validatePromoVideoBlock()
{
	try {
		boolean promoVideo=elementPresent(OR.vid_Reg_Contributor_Page_PromoVideo_Block);
		if(promoVideo==true)
		{
			testStepPassed("Promo Video Block is present");
		}
		else
		{
			getCurrentPageURL();
			testStepInfo("Promo video Block is not present ");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

public void validateArchiveContributor()
{
	testStepInfo("***********************Validating Archive*******************************");
	try {
		
		boolean latestHeader=elementPresent(OR.txt_Reg_Contributor_PAge_LatestHeader);
		if(latestHeader==true)
		{
			String getLatestHeader=getText(OR.txt_Reg_Contributor_PAge_LatestHeader);
			testStepPassed("Latest Heading is Present---"+getLatestHeader);
			boolean firstArticleInLatestPosts=elementPresent("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope'][1]//h2");
			if(firstArticleInLatestPosts==true)
			{
				String latestPost=getText("Latest Posts#xpath=//ul[@class='common-stream articles edittools-stream' or @class='edittools-stream']/li[@class='stream-article et-promoblock-removeable-item et-promoblock-star-item ng-scope'][1]//h2");
				testStepPassed("Latest Post is --->"+latestPost);
				waitTime(5);
				scrollBy(0, -1500);
				boolean archive=elementPresent(OR.txt_ReG_Contributor_Page_Archive);
				if(archive==true)
				{
					this.scrollToElement(OR.txt_ReG_Contributor_Page_Archive);
					this.scrollBy(0, -60);
					clickOn(OR.txt_ReG_Contributor_Page_Archive);
					boolean archiveLabel=elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel);
					boolean archivePostsCount=elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabelPostCount);
					if(archiveLabel==true && archivePostsCount==true)
					{
						testStepPassed("Archive List is displayed");
						this.scrollToElement(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel);
						this.scrollBy(0, -60);
						clickOn(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel);
						boolean archiveLatestPost=elementPresent(OR.txt_Reg_Contributor_Page_Archive_LatestPost);
						if(archiveLatestPost==true)
						{
							String getArchiveLatestPost=getText(OR.txt_Reg_Contributor_Page_Archive_LatestPost);
							testStepPassed("Archive Latest Post is Displayed--->"+getArchiveLatestPost);
							/*if(latestPost.contains(getArchiveLatestPost))
							{
								scrollBy(0, 300);
								testStepPassed("Latest Post and Latest Article matching");
							}
							else
							{
								testStepFailed("Latest post is not displayed in the Archive Section");
							}*/
						
						}
						else
						{
							testStepFailed("Archive Latest Post is not Displayed");
						}
						
					}
					else
					{
						testStepFailed("Archive List is not Displayed");
					}
				}
				
			}
			else
			{
				testStepFailed("Latest Posts are not present");
			}
			boolean latestLink=elementPresent(OR.txt_ReG_Contributor_Page_Archive);
			if(latestLink==true)
			{
				this.scrollToElement(OR.txt_ReG_Contributor_Page_Archive);
				this.scrollBy(0, -60);
				clickOn(OR.txt_ReG_Contributor_Page_Archive);
				waitTime(3);
			}
			else
			{
				testStepFailed("Latest Post Link is not displayed");
			}
		}
		else
		{
			testStepFailed("Latest Header Element is not Displayed");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	
}
public void verifyContributorNameInMobile()
{
	testStepInfo("************************************* Contributor Details ************************************************");
	try {
		boolean authorName=elementPresent(OR.txt_Article_Page_contributor_Forbes_Staff_Name);
		if(authorName==true)
		{
			
			testStepPassed("Author name is displayed");
		}
		else
		{
			testStepFailed("Author name is not displayed");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

public void validateBottomAds(String bottomStickyAd) {
	try {
		boolean bottomAds = elementPresent(bottomStickyAd);
		if (bottomAds == true) {
			//takeAdScreenshot(bottomStickyAd, "Bottom Ads");
			testStepPassed("Bottom Sticky Ads is displayed");
		} else {
			testStepFailed("Bottom Sticky Ads is not displayed");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}
//07 Dec 2016--> Contributor Page
		
public void validatecontributorDetails(String image,String aType)
{
	try {
		boolean groupContLogo=elementPresent(image);
		boolean groupType=elementPresent(aType);
		if(groupContLogo==true)
		{
			testStepPassed("Contributor Logo is Displayed");
		
		}
		else
		{
			getCurrentPageURL();
			testStepFailed(" Contributor Logo is not Displayed");
		}
		if(groupType==true)
		{
			String atype=getText(aType);
			testStepPassed(" Contributor Type is Displayed-"+atype);
		}
		else
		{
			getCurrentPageURL();
			testStepFailed(" Contributor Type is not Displayed");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
	
}


}