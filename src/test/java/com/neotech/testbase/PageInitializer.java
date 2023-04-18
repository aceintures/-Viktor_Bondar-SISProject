package com.neotech.testbase;


import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashboardPageElements dashboard;
	
	

	public static void initialize() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		
	

	}

}
