package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By accPageHeaders = By.cssSelector("div#content h2");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle() {
		String title = eleUtil.waitForTitleToBe(AppConstants.ACCOUNT_PAGE_TITLE,AppConstants.SMALL_DEFAULT_TIME_OUT);
		System.out.println("Acc page title :" + title);
		return title;
	}
	public String getAccountsPageUrl() {
        String url = eleUtil.waitForUrl(AppConstants.SMALL_DEFAULT_TIME_OUT, AppConstants.ACCOUNT_PAGE_URL_FRACTION);
		System.out.println("Acc page url :" + url);
		return url;
	}
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, AppConstants.MEDIUM_DEFAULT_TIME_OUT).isDisplayed();
		
	}
	
	public boolean isSearchFieldExist() {
		return eleUtil.waitForElementVisible(searchField, AppConstants.MEDIUM_DEFAULT_TIME_OUT).isDisplayed();
		
	}
	public List<String> getAccountHeaderList() {
		return eleUtil.getAllElementsTextList(accPageHeaders, AppConstants.SMALL_DEFAULT_TIME_OUT);
	}



	

}
