
package forbesOnTrumpPage;

import iSAFE.ApplicationKeywords;


import objectsRepository.OR;


import baseClass.BaseClass;

// TODO: Auto-generated Javadoc
/**
 * The Class ContributorPageValidation.
  */
public class ForbesOnTrumpPageValidation extends ApplicationKeywords {

	
	/** The obj. */
	BaseClass obj;

	
	public ForbesOnTrumpPageValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	
	
	public ForbesOnTrumpPageValidation() {

	}

	
	public void validateForbesOnTrumpPage() {
		testStepInfo("**************** Forbes On Trump Page *********************");
		if (currentExecutionMachineName.equalsIgnoreCase("Search_Video"))
		{
			validateForbesOnTrumpHeading(OR.txt_Forbes_On_Trump_Heading,"Forbes On Trump");
			validateTopAds(OR.txt_EditorsPick_EditorPickTopAd);
			validateRecAds(OR.txt_EditorsPick_EditorPickRecAd);
			validateTopxAds(OR.txt_EditorsPick_EditorPickBottomAd);
			verifySearchPageArticleStreamAndSeeMore(OR.txt_EditorsPick_EditorPickArticleStream, OR.button_searchPage_SeeMore, "Forbes On Trump Page");
			validateFirstArticleNavigation(OR.txt_Forbes_On_Trump_First_Article, OR.txt_EditorsPick_EditorPickArticle, "Forbes On Trump");
			validateBadge(OR.icon_Forbes_On_Trump_Badge, OR.txt_Forbes_On_Trump_Heading, "Forbes On Trump");
			
		}
		else
		{
			testStepInfo("**************** Forbes On Trump Page For Mobile *********************");
			validateForbesOnTrumpHeading(OR.txt_Forbes_On_Trump_Heading,"Forbes On Trump");
			validateRecAds(OR.ad_EditorsPick_Mobile_RecAd); 
			validateRecAds(OR.ad_EditorsPick_Mobile_RecxAd);
			validateStickyAds("Forbes On Trump");
			validateShareIcon("Forbes On Trump");
			verifySearchPageArticleStreamAndSeeMore(OR.articles_EditorsPick_Mobile_ArticleStream,OR.button_searchPage_SeeMore,"Forbes On Trump Page");
			validateFirstArticleNavigation(OR.articles_EditorsPick_Mobile_FirstArticle, OR.articles_EditorsPick_Mobile_ArticleHeader, "Forbes On Trump");
			validateBadge(OR.icon_Mob_Forbes_On_Trump_Badge, OR.txt_Forbes_On_Trump_Heading, "Forbes On Trump");
		}
		
	}
	

public void validateForbesOnTrumpHeading(String xpath,String name)
{
	testStepInfo("************************Validating Title*******************************");
	try {
		boolean heading=elementPresent(xpath);
		if(heading==true)
		{
			testStepPassed(name+"--- Heading is present");
		}
		else
		{
			getCurrentPageURL();
			testStepFailed(name+"--- Heading is not present");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}

public void validateStickyAds(String name)
{
	try {
		boolean stickyAd=elementPresent(OR.ad_EditorsPick_Mobile_StickyAd);
		if(stickyAd==true){
			testStepPassed(name+"mobile StickyAd is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed(name+"mobile StickyAd is not displayed");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}


public void validateShareIcon(String name)
{
	try {
		boolean shareIcon=elementPresent(OR.icon_EditorsPick_Mobile_ShareIcon);
		if(shareIcon==true){
			testStepPassed("Editors Pick Mobile : Editors picks share icon is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed("Editors Pick Mobile : Editors picks share icon is not displayed");
		}
	} catch (Exception e) {
		writeToLogFile("ERROR", "Exception: " + e.toString());
	}
}
	
	public void verifySearchPageArticleStreamAndSeeMore(String stream,String button,String name){
		try{
		testStepInfo("*********************************Validate the article stream and check see more button**********************************");
		int editorsPickPageArticleStreamCount= getElementCount(stream);
		if(editorsPickPageArticleStreamCount==10){
			testStepPassed(name+"-->  article stream count is "+editorsPickPageArticleStreamCount+" as expected");
		}
		else{
			getCurrentPageURL();
			testStepFailed(name+"-->  article stream count is "+editorsPickPageArticleStreamCount+" and id not expected");
		}
		
		boolean isButtonDisplayed = elementPresent(button);
		if(isButtonDisplayed==true){
			testStepPassed(name+"--> See more button is displayed");
		}
		else{
			getCurrentPageURL();
			testStepFailed(name+"--> See more button is not displayed");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}


	
	public void validateFirstArticleNavigation(String firstArticle, String navigatedArticle, String name)
	{
		testStepInfo("*********************** Validating Article Navigation ************************");
		try {
			this.scrollToElement(firstArticle);
			this.scrollBy(0, -100);
			boolean isFirstArticle=elementPresent(firstArticle);
			if(isFirstArticle==true)
			{
				String headingOfFirstArticle=getText(firstArticle);
				clickOn(firstArticle);
				String headingOfArticle=getText(navigatedArticle);
				//headingOfArticle
				if(headingOfArticle.equals(headingOfFirstArticle))
				{
				testStepPassed(name+"first post when clicked is navigated to the article");
				}
				else
				{
					getCurrentPageURL();
					testStepFailed(name+" first post when clicked is not navigated to the article");
				}
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
		
	}
	
}
