package newWelcomePageForArticle;

import org.openqa.selenium.Keys;

import objectsRepository.OR;
import iSAFE.ApplicationKeywords;
import baseClass.BaseClass;

public class WelcomeArticlePageValidation extends ApplicationKeywords {

	BaseClass obj;
	public WelcomeArticlePageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}
	
	public WelcomeArticlePageValidation() {

		// TODO Auto-generated constructor st ub
	}
	
	public void validateArticleWelcomePage()
	{
		if (currentExecutionMachineName.equalsIgnoreCase("WelcomeArticle_Gallery"))
		{
		//	driver.manage().deleteAllCookies();
			validateLatestArticle();
			
		}
		else
		{
			validateLatestArticleInMobile();
		}
	
	}
	
	public void validateLatestArticle()
	{
		testStepInfo("************************** Article Latest Link**********************************");
		waitTime(5);
		boolean latestArticle=elementPresent(OR.txt_Welcome_Article_Page_Latest_Link);
		if(latestArticle==true)
		{
			String latestArt=getText(OR.txt_Welcome_Article_Page_Latest_Link); 
			testStepPassed(latestArt); 
			clickOn(OR.txt_Welcome_Article_Page_Latest_Link);
			//waitTime(5);
			//getCurrentPageURL();
			String currentUrl=driver.getCurrentUrl();
			testStepPassed("Current URL is -"+currentUrl);
			
			/*String[] url = currentUrl.split("www.");
			String url1 = url[0];
			String url2 = url[2];
			String url3 = url[3];
		
			testStepPassed("1."+url1);
			testStepPassed("2."+url2);
			testStepPassed("3."+url3);
			//testStepPassed(url4);
*/		waitTime(5);

		/*	verifyQuoteOfTheDay();
			verifyWelcomeAds();*/
			
			testStepInfo("******************************* Continue To Article *****************************************");
			boolean continueToArticle=elementPresent(OR.txt_Welcome_Article_Page_Label);
			if(continueToArticle==true)
			{
				
				String txtContinueToArticle=getText(OR.txt_Welcome_Article_Page_Label);
				clickOn(OR.txt_Welcome_Article_Page_Label);
				testStepPassed("Continue to Article is Displayed-"+txtContinueToArticle);
				
			
			
				
			}
			else
			{
				testStepInfo(" Redirected to Article Page");
			}
			
			waitTime(5);
			//clickOn(OR.txt_Welcome_Article_Page_Label);
			waitTime(3);
			String articleUrl=driver.getCurrentUrl();
			testStepPassed("Current URL is -"+articleUrl);
			
			String[] articleUrl1 = articleUrl.split("#");
			//String part1 = parts[0]; // 004
			String arturl1 = articleUrl1[0];
			String arturl2 = articleUrl1[1];
			
			testStepPassed("1."+arturl1);
			testStepPassed("2."+arturl2);
			
			if(currentUrl.contains(arturl1))
			{
				testStepPassed("Navigated to Article Page");
			}
			else
			{
				testStepFailed("Latest Article is not redirected to Article page");
			}
			
		}
		else
		{
			testStepFailed("Latest Article is not Displayed");
		}
		driver.manage().deleteAllCookies();
	}
	
	public void validateLatestArticleInMobile()
	{
		testStepInfo("************************** Article Latest Link**********************************");
		//waitTime(5);
		boolean latestArticle=elementPresent(OR.txt_Mob_Welcome_Article_Page_Latest_Link);
		if(latestArticle==true)
		{
			String latestLink=getText(OR.txt_Mob_Welcome_Article_Page_Latest_Link);
			testStepPassed(latestLink);
			
			
			//String galleryLink=latestLink.replaceAll("\\s+","");
			//testStepPassed(galleryLink); 
			//String lowerCase=galleryLink.toLowerCase();
			//testStepPassed(lowerCase);
			clickOn(OR.txt_Mob_Welcome_Article_Page_Latest_Link);
			//waitTime(3);
			String currentUrl=driver.getCurrentUrl();
			testStepPassed("Current URL is -"+currentUrl);
		
			/*verifyQuoteOfTheDay();
			verifyWelcomeAds();*/
			
			testStepInfo("******************************* Continue To Article *****************************************");
			boolean continueToArticle=elementPresent(OR.txt_Welcome_Article_Page_Label);
			if(continueToArticle==true)
			{
				
				clickOn(OR.txt_Welcome_Article_Page_Label);
				String btn=getText(OR.txt_Welcome_Article_Page_Label);
				testStepPassed("Continue to Article Button is present-"+btn);
				//waitTime(3);
				
				
			}
			else
			{
				testStepInfo("Redirected to Article Page");
			}
			String articleUrl=driver.getCurrentUrl();
			testStepPassed("Current URL is -"+articleUrl);
			
							
			if(currentUrl.contains(articleUrl))
			{
				boolean txtHeading=elementPresent(OR.txt_Article_Page_Heading);
				
				if(txtHeading==true)
				{
					String heading=getText(OR.txt_Article_Page_Heading);
					testStepPassed(""+heading);
					takeAdScreenshot(OR.txt_Article_Page_Heading, "Article");
					testStepPassed("Navigated to Article Page");
				}
				
			}
			
		}
		else
		{
			testStepFailed("Latest Article is not Displayed");
		}
		driver.manage().deleteAllCookies();
	}
	
	

	
	
	public void validateLatestGallery()
	{
		if (currentExecutionMachineName.equalsIgnoreCase("WelcomeArticle_Gallery"))
		{
			//driver.get("https://www.google.com/#q=forbes+pictures");
		testStepInfo("******************************** Welcome Gallery Page***********************************");
		boolean latestArticle=elementPresent(OR.txt_Welcome_Article_Page_Latest_Link);
		if(latestArticle==true)
		{
			waitTime(10);
			String articleLink=getText(OR.txt_Welcome_Article_Page_Latest_Link);
			testStepPassed(articleLink);
			
			String galleryLink=articleLink.replaceAll("\\s+","");
			testStepPassed(galleryLink); 
			String lowerCase=galleryLink.toLowerCase();
			//testStepPassed(lowerCase+"88888888888");
			//String galleryLink1[0] = galleryLink[0].to();
	         
			clickOn(OR.txt_Welcome_Article_Page_Latest_Link);
			/*String currenturl=driver.getCurrentUrl();
			testStepPassed(""+currenturl);
			
			String[] spliturl=currenturl.split("//");
			String c11=spliturl[0];
			String c21=spliturl[1];
			String c31=spliturl[2];
			String c41=spliturl[3];
			
			testStepPassed(c11);
			testStepPassed(c21);
			testStepPassed(c31);
			testStepPassed(c41);*/
			/*verifyQuoteOfTheDay();
			verifyWelcomeAds();*/
			boolean galleryBtn=elementPresent(OR.txt_Welcome_Gallery_Page_Continue);
			if(galleryBtn==true)
			{
				String gallery=getText(OR.txt_Welcome_Gallery_Page_Continue);
				
					testStepPassed("Continue to Gallery is Displayed-"+gallery);
				
				clickOn(OR.txt_Welcome_Gallery_Page_Continue);
			
			}
			else
			{
				testStepInfo("Redirected to Gallery Page");
			}
			
			
			String currenturl=driver.getCurrentUrl();
			//testStepPassed(""+currenturl);
			waitTime(5);
			//getCurrentPageURL();
			waitTime(5);
			String currentURL=driver.getCurrentUrl();
			testStepPassed(""+currentURL);
			String[] splitURL=currentURL.split("/");
			String c1=splitURL[0];
			String c2=splitURL[1];
			String c3=splitURL[2];
			String c4=splitURL[5];
			
			testStepPassed(c1);
			testStepPassed(c2);
			testStepPassed(c3);
			testStepPassed(c4);
			String replace=c4.replaceAll("-", "");
			testStepPassed(replace); 
			if(replace.contains(lowerCase) || replace.equalsIgnoreCase(lowerCase) ||currentURL.contains(currenturl))
			{
			
				testStepPassed("Page is navigated to Gallery Page");
			}
			else
			{
				testStepFailed("Page is not navigated to Gallery Page");
			}
		}
	}
		else
		{
			validateGalleryInMobile();
		}
	}
		
			
	public void validateGalleryInMobile()
	{
		try {
			boolean latestArticle=elementPresent(OR.txt_Mob_Welcome_Article_Page_Latest_Link);
			if(latestArticle==true)
			{
				
				String articleLink=getText(OR.txt_Mob_Welcome_Article_Page_Latest_Link);
				//testStepPassed(articleLink);
				
				String galleryLink=articleLink.replaceAll("\\s+","");
				//testStepPassed(galleryLink); 
				String lowerCase=galleryLink.toLowerCase();
				
				clickOn(OR.txt_Mob_Welcome_Article_Page_Latest_Link);
				waitTime(3);
				String currentUrl=driver.getCurrentUrl();
				testStepPassed("Current URL is -"+currentUrl);
				String[] splitUrl=currentUrl.split("//");
				String s1=splitUrl[0];
				String s2=splitUrl[1];
				String s3=splitUrl[2];
				
				String[] s4=s3.split("&");
				String s5=s4[0];
				String s6=s4[1];
				testStepPassed(s1);
				testStepPassed(s2);
				testStepPassed(s3);
				testStepPassed(s5);
				testStepPassed(s6);
				//verifyQuoteOfTheDay();
				//verifyWelcomeAds();
				boolean galleryButton=elementPresent(OR.txt_Welcome_Gallery_Page_Continue);
				if(galleryButton==true)
				{
					//clickOn(OR.txt_Welcome_Gallery_Page_Continue);
					testStepPassed("Continue To Site Gllery is Present");
					
					/*String gallery=getText(OR.txt_Welcome_Gallery_Page_Continue);
					testStepPassed(""+gallery);*/
					
				}
				else
				{
					testStepInfo("Redirected to Gallery Page");
				}
				
				waitTime(5);
				String currentURL=driver.getCurrentUrl();
				testStepPassed(""+currentURL);
				String[] splitURL=currentURL.split("//");
				String c1=splitURL[0];
				String c2=splitURL[1];
				testStepPassed(c1);
				testStepPassed(c2);
				/*String c3=splitURL[2];
				String c4=splitURL[5];
				
				testStepPassed(c1);
				testStepPassed(c2);
				testStepPassed(c3);
				testStepPassed(c4);
				String replace=c4.replaceAll("-", "");
				testStepPassed(replace);*/ 
				if(currentUrl.contains(currentURL)||c2.contains(s5))
				{
				
					testStepPassed("Page is navigated to Gallery Page");
				}
				else
				{
					testStepFailed("Page is not navigated to Gallery Page");
				}
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
			
	
}
