/**
 * Check all the ads and the page has content
 * Real Time label with the graph
 * Chek all the lins(All, Business, Investing, Tech etc)
 * Check for the stream
 * Check Load more button at the bottom of the page

 */

package realTimePage;



import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

// TODO: Auto-generated Javadoc
/**
 * The Class RealTimePageValidation.
 * class names are written in mixed case with the first letter of each internal word capitalized
 */
public class RealTimePageValidation extends ApplicationKeywords {
	
	/** The obj. */
	BaseClass obj;


	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :New Posts Page Validation
	// Created by :Shakira
	// Created on :9 June 2016
	
	// ///////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Instantiates a new real time page validation.
	 *
	 * @param obj the obj
	 */
	public RealTimePageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new real time page validation.
	 */
	public RealTimePageValidation() {

	}

	/**
	 * Verify new posts page.
		 */
	public void verifyNewPostsPage() {
		
		if (currentExecutionMachineName.equalsIgnoreCase("NewPosts_MostPopular_Angular"))
		{
			
			/*boolean continueToSite=elementPresent(OR.txt_Home_Forbes_Continue_site);
			if(continueToSite==true)
			{
			
				clickOn(OR.txt_Home_Forbes_Continue_site);
			}
			else
			{
				testStepFailed("falied");
			}*/
			validatePageLoadTime("http://www.forbes.com/real-time/?nowelcome",21, "New Posts Page");
			verifyNewPostsTitle();
			waitTime(2);
			verifyGraph();
			verifyRealTimeChannelTabs();
			verifyNewPostedPosts();
		
			verifyRealTimeAds();
			validateLoadMore();
		}
		else
		{
			validatePageLoadTime("http://www.forbes.com/real-time/?nowelcome",11, "New Posts Page");
			waitTime(5);
			validateNewPostsHeading();
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
			verifyRecentPostsInNewPosts();
			
		}

	}

	public void verifyNewPostsTitle()
	{
		boolean newPosts=elementPresent(OR.txt_Header_Navigation_New_Post);
		if(newPosts==true)
		{
			String varRealPost = getText(OR.txt_Header_Navigation_New_Post);
			testStepPassed("Title of the Page--" + varRealPost);
			testStepPassed("Navigated to New Posts Page");
		}
		else
		{
			testStepFailed("Failed to navigate to New Posts");
		}
	}
	public void verifyNewPostedPosts()
	{
		testStepInfo("**************Newly Posted Events*******************");
		try {
			scrollBy(0, 100);
			waitForElement(OR.txt_New_Posts_link);
			boolean newPosts=elementPresent(OR.txt_New_Posts_link);
			if (newPosts==true) 
			{
			
				String newPostsLink=getText(OR.txt_New_Posts_link);
				testStepPassed(newPostsLink);
			}
			else
			{
				testStepFailed("Newly Posted Posts are not loaded");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Verify graph.
	 */
	public void verifyGraph() {
		String varGraph = null;
		testStepInfo("************************************* Graph *******************************************");
		try {
			int graphNo=1;
			for (graphNo = 1; graphNo <= 3; graphNo++) {

				waitTime(3);
				varGraph = "Graph#xpath=//div[@class='visualStats']//dd[" + graphNo
						+ "]//canvas";
				 boolean graph=elementPresent(varGraph);
				testStepPassed("Graph -"+graphNo+"-"+graph);

			}
			
			int labelNo=1;
			for (labelNo= 1; labelNo <= 3; labelNo++) {
				String label = "Label#xpath=//div[@class='visualStats']//dt[" + labelNo
						+ "]";
				String textLabel = getText(label);
				testStepPassed("Graph is present with Labels--" + textLabel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	/**
	 * Validate load more.
	 */
	public void validateLoadMore() {
		testStepInfo("**************************Load More*******************");
		try {
			boolean loadMore = elementPresent(OR.txt_New_Posts_Load_More);
			if (loadMore == true) {
				testStepPassed("Load More option is displayed");
			}
			else
			{
				testStepFailed("Load More option is not displayed ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	
	}

	/**
	 * Verify real time channel tabs.
	 */
	public void verifyRealTimeChannelTabs() {
		int countImages = 0;
		testStepInfo("*************************************Real Time Channel Tabs********************************************");
		try {
			int channelTab=1;
			for (channelTab = 1; channelTab <= 8;channelTab++) {

				String varXpath = "Real time Channel Tabs#xpath=//div[@id='realtimechanneltabs']//ul//li[@data-channel-mapping='channel_"
						+ channelTab + "']";

				clickOn(varXpath);
				waitTime(2);
				String varChannel = getText(varXpath);

				testStepPassed("Real time channel is --" + varChannel);
				boolean image = elementPresent(OR.img_New_Posts_Images);
				if (image == true) {
					countImages = getElementCount(OR.img_New_Posts_Images);
					//manualScreenshot(OR.img_New_Posts_Images);
					testStepPassed("Total images are dispalyed --" + countImages);
					// testStepPassed("Images are Displayed");

				} else {
					testStepFailed("Images are not Displayed");
				}

			}

			clickOn(OR.txt_New_Posts_Channel_Tab10);
			String varChannel = getText(OR.txt_New_Posts_Channel_Tab10);
			testStepPassed("Real time channel is --" + varChannel);

			clickOn(OR.txt_New_Posts_Channel_Tab);
			String varChannel1 = getText(OR.txt_New_Posts_Channel_Tab);
			testStepPassed("Real time channel is --" + varChannel1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	/**
	 * Mobile Script
	 * Created On : 21 June
	 */
	public void validateNewPostsHeading()
	{
		try {
			//clickOn(OR.tab_Mob_New_Posts);
			waitTime(5);
			String newPostsHeading=getText(OR.txt_Header_Navigation_New_Post);
			testStepPassed("Redirected to - "+newPostsHeading+" -Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void verifyRecentPostsInNewPosts()
	{
		
		//clickOn(OR.txt_Mob_New_Posts_Recent);
		try {
			boolean recentPosts=elementPresent(OR.txt_Mob_New_Posts_Recent);
			if (recentPosts==true)
			{
				String recentPost=getText(OR.txt_Mob_New_Posts_Recent);
				testStepPassed("New Post is -"+recentPost);
				testStepPassed("Recent Posts is displayed");	
			}
			else
			{
				testStepFailed("Recent Posts is not displayed");	
				
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		scrollBy(0, 700);
		verifyLoadMoreInRealTime();
		
	}
}
