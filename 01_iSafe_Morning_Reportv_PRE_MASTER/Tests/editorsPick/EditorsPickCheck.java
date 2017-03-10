package editorsPick;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class EditorsPickCheck extends ApplicationKeywords{
	
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
	public EditorsPickCheck(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public EditorsPickCheck() {

		// TODO Auto-generated constructor stub
	}
	
	public void verifyEditorsPickpageContents(){
		testStepInfo("*********************************Editors Pick Page validation**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")) {

			verifyEditorsPickpageContentsInDesktop();

		} else {
			validateEditorsPickpageInMobile();

		}
	}
	
	public void verifyEditorsPickpageContentsInDesktop(){
		try{
			validatePageLoadTime("http://www.forbes.com/editors-picks/?nowelcome",15,"Actors CSF Page");
			/*navigateTo("http://www.forbes.com/");
			boolean editorpickTab=elementPresent(OR.tab_Home_Page_EditorsPick);
			if(editorpickTab==true)
			{
				String getUrl=getAttributeValue(OR.tab_Home_Page_EditorsPick, "href");
				testStepPassed("Editor pick Page Url is -"+getUrl);
				validatePageLoadTime(getUrl,15,"Editors pick Page");
					*/
				if(elementPresent(OR.txt_EditorsPick_EditorPickheader)){
					testStepPassed("Editors Pick Page--> Editors Pick header is displayed");
				}
				else{
					getCurrentPageURL();
					testStepFailed("Editors Pick Page--> Editors Pick header is not displayed");
				}
				
				validateEditorsPcikPageAdsInDesktop();
				verifySearchPageArticleStreamAndSeeMore(OR.txt_EditorsPick_EditorPickArticleStream,OR.button_searchPage_SeeMore);
				validateFirstPostClickedisNavigated();
				//readJS();
				//readJS();
				
				validateBadge(OR.txt_EditorsPick_EditorPickText, OR.txt_EditorsPick_EditorPickheader, "Editors Pick Page ");
				//checkEditorsPickbadge();
				/*}
				else{
					testStepFailed("Editor pick Tab is not displayed");
				}*/
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		//articlepageobj.verifyAdsInArticle();
	}
	
	public void verifySearchPageArticleStreamAndSeeMore(String stream,String button){
		try{
		testStepInfo("*********************************Validate the article stream and check see more button**********************************");
		int editorsPickPageArticleStreamCount= getElementCount(stream);
		if(editorsPickPageArticleStreamCount==10){
			testStepPassed("Editors Pick Page--> Editors pick page article stream count is "+editorsPickPageArticleStreamCount+" as expected");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Page--> Editors Pick page article stream count is "+editorsPickPageArticleStreamCount+" and id not expected");
		}
		if (currentExecutionMachineName.equalsIgnoreCase("AndroidMobile")){
			this.scrollBy(0, 2000);
		}
		boolean isButtonDisplayed = isElementDisplayed(button);
		if(isButtonDisplayed==true){
			testStepPassed("Editors Pick Page--> See more button is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Page--> See more button is not displayed");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void validateEditorsPcikPageAdsInDesktop()
	{
		testStepInfo("*********************************Validating Ads on Search page**********************************");
		try{
		boolean editorsPickPageTopAd=elementPresent(OR.txt_EditorsPick_EditorPickTopAd);
		if(editorsPickPageTopAd==true)
		{
			testStepPassed("Editors pick top ad is displayed");
		}
		else
		{
			getCurrentPageURL();
			testStepFailed("Editors pick top ad is not displayed");
		}
		boolean editorsPickPageRecAd=elementPresent(OR.txt_EditorsPick_EditorPickRecAd);
		if(editorsPickPageRecAd==true)
		{
			
			testStepPassed("Editors pick rec ad is displayed");
		}
		else
		{
			getCurrentPageURL();
			testStepFailed("Editors pick rec ad is not displayed");
		}
		boolean editorsPickPageBottomAd=elementPresent(OR.txt_EditorsPick_EditorPickBottomAd);
		if(editorsPickPageBottomAd==true)
		{
			testStepPassed("Editors pick bottom ad is displayed");
		}
		else
		{
			getCurrentPageURL();
			testStepFailed("Editors pick bottom ad is not displayed");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	public void validateFirstPostClickedisNavigated(){
		testStepInfo("*********************************Validating navigation of first article on Editors pick page**********************************");
		try{
			waitForElement(OR.txt_EditorsPick_FirstPost);
			String firstpost = getText(OR.txt_EditorsPick_FirstPost);
			clickOn(OR.txt_EditorsPick_FirstPost);
			waitForElement(OR.txt_EditorsPick_EditorPickArticle);
			String articleDesc = getText(OR.txt_EditorsPick_EditorPickArticle);
			if(firstpost.equals(articleDesc)){
				testStepPassed("Editors pick first post when clicked is navigated to the article");
			}
			else{
				getCurrentPageURL();
				testStepFailed("Editors pick first post when clicked is not navigated to the article");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	public void checkEditorsPickbadge(){
		testStepInfo("*********************************Validating Editors pick badge on article**********************************");
		try{
		if(elementPresent(OR.txt_EditorsPick_EditorPickIcon)){
			testStepPassed("Editors pick badge/label is displayed");
			clickOn(OR.txt_EditorsPick_EditorPickText);
			waitForElement(OR.txt_EditorsPick_EditorPickheader);
			String url = driver.getCurrentUrl();
			String editorpickurl = "http://www.forbes.com/editors-picks/";
			String[] urlparts = url.split("#");
			String urlpart1 = urlparts[0];
			if(urlpart1.equals(editorpickurl)){
				testStepPassed("Directed to editors pick page on clikcing the badge and the URL is "+editorpickurl);
			}
			else{
				getCurrentPageURL();
				testStepFailed("Not Directed to editors pick page on clikcing the badge");
			}
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors pick badge/label is not displayed");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	/*public void readJS(){
	 Object id = ((JavascriptExecutor) driver).executeScript("return document.getElementById('top-fbs-ad-article-0');");
	 System.out.println("ffffffffff"+id);
		if (driver instanceof JavascriptExecutor) {
		Object val =	((JavascriptExecutor) driver)
				.executeScript("external_services.ad_slots[id].creative_id");
			System.out.println("ddddddddddddddddddddddddd******"+val);
			
		}
	}*/
	
	public void validateEditorsPickpageInMobile(){
		validateEditorsPickcontents();
		verifySearchPageArticleStreamAndSeeMore(OR.articles_EditorsPick_Mobile_ArticleStream,OR.button_EditorsPick_Mobile_seeMore);
		clickArticleFromStreamMobile();
	}
	public void validateEditorsPickcontents(){
		try{
			waitForElement(OR.txt_EditorsPick_Mobile_EditorPickheader);
		if(elementPresent(OR.txt_EditorsPick_Mobile_EditorPickheader)){
			testStepPassed("Editors Pick Mobile : Editors picks header is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Mobile : Editors picks header is not displayed");
		}
		
		if(elementPresent(OR.ad_EditorsPick_Mobile_RecAd)){
			testStepPassed("Editors Pick Mobile : Editors picks RecAd is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Mobile : Editors picks RecAd is not displayed");
		}
		if(elementPresent(OR.ad_EditorsPick_Mobile_RecxAd)){
			testStepPassed("Editors Pick Mobile : Editors picks RecxAd is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Mobile : Editors picks RecxAd is not displayed");
		}
		if(elementPresent(OR.ad_EditorsPick_Mobile_StickyAd)){
			testStepPassed("Editors Pick Mobile : Editors picks StickyAd is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Mobile : Editors picks StickyAd is not displayed");
		}
		/*if(elementPresent(OR.icon_EditorsPick_Mobile_SearchIcon)){
			testStepPassed("Editors Pick Mobile : Editors picks search icon is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Mobile : Editors picks search icon is not displayed");
		}*/
		if(elementPresent(OR.icon_EditorsPick_Mobile_ShareIcon)){
			testStepPassed("Editors Pick Mobile : Editors picks share icon is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Mobile : Editors picks share icon is not displayed");
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
	
	public void clickArticleFromStreamMobile(){
		try{
			this.scrollBy(0, -2000);
			String firstArticleTitleOnEditorPickPage = getText(OR.articles_EditorsPick_Mobile_FirstArticle);
			clickOn(OR.articles_EditorsPick_Mobile_FirstArticle);
			String articleTitle = getText(OR.articles_EditorsPick_Mobile_ArticleHeader);
			if(firstArticleTitleOnEditorPickPage.equals(articleTitle)){
				testStepPassed("Editors Pick Mobile : Clicking on Editors picks article is directed to the article page");
			}
			else{
				testStepPassed("Editors Pick Mobile : Clicking on Editors picks article is not directed to the article page");
			}
			if(elementPresent(OR.icon_EditorsPick_Mobile_badge)){
				testStepPassed("Editors Pick Mobile : Editors picks badge is displayed");
				clickOn(OR.icon_EditorsPick_Mobile_badge);
				waitForElement(OR.txt_EditorsPick_EditorPickheader);
				String url = driver.getCurrentUrl();
				String editorpickurl = "http://www.forbes.com/editors-picks/";
				String[] urlparts = url.split("#");
				String urlpart1 = urlparts[0];
				if(urlpart1.equals(editorpickurl)){
					testStepPassed("Directed to editors pick page on clikcing the badge and the URL is "+editorpickurl);
				}
				else{
					testStepPassed("Not Directed to editors pick page on clikcing the badge");
				}
			}
			else{
				testStepPassed("Editors Pick Mobile : Editors picks badge is not displayed");
			}
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	
	}
}
