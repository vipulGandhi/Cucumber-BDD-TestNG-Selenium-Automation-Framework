package com.qa.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants
{
	
	//--------------------------------------------------------------------------------------
	// Global
	public static final int DEFAULT_TIME_OUT = 120;
	
	//--------------------------------------------------------------------------------------
	// Home Page
	public static List<String> loginPanelItems()
	{
		List<String> loginPanelItemsString = new ArrayList<String>();
		
		loginPanelItemsString.add("My Orders");
		loginPanelItemsString.add("My Prescription");
		loginPanelItemsString.add("My Store Credit");
		loginPanelItemsString.add("My Dittos");
		loginPanelItemsString.add("Account Information");
		loginPanelItemsString.add("Logout");
		
		return loginPanelItemsString;
	}
}
