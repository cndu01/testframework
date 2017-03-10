package searchPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class searchPageFunctionality extends ApplicationKeywords{
	
	BaseClass obj;
	String searchEntity="mark zuckerberg";
	String searchContributor="lewis dvorkin";

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
	public searchPageFunctionality(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public searchPageFunctionality() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifySearchpageContents(){
		testStepInfo("*********************************Search Page validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("Search_Video")) {

			verifySearchPageContentsInDesktop();

		} else {
			verifySearchPageContentsInMobile();
		}
	}
	/*
	 * Validating search page contents on desktop
	 */
	public void verifySearchPageContentsInDesktop(){	
		validatePageLoadTime("http://www.forbes.com/search/?nowelcome'",15,"Search Page");
		navigateTo("http://www.forbes.com/");
		entitySearch();
		profileSearchCheck();
		hashtagClickSearchCheck();
	}
	
	public void verifySearchPageContentsInMobile(){
		validatePageLoadTime("http://www.forbes.com/search/?nowelcome'",15,"Search Page");
		navigateTo("http://www.forbes.com/");
		clickOn(OR.img_Mob_Home_Page_Search);
		typeIn(OR.txt_searchPageMobile_textboxOnHomePage, searchEntity);
		webElement.sendKeys(Keys.ENTER);	
		validateSearchPageFields(searchEntity);
		validateSearchPageAdsInMobile();
		verifySearchPageArticleStreamAndSeeMore();
		boolean seeMore=elementPresent(OR.button_searchPage_SeeMore);
		if(seeMore==true)
		{
			this.scrollToElement(OR.button_searchPage_SeeMore);
			this.scrollBy(0, -60);
		//scrollBy(0, 200);
		clickOn(OR.button_searchPage_SeeMore);
		waitTime(2);
		int countAfterClickonSeemore = getElementCount(OR.articles_searchPage_SearchResultArticleStream);
		if(countAfterClickonSeemore==20){
			testStepPassed("Search Page--> Articles are loaded upon clicking see more button");
		}
		else{
			testStepFailed("Search Page--> Articles are not loaded upon clicking see more button");
		}
		}
		else
		{
			testStepFailed("See More button is not present");
		}
		waitTime(1);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-5000)");
		clickOn(OR.txt_searchPage_SearchResultDate);
		verifySearchPageArticleStreamAndSeeMore();
		profileSearchCheckMobile();
		hashtagClickSearchCheckMobile();
		
	}
	public void validateSearchPageAdsInMobile(){
		testStepInfo("*********************************Validating Ads on mobile Search page**********************************");
		try{
			scrollBy(0, 1000);
		boolean searchPageAdsinFifthPosition=elementPresent(OR.ads_searchPageMobile_SearchResultAdSection5);
		if(searchPageAdsinFifthPosition==true)
		{
			testStepPassed("Mobile Search Page ads at 5th position is displayed");
		}
		else
		{
			testStepFailed("Mobile Search Page ads at 5th position is not displayed");
		}
		scrollBy(0, 1000);
		boolean searchPageAds1=elementPresent(OR.ads_searchPageMobile_SearchResultLogeAd);
		if(searchPageAds1==true)
		{
			testStepPassed("Mobile Search Page Loge Ad is displayed");
		}
		else
		{
			testStepFailed("Mobile Search Page Loge Ad is not displayed");
		}
		
		boolean searchPagestickyAd=elementPresent(OR.ads_searchPageMobile_SearchResultStickyAd);
		if(searchPagestickyAd==true)
		{
			testStepPassed("Mobile Search Page Sticky Ad is displayed");
		}
		else
		{
			testStepFailed("Mobile Search Page Sticky Ad is not displayed");
		}
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void profileSearchCheckMobile(){
		testStepInfo("**************************************** Profile Search ********************************");
		clearEditBox(OR.txtbox_searchPage_SearchTextBox);
		typeIn(OR.txtbox_searchPage_SearchTextBox, searchContributor);
		webElement.sendKeys(Keys.ENTER);
		validateSearchPageFields(searchContributor);
		validateSearchPageAdsInMobile();
		verifySearchPageArticleStreamAndSeeMore();
		scrollBy(0,2000);
	boolean seeMore=	elementPresent(OR.button_searchPage_SeeMore);
	if(seeMore==true)
	{
		scrollBy(0, -300);
		clickOn(OR.button_searchPage_SeeMore);
	}
	else
	{
		testStepFailed("See More Button is not loaded");
	}
		waitTime(1);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-5000)");
		clickOn(OR.txt_searchPage_SearchResultDate);
		verifyArticleOnClickingDate();
		
	}
	
	public void hashtagClickSearchCheckMobile(){
		testStepInfo("*********************Hash tag Check ***************************");
		clickSearchhashtag();
		verifyDateLink();
		validateSearchPageAdsInMobile();
		verifySearchPageArticleStreamAndSeeMore();
		scrollBy(0, -200);
		boolean seeMore=elementPresent(OR.button_searchPage_SeeMore);
		if(seeMore==true)
		{//	scrollBy(0, 100);
			this.scrollToElement(OR.button_searchPage_SeeMore);
			this.scrollBy(0, -60);
			clickOn(OR.button_searchPage_SeeMore);
		}
		else
		{
			testStepFailed("See More Button is not loaded");
		}
	}
		
	public void entitySearch(){
		verifySearchPagePassingString(searchEntity);
		validateSearchPageFields(searchEntity);
		validateSearchPageAdsInDesktop();
		verifySearchPageArticleStreamAndSeeMore();
		clickOn(OR.button_searchPage_SeeMore);
		waitTime(2);
		int countAfterClickonSeemore = getElementCount(OR.articles_searchPage_SearchResultArticleStream);
		if(countAfterClickonSeemore==20){
			testStepPassed("Search Page--> Articles are loaded upon clicking see more button");
		}
		else{
			testStepFailed("Search Page--> Articles are not loaded upon clicking see more button");
		}
		waitTime(1);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-5000)");
		clickOn(OR.txt_searchPage_SearchResultDate);
		verifySearchPageArticleStreamAndSeeMore();
	}
	
	public void profileSearchCheck(){
		clearEditBox(OR.txtbox_searchPage_SearchTextBox);
		typeIn(OR.txtbox_searchPage_SearchTextBox, searchContributor);
		webElement.sendKeys(Keys.ENTER);
		validateSearchPageFields(searchContributor);
		validateSearchPageAdsInDesktop();
		verifySearchPageArticleStreamAndSeeMore();
		boolean seeMore=elementPresent(OR.button_searchPage_SeeMore);
		if(seeMore==true)
		{
			this.scrollToElement(OR.button_searchPage_SeeMore);
			this.scrollBy(0, -60);
		clickOn(OR.button_searchPage_SeeMore);
		}
		else
		{
			testStepFailed("See more button is not present");
		}
		waitTime(1);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-5000)");
		clickOn(OR.txt_searchPage_SearchResultDate);
		verifyArticleOnClickingDate();
		
	}
	
	public void hashtagClickSearchCheck(){
		clickSearchhashtag();
		verifyDateLink();
		validateSearchPageAdsInDesktop();
		verifySearchPageArticleStreamAndSeeMore();
		clickOn(OR.button_searchPage_SeeMore);
	}
	
	/**
	 * Method to pass the search string 
	 * @param str
	 */
	public void verifySearchPagePassingString(String str){
		testStepInfo("*********************************Passing the search string in the text box**********************************");
		typeIn(OR.txt_searchPage_textboxOnHomePage, str);
		webElement.sendKeys(Keys.ENTER);	
	}
	/*
	 * Method to verify all the fields on searching Entity and profile
	 * @param str
	 */
	public void validateSearchPageFields(String str){
		try{
		testStepInfo("*********************************Validate Search page fields**********************************");
		boolean searchResultHeaderTxt=elementPresent(OR.txt_searchPage_SearchResultLabel);
		if(searchResultHeaderTxt==true)
		{
			testStepPassed("Search Page--> Search Results header is displayed");
		}
		else
		{
			testStepFailed("Search Page--> Search Results header is not displayed");
		}
		boolean searchResultRelevanceTxt=elementPresent(OR.txt_searchPage_SearchResultRelevance);
		if(searchResultRelevanceTxt==true)
		{
			testStepPassed("Search Page--> Search Results Relevance link is displayed");
		}
		else
		{
			testStepFailed("Search Page--> Search Results Relevance link is not displayed");
		} 
		boolean searchResultDateLink=elementPresent(OR.txt_searchPage_SearchResultDate);
		if(searchResultDateLink==true)
		{
			testStepPassed("Search Page--> Search Results Date link is displayed");
		}
		else
		{
			testStepFailed("Search Page--> Search Results Date link is not displayed");
		} 
		boolean searchResultProfilepic=elementPresent(OR.txt_searchPage_SearchResultProfilePic);
		if(searchResultProfilepic==true)
		{
			testStepPassed("Search Page--> Search Results Profile pic is displayed");
		}
		else
		{
			testStepFailed("Search Page--> Search Results Profile pic is not displayed");
		} 
		boolean txt = getText(OR.txt_searchPage_SearchResultEntityname).equalsIgnoreCase(str);
		if(txt==true)
		{
			testStepPassed("Search Page--> Search Results Entity name is displayed");
		}
		else 
		{
			testStepFailed("Search Page--> Search Results Entity name is not displayed");
		} 
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	/*
	 * Validating ads are displayed on search page
	 * Top,Rec,Loge,Recx, Ad at 5th position
	 */
	public void validateSearchPageAdsInDesktop()
	{
		testStepInfo("*********************************Validating Ads on Search page**********************************");
		try{
		boolean searchPageAdsinFifthPosition=elementPresent(OR.ads_searchPage_SearchResultAdSection5);
		if(searchPageAdsinFifthPosition==true)
		{
			testStepPassed("Search Page ads at 5th position is displayed");
		}
		else
		{
			testStepFailed("Search Page ads at 5th position is not displayed");
		}
		boolean searchPageAds1=elementPresent(OR.ads_searchPage_SearchResultTopAd);
		if(searchPageAds1==true)
		{
			testStepPassed("Search Page Top Ad is displayed");
		}
		else
		{
			testStepFailed("Search Page Top Ad is not displayed");
		}
		boolean searchPagerecAd=elementPresent(OR.ads_searchPage_SearchResultRecAd);
		if(searchPagerecAd==true)
		{
			testStepPassed("Search Page Rec Ad is displayed");
		}
		else
		{
			testStepFailed("Search Page Rec Ad is not displayed");
		}
		scrollBy(0, 100);
		boolean searchPagelogeAd=elementPresent(OR.ads_searchPage_SearchResultLogeAd);
		if(searchPagelogeAd==true)
		{
			testStepPassed("Search Page Loge Ad is displayed");
		}
		else
		{
			testStepFailed("Search Page Loge Ad is not displayed");
		}
		boolean searchPagerecxAd=elementPresent(OR.ads_searchPage_SearchResultRecxAd);
		if(searchPagerecxAd==true)
		{
			testStepPassed("Search Page Recx Ad is displayed");
		}
		else
		{
			testStepFailed("Search Page Recx Ad is not displayed");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	/*
	 * validating the search page article stream and see more button
	 */
	public void verifySearchPageArticleStreamAndSeeMore(){
		try{
		testStepInfo("*********************************Validate the article stream and check see more button**********************************");
		int searchPageArticleStreamCount= getElementCount(OR.articles_searchPage_SearchResultArticleStream);
		if(searchPageArticleStreamCount==10){
			testStepPassed("Search Page--> Search page article stream count is "+searchPageArticleStreamCount+" as expected");
		}
		else{
			testStepFailed("Search Page--> Search page article stream count is "+searchPageArticleStreamCount+" and id not expected");
		}
		//scrollBy(0, 1000);
		boolean isButtonDisplayed = elementPresent(OR.button_searchPage_SeeMore);
		if(isButtonDisplayed==true){
			testStepPassed("Search Page--> See more button is displayed");
		}
		else{
			testStepFailed("Search Page--> See more button is not displayed");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/*
	 * Articles check on clicking Date link
	 */
	public void verifyArticleOnClickingDate(){
		testStepInfo("*********************************Validating posts upon clikcing date link**********************************");
		String latestpost = getText(OR.articles_searchPage_LatestPost);
		String firstpost = getText(OR.articles_searchPage_FirstPost);
		if(latestpost.equals(firstpost)){
			testStepPassed("Search Page--> Latest post and the first post are same when sorted by Date");
		}
		else{
			testStepFailed("Search Page--> Latest post and the first post are different when sorted by Date");
		}
	}
	
	/*
	 * Click hashtag from the article
	 */
	public void clickSearchhashtag(){
		testStepInfo("*********************************Clicking on Hashtag**********************************");
		WEBCLICK_ListElement(OR.hashtag_searchPage_FirstHashtag,1);
		
	}
	
	/*
	 * Verify Date is selected by default on hashtag search
	 */
	public void verifyDateLink(){
		boolean isDateSelected = elementPresent(OR.txt_searchPage_SearchResultActiveDate);
		if(isDateSelected==true){
			testStepPassed("Search Page--> Date is selected by default when clicked on Hashtag to search");
		}
		else{
			testStepFailed("Search Page--> Date is not selected by default when clicked on Hashtag to search");
		}
	}
}
