
package podcastsPage;



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;
import baseClass.BaseClass;

public class PodCastsPageValidation extends ApplicationKeywords {
	
	/** The obj. */
	BaseClass obj;

	public PodCastsPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	public PodCastsPageValidation() {

	}

	public void verifyPodcastsPage() throws Exception {
		
		if (currentExecutionMachineName.equalsIgnoreCase("NewPosts_MostPopular_Angular"))
		{
			
			validatePodcastsHeading();
			validateSocialnetworks(OR.img_Podcasts_Page_Social_Share);
			//validateCarouselLayout();
			validatePodcatsAds(OR.ads_Podcasts_Page_TopAds);
			scrollBy(0, 300);
			validateCSFGrid();
		/*	validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section5, 5);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section6, 6);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section7,7);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section8,8);*/
	
		}
		else
		{
			
			validatePodcastsHeading();
			validateSocialNetworks();
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			//validateCarouselLayout();
			validatePodcatsAds(OR.ads_Mob_Podcasts_TopAds);
			validateCSFGrid();
			/*validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section5, 5);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section6, 6);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section7,7);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section8,8);*/
		}

	}

	

	public void validateCSFGrid() throws Exception
	{
		boolean csfGrid=elementPresent("CSF Grid#xpath=//div[@id='csf-main-content']//section//li[@class='csf-column article-grid fs-layout-one']//div[@class='article-block ng-scope']");
		if(csfGrid==true)
		{
			int countGrid=getElementCount("CSF Grid#xpath=//div[@id='csf-main-content']//section//li[@class='csf-column article-grid fs-layout-one']//div[@class='article-block ng-scope']");
			testStepPassed("Total Number of CSF Article Grid--->"+countGrid);
			
			if(countGrid>=1)
			{
				openPodcastsInNewtab("CSF Grid#xpath=//div[@id='csf-main-content']//section//li[@class='csf-column article-grid fs-layout-one']//div[@class='article-block ng-scope'][1]");
			}
			else
			{
				testStepFailed("Podcast CSF Grid is not present");
			}
			/*validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section5, 5);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section6, 6);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section7,7);
			validateForbesPodcastsSection(OR.txt_Podcasts_Page_Section8,8);*/
		
		
		}
		else
		{
			testStepFailed("CSF Article Grid is  not displayed");
		}
	
	}
	
	
	
	public void openPodcastsInNewtab(String strPropertykey) throws InterruptedException{
		
		try{
			String podcastsName = getText(strPropertykey);
			testStepPassed("Carousel Link is -"+podcastsName);
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
				if(podcastsName.equalsIgnoreCase(title)||!title.equals("404"))
				{
					testStepPassed("Navigated to correct Podcasts Page");
				}
				else
				{
					testStepFailed("Failed to navigate Podcasts Page");
				}
				boolean ads=elementPresent(OR.ads_Podcasts_Page_PodcastsAds);
				if(ads==true)
				{
					testStepPassed("Podcasts Ads is present");
				}
				else
				{
					testStepFailed("Podcasts Ads is not present");
				}
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
		
		}
	public void validatePodcatsAds(String ads)
	{
		testStepInfo("********************************************** Validate Ads ***********************************************");
		
		try {
			boolean topAds=elementPresent(ads);
			if(topAds==true)
			{
				testStepPassed("Podcasts Top ads is displayed");
			}
			else
			{
				testStepFailed("Podcasts Top ads is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validatePodcastsHeading()
	{
		testStepInfo("********************************************** Validate Heading ***********************************************");
		try {
			
				boolean heading=elementPresent(OR.img_Podcasts_Page_Heading);
				if(heading==true)
				{
					testStepPassed("Podcasts heading is displayed");
				}
				else
				{
					testStepFailed("Podcasts heading is not displayed");
				}
			
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateSocialNetworks()
	{
		testStepInfo("********************************************** Social Shares ***********************************************");
		try {
			boolean socialShare=elementPresent(OR.img_Podcasts_Page_Social_Share);
			if(socialShare==true)
			{
				clickOn(OR.img_Podcasts_Page_Social_Share);
				int countSocialShares=getElementCount(OR.img_Podcasts_Page_Social_Share);
				testStepPassed("Podcasts Social shares are present----"+countSocialShares);
				clickOn("Close#xpath=//button[@class='button']");
			}
			else
			{
				testStepFailed("Podcasts Social shares are not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
}
