package testingBuckets;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

import org.openqa.jetty.html.Heading;

import baseClass.BaseClass;

public class Report404Validation extends ApplicationKeywords{
	/** The obj. */
	BaseClass obj;
	public Report404Validation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}
	public Report404Validation() {

		// TODO Auto-generated constructor st ub
	}

	
	public void validate404Report()
	{
		
		
		if (currentExecutionMachineName.equalsIgnoreCase("TestingBucket"))
		{
					
			validateTestingBucket404();
		/*validateArticle_d_delta_b();
		validateArticle_d_delta_c();
		//validateArticle_delta_d();
		validateArticle_delta_e();
		//validateArticle_d_delta_f();
		validateArticle_d_delta_i();
		validateArticle_d_dela_j();
		validateArticle_d_delta_t();
		validateArticle_d_delta_d();
		
		validatePictures_delta_b();
		validatePictures_delta_c();
		//validateArticle_d_rc_b();
		validateGallery_rc_b();
		validateArticle_d_delta_g();
		validateArticle_d_delta_h();
		validateArticle_d_delta_u();
		validateWelcome_delta_b();
		validatePictures_delta_x();
		validateArticle_d_delta_k();
		validateArticle_d_delta_l();
		validateArticle_d_delta_f();*/
		//validateMostPopularHashTag();
		}
		else
		{
			
			//validateTestingBucket404();
			validateWelcome_delta_b();
			validateArticle_d_dela_j();
			validatePictures_delta_x();
			validateArticle_d_delta_d();
			validateArticle_d_delta_t();
			validateArticle_d_delta_g();
			validateArticle_d_delta_h();
			validateArticle_d_delta_k();
			validateArticle_d_delta_l();
			//validateWelcome_delta_b();
			
			validateArticle_d_delta_f();
		
			
			
		}
	}
	
	
	
	public void validateTestingBucket404()
	{
		try {
		String[] urlList = {
				
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-b#4877ad8c49ab",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-c#7569671349ab",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-e#101e7a5349ab",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-i#43ef798649ab",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-j#358fb94f49ab",
				
				
				"http://www.forbes.com/pictures/emjl45mmei/the-worlds-highest-paid-/?view=beta-b",
				"http://www.forbes.com/pictures/feki45ehllk/9-charlottesville-virg/?view=beta-c",
				"http://www.forbes.com/pictures/emjl45mmei/the-worlds-highest-paid-/?view=beta-x",
				"http://www.forbes.com/pictures/emjl45mmei/the-worlds-highest-paid-/?view=angular_gallery",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-d#4877ad8c49ab",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-t",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-g#442bba0e49ab",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-h#318c047749ab",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-k",
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-l",
				/*"http://www.forbes.com/forbes/welcome/?view=beta-b",*/
				"http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-u"
				
		
		
		};
		
			int size=urlList.length;
			testStepPassed("Total Number of URLs--->"+size);
			System.out.println("Number of URLs "+size);
			for (int i = 1; i <=size; i++) {

				driver.get(urlList[i]);
				waitTime(5);
				testStepPassed("Entered URL is -" + urlList[i]);
			
				  
				String getTitle = driver.getTitle();
				testStepPassed("Title of the page is -------->" + getTitle);
				
				
				if(getTitle.equals("404"))
				{
					testStepPassed("URL no : "+i+" URL: " +urlList[i]+ "\n\t Status-----> INVALID");
					manualScreenshot(getTitle);
					testStepFailed("URL is throwing error");
				}
				else
				{
					testStepPassed("URL no : "+i+" URL: " +urlList[i]+ "\n\t Status-----> VALID");
					testStepPassed("URL is navigated to correct page");;
				}
				
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateMostPopularHashTag()
	{
		testStepInfo("********************************* Most Popular Hashtag ****************************************");
		driver.get("http://www.forbes.com/most-popular/hashtags");
		boolean heading=elementPresent(OR.txt_Testing_buckets_MostPopularHashTag_Title);
		if(heading==true)
		{
			testStepPassed("Page is navigated to Most Popular page");
		}
		else
		{
			getCurrentPageURL();
			testStepFailed("Failed to navigate to the Most Popular Page");
		}
	}
	
	
	
	public void validateArticle_d_delta_b()
	{
		testStepInfo("********************************* Article_d_delta_b ****************************************");
		try {
			driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-b#4877ad8c49ab");
			//driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-b#4877ad8c49ab");
			waitTime(3);
			getCurrentPageURL();
			validateTestBucketURL();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	public void validateArticle_d_delta_c()
	{
		
		testStepInfo("********************************* Article_d_delta_c ****************************************");
		try {
			driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-c#7569671349ab");
			waitTime(3);
			validateTestBucketURL();
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateArticle_delta_d()
	{
		testStepInfo("********************************* Article_d_delta_d ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-d#4877ad8c49ab");
		
		
		validateTestBucketURL();
	}
	
	public void validateArticle_delta_e()
	{
		testStepInfo("********************************* Article_d_delta_e ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-e#101e7a5349ab");
		
		waitTime(3);
		validateTestBucketURL();
	}
	
	
	public void validateArticle_d_rc_b()
	{
		testStepInfo("********************************* Article_d_rc_b ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=angular_article#6df4694749ab");
		
		waitTime(3);
		validateTestBucketURL();
	}
	
	
	public void validatePictures_delta_c()
	{
		
		testStepInfo("********************************* Pictures_delta_c ****************************************");
		driver.get("http://www.forbes.com/pictures/feki45ehllk/9-charlottesville-virg/?view=beta-c");
		waitTime(3);
		validateTestBucketURL();	
	}
	
	public void validatePictures_delta_x()
	{
		
		testStepInfo("********************************* Pictures_delta_x ****************************************");
		driver.get("http://www.forbes.com/pictures/emjl45mmei/the-worlds-highest-paid-/?view=beta-e");
		waitTime(3);
		validateTestBucketURL();	
	}
	
	public void validatePictures_delta_b()
	{
		testStepInfo("********************************* Pictures_delta_b ****************************************");
		driver.get("http://www.forbes.com/pictures/emjl45mmei/the-worlds-highest-paid-/?view=beta-b");
		
		validateTestBucketURL();
	}
	
	public void validateArticle_d_dela_j()
	{
		testStepInfo("********************************* Article_d_dela_j ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-j#358fb94f49ab");
		validateTestBucketURL();
	}
	
	public void validateArticle_d_delta_i()
	{
		testStepInfo("********************************* Article_d_delta_i ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-i#43ef798649ab");
		validateTestBucketURL();
	}
	
	public void validateArticle_d_delta_f()
	{
		testStepInfo("********************************* Article_d_delta_f ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-f#670ebc4149ab");
		validateTestBucketURL();
	}
	
	public void validateArticle_d_delta_e()
	{
		testStepInfo("********************************* Article_d_delta_e ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-e#101e7a5349ab");
		validateTestBucketURL();
	}
	public void validateArticle_d_delta_d()
	{
		testStepInfo("********************************* Article_d_delta_d ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-d#4877ad8c49ab");
		validateTestBucketURL();
	}
	

	public void validateArticle_d_delta_g()
	{
		testStepInfo("********************************* Article_d_delta_g ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-g#442bba0e49ab");
		validateTestBucketURL();
	}
	
	public void validateArticle_d_delta_h()
	{
		testStepInfo("********************************* Article_d_delta_h ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-h#318c047749ab");
		validateTestBucketURL();
	}
	
	
	
		
		public void validateArticle_d_delta_u()
	{
		testStepInfo("********************************* Article_d_delta_u ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-u");
		validateTestBucketURL();
	}
	public void validateArticle_d_delta_k()
	{
		testStepInfo("********************************* Article_d_delta_k ****************************************");
		waitTime(3);
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-k");
		//driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-k");
		validateTestBucketURL();
	}
	
	public void validateArticle_d_delta_l()
	{
		testStepInfo("********************************* Article_d_delta_l ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-l");
		validateTestBucketURL();
	}
	
	public void validateArticle_d_delta_t()
	{
		testStepInfo("********************************* Article_d_delta_t ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=beta-t");
		validateTestBucketURL();
	}
	public void validateWelcome_delta_b()
	{
		testStepInfo("********************************* Welcome_delta_b ****************************************");
		driver.navigate().to("http://www.forbes.com/forbes/welcome/?view=beta-b");
		validateTestBucketURL();
	}
	public void validateArticle_rc_b()
	{
		testStepInfo("********************************* Article_rc_b ****************************************");
		driver.get("http://www.forbes.com/sites/jaredmeyer/2016/05/11/by-losing-uber-austin-is-no-longer-a-tech-capital/?view=angular_article");
		validateTestBucketURL();
	}
	
	public void validateGallery_rc_b()
	{
		testStepInfo("********************************* Gallery_rc_b ****************************************");
		//driver.get("http://www.forbes.com/pictures/emjl45mmei/the-worlds-highest-paid-/?view=angular_gallery_mobile");
		driver.get("http://www.forbes.com/pictures/emjl45mmei/the-worlds-highest-paid-/?view=angular_gallery");
		validateTestBucketURL();
	}

	public void validateWelcome()
	{
		testStepInfo("******************************** Home Page **************************************");
		try {
			waitTime(1);
			boolean topStoryLabel=elementPresent(OR.txt_Home_Page_Top_Stories);
			if(topStoryLabel==true)
			{
				String heading=getText(OR.txt_Home_Page_Top_Stories);
				if(!heading.equals("4-0-"))
				{
					testStepPassed("Redirected to -"+heading+"-Page");
				}
				
				else
				{
					testStepFailed("Throwing 404 Error");
				}
				
			}
			else
			{
				testStepFailed("Failed to navigate Home page");
			}
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateTestBucketURL()
	{
		try {
			waitTime(5);
			
			/*boolean articleHeading=elementPresent(OR.txt_Article_Page_Heading);
			if(articleHeading==true)
			{*/
				//String heading=getText(OR.txt_Article_Page_Heading);
				//getCurrentPageURL();
				
				String title=driver.getTitle();
				if(!title.equals("404"))
				{
					testStepPassed("Page is navigated to correct page");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed("Failed to navigate to the  Page");
				}
				
			/*}
			else
			{
				getCurrentPageURL();
				testStepFailed("Article Heading is not Displayed");
			}*/
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/*public void validateArticle1()
	{
		testStepInfo("********************************* Article Page *********************************");
		try {
			waitTime(5);
			scrollBy(0, 100);
			boolean articleHeading=elementPresent(OR.txt_Article_Page_Heading);
			boolean error=elementPresent(OR.txt_Testing_Buckets_404_Error);
			boolean articleHeading1=elementPresent(OR.txt_Article_Page_Heading1);
			if(articleHeading1==true ||articleHeading==true)
			{
				String heading=getText(OR.txt_Article_Page_Heading1);
				getCurrentPageURL();
				testStepPassed("Redirected to -"+heading+"-Page");
			}
			else if(error==true)
			{
				testStepFailed("Page is having 404 Error");
			}
			else
			{
				getCurrentPageURL();
				testStepFailed("Failed to navigate to the Article Page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/
	/*public void validateGallery()
	{
		
		testStepInfo("********************************* Gallery Page *********************************");
		try {
			String currentUrl=driver.getCurrentUrl();
			boolean error=elementPresent(OR.txt_Testing_Buckets_404_Error);
			
			if(error==true)
			{
				takeAdScreenshot(OR.txt_Testing_Buckets_404_Error,"404 Error");
				testStepFailed("Page is having 404 Error");
			}
			else
			{
				getCurrentPageURL();
				testStepPassed("Navigated to the Gallery Page");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}*/
	
	
}
