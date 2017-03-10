package angularGalleryCheck;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class AngularGalleryFunctionalityCheck extends ApplicationKeywords {

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
	 * Instantiates BVPage Functions
	 *
	 * @param obj
	 *            the obj
	 */
	public AngularGalleryFunctionalityCheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public AngularGalleryFunctionalityCheck() {

		// TODO Auto-generated constructor st ub
	}

	public void verifyAngularGallery() {
		testStepInfo("*********************************Angular Gallery Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("NewPosts_MostPopular_Angular")) {

			verifyAngularGalleryOnDesktop();

		} else {
			verifyAngularGalleryOnMobile();
		}
	}

	public void verifyAngularGalleryOnDesktop() {
		try {
			//clickOn(OR.txt_GalleryCheck_PopularGallery);
				
				checkAdsonAngularGallery();
				
				validateGallerySlides();
				validateSocialShares(OR.img_Angular_Gallery_Page_Social_Sahres);
				verifyArticleTextsInNewtab(OR.txt_Angular_Gallery_Page_GalleryLink,OR.txt_Angular_Gallery_Page_GalleryLink,OR.txt_Article_Page_Heading);
			
				//viewAngularGallerySlides();
				//clickGalleryExpandButton();	
			
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		
	}

	public void validateGalleryArea()
	{
		try {
			boolean checkGalleryArea=elementPresent(OR.txt_GalleryCheck_mobileGalleryArea);
			boolean checkGalelryTitle=elementPresent(OR.txt_GalleryCheck_Title);
			if(checkGalelryTitle==true && checkGalleryArea==true)
			{
				String getGalleryTitle=getText(OR.txt_GalleryCheck_Title);
				testStepPassed("Gallery Title is present--"+getGalleryTitle);
			}
			else
			{
				testStepFailed("Gallery Title is not present");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateGallerySlides()
	{
		testStepInfo("**************************************** Angular Gallery Slides Validation *************************************");
		try {
			boolean galleryImage=elementPresent(OR.img_Angular_Gallery_Image);
			if(galleryImage==true)
			{
				String slideCount=getText(OR.txt_AngularGalleryCheck_SlideCount);
				//testStepPassed(slideCount);
				String[] splitString=slideCount.split("of");
				String split1=splitString[0].trim();
				String split2=splitString[1].trim();
				testStepPassed("First Slide number is ---->"+split1+"Last Slide number is --->"+split2);
				int totalslidesCount=Integer.parseInt(split2);
				testStepPassed("Total Number of Slides  "+totalslidesCount);
				if(totalslidesCount>=6)
				{
					testStepPassed("Gallery Slides are more than 6 slides");
					
					for (int i = 1; i <=5; i++) {
						
						boolean galleryTitle=elementPresent(OR.txt_Angular_Gallery_Page_GalleryLink);
						boolean galleryBelowLink=elementPresent(OR.txt_Angular_Gallery_Page_Below_GalleryTitle);
						boolean galleryExpand=elementPresent(OR.btn_Angular_Gallery_Expand_Arrow);
						
							
								
								if(galleryTitle==true && galleryBelowLink==true)
								{
									
									String getGalleryTitle=getText(OR.txt_Angular_Gallery_Page_GalleryLink);
									String getBelowText=getText(OR.txt_Angular_Gallery_Page_Below_GalleryTitle);
									testStepPassed("Top of the Gallery Title --->"+getGalleryTitle);
									testStepPassed("Below of the Gallery Title --->"+getBelowText);
									if(galleryExpand==true)
									{
										scrollBy(0, 300);
										scrollBy(0, -100);
										clickOn(OR.btn_Angular_Gallery_Expand_Arrow);
										boolean expandedContent=elementPresent(OR.txt_Angualr_Gallery_Expanded_Content);
										if(expandedContent==true)
										{
											String getExpanded=getText(OR.txt_Angualr_Gallery_Expanded_Content);
											testStepPassed("After Clicking on the Expanded Arrow--->"+getExpanded);
										}
										else
										{
											testStepFailed("Expanded content is not Displayed");
										}
										
									}
									else{
										testStepFailed("Angular Gallery ----> Expand Arrow is not Displayed");
									}
									boolean nextButton=elementPresent(OR.btn_Angular_Gallery_Page_NextButton);
									
									
									if(nextButton==true)
									{
										waitTime(4);
										clickOn(OR.btn_Angular_Gallery_Page_NextButton);
										waitTime(5);
										//checkAdsonAngularGallery();
									}
									else
									{
										testStepFailed("Angular Gallery ---> Next Button is not enabled");
									}
								}
								else
								{
									testStepFailed("Gallery Title is not Displayed");
								}
					}
				
				}
				else
				{
					testStepFailed("Gallery Slides are not more than 6n slides");
				}
				
			}
			else
			{
				testStepFailed("Gallery Image is not Displayed");
			}
		} catch (NumberFormatException e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	/*public void checkTopAdOnAngularGallery() {
		try {
			testStepInfo(
					"*********************************Top Ad Angular Gallery Check**********************************");
			boolean isTopAdDisplayed = elementPresent(OR.txt_AngularGalleryCheck_LeaderBoard);
			if (isTopAdDisplayed) {
				testStepInfo(
						"*********************************Top Leaderboard Ad***********************************************");
				testStepPassed(
						"Angular Gallery Check (Angular Gallery Top Leaderboard Ad is displayed- " + isTopAdDisplayed);
			} else {
				testStepFailed("Angular Gallery Check (Angular Gallery Top Leaderboard Ad is not displayed- "
						+ isTopAdDisplayed);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/

	public void viewAngularGallerySlides() {
		try {
			testStepInfo("*********************************Slides on Angular Gallery**********************************");
			waitTime(5);
			fluentwaitforVisibility("//button[@class='slick-next slick-arrow' and @aria-disabled='false']");
			waitForElement(OR.txt_AngularGalleryCheck_nextIcon);
			boolean isNexticonPresent = elementPresent(OR.txt_AngularGalleryCheck_nextIcon);
			if (isNexticonPresent==true) {
				testStepPassed("Angular Gallery Check::Gallery next icon is displayed on the page)");
			} else if (!isNexticonPresent) {
				refreshPage();
				waitTime(5);
				if (isNexticonPresent) {
					testStepPassed(
							"Angular Gallery Check::Gallery next icon is displayed on the page after refreshing the page)");
				}
			} else {
				testStepFailed("Angular Gallery Check (Gallery imageBox is not displayed on the page)");
			}
			checkImagesInGallery(OR.txt_AngularGalleryCheck_SlideCount, OR.txt_AngularGalleryCheck_nextIcon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	public void validateAngularGallerySlides()
	{
		testStepInfo("************************ Slides on Angualar Gallery ***************************");
		boolean nextIcon=elementPresent(OR.btn_AngularGalleryCheck_Next_Icon);
		if (nextIcon==true) {
			for (int i = 1; i <=3; i++) {
				clickOn(OR.btn_AngularGalleryCheck_Next_Icon);
				waitTime(3);
				testStepPassed("Next Slide is present");
			}
			
		}
		else
		{
			testStepPassed("Next Slide is not displayed");
		}
	}
	
	public void clickGalleryExpandButton(){
		try{	
			waitForElement(OR.txt_AngularGalleryCheck_ExpandIcon);
			boolean isIconDisplayed=elementPresent(OR.txt_AngularGalleryCheck_ExpandIcon);
			if(isIconDisplayed){
		
				testStepPassed("Angular Gallery Check:: Gallery slider icon is displayed on the page ");
				clickOn(OR.txt_AngularGalleryCheck_ExpandIcon);
				waitTime(2);
				boolean isIcon2Displayed=elementPresent(OR.txt_AngularGalleryCheck_AfterExpandIcon);
				if(isIcon2Displayed==true){
					testStepPassed("Angular Gallery Check:: Gallery slider icon is expanded on the gallery");
				}else{
					testStepFailed("Angular Gallery Check:: Gallery slider icon is not expanded on the gallery");
				}
			}
			else{
				testStepFailed("Angular Gallery Check:: Gallery slider icon is not displayed on the page");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	//Changes done by Shakira on 12 Oct 2016
	public void verifyAngularGalleryOnMobile() {
		testStepInfo("************************ Verifying Gallery contents on mobile***************************");
		try{
		
					//clickOn(OR.txt_GalleryCheck_mobilePopularGallery);
					//testStepPassed("Most Popular Gallery is Displayed");
			validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
					verifyGalleryMobileCheck();
					//CheckMobileAd(OR.txt_GalleryCheck_mobileAdOnGallery);
					
			
		//String galleryTitle=getText(OR.txt_GalleryCheck_mobilePopularGalleryTitle);
		
		//swipeThroughSlides();
		/*clickOn(OR.button_GalleryCheck_closeSymbol);
		waitForElement(OR.button_GalleryCheck_gallerytitle);
		String gallerytitleonpage=getText(OR.button_GalleryCheck_gallerytitle);
		if(gallerytitleonpage.equals(galleryTitle)){
			testStepPassed("Directed to gallery page on closing the picture from the gallery");
		}
		else{
			testStepFailed("Not Directed to gallery page on closing the picture from the gallery");
		}*/
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		}
		
public void verifyGalleryMobileCheck(){
	try{
	waitForElement(OR.txt_GalleryCheck_TotalSlides);
	String slidecount=getText(OR.txt_GalleryCheck_TotalSlides);
	int totalPicNumber = Integer.parseInt(slidecount);
	testStepPassed("Total Number of slides-"+totalPicNumber);
	testStepPassed("Total number of pictures in the gallery are ::"+slidecount);
	if(totalPicNumber>=6){
		swipeThroughSlides();
		
	}
	else{
		testStepFailed("Angular Gallery Check:: No pictures in the gallery");
	}
	testStepInfo("************************Gallery Close button on mobile***************************");
	if(elementPresent(OR.button_GalleryCheck_closeSymbol)){
		testStepPassed("Angular Gallery Check:: Mobile gallery close icon is displayed");
	}
	else{
		testStepFailed("Angular Gallery Check:: Mobile gallery close icon is not displayed");
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
		
		}
		
		
public void swipeThroughSlides(){
	testStepInfo("************************ Swiping the pictures on mobile***************************");
	try{
		waitTime(3);
	String currentPic=getText(OR.txt_GalleryCheck_currentSlide);
	int currentPicNumber = Integer.parseInt(currentPic);
	testStepPassed("Current Slide Count -"+currentPicNumber);
	for(int i=1;i<=6;i++){
		//validateGalleryArea();
		validateBottomAds(OR.txt_GalleryCheck_mobileAdOnGallery);
		swipeToLeft(1200,60,1300);
		
		
	
	String slidenum = getText(OR.txt_GalleryCheck_currentSlide);
	int currentNumber = Integer.parseInt(slidenum);
	testStepPassed("swiped to next pciture and the current picture number is " +currentNumber);
	if(i==5)
	{
		testStepInfo("************************ Gallery Ads and Swipe To continue Button on mobile***************************");
		boolean galleryAds=elementPresent(OR.button_GalleryCheck_galleryAd);
		boolean swipeTocontinue=elementPresent(OR.button_GalleryCheck_galleryAdText);
		if(galleryAds==true && swipeTocontinue==true){
			takeAdScreenshot(OR.button_GalleryCheck_galleryAd, "Interstitial Ad");
			testStepPassed("Ad is displayed after swiping till 5th picture");
			testStepPassed("Swipe To Continue button is displayed after swiping 5th picture");
			
		}
		else{
			testStepFailed("Ad is not displayed after swiping till 5th picture");
			testStepFailed("Swipe To Continue button is not displayed after swiping 5th picture");
		}
		//swipeToLeft(1100,50,1100);
		testStepPassed("***********************After Interstitial Ad Slide is swipped*******************************");
		
	}
	}
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

	
	/*public void verifyAngularGalleryOnMobile() {
		testStepInfo("************************ Verifying Gallery contents on mobile***************************");
		try{
		this.scrollBy(0, 1700);
		waitTime(2);
		waitForElement(OR.txt_GalleryCheck_mobilePopularGallery);
		//String galleryTitle=getText(OR.txt_GalleryCheck_mobilePopularGalleryTitle);
		clickOn(OR.txt_GalleryCheck_mobilePopularGallery);
		verifyGalleryMobileCheck();
		CheckMobileAd(OR.txt_GalleryCheck_mobileAdOnGallery);
		swipeThruSlides();
		clickOn(OR.button_GalleryCheck_closeSymbol);
		waitForElement(OR.button_GalleryCheck_gallerytitle);
		String gallerytitleonpage=getText(OR.button_GalleryCheck_gallerytitle);
		if(gallerytitleonpage.equals(galleryTitle)){
			testStepPassed("Directed to gallery page on closing the picture from the gallery");
		}
		else{
			testStepFailed("Not Directed to gallery page on closing the picture from the gallery");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		}*/
		
/*public void verifyGalleryMobileCheck(){
	try{
	waitForElement(OR.txt_GalleryCheck_TotalSlides);
	String slidecount=getText(OR.txt_GalleryCheck_TotalSlides);
	if(slidecount!=null){
		testStepPassed("Total number od pictures in the gallery are ::"+slidecount);
	}
	else{
		testStepFailed("Angular Gallery Check:: No pictures in the gallery");
	}
	if(elementPresent(OR.button_GalleryCheck_closeSymbol)){
		testStepPassed("Angular Gallery Check:: Mobile gallery close icon is displayed");
	}
	else{
		testStepFailed("Angular Gallery Check:: Mobile gallery close icon is not displayed");
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
		
		}
		
		
	public void swipeThruSlides(){
		testStepInfo("************************ Swiping the pictures on mobile***************************");
		try{
		String currentPic=getText(OR.txt_GalleryCheck_currentSlide);
		int currentPicNumber = Integer.parseInt(currentPic);
		for(int i=currentPicNumber;i<6;i++){
		swipeToLeft();
		String slidenum = getText(OR.txt_GalleryCheck_currentSlide);
		testStepPassed("swiped to next pciture and the current picture number is " +slidenum);
		}
		if(elementPresent(OR.button_GalleryCheck_galleryAd)){
			testStepPassed("Ad is displayed after swiping till 5th picture");
		}
		else{
			testStepFailed("Ad is displayed after swiping till 5th picture");
		}
		if(elementPresent(OR.button_GalleryCheck_galleryAdText)){
			testStepPassed("Ad is displayed after swiping 5th picture");
		}
		else{
			testStepFailed("Swipe to continue text is displayed after swiping 5th picture");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}*/

	}

