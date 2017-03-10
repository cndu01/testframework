package sslCertification;

import iSAFE.ApplicationKeywords;
import objectsRepository.OR;
import baseClass.BaseClass;

public class SSLCertificationValidation extends ApplicationKeywords {

	/** The obj. */
	BaseClass obj;

	// //////////////////////////////////////////////////////////////////////////////
	// Function Name :SSL Certification Validation
	// Created by :Shakira
	// Created on :14 Oct 2016

	// ///////////////////////////////////////////////////////////////////////////////

	public SSLCertificationValidation(BaseClass obj) {
		super(obj);
		this.obj = obj;
	}

	public SSLCertificationValidation() {

	}

	public void verifySSLCertification() {
		try {

			if (currentExecutionMachineName.equalsIgnoreCase("SSL")) {
				
				//validateSSLURL_HTTP();
				validateSSLURL_HTTPS();
				//validateHTTPURLsFromExcel();
				
			} else {
				//validateSSLURL_HTTP();
				validateSSLURL_HTTPS();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}

	
	
	public void validateSSLURL_HTTP()
	{
		try {
		String[] urlList = {
				
				"http://www.forbes.com/feature/my-next-step/#78d16cc86c05",
				"http://www.forbes.com/feature/under-30-holiday-gift-guide",
				"http://www.forbes.com/feature/retirement-rules",
				"http://forbes.com/feature/passions-and-pursuits",
				"http://www.forbes.com/healthcare-2025",
				"http://www.forbes.com/feature/inside-the-future/",
				"http://www.forbes.com/executive-edge/",
				"http://www.forbes.com/feature/future-of-work/",
				"http://www.forbes.com/feature/driving-disruption/",
				"http://www.forbes.com/feature/investing-for-life",
				"http://www.forbes.com/setting-the-standard/",
				"http://www.forbes.com/next-generation-health",
				"http://www.forbes.com/scripts-for-success/",
				"http://www.forbes.com/billionaire-newcomers",
				"http://www.forbes.com/taste-makers",
				"http://www.forbes.com/retirement-rules/",
				"http://www.forbes.com/tax-guide/",
				"http://www.forbes.com/brokers",
				"http://www.forbes.com/great-performers/",
				
				"http://forbes.com/healthcare-2025",
					"http://www.forbes.com/innovation-rx",
					"http://www.forbes.com/influencing-styles",
					"http://forbes.com/his-and-hers-gift-guide",
					"http://www.forbes.com/secrets-of-the-trade/",

					"http://www.forbes.com/under30summit/",
					"http://www.forbes.com/financial-playbook/",
					"http://www.forbes.com/surging-sectors/",
					"http://www.forbes.com/investing-for-life/",
					"http://www.forbes.com/performance-inc",
						
					"http://www.forbes.com/second-acts",

					"http://www.forbes.com/business-of-tennis",
					"http://www.forbes.com/think-like-a-startup/",
					"http://www.forbes.com/build-small-business/",
					"http://www.forbes.com/internet-of-things/",
					"http://www.forbes.com/business-of-golf/",
					"http://www.forbes.com/views-from-the-top/",
					"http://www.forbes.com/mavericks/",
					"http://www.forbes.com/secrets-of-success/"
				
				
				
				/*"http://www.forbes.com/podcasts",
				"http://www.forbes.com/most-popular/",
				"http://www.forbes.com/most-popular/hashtags/",
				"http://www.forbes.com/real-time/",
				"http://www.forbes.com/video/",
				"http://www.forbes.com/pictures/hhge45l/hillary-clintons-top-do/",
				"http://www.forbes.com/lists/",
				"http://www.forbes.com/billionaires/",
				"http://www.forbes.com/forbes-400/",
				"http://www.forbes.com/business/",
				"http://www.forbes.com/executive-edge/",
				"http://www.forbes.com/actors/",
				"http://www.forbes.com/newsletters/",
				"http://www.forbes.com/newsletters/sss/",
				"http://www.forbes.com/newsletters/forbes-premium-income-report/",
				"http://www.forbes.com/global/2008/0310/009.html",
				"http://www.forbes.com/fdc/privacy.html",
				"http://info.forbes.com/CM-WebResource-Little-Black-Book_Little-Black-Book-of-Billionaire-Secrets-Download-Page.html?k=Bill_UpperLeft",
				"http://edittools-staging.forbes.com",
				"http://edittools.forbes.com",
				"http://b-i.forbesimg.com",
				
				//"http://billionaires-static.forbes.com",
				//"http://galleries-images.forbes.com",
				//"http://galleries-static.forbes.com",
				"http://images.forbes.com",
				"http://specials-images.forbesimg.com/imageserve/623406804/960x0.jpg",
				"http://specials-static.forbes.com/imageserve/623406804/960x0.jpg",
				"http://www.forbesconferences.com/",
				"http://forbesreprints.magreprints.com/",
				"http://www.forbesmagazine.com/",
				"http://www.forbes.com/products/2016-college-guide/",
				"http://custom.forbes.com/",
				"http://www.forbesmagazine.com/custom-covers/",
				"http://www.forbesmedia.com/",
				"http://www.forbes.com/fdc/contact.html",
				"http://www.forbes.com/fdc/sitemap.html",
				
				"http://blogs.forbes.com",
				"http://www.forbes.com/forbeslife/",
				"http://blogs-stage.forbes.com/account/login/",
				"http://blogs.forbesimg.com",
				"http://specials-images.forbes.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				"http://specials-static.forbes.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				"http://blogs-images.forbes.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				"http://specials-images.forbesimg.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				
				"http://i.forbesimg.com",
				"http://m.forbes.com",
				
				//"http://thoughts.forbes.com",
				//"http://www.forbes.com/marketing/",
				//"http://www.forbes.com/small-giants/",
				//"http://www.forbes.com/small-business-tech/",
				"http://www.forbes.com/solopreneurs/",
				"http://www.forbes.com/finance/",
				"http://www.forbes.com/forbes/welcome/",
				"http://www.forbes.com/",
				"http://www.forbes.com/home_usa/",
				"http://www.forbes.com/home_europe/",
				"http://www.forbes.com/home_asia/",
				"http://www.forbes.com/sites/maggiemcgrath/2016/10/12/embattled-wells-fargo-ceo-john-stumpf-is-retiring-effective-immediately/",
				"http://www.forbes.com/editors-picks/",
				"http://www.forbes.com/sites/sap/2016/10/04/a-winning-digital-formula-adoption-investment-and-partnerships/",
				"http://www.forbes.com/sites/sap/",
				"http://www.forbes.com/sites/sap/people/billmcdermott/",
				
				"http://www.forbes.com/dell/cities-transformed/",
				"http://www.forbes.com/johnhancock/in-a-lifetime-healthcare/",
				"http://www.forbes.com/oppenheimerfunds/the-upside",
				"http://www.forbes.com/colehaan/daring-to-step-forward/",
				"http://www.forbes.com/kpmg/the-great-rewrite/#/",
				"http://www.forbes.com/themacallan/worlds-together/",
				
				"http://www.forbes.com/sites/maggiemcgrath/",
				"http://www.forbes.com/sites/forbesinsights",
				"http://www.forbes.com/forbes/",
				"http://www.forbes.com/forbesasia",
				"http://www.forbes.com/sites/yec"*/
				
				//https://www.forbes.com/sites/sap/
				//https://www.forbes.com/sites/sap/people/susangaler/
				//http://www.forbes.com/sites/sap/2016/11/03/will-self-driving-cars-kill-the-insurance-industry/	
				
				//"http://galleries.forbes.com",
				//"http://forbes_video.edgesuite.net", ----> File not found
				//"http://www.forbes.com/kpmg/the-great-rewrite/", ----->Blank Page
				//"http://www-staging.forbes.com/",
				//"http://www-staging-2.forbes.com/",
				//"http://www-staging-3.forbes.com/",
				//"http://www-staging-4.forbes.com/",
				//"http://www-staging-5.forbes.com/",
				//"http://www-staging-6.forbes.com/"
				
					
		};
		
		int size=urlList.length;
		testStepPassed("Total Number of URLs--->"+size);
		System.out.println("Number of URLs "+size);
		for (int i = 1; i <=size; i++) {

			driver.get(urlList[i]);
			testStepPassed("Entered URL is -" + urlList[i]);
		
			  
			String getTitle = driver.getTitle();
			testStepPassed("Title of the page is -------->" + getTitle);
			//boolean trueFalse=elementPresent(OR.txt_SSL_Validation_Error_Message);
			//boolean error=elementPresent(OR.txt_SSL_Validation_403Error);
			if(getTitle.contains("Service Unavailable - Fail to connect")||getTitle.contains("Access Denied")||getTitle.contains("Invalid URL")||getTitle.equals("Certificate Error: Navigation Blocked")||getTitle.trim().contains("Privacy error")||getTitle.contains("404") ||getTitle.contains("This page can’t be displayed")||getTitle.contains("403 Administratively Forbidden"))
			{
				
			//	getCurrentPageURL();
				testStepPassed("URL no : "+i+" URL: " +urlList[i]+ "\n\t Status-----> INVALID");
				manualScreenshot(getTitle);
				testStepFailed("URL is throwing error");
			} else {
				//getCurrentPageURL();
				manualScreenshot(getTitle);
				testStepPassed("URL no : "+i+" URL: " +urlList[i]+ "\n\t Status-----> VALID");
				testStepPassed("URL is navigated to correct page");
			}
		}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	public void validateSSLURL_HTTPS()
	{
		try {
		String[] urlList = {
				
				"https://www.forbes.com/feature/my-next-step/#78d16cc86c05",
				"https://www.forbes.com/feature/under-30-holiday-gift-guide",
				"https://www.forbes.com/feature/retirement-rules",
				"https://forbes.com/feature/passions-and-pursuits",
				"https://www.forbes.com/healthcare-2025",
				"https://www.forbes.com/feature/inside-the-future/",
				"https://www.forbes.com/executive-edge/",
				"https://www.forbes.com/feature/future-of-work/",
				"https://www.forbes.com/feature/driving-disruption/",
				"https://www.forbes.com/feature/investing-for-life",
				"https://www.forbes.com/setting-the-standard/",
				"https://www.forbes.com/next-generation-health",
				"https://www.forbes.com/scripts-for-success/",
				"https://www.forbes.com/billionaire-newcomers",
				"https://www.forbes.com/taste-makers",
				"https://www.forbes.com/retirement-rules/",
				"https://www.forbes.com/tax-guide/",
				"https://www.forbes.com/brokers",
				"https://www.forbes.com/great-performers/",
				
				"https://forbes.com/healthcare-2025",
					"https://www.forbes.com/innovation-rx",
					"https://www.forbes.com/influencing-styles",
					"https://forbes.com/his-and-hers-gift-guide",
					"https://www.forbes.com/secrets-of-the-trade/",

					"https://www.forbes.com/under30summit/",
					"https://www.forbes.com/financial-playbook/",
					"https://www.forbes.com/surging-sectors/",
					"https://www.forbes.com/investing-for-life/",
					"https://www.forbes.com/performance-inc",
						
					"https://www.forbes.com/second-acts",

					"https://www.forbes.com/business-of-tennis",
					"https://www.forbes.com/think-like-a-startup/",
					"https://www.forbes.com/build-small-business/",
					"https://www.forbes.com/internet-of-things/",
					"https://www.forbes.com/business-of-golf/",
					"https://www.forbes.com/views-from-the-top/",
					"https://www.forbes.com/mavericks/",
					"https://www.forbes.com/secrets-of-success/"
				
				/*"https://www.forbes.com/forbes/welcome/?toURL=https://www.forbes.com/&refURL=&referrer=",
				"https://www.forbes.com/",
				"https://www.forbes.com/home_usa/",
				"https://www.forbes.com/home_europe/",
				"https://www.forbes.com/home_asia/",
				"https://www.forbes.com/sites/maggiemcgrath/2016/10/12/embattled-wells-fargo-ceo-john-stumpf-is-retiring-effective-immediately/",
				"https://www.forbes.com/editors-picks/",
				"https://www.forbes.com/sites/sap/2016/10/04/a-winning-digital-formula-adoption-investment-and-partnerships/",
				"https://www.forbes.com/sites/sap/",
				"https://www.forbes.com/sites/sap/people/billmcdermott/",
				
				"https://www.forbes.com/sites/maggiemcgrath/",
				"https://www.forbes.com/sites/forbesinsights",
				"https://www.forbes.com/sites/yec",
				"https://www.forbes.com/podcasts",
				"https://www.forbes.com/most-popular/",
				"https://www.forbes.com/most-popular/hashtags/",
				"https://www.forbes.com/real-time/",
				"https://www.forbes.com/video/",
				"https://www.forbes.com/pictures/hhge45l/hillary-clintons-top-do/",
				"https://www.forbes.com/lists/",
				"https://www.forbes.com/billionaires/",
				"https://www.forbes.com/forbes-400/",
				"https://www.forbes.com/business/",
				"https://www.forbes.com/executive-edge/",
				"https://www.forbes.com/actors/",
				"https://www.forbes.com/newsletters/",
				"https://www.forbes.com/newsletters/sss/",
				"https://www.forbes.com/newsletters/forbes-premium-income-report/",
				"https://www.forbes.com/global/2008/0310/009.html",
				"https://www.forbes.com/fdc/privacy.html",
				
				"https://www.forbesconferences.com/",
				"https://www.forbesmagazine.com/",
				"https://www.forbes.com/products/2016-college-guide/",
				"https://custom.forbes.com/",
				"https://www.forbesmagazine.com/custom-covers/",
				"https://www.forbesmedia.com/",
				"https://www.forbes.com/fdc/contact.html",
				"https://www.forbes.com/fdc/sitemap.html",
				"https://www.forbes.com/forbes/",
				"https://www.forbes.com/forbesasia",
				"https://blogs.forbes.com",
				"https://blogs.forbes.com/account/login/",
				"https://www.forbes.com/forbeslife/",
				"https://edittools-staging.forbes.com",
				"https://edittools.forbes.com",
				"https://b-i.forbesimg.com",
				
				//"https://billionaires-static.forbes.com",
				//"https://galleries-images.forbes.com",
				//"https://galleries-static.forbes.com",
				"https://images.forbes.com",
				"https://specials-images.forbes.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				"https://specials-static.forbes.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				"https://blogs-images.forbes.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				"https://specials-images.forbesimg.com/insertcoin/files/2016/07/diablo-3-reaper-1200x675.jpg?width=400&height=0",
				"https://specials-images.forbesimg.com/imageserve/623406804/960x0.jpg",
				"https://specials-static.forbes.com/imageserve/623406804/960x0.jpg",
				"https://blogs.forbesimg.com",
				"https://i.forbesimg.com",
				
							
				//"https://thoughts.forbes.com",
				//"https://www.forbes.com/marketing/",
				//"https://www.forbes.com/small-giants/",
				//"https://www.forbes.com/small-business-tech/",
				"https://www.forbes.com/solopreneurs/",
				"https://www.forbes.com/finance/",
				"https://www.forbes.com/forbes/welcome/",
				"https://www.forbes.com/",
				"https://www.forbes.com/home_usa/",
				"https://www.forbes.com/home_europe/",
				"https://www.forbes.com/home_asia/",
				"https://www.forbes.com/sites/maggiemcgrath/2016/10/12/embattled-wells-fargo-ceo-john-stumpf-is-retiring-effective-immediately/",
				"https://www.forbes.com/editors-picks/",
				"https://www.forbes.com/sites/sap/2016/10/04/a-winning-digital-formula-adoption-investment-and-partnerships/",
				"https://www.forbes.com/sites/sap/",
				"https://www.forbes.com/sites/sap/people/billmcdermott/",
				
				"https://www.forbes.com/dell/cities-transformed/",
				"https://www.forbes.com/johnhancock/in-a-lifetime-healthcare/",
				"https://www.forbes.com/oppenheimerfunds/the-upside",
				"https://www.forbes.com/colehaan/daring-to-step-forward/",
				"https://www.forbes.com/kpmg/the-great-rewrite/#/",
				"https://www.forbes.com/themacallan/worlds-together/",
				
				"https://www.forbes.com/sites/maggiemcgrath/",
				"https://www.forbes.com/sites/forbesinsights",
				"https://www.forbes.com/forbes/",
				"https://www.forbes.com/forbesasia",
				"https://www.forbes.com/sites/yec"*/
				
				/*,
				"https://forbesreprints.magreprints.com/",
				"https://forbes_video.edgesuite.net", -----> File not found
				"https://info.forbes.com/CM-WebResource-Little-Black-Book_Little-Black-Book-of-Billionaire-Secrets-Download-Page.html?k=Bill_UpperLeft", ------>500 Error
				"https://m.forbes.com",
				"https://galleries.forbes.com",
				"https://blogs-stage.forbes.com",
				"https://www-staging.forbes.com/",
				"https://www-staging-2.forbes.com/",
				"https://www-staging-3.forbes.com/",
				
				"https://www-staging-4.forbes.com/",
				"https://www-staging-5.forbes.com/",
				"https://www-staging-6.forbes.com/",
				"https://www.forbes.com/kpmg/the-great-rewrite/"*/

		
		};
		
			int size=urlList.length;
			testStepPassed("Total Number of URLs--->"+size);
			System.out.println("Number of URLs "+size);
			for (int i = 1; i <=size; i++) {

				driver.get(urlList[i]);
				testStepPassed("Entered URL is -" + urlList[i]);
			
				  
				String getTitle = driver.getTitle();
				testStepPassed("Title of the page is -------->" + getTitle);
				//boolean trueFalse=elementPresent(OR.txt_SSL_Validation_Error_Message);
				//boolean error=elementPresent(OR.txt_SSL_Validation_403Error);
				if(getTitle.contains("Service Unavailable - Fail to connect")||getTitle.contains("Access Denied")||getTitle.contains("Invalid URL")||getTitle.equals("Certificate Error: Navigation Blocked")||getTitle.trim().contains("Privacy error")||getTitle.contains("404") ||getTitle.contains("This page can’t be displayed")||getTitle.contains("403 Administratively Forbidden"))
				{
					
				//	getCurrentPageURL();
					testStepPassed("URL no : "+i+" URL: " +urlList[i]+ "\n\t Status-----> INVALID");
					manualScreenshot(getTitle);
					testStepFailed("URL is throwing error");
				} else {
					//getCurrentPageURL();
					manualScreenshot(getTitle);
					testStepPassed("URL no : "+i+" URL: " +urlList[i]+ "\n\t Status-----> VALID");
					testStepPassed("URL is navigated to correct page");
				}
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
	}
	
	
	
	public void validateHTTPURLsFromExcel()
	{
		try {
			String getURL=retrieve("HTTPURL");
			
			driver.get(getURL);
			testStepPassed("Entered URL is --->"+getURL);
			String getTitle = driver.getTitle();
			testStepPassed("Title of the page is ----->" + getTitle);
			//boolean trueFalse=elementPresent(OR.txt_SSL_Validation_Error_Message);
			if(getTitle.equals("Certificate Error: Navigation Blocked")||getTitle.contains("403 Administratively Forbidden")||getTitle.contains("Service Unavailable - Fail to connect")||getTitle.trim().contains("Privacy error")||getTitle.contains("404") ||getTitle.contains("Invalid URL")||getTitle.contains("This page can’t be displayed"))
			{
				
				getCurrentPageURL();
				testStepPassed("URL is ----> INVALID");
				manualScreenshot(getTitle);
				testStepFailed("Your connection is not secure");
			}
			else {
				getCurrentPageURL();
				manualScreenshot(getTitle);
				testStepPassed("URL is-----> VALID");
				testStepPassed("URL is navigated to correct page");
			}
		} catch (Exception e) {
			writeToLogFile("ERROR", "Exception: " + e.toString());
		}
		
	}
}
