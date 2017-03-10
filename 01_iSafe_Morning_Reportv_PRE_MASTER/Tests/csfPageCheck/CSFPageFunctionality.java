package csfPageCheck;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.BaseClass;
import iSAFE.ApplicationKeywords;
import objectsRepository.OR;

public class CSFPageFunctionality extends ApplicationKeywords{
	
	
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
	public CSFPageFunctionality(BaseClass obj) {
		// TODO Auto-generated constructor stub
		super(obj);
		this.obj = obj;
	}

	/**
	 * Instantiates BVPage Functions.
	 */
	public CSFPageFunctionality() {

		// TODO Auto-generated constructor st ub
	}
	
	public void verifyCSFpageContents(){
		testStepInfo("*********************************CSF Check**********************************");
		waitTime(5);
		if (currentExecutionMachineName.equalsIgnoreCase("CSF_CSR_List_Editors")) {

			verifyCSFPageContentsInDesktop();

		} else {
			verifyCSFPageContentsInMobile();
		}
	}
	
	
	
	
	public void verifyCSFPageContentsInMobile(){
		checkAdOnCSF();
		CheckMobileAd(OR.ad_MobileCSFPageCheck_Stickymobilead);
		this.scrollBy(0, 1000);
		isListDisplayedOnMobile("//span[@class='more']");
		checkImagesOnCSF();
		checkvideosOnCSF();
		
	}
	
	

	
	
}
