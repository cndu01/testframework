package groupContributorPage;

import iSAFE.ApplicationKeywords;


import objectsRepository.OR;


import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class GroupContributorPageValidation extends ApplicationKeywords {

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
	public GroupContributorPageValidation(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	
	/**
	 * Instantiates a new contributor page validation.
	 */
	public GroupContributorPageValidation() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * Validate contributor page.
	 */
	public void validateGroupContributorPage() {
		testStepInfo("************************************************** Contributor Page ****************************************************");
		if (currentExecutionMachineName.equalsIgnoreCase("Contributor_BrandVoice"))
		{
			
			
			
			driver.get("http://www.forbes.com/sites/sportsmoney/?view=csf_contrib");
			verifyAuthorName();
			validateContributorImage(OR.img_Reg_Contributor_Page_Image);
			validatecontributorDetails(OR.img_Reg_Groupcontributor_Logo,OR.txt_Reg_Contributor_Page_TypeOFContributor);
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			//verifyFullBio();
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validateAboutSection();
			validateOurWriters();
			validateWritersHomePage();
			validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validatePromoVideoBlock();
			scrollBy(0, -1000);
			validateArchiveContributor();
			//validateLatestPostsImages();
			clickingAllLatestPosts();
			
			validateMostPopularArticles();
		
			/*verifyAuthorName();		
			validatecontributorDetails(OR.img_Reg_Groupcontributor_Logo,OR.txt_Reg_Contributor_Page_AuthorType);
			validateSocialSidebar(OR.sidebar_BVHomePage_socialIcons);
			validateTagLine();
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			scrollBy(0, 300);
			validateContriCarousel();
			
			
		
			//scrollBy(0, 550);
			scrollBy(0, -250);
			validateContributorTopFeatures();
			validateAboutSection();
			validateAboutOurWriter();
			verifyAdsContributorPage();
			scrollBy(0, -200);
			clickingAllLatestPostsAndGallery();
			scrollBy(0, -300);
			clickArchive();
			checkShowMoreCircleButtons();
			clickingAllMostPopularArticles();
			verifyDoNotMissLayout();*/
			
		}
		else
		{
		
			verifyContributorNameInMobile();
			validatecontributorDetails(OR.img_Reg_Contributor_Page_Image,OR.txt_Reg_Contributor_Page_TypeOFContributor);
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			
			//verifyAuthorNameInMobile();
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			this.scrollBy(0, -10);
			//validateTopAds(OR.ads_Welcome_Page_Ads);
			validateLatestPostsInMobile();
			validateArchiveContributor();
			
			//validateRecAds(OR.ads_Podcasts_Page_TopAds);
			validateMostPopularArticlesInMobile();
			
		
		}
		
	}
	
	
	
	
	
	public void validateQAVideoSection()
	{
		testStepInfo("********************************** QA Video ***********************************");
		try {
			boolean qaVideo=elementPresent(OR.vid_Reg_GroupContributor_Video);
			if(qaVideo==true)
			{
				testStepPassed("QA Test- Video Block is Displayed");
			}
			else
			{
				testStepFailed("QA Test-Video Block is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateTwitterSection()
	{
		testStepInfo("********************************** QA Test  ***********************************");
		try {
			boolean twitterBlock=elementPresent(OR.txt_Reg_GroupContributor_TwitterBlock);
			if(twitterBlock==true)
			{
				testStepPassed("QA Test- Twiiter Block is Displayed");
			}
			else
			{
				testStepFailed("QA Test-Twitter Block is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
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
			}
			else
			{
				testStepFailed("About Description is not Displayed");
			}
			
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateAboutOurWriter()
	{
	
		boolean writer=elementPresent(OR.txt_Reg_GroupContributor_FirstWriter);
		if(writer==true)
		{
			clickOn(OR.txt_Reg_GroupContributor_FirstWriter);
			
			boolean writerName=elementPresent(OR.txt_Reg_GroupContributor_WriterName);
			if(writerName==true)
			{
				String getWriterName=getText(OR.txt_Reg_GroupContributor_WriterName);
				testStepPassed(getWriterName);
				boolean viewPosts=elementPresent(OR.txt_Reg_GroupContributor_ViewPosts);
				boolean close=elementPresent(OR.txt_Reg_GroupContributor_Close);
				if(viewPosts==true &&close==true)
				{
					clickOn(OR.txt_Reg_GroupContributor_Close);
					waitTime(2);
					testStepPassed("View Posts and close are present");
				}
				else
				{
					testStepFailed("View Post and close buttons are not Displayed");
				}
			}
			else
			{
				testStepFailed("Writer Name is not Displayed");
			}
		}
	}
	
	public void validateTagLine()
	{
		try {
			boolean tagLine=elementPresent(OR.txt_Reg_Contributor_Page_TagLine);
			if(tagLine==true)
			{
				String getTagLine=getText(OR.txt_Reg_Contributor_Page_TagLine);
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
	

	
}
