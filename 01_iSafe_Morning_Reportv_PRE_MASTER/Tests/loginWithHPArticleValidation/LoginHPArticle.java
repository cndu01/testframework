
package loginWithHPArticleValidation;



import objectsRepository.OR;
import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;


public class LoginHPArticle extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	public LoginHPArticle(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	public LoginHPArticle() {

		// TODO Auto-generated constructor st ub
	}

	
	public void validateHPArticle() {

		if (currentExecutionMachineName.equalsIgnoreCase("LoginHPArticle")) {
			testStepInfo("*************************************************** HOME PAGE ****************************************************************");
			verifyLoginForm();
			verifyLoginPage();
			verifyUSUserZone();
			verifyEuropeUserZone();
			verifyAsiaUserZone();
			validateTabs();
			
			verifyAdDisplayedInHomePage();

			verifyFollowForbes();
			verifyTopStory();
			
			verifyVideoOnHomePage();
			validateSignUpInLevelUp();
			validateLevelUpLogo(OR.img_Reg_Home_Page_LevelUp);
			validateLevelUpLinks();
			getMostPopularLinks();
			verifySocialWeb();

			verifyForbesBrandVoice();
			verifyForbesList();
			verifyFooter();
			testStepInfo("*************************************************** ARTICLE PAGE ****************************************************************");
			waitForText("Today's Top Stories");
			waitTime(2);
			clickOnMainArticle();
			validateLeftStreamArticle(OR.txt_Reg_Article_Page_LeftRailArticle);
			validateLeftRailArticleNavigation(
					OR.txt_Reg_Home_Page_HeadLine_Article,
					OR.txt_Reg_Article_Page_LeftRail_Article_Heading);
			//validateHashTag(OR.txt_Reg_Article_Page_HashTag);
			validateAuthorDetailsForDesktop();
			validateFullBio();
			validateShare();
			validateAds();
			verifyAdsInArticle();
			validateRevContentInDesktop();
			clickOnBackButton();
			testStepInfo("*************************************************** LISTS PAGE ****************************************************************");
			driver.get("http://www.forbes.com/billionaires/");
			validateProfile();
			verifyFullList();
			verifyAdsInLsits();
			testStepInfo("*************************************************** CSF PAGE ****************************************************************");
			driver.get("http://www.forbes.com/actors");
			verifyCSFPageContentsInDesktop();
		}
		
	}

}
