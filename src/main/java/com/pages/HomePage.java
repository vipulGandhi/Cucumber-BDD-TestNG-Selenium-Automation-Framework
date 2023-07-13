package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utils.ActionsUtil;
import com.qa.utils.Constants;
import com.qa.utils.ElementUtil;
import com.qa.utils.JavascriptUtil;
import com.qa.utils.WaitUtils;


public class HomePage
{
	private ElementUtil elementUtil;
	private WaitUtils waitUtils;
	private ActionsUtil actionsUtil;
	
	private By userNameBy = By.xpath("(//div[@class='login-panel']/div)[1]");
	private By loginPanelItemsBy = By.xpath("//div[@class='login-panel']//a[@class='dropdown-list']");
	
	public HomePage(WebDriver driver)
	{
		elementUtil = new ElementUtil(driver);
		waitUtils = new WaitUtils(driver);
		actionsUtil = new ActionsUtil(driver);
	}
	
	public String getUserName()
	{
		return elementUtil.getElementText(waitUtils.isVisibilityOfElementLocated(userNameBy, Constants.DEFAULT_TIME_OUT));
	}
	
	public int getLoginPanelItemsCount()
	{
		
		actionsUtil.doMoveToElement(waitUtils.isVisibilityOfElementLocated(userNameBy, Constants.DEFAULT_TIME_OUT));
		return elementUtil.getElementsText(waitUtils.isVisibilityOfElementsLocated(loginPanelItemsBy, Constants.DEFAULT_TIME_OUT)).size();
	}
	
	public List<String> getLoginPanelItems()
	{
		actionsUtil.doMoveToElement(waitUtils.isVisibilityOfElementLocated(userNameBy, Constants.DEFAULT_TIME_OUT));
		return elementUtil.getElementsText(waitUtils.isVisibilityOfElementsLocated(loginPanelItemsBy, Constants.DEFAULT_TIME_OUT));
	}
}
