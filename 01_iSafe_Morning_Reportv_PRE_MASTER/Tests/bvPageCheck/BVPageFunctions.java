package bvPageCheck;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class BVPageFunctions extends ApplicationKeywords{
	
	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :
	// Purpose :
	// Parameters :
	// Return Value :
	// Created by :
	// Created on :
	// Remarks :
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Instantiates  BVPage Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public BVPageFunctions(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public BVPageFunctions() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyBVpageContents(){
		testStepInfo("*********************************BV Page validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Contributor_BrandVoice")) {

			//driver.get("http://www.forbes.com/sites/northwesternmutual/?view=csf_contrib");
			
			
			verifyAuthorName();
			
			validateContributorImage(OR.img_Reg_Contributor_Page_Image);
			
			validateVoiceLogo(OR.txt_Reg_BrandVoice_ForbesLogo, OR.txt_Reg_BrandVoice_BrandVoiceLogo, "BrandVoice");
			validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
			validateWhatIsThisLabel();
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validatePromoSectionInBrandVoice();
			validateAboutSection();
			validateFilterTabs();
			/*validateTopAds(OR.ads_Reg_Contributor_Page_TopAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);*/
			validatePromoVideoBlock();
			validateRecAds(OR.ads_Reg_Contributor_Page_RecAds);
			//validateRecAds(OR.ads_Reg_Contributor_Page_RecAds2);
			validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			scrollBy(0, -3000);
			validateArchiveContributor();
			scrollBy(0, 400);
			validateAlLatestPosts();
			
			validateMostPopularArticles();
			
			
			validateOurWriters();
			validateWritersHomePage();
			//verifyBVPageContentsInDesktop();

		} else {
			//validateBrandVoiceLabelAndImagesInMobile();
			//verifyBVPageContentsInMobile();
			//driver.get("http://www.forbes.com/sites/northwesternmutual/?view=csf_contrib");
			verifyAuthorNameInMobile();
			validateContributorImage(OR.img_Reg_Contributor_Page_Image);
			validateTagLine(OR.txt_Reg_Contributor_Page_TagLine);
			boolean shareButton=elementPresent(OR.btn_contributor_Page_ShareButton);
			validateFilterDropdown();
			
			if(shareButton==true)
			{
				clickOn(OR.btn_contributor_Page_ShareButton);
				validateSocialnetworks(OR.img_Reg_contributor_Page_SocialShares);
				clickOn(OR.btn_contributor_Page_ShareButton);
			}
			else
			{
				testStepFailed("Share Button is not displayed");
			}
			validateVoiceLogo(OR.txt_Reg_BrandVoice_ForbesLogo, OR.txt_Reg_BrandVoice_BrandVoiceLogo, "BrandVoice");
			validateWhatIsThisLabel();
			verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
			validateNetworkShares(OR.img_Reg_Contributor_Page_NetworkShares);
			validatePromoSectionInMobile();
			
			validateBottomAds(OR.ad_Mob_Contributor_Page_BottomSticky);
			//validateTopAds(OR.ads_Reg_Contributor_Page_RecAds);
			
			validateAboutSection();
			
			validateArchiveContributor();
			
			validateLatestPostsInMobile();
			//validateTopxAds(OR.ads_Reg_Contributor_Page_TopxAds);
			validateMostPopularArticlesInMobile();
			validateOurWriters();
			validateWritersHomePage();
		}
	}
	
	
	
	//14 Dec 
	public void validateFilterDropdown()
	{
		testStepInfo("**************************************** Validate Filtering tabs****************************************");
		boolean dropDown=elementPresent("#xpath=//div[@class='list-hover']//ul//li");
		if(dropDown==true)
		{
			this.scrollToElement("Tabs#xpath=//div[@class='list-hover']//ul//li");
			this.scrollBy(0, -60);
			clickOn("Tabs#xpath=//i[@class='icon icon-chevron-down']");
			int count=getElementCount("#xpath=//div[@class='list-hover']//ul//li");
			testStepPassed("Total Number of Tabs--->"+count);
			String getAll=null;
			for (int j = 1; j <=count; j++) {
				getAll=getText("Tabs#xpath=//div[@class='list-hover']//ul//li["+j+"]//a");
				testStepPassed("Tab names--->"+getAll);
			}
			
			for (int i = 2; i <=3; i++) {
				//String tabNameInFilter=getText("Brandvoice Tabs#xpath=//div[@class='list-hover']//ul//li["+i+"]//a");
				
				this.scrollToElement("Tabs#xpath=//div[@class='list-hover']//ul//li");
				this.scrollBy(0, -60);
				clickOn("Arrow down#xpath=//i[@class='icon icon-chevron-down']");
				
				this.scrollToElement("Tabs#xpath=//div[@class='list-hover']//ul//li["+i+"]//a");
				this.scrollBy(0, -60);
				clickOn("Tabs#xpath=//div[@class='list-hover']//ul//li["+i+"]//a");
				
				//Not Required to add parameter ?view=csf_contrib
				
				/*String url=driver.getCurrentUrl();
				testStepPassed(url);
				String[] splittedUrl= url.split("#");
				String firstPart=splittedUrl[0];
				String secPart=splittedUrl[1];
				//testStepPassed(firstPart);
				//testStepPassed(secPart);
				String appenedURL=firstPart.concat("?view=csf_contrib");
				driver.get(appenedURL);*/
				
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
					testStepPassed("Tab Name is Displayed in the Latest--->"+sec);
					
				/*	if(getAll.trim().contains(s2))
					{
						testStepPassed(" Filter Tab name is matching in Latest ");
					}
					else
					{
						getCurrentPageURL();
						testStepFailed(" Filter Tab name is not matching in Latest ");
					}*/
				}
				else
				{
					testStepFailed("Latest Label is not Displayed");
				}
				
				validateLatestPostsInMobile();
				clickOnBackButton();
				//clickOnBackButton();
				
			}
			
		}
	}
	
	
	
	public void validatePromoSectionInMobile()
	{
		testStepInfo("******** Validating Promo Section ************");
		try {
			boolean promo=elementPresent(OR.txt_Reg_Brandvoice_Article_Page_Promo);
			boolean promoTitle=elementPresent(OR.txt_Reg_BrandVoice_PromoTitle);
			if(promo==true &&promoTitle==true)
			{
					this.scrollToElement(OR.txt_Reg_Brandvoice_Article_Page_Promo);
					scrollBy(0, -60);
					testStepPassed("Promo Block is present");
					
					boolean moreButton=elementPresent(OR.btn_Reg_BrandVoice_Page_Toggle);
					if(moreButton==true)
					{
						this.scrollToElement(OR.btn_Reg_BrandVoice_Page_Toggle);
						this.scrollBy(0, -60);
						clickOn(OR.btn_Reg_BrandVoice_Page_Toggle);
						boolean relatedArticles=elementPresent(OR.txt_Reg_Brandvoice_PromoBlockRelated_Articles);
						if(relatedArticles==true)
						{
							int getArticlesCount=getElementCount(OR.txt_Reg_Brandvoice_PromoBlockRelated_Articles);
							testStepPassed("Related Articles in the promo section --"+getArticlesCount);
							
							boolean lessButton=elementPresent(OR.btn_Reg_BrandVoice_Page_Toggle);
							if(lessButton==true)
							{
							this.scrollToElement(OR.btn_Reg_BrandVoice_Page_Toggle);
							this.scrollBy(0, -60);
							clickOn(OR.btn_Reg_BrandVoice_Page_Toggle);
							}
							else
							{
								testStepFailed("Less button is not present");
							}
							
						}
						else
						{
							testStepFailed("Related Articles are not present in the Promo section");
						}
					}
					else
					{
						testStepFailed("More button is not present");
					}
			}
			else
			{
				getCurrentPageURL();
				testStepInfo("Promo Section is not Displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
	
	
	/*
	 * Verify BrandVoice page contents on Desktop
	 */
/*	public void verifyBVPageContentsInDesktop(){
	try{
		
		verifyBVPageFields();
		validateSocialSidebar(OR.sidebar_BVHomePage_socialIcons);
		verifyAboutSection();
		waitTime(3);
		validateBrandVoiceAdsInDesktop();
		checkShowMoreCircleButtons();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1000)");
		checkPromoBlockPostsOnBV();
		clickingAllLatestPostsAndGallery();
		scrollBy(0, -300);
		clickArchive();
		checkPostsOnBV();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)");
		clickingAllMostPopularArticles();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-2500)");
		validatingFiltertabs();
		
		clickOnBVContributor();
		clickOnBackButton();
		checkadsOnBVArticlePage();
		scrollBy(0, -2000);
		clickContributorBVArticle();
		verifyAuthorName();
		verifyFullBio();
		verifyFollowInDeskyop();
		validateContriCarousel();
		validateBrandVoiceAdsInDesktop();
		validateContributorTopFeatures();
		//verifyDoNotMissLayout();
		verifyMostPopular();
		
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/
	/*
	 * Verify BrandVoice page contents on Mobile
	 */
/*	public void verifyBVPageContentsInMobile(){
		testStepInfo("*********************************Mobile BV Page validation**********************************");
		waitForElement(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
		checkShowMoreCircleButtons();
		validateLatestPost();
		validateBrandVoiceAdsInMobile();
		
		checkadsOnBVArticlePage();
		
	}*/
	
	/*public void verifyBVPageFields(){
		testStepInfo("********************************* BV Page fields validation**********************************");
		boolean bvimage=elementPresent(OR.txt_BVPage_Validation_Imageicon);
		if(bvimage==true)
		{
			testStepPassed("BV Page-->Image is displayed");
		}
		else
		{
			testStepFailed("BV Page-->Image is not displayed");
		} 
		verifyFollowInDeskyop(OR.btn_Contributor_Page_Follow);
		verifyWhatisthisOnDesktop();
		
	}*/
	
	public void verifyAboutSection(){
		try{
		boolean bvaboutheader=elementPresent(OR.txt_BVPage_Validation_Aboutheader);
		if(bvaboutheader==true)
		{
			testStepPassed("BV Page-->About header is displayed");
		}
		else
		{
			testStepFailed("BV Page-->About header is not displayed");
		} 
		boolean bvourcontributors=elementPresent(OR.txt_BVPage_Validation_OurContributors);
		if(bvourcontributors==true)
		{
			testStepPassed("BV Page-->Our Contributors text is displayed");
		}
		else
		{
			testStepFailed("BV Page-->Our Contributors text is not displayed");
		} 
		int numOfContributorimages=getElementCount(OR.icons_AllContributoricons);
		if(numOfContributorimages<=7){
			testStepPassed("Number of contributors are less than 7. No Show more button displayed");
		}
		else if(numOfContributorimages>7){
			testStepPassed("Number of contributors are 7. Checking for Show more button");
			boolean isPresent=elementPresent(OR.icons_showmoreInAbout);
			if(isPresent==true){
				testStepPassed("Show more button is displayed with 7 contributor images");
			}
			else{
				testStepFailed("Show more button is not displayed with 7 contributor images");
			}
		}
		else{
				testStepFailed("could not get the contributors count");
			}
		boolean readmoreicon=elementPresent(OR.icons_readmoreInAbout);
		if(readmoreicon==true){
			testStepPassed("readmore is displayed in the description");
			clickOn(OR.icons_readmoreInAbout);
			clickOn(OR.icons_readlessInAbout);
		}
		else{
			testStepPassed("Description is short. No read more in it.");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		}
	
	/**
	 * check the contributor details from bio section
	 */
	public void clickOnBVContributor(){
		try{
			testStepInfo("*********************************Clicking on Contributor Image from About Section**********************************");
			clickOn(OR.img_BrandVoice_Page_Contrib_Image);
			String contribnameinimage=getAttributeValue(OR.img_BrandVoice_Page_Contrib_Image, "title");
			String contribnameinbio=getText(OR.txt_BrandVoice_Page_Contrib_Name_Bio_Container);
			Boolean isviewpostsdisplayed = elementPresent(OR.link_BrandVoice_Page_Contrib_ViewAllPosts);
			if(isviewpostsdisplayed==true){
				testStepPassed("BV Page-->Contributor Bio Section is displayed");
				if(contribnameinimage.equals(contribnameinbio)){
					testStepPassed("BV Page-->Contributor image is clicked and the name is displayed in the bio section");
				}
				else{
					testStepFailed("BV Page-->Contributor image is clicked and the name is not displayed in the bio section");
				}
				scrollBy(0, 50);
				clickOn(OR.link_BrandVoice_Page_Contrib_ViewAllPosts);
				waitForElement(OR.txt_BrandVoice_ContribPage_Name);
				String contribNameinContibPage=getText(OR.txt_BrandVoice_ContribPage_Name);
				if(contribNameinContibPage.equals(contribnameinbio)){
					testStepPassed("BV Page-->Contributor name in bio on clciking view posts is directed to the contributor page");
				}
				else{
					testStepPassed("BV Page-->Contributor name in bio on clciking view posts is not directed to the contributor page");
				}
			}else{
				testStepFailed("BV Page-->Contributor Bio Section is not displayed");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	/**
	 * check the posts on BV promoblock 
	 */
	public void checkPromoBlockPostsOnBV(){
		try{
		testStepInfo("*****Validating promoblock posts on BV page*****");
		this.scrollBy(0, -400);
		for(int i=1;i<=getElementCount(OR.txt_promoblockArticles);i++){
			verifyArticleTextsInNewtab("#xpath=//section[contains(@class,'section section-1')]/div/ul/li["+i+"]/a[2]/h3","#xpath=//section[contains(@class,'section section-1')]/div/ul/li["+i+"]/a[2]/h3",OR.txt_ArticleTextInLandingpage);
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/**
	 * check the posts on BV page
	 */
	public void checkPostsOnBV(){
		try{
		testStepInfo("*********************************Verifying posts on BV page**********************************");
		int postCount = getElementCount(OR.txt_BVPage_Validation_BVPosts);
		if(!elementPresent(OR.txt_BVPage_Validation_BV6thPost) &&
				postCount==5){
		testStepPassed("BV Page validation (BV PostStream Showmore Button displayed after - " + postCount+" posts");
		clickOn(OR.txt_BVPage_Validation_showMoreButtonAfter5BVPosts);
		}
		else{
			testStepInfo("BV Page validation (BV PostStream Showmore Button is displayed after - " + postCount+" posts");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/**
	 * Validating all latest posts
	 */
	/*public void clickingAllLatestPosts(){
		try{
			testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
		for(int i=1;i<=getElementCount(OR.txt_AllArticleTexts);i++){
			verifyArticleTextsInNewtab("#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div/div/a/h3","#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div/div/a/h3",OR.txt_ArticleTextInLandingpage);
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/
	
	/**
	 * Validating all latest posts and Gallery
	 */
	public void clickingAllLatestPostsAndGallery(){
		try{
			testStepInfo("*********Clicking on all the articles in Latest and Validating***********");
		for(int i=1;i<=getElementCount(OR.txt_BVPage_Validation_BVPosts);i++){
			if(getAttributeValue("#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div", "ng-switch-when").equals("blog")){
				testStepPassed("Validating Article post");
			verifyArticleTextsInNewtab("#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div/div/a/h3","#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div/div/a/h3",OR.txt_ArticleTextInLandingpage);
			}
			else if(getAttributeValue("#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div", "ng-switch-when").equals("slide")){
				testStepPassed("Validating Gallery post");
				verifyArticleTextsInNewtab("#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div/div/div/a","#xpath=//ul[@class='common-stream articles edittools-stream']/li["+i+"]/div/div/div/a",OR.txt_AngularGalleryCheck_SlideCount);
			}
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
	/**
	 * Validating Filters on BV Page
	 */
/*	public void validatingFiltertabs(){
		try{
			testStepInfo("*****Validating the filters*****");
			for(int i=2;i<=getElementCount(OR.txt_AllFilterTabs);i++){
				testStepInfo("************************Validating the filter-"+getText("#xpath=//div[@class='sub-blogs-list ng-scope']/div/ul/li["+i+"]/a")+"***************");
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-2500)");
				clickOn("#xpath=//div[@class='sub-blogs-list ng-scope']/div/ul/li["+i+"]/a");
				checkPromoBlockPostsOnBV();
				clickingAllLatestPosts();
				clickingAllMostPopularArticles();
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/
	
	/**
	 * Verify ads on BV article page
	 */
	/*public void checkadsOnBVArticlePage(){
		try{
		testStepInfo("****************************Ads on Brand Voice Article Page********************************************");
		//this.scrollBy(0, -60);
		waitForElement(OR.txt_BVPage_Validation_BV61stPost);
		clickOn(OR.txt_BVPage_Validation_BV61stPost);
		waitTime(3);
		validateArticleTopAds();
		verifyAdsInArticle();
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}*/
	
	public void checkBVRecommendedBY(){
		waitForElement(OR.txt_BVPage_Validation_recommendedbyBVlabel);
		boolean isdisplayed = isElementDisplayed(OR.txt_BVPage_Validation_recommendedbyBVlabel);
			if(isdisplayed==true){
				testStepPassed("BV Page validation --> BV Recommended by BV label is  displayed");
			}
			else{
				testStepFailed("BV Page validation --> BV Recommended by BV label is not displayed in the first article");
			}
		}
	/**
	 * Click contributor name from BV article
	 */
	public void clickContributorBVArticle(){
		try{
		testStepInfo("****************************Contributor on Brand Voice Article Page********************************************");
		String bvArticleContribname=getText(OR.txt_BrandVoiceArticle_Contrib_Name);
		clickOn(OR.txt_BrandVoiceArticle_Contrib_Name);
		waitForElement(OR.txt_BrandVoiceArticle_ContribPage_Header);
		String contribheaderTitle=getText(OR.txt_BrandVoiceArticle_ContribPage_Header);
		if(bvArticleContribname.equals(contribheaderTitle)){
			testStepPassed("BV Article Page--> Clicking on Article contributor name is directed to the contributor page");
		}
		else{
			String url = driver.getCurrentUrl();
			testStepFailed("BV Article Page--> Clicking on Article contributor name is not directed to the contributor page "+url);
		}
		}catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			String url = driver.getCurrentUrl();
			testStepFailed(url);
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void validateBrandVoiceAdsInDesktop()
	{
		scrollBy(0, 600);
		boolean bvAds1=elementPresent(OR.ads_BrandVoice_Page_Ads1);
		if(bvAds1==true)
		{
			testStepPassed("Brand Voice Ad block is displayed");
		}
		else
		{
			testStepFailed("Brand Voice Ad block is not displayed");
		}
		
		scrollBy(0, 900);
		boolean bvAds2=elementPresent(OR.ads_BrandVoice_Page_Ads2);
		if(bvAds2==true)
		{
			testStepPassed("Brand Voice Rec Ad block is displayed");
		}
		else
		{
			testStepFailed("Brand Voice Rec Ad block is not displayed");
		}
		scrollBy(0, 100);
		boolean bvAds3=elementPresent(OR.ads_BrandVoice_Page_Ads3);
		if(bvAds3==true)
		{
			testStepPassed("Brand Voice Topx Ad block is displayed");
			scrollBy(0, -100);
		}
		else
		{
			testStepFailed("Brand Voice Topx Ad block is not displayed");
		}
	}
	
	/**
	 * Validate Contributors in BV 
	 */
	
	public void clickContributorFromBVArticle(){
		
	}
	
	public void readJS(){
		
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver)
				.executeScript("external_services.ad_slots['top-fbs-ad-article-0'];");
			System.out.println(((JavascriptExecutor) driver)
				.executeScript("external_services.ad_slots['top-fbs-ad-article-0'];"));
		}
	}
	public void validateBrandVoiceAdsInMobile()
	{
		scrollBy(0, 900);
		//scrollBy(0, 500);
		waitForElement(OR.ads_BrandVoice_Page_Rec_ads);
		boolean bvAds1=elementPresent(OR.ads_BrandVoice_Page_Rec_ads);
		if(bvAds1==true)
		{
			testStepPassed("Brand Voice Rec Ad block is displayed");
		}
		else
		{
			testStepFailed("Brand Voice Rec Ad block is not displayed");
		}
		
		scrollBy(0, 1000);
		//scrollBy(0, 500);
		boolean bvAds2=elementPresent(OR.ads_BrandVoice_Page_Recx_ads);
		if(bvAds2==true)
		{
			testStepPassed("Brand Voice Recx Ad block is displayed");
		}
		else
		{
			testStepFailed("Brand Voice Recx Ad block is not displayed");
		}
		scrollBy(0, 100);
		boolean bvAds3=elementPresent(OR.ads_BrandVoice_Page_Topx_ads);
		if(bvAds3==true)
		{
			testStepPassed("Brand Voice Topx Ad block is displayed");
			scrollBy(0, -100);
		}
		else
		{
			testStepFailed("Brand Voice Topx Ad block is not displayed");
		}
		scrollBy(0, 100);
		boolean bvAds4=elementPresent(OR.ads_BrandVoice_Page_Log_ads);
		if(bvAds3==true)
		{
			testStepPassed("Brand Voice Bottom Ad block is displayed");
			scrollBy(0, -100);
		}
		else
		{
			testStepFailed("Brand Voice Bottom Ad block is not displayed");
		}
		
		
	}
	public void validateLatestPost()
	{
		//scrollBy(0, 100);
		/*waitForElement(OR.txt_Mob_BVPage_Validation_postsLabel);
		if(elementPresent(OR.txt_Mob_BVPage_Validation_postsLabel) && elementPresent(OR.button_Mob_BVPage_Validation_Latest) && elementPresent(OR.button_Mob_BVPage_Validation_Archive)){
			testStepPassed("BV Mobile Page validation: Latest and Archive are displayed on the page");
			//this.scrollBy(0,400);
			//scrollBy(0,600);
			 * 
			 *
*/		
		scrollBy(0, 100);	
		takeAdScreenshot(OR.button_Mob_BVPage_Validation_Archive,"Archive");
		waitForElement(OR.button_Mob_BVPage_Validation_Archive);
		boolean archive=elementPresent(OR.button_Mob_BVPage_Validation_Archive);
			if(archive==true)
			{
			clickOn(OR.button_Mob_BVPage_Validation_Archive);
			if(elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabel) && elementPresent(OR.txt_Mob_BVPage_Validation_ArchiveFirstlabelPostCount)){
				testStepPassed("BV Mobile Page validation: Archive List is displayed");
			}
			else{
				testStepFailed("BV Mobile Page validation: Archive List is not displayed");
			}
		}
		else{
			testStepFailed("BV Mobile Page validation: Latest and Archive are not displayed on the page");
		}
		clickOn(OR.button_Mob_BVPage_Validation_inactiveLatest);
		waitTime(2);
		scrollBy(0,1200);
		
		waitTime(3);
		testStepInfo("*********************************Clicking on show more button on BV page**********************************");
		scrollBy(0, 100);
		clickOn(OR.txt_BVPage_Validation_showMoreButtonAfter5BVPosts);
		waitTime(3);
	}
	public void validateBrandVoiceLabelAndImagesInMobile()
	{
		testStepInfo("************************************ BrandVoice Label and Image ************************************");
		waitTime(3);
		try {
			boolean bvLabel=elementPresent(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
			if(bvLabel==true)
			{
				String label=getText(OR.txt_BVPage_Validation_ForbesBrandVoice_Label);
				testStepPassed("Brand Voice Label is displayed-"+label);
			}
			else
			{
				testStepFailed("Brand Voice Label is not displayed");
			}
			boolean bvImage=elementPresent(OR.txt_BVPage_Validation_Imageicon);
			if(bvImage==true)
			{
				testStepPassed("Brand Voice Image is displayed-");
			}
			else
			{
				testStepFailed("Brand Voice Image is not displayed");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

}
