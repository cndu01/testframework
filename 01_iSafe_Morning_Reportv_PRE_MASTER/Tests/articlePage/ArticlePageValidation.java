/**
 * Validate Author info & image
 * Article Ads
 * Social sharing

 */
package articlePage;

import java.util.List;
import java.util.Set;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * class names are written in mixed case with the first letter of each internal
 * word capitalized.
 */
public class ArticlePageValidation extends ApplicationKeywords {

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :Article Page Validation
	// Created by :Shakira
	// Created on :9 June 2016

	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates a new article page validation.
	 *
	 * @param obj the obj
	 */
	public ArticlePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
	}

	/**
	 * Verify ads in article page. methods are written in mixed case with the
		 */
	public void verifyAdsInArticlePage() {

		
		String articleText = null;
		
		try {

			if (currentExecutionMachineName.equalsIgnoreCase("Welcome_Home_Article")) {
				waitForText("Today's Top Stories");
				
				
				
			
				
				//testStepPassed(""+pageViewCounts);
				//openArticleLinksInWindow(OR.txt_Mob_Contributor_Page_Article);
				waitTime(5);
				boolean topStory=elementPresent(OR.txt_Home_Page_Top_Stories1);
				if(topStory==true)
				{
					
				int pageViewCounts=openArticleLinksInWindow(OR.txt_Home_Page_Top_Stories1,OR.txt_Article_Page_View_Count);
				driver.manage().deleteAllCookies();
				
				driver.get("https://www.forbes.com/home_usa/?nowelcome");
				waitTime(10);
				String getUrl=getAttributeValue(OR.txt_Home_Page_Top_Stories1, "href");
				testStepPassed("Article Page Url is "+getUrl);
				
				String articlePageUrl=getUrl.concat("?view=prod");
				String articlePageUrl1=articlePageUrl.concat("?nowelcome");
				//clickOnMainArticle();
				
				validatePageLoadTime(articlePageUrl1, 23,"Article Page");
				//driver.get(articlePageUrl1);
				//driver.get(articlePageUrl1);
				waitTime(8);
				driver.get(articlePageUrl1);
				
				
				waitTime(5);
				
				validateNativeLeftrailAds();
				validateLeftRailArticleNavigation(
						OR.txt_Reg_Home_Page_HeadLine_Article,
						OR.txt_Reg_Article_Page_LeftRail_Article_Heading);
				validateHashTag(OR.txt_Reg_Article_Page_HashTag);
				validateAdOnLeftRail();
				validateAuthorDetailsForDesktop();
				validateFullBio();
				validateShare();
				
				int viewCounts=0;
				boolean pageView=elementPresent(OR.txt_Article_Page_View_Count);
				if(pageView==true)
				{
				String pageViewCount=getText(OR.txt_Article_Page_View_Count);
				String replaceComma=pageViewCount.replace(",","");
				//testStepPassed(replaceComma);
				  viewCounts=Integer.parseInt(replaceComma);
				
				
				testStepPassed("Second Time View Count is "+viewCounts);
				}
				else
				{
					testStepFailed("Page View Count is not Displayed");
				}
				
				if(viewCounts>pageViewCounts)
				{
					testStepPassed("Page View Count is Increased");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Page View Count is not Increased");
				}
				//validateLeftStreamArticle(OR.txt_Reg_Article_Page_LeftRailArticle);
				
				
				validateAds();
				verifyAdsInArticle();
				validateRevContentInDesktop();
				validateArticleByScroll();
				}
				else
				{
					testStepFailed("Promo Section is not displayed");
				}
				
			} else {
				waitTime(5);
				waitForText("Top Stories");
				scrollBy(0, 300);
				//int pageView=openArticleLinksInWindow(OR.txt_Mob_Home_Page_Top_Stories, OR.txt_Article_Page_View_Count);
				//testStepPassed("Page View Count ---"+pageView);
				boolean promoSection=elementPresent(OR.txt_Mob_Home_Page_Top_Stories);
				if(promoSection==true)
				{
				String getUrl=getAttributeValue(OR.txt_Mob_Home_Page_Top_Stories, "href");
				testStepPassed("Article Page Url is "+getUrl);
				
				validatePageLoadTime(getUrl, 23, "Article Page");
				//clickOnMainArticle();
				
			
				validateSocialShare();
				validateAuthorDetailsForMobile();
				verifyeFullBioInArticlePage();
				validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
				verifyAdsInMobileArticle();
				validateRecommendedLabel();
				validateRevContentInMobile();
				
				//validateFromWebInMobile();
				validateAdStream();
				
				boolean nextArticle=elementPresent(OR.txt_Article_Page_Next_Article);
				if(nextArticle==true)
				{
					this.scrollBy(0, 500);
				scrollToElement(OR.txt_Article_Page_Next_Article);
				scrollBy(0, -60);
				articleText = getText(OR.txt_Article_Page_Next_Article);
				clickOn(OR.txt_Article_Page_Next_Article);
				testStepPassed("Article Text: "
						+ getText(OR.txt_Article_Page_Article_Header));
				}
				else
				{
					
					testStepFailed("Next Article is not found ");
				}
				}
				else
				{
					testStepFailed("Promo Section is not Displayed");
				}
				verifyPageShouldContainText(articleText);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void validateNativeLeftrailAds()
	{
		try {
			boolean check2ndLeftrailAd=elementPresent(OR.txt_Article_Page_Leftrail_2ndNtvAds);
			
			
			if(check2ndLeftrailAd==true)
			{
				String get2ndntvAd=getText(OR.txt_Article_Page_Leftrail_2ndNtvAds);
				if(get2ndntvAd.contains("Voice: "))
				{
				testStepPassed("Leftrail Native ad is present in 2nd position--->"+get2ndntvAd);
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Leftrail native ad is not present in 2nd position"+get2ndntvAd);
				}
			}
			else
			{
				testStepFailed("Leftrail native ad is not present in 2nd position");
			}
			
			boolean check6thLeftrailAd=elementPresent(OR.txt_Article_Page_Leftrail_6thNtvAds);
			if(check6thLeftrailAd==true)
			{
				String get6thntvAd=getText(OR.txt_Article_Page_Leftrail_6thNtvAds);
				if(get6thntvAd.contains("Voice: "))
				{
					testStepPassed("Leftrail Native ad is present in 6th position--->"+get6thntvAd);
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Leftrail Native ad is not present in 6th position"+get6thntvAd);	
				}
				
			}
			else{
				testStepFailed("Leftrail Native ad is not present in 6th position");	
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateRecommendedLabel() {
		testStepInfo("************* Recommended *****************");
		try {
			this.scrollToElement(OR.txt_Reg_Article_Page_Recommended_Label);
			this.scrollBy(0, -60);
			boolean recommendedLabel = elementPresent(OR.txt_Reg_Article_Page_Recommended_Label);
			if (recommendedLabel == true) {
				testStepPassed("Recommended Label is displayed");
				/*boolean nextButton=elementPresent(OR.btn_Reg_Article_Page_Recommended_NextButton);
				if(nextButton==true)
				{
					for (int i = 1; i <=2; i++) {
					
						boolean checkName=elementPresent(OR.txt_Reg_article_Page_Recommended_Name);
								if(checkName==true)
								{
									swipeToLeft(1100, 40, 1100);
									waitTime(3);
									//waitTime(5);
									String getName=getText(OR.txt_Reg_article_Page_Recommended_Name);
									testStepPassed("Recommended Story Name---"+getName);
									//clickOn(OR.btn_Reg_Article_Page_Recommended_NextButton);
								}
								else{
									testStepFailed("Next Story is not present");
								}
						
						waitTime(5);
						clickOn(OR.btn_Reg_Article_Page_Recommended_NextButton);
					}
				}*/
			} else {
				getCurrentPageURL();
				testStepInfo("Recommended Label is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateAdOnLeftRail()
	{
		testStepInfo("************************** Ad On Left Rail ****************************");
		try {
			
			//driver.get("https://www.forbes.com/sites/stevenbertoni/2017/01/17/adam-carolla-from-manual-laborer-to-media-mogul/#51b560d615c6");
			waitTime(10);
			boolean getAllLeftRailArticle=elementPresent(OR.txt_Article_Page_LeftRail_Articles);
			if(getAllLeftRailArticle==true)
			{
				
				List<WebElement> allLeftRail=driver.findElements(By.cssSelector(".item .ng-binding.ng-scope"));
				int count=allLeftRail.size();
				testStepPassed("Total Articles Present in the leftrail---"+count);
				
				for (int i = 1; i <=count; i++) {
					String getLeftRail=allLeftRail.get(i).getText();
					testStepPassed("LeftRail Articles---"+i+"---"+getLeftRail);
					if(getLeftRail.contains("Voice"))
					{
					testStepPassed("ntv rail ad present in the leftrail");	
					}
					else
					{
						testStepPassed("Normal Articles are present in the leftrail");
					}
				}
				
			/*int getTotalLeftRailArtilces=getElementCount("Total Leftrail articles#cssselector=.item.post .link h3 span");
			//testStepPassed("Total Leftrail articles---"+getTotalLeftRailArtilces);
				for (int i = 3; i <=11; i++) {
					String getArticle="Article#cssselector=.item.post:nth-of-type("+i+") .link h3 span";
					String getAllArticles=getText(getArticle);
					testStepPassed(getAllArticles);
					
					if(getAllArticles.contains("Voice"))
					{
						this.scrollBy(0, 200);
						clickOn("Left rail Article#cssselector=.item.post:nth-of-type("+i+") .link h3 span");
						ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					    driver.switchTo().window(tabs2.get(1));
					    waitTime(5);
					    testStepPassed("Leftrail Article is opened in the new tab---");
					    validateHeadLineArticle();
					    
					    driver.close();
					    driver.switchTo().window(tabs2.get(0));
						
					}
					else
					{
						testStepInfo("Article page is not having ad on left rail");
					}
				}*/
				
			}
			else
			{
				testStepFailed("Left Rail Articles are not Present");
			}
			
				
			boolean podcastArt=elementPresent("Podacast#cssselector=li:nth-of-type(3) .ng-binding.ng-scope");
			if(podcastArt==true)
			{
				String getPodcast=getText("Podacast#cssselector=li:nth-of-type(3) .ng-binding.ng-scope");
				testStepPassed("Podcast article is present in the 3rd position---"+getPodcast);
			}
			else
			{
				testStepPassed("Normal Article is present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	/*public void validateArticleByScroll()
	{
		testStepInfo("******************************** Validating Articles By scrolling ***********************************");
		
		int countArticles=getElementCount("Article Title#xpath=//section[@id='article-page']//article//h1[@class='article-headline ng-binding']");
		testStepPassed("Total Articles on the page---"+countArticles);
		for (int i = 1; i <=4; i++) {
			
			boolean articles=elementPresent("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
			if(articles==true)
			{
				this.scrollToElement("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
				this.scrollBy(0, -60);
				String headingOfArticle=getText("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
				testStepPassed("Heading of the Article-"+headingOfArticle);
				this.scrollBy(0, 100);
				String title=driver.getTitle();
				testStepPassed("Title of the Article is --- "+i+" - "+title);
				waitTime(8);
				
				//String getHeadingOfArticle=getText("Article Heading#xpath=//article["+i+"]//h1[@class='article-headline ng-binding']");
				String leftRailArticleTitle=getText("Leftrail Article name#cssselector=.items.ng-scope .item.active .ng-binding.ng-scope");
				//testStepPassed("Leftrail article title--"+getHeadingOfArticle);
				this.scrollBy(0, -60);
				if(leftRailArticleTitle.trim().contains(title) || leftRailArticleTitle.trim().contains(title))
				{
					testStepPassed("Article Title is matching with leftrail of first article");
				}
				else
				{
					getCurrentPageURL();
					testStepInfo("Article Title is not matching with leftrail of first article");
				}
			}
			else
			{
				getCurrentPageURL();
				testStepInfo(" Next Article are not loaded");
			}
			
			this.scrollToElement(titleOfArticle);
			this.scrollBy(0, -60);
			
		}
	}*/
	public void validateArticleScrollBy(String leftRailArticleTitle, String headOfArticle)
	{
		try {
			boolean checkArticle=elementPresent(headOfArticle);
			if(checkArticle==true)
			{
				this.scrollToElement(headOfArticle);
				this.scrollBy(0, -60);
				String getHeadOfArticle=getText(headOfArticle);
				String title=driver.getTitle();
				String getLeftRailArticleTitle=getText(leftRailArticleTitle);
				if(getHeadOfArticle.trim().contains(getLeftRailArticleTitle)||getLeftRailArticleTitle.trim().contains(headOfArticle))
				{
					//testStepPassed("Title of the Article---"+title);
					testStepPassed("LeftRail article ---"+leftRailArticleTitle);
					testStepPassed("Article Title is matching with leftrail of first article");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Article Title is not matching with leftrail of first article");
				}
				
			}else{
				testStepFailed("Next Article is not loaded");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateArticleByScroll()
	{
		try {
			testStepInfo("******************************** Validating Articles By scrolling ***********************************");
			int countArticles=getElementCount("Article Title#xpath=//section[@id='article-page']//article//h1[@class='article-headline ng-binding']");
			testStepPassed("Total Articles on the page---"+countArticles);
			
			for (int i = 1; i <=3; i++) {
				
				boolean articles=elementPresent("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
				if(articles==true)
				{
					this.scrollToElement("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
					this.scrollBy(0, -60);
					String headingOfArticle=getText("Article Title#xpath=//section[@id='article-page']//article["+i+"]//h1[@class='article-headline ng-binding']");
					//testStepPassed("Title of the Article-"+titleOfArticle);
					this.scrollBy(0, 100);
					String title=driver.getTitle();
					//testStepPassed("Title of the Article is --- "+i+" - "+title);
					waitTime(10);
					this.scrollBy(0, 100);
					waitTime(10);
					String leftRailArticleTitle=getText("Leftrail Article name#cssselector=.items.ng-scope .item.active .link .headline.ng-isolate-scope");
					//testStepPassed("Leftrail article title--"+leftRailArticleTitle);
					//this.scrollBy(0, 100);
					if(leftRailArticleTitle.trim().contains(headingOfArticle)||leftRailArticleTitle.trim().contains(title)||headingOfArticle.trim().contains(title))
					{
						testStepPassed("Leftrail article title---"+leftRailArticleTitle);
						testStepPassed("Article Title is matching with leftrail of first article");
					}
					else
					{
						getCurrentPageURL();
						testStepFailed("Article Title is not matching with leftrail of first article");
					}
				}
				else
				{
					getCurrentPageURL();
					testStepInfo(" Next Article are not loaded");
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateAdStream()
	{
		testStepInfo("*************** Validating Ads Article Stream *************");
	
		try {
			scrollBy(0, 2000);
			boolean trendingOnForbes=elementPresent(OR.txt_Mob_Article_Page_TrendingONForbes);
			if(trendingOnForbes==true)
			{
				
				testStepPassed("Trending on Forbes is present ");
				boolean articleLists=elementPresent(OR.txt_Mob_Article_Page_ArticleList);
				boolean articleImages=elementPresent(OR.img_Article_Page_TrendingStories_Images);
				if(articleLists==true && articleImages==true)
				{
					int countArticleList=getElementCount(OR.txt_Mob_Article_Page_ArticleList);
					testStepPassed("Total Number os Articles in the Stream--->"+countArticleList);
					int countImages=getElementCount(OR.img_Article_Page_TrendingStories_Images);
					testStepPassed("Total Number os Article Images in the Stream--->"+countImages);
					
					for (int i = 1; i <=countArticleList; i++) {
						boolean checkTrendingStoryTitle=elementPresent("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
						if(checkTrendingStoryTitle==true)
						{
						String getArticleLists=getText("Article List in the Stream#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//h3");
						testStepPassed("Trending Story title--->"+i+"---"+getArticleLists);
						
						
						boolean checkImage=elementPresent("Article Stream Image#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//div[@class='ratio-holder ng-scope']//img[@class='thumb ng-scope']");
						if(checkImage==true)
						{
							testStepPassed("Article Stream Image is displayed----"+i);
						}
						else
						{
							getCurrentPageURL();
							testStepInfo("Article Stream Image is not displayed");
						}
						boolean chechShare=elementPresent("Social Share#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//div[@class='share ng-isolate-scope']/ul");
						if(chechShare==true)
						{
							testStepPassed("Social Share is present in the Article Stream");
						}
						else
						{
							testStepFailed("Social Share is not present in the Article Stream");
						}
						/*this.scrollToElement("Article Stream Image#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//div[@class='ratio-holder ng-scope']//img[@class='thumb ng-scope']");
						
						this.scrollBy(0, 500);
						this.scrollBy(0, -60);
						waitTime(10);
						waitForElement("Article Stream Image#xpath=//article[@class='recommended-stream clearfix ng-scope' or @class='recommended-stream clearfix ng-scope brandvoice']["+i+"]//div[@class='ratio-holder ng-scope']//img[@class='thumb ng-scope']");
						*/
						
						
						}
						else
						{
							testStepFailed("Trending Story title is not displayed");
						}
					
					}
					
					
				}
				scrollBy(0, 2500);
				boolean adStream=elementPresent(OR.ads_Article_Page_AdsStream);
				if(adStream==true)
				{
					int getCountAds=getElementCount(OR.ads_Article_Page_AdsStream);
					testStepPassed("Total Ads in the Stream--->"+getCountAds);
					if(getCountAds>=1)
					{
						for (int i = 1; i <=getCountAds; i++) {
							waitTime(3);
							
							takeAdScreenshot("Ads Stream#xpath=//article[@class='recommended-stream clearfix ng-scope stream-ad']["+i+"]/div", "Ads");
							testStepPassed("Ads in the Stream--->"+i);
						}
					}
					else
					{
						testStepFailed("Article Stream Ads are not present");
					}
					
					
				}
				else
				{
					testStepFailed("Ads are not loaded");
				}
				
				boolean moreStoriesButton=elementPresent(OR.btn_Mob_Article_Page_More_Stories);
				if(moreStoriesButton==true)
				{
					testStepPassed("More Trending Stories Button is Displayed");
				}
				else
				{
					testStepFailed("More Trending Stories Button is not Displayed");
				}
				
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Trending On Forbes is not present");
			}
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateFromWebInMobile()
	{
		testStepInfo("*************************************** From Web ***************************************");
		try {
			boolean fromWeb=elementPresent(OR.txt_Mob_Reg_Article_Page_FromWeb);
			if(fromWeb==true)
			{
				testStepPassed("From Web Section is Present");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("From Web Section is not present");
			}
		} catch (Exception e) {
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

	
	// Start Date : 21 June 2016

	/**
	 * Verifye full bio in article page.
	 */
	public void verifyeFullBioInArticlePage() {
		testStepInfo("************************************************** Full Bio  ****************************************************");
		try {
			boolean fullBio=elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
				if(fullBio==true)
				{
			clickOn(OR.btn_Mob_Article_Page_Full_Bio);
			String fullBioDetails = getText(OR.txt_Mob_Article_Page_Full_Bio_Details);
			testStepPassed(fullBioDetails);
			scrollBy(0, 330);
			//scrollToElement(OR.btn_Mob_Article_Page_Full_Bio);

			boolean closeBtn=elementPresent(OR.btn_Mob_Article_Page_Full_Bio);
			if(closeBtn==true)
			{
			clickOn(OR.btn_Mob_Article_Page_Full_Bio);
			}
			else
			{
				testStepFailed("Close Button is not Displayed on the page");
			}
				}
				else
				{
					testStepFailed("Full Bio is not displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate author details for mobile.
	 */
	public void validateAuthorDetailsForMobile() {
		testStepInfo("************************************************** Author Details  ****************************************************");
		try {
			boolean authorName = elementPresent(OR.txt_Mob_Article_Page_Author_Name);
			if (authorName == true) {

				String varAuthorName = getText(OR.txt_Mob_Article_Page_Author_Name);
				testStepPassed("Author Name is displayed -" + varAuthorName);

			} else {
				testStepFailed("Article Name is not displayed");
			}
			boolean authorImage = elementPresent(OR.img_Article_Page_Contributor);
			if (authorImage == true) {
				//takeAdScreenshot(OR.img_Article_Page_Contributor,"Author Image");
				testStepPassed("Author image is displayed");
			} else {
				testStepFailed("Image is not loaded properly");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	/**
	 * Validate social share.
	 */
	public void validateSocialShare() {
		try {
			testStepInfo("************************************************** Social Share ****************************************************");
			waitTime(3);
			clickOn(OR.img_Mob_Article_Page_Share_Icon);

			boolean shareFacebook = elementPresent(OR.img_Mob_Article_Page_Facebook);
			if (shareFacebook == true) {
				testStepPassed("Social Share Facebook is available");
			} else {
				testStepFailed("Social Share are not loaded properly");
			}
			clickOn(OR.img_Mob_Article_Page_Share_Icon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}

	}

	
	
	public void validateArticleAds()
	{
		
		List<WebElement> allAdLinks = driver
				.findElements(By
						.xpath("//iframe[contains(@id,'google_ads_iframe')]"));
		for (int k = 0; k < allAdLinks.size(); k++) {

			boolean isAdDisplayed = allAdLinks.get(k).isDisplayed();
			if(isAdDisplayed==true){
				System.out.println("---->"+""+(k+1));
			testStepPassed("Article Page validation (Article - " + (k + 1) + ")"
					+ isAdDisplayed);
			}
			else
			{
				testStepPassed("Article ads are not displayed");
			}
		}
	}
	
	public void validateRevContentInMobile()
	{
		testStepInfo("*************************************** Ads By RevContent ***************************************");
		scrollBy(0, 2000);
		waitTime(8);
		scrollBy(0, 300);
		boolean revContent=elementPresent(OR.txt_Article_Page_RevContent);
		if(revContent==true)
		{
		testStepPassed("Ads By RevContent is Displayed");	
		}
		else
		{
			getCurrentPageURL();
			testStepFailed("Ads By Revcontent is not Displayed");
		}
		
	}
	
}
