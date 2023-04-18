package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement pim;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmployee;

	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement employeeList;

	@FindBy(id = "account-job")
	public WebElement accountJobDropDown;

	@FindBy(xpath = "//a[@id='logoutLink']")
	public WebElement logout;

	@FindBy(id = "account-name")
	public WebElement accountName;

	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;

	@FindBy(linkText = "Add Employee")
	public WebElement addEmployeeLink;

	@FindBy(linkText = "Employee List")
	public WebElement employeeListLink;

	@FindBy(xpath = "//*[@id='menu_news_More']/a")
	public WebElement moreMenuItem;

	@FindBy(xpath = "//div[@id = 'menu-content']/ul/li")
	public List<WebElement> menuList;

	@FindBy(id = "menu_discipline_defaultDisciplinaryView")
	public WebElement discipline;

	@FindBy(xpath = "//div[@class='oxd-dashboard container']")
	public WebElement dashboardPage;

	@FindBy(id = "ohrm-small-logo")
	public WebElement orangeHRMLogo;
	
	@FindBy(id = "home-menu-trigger")
	public WebElement Home;
	
	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}

}
