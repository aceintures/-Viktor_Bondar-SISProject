package steps_old_copy;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageValidationSteps extends CommonMethods {
	
	@Given("I navigated to the HRM website")
	public void i_navigated_to_the_hrm_website() {
	    sendText(login.username, ConfigsReader.getProperty("username"));
	    sendText(login.password, ConfigsReader.getProperty("password"));
	    click(login.logInButton);
	}
	@Given("I can see that the dashboard page is displayed successfully")
	public void i_can_see_that_the_dashboard_page_is_displayed_successfully() throws Exception {
	    if(dashboard.dashboardPage.isDisplayed()) {
	    	System.out.println("Dashboard Page DISPLAYED!!");
	    }else {
	    	System.out.println("Dashboard Page IS NOT DISPLAYED!!");
	    	throw new Exception();
	    }
	}
	@Given("I can see that Orange HRM Logo is visible")
	public void i_can_see_that_orange_hrm_logo_is_visible() throws Exception {
	    if(dashboard.orangeHRMLogo.isDisplayed()) {
	    	System.out.println("Logo is DISPLAYED");
	    }else {
	    	System.out.println("Logo is NOT DISPLAYED");
	    	throw new Exception();
	    }
	}
	@Then("I can that the url includes dashboard extension on address bar")
	public void i_can_that_the_url_includes_dashboard_extension_on_address_bar() throws Exception {
	    String expectedURL = "https://hrm.neotechacademy.com/client/#/dashboard";
	    String actualURL = driver.getCurrentUrl();
	    System.out.println(actualURL);
	    
	    if(actualURL.equals(expectedURL)) {
	    	System.out.println("Dashboard Extension IS DISPLAYED");
	    
	    }else {
	    	System.out.println("Dashboard Extension IS NOT DISPLAYED!!");
	    	throw new Exception();
	    }
	}


}
