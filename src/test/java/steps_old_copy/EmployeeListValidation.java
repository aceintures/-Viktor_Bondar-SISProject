package steps_old_copy;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeListValidation extends CommonMethods {

	@Given("user navigates to employee list page")
	public void user_navigates_to_employee_list_page() {
		click(dashboard.PIM);
		click(dashboard.employeeListLink);
	}
	
	@When("enters valid employee name in the search bar")
	public void enters_valid_employee_name_in_the_search_bar() {
		String employeeName = "Peter Mac Anderson";
		sendText(employeeList.searchBox, employeeName);
	}
	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
		wait(3);
		jsClick(employeeList.searchIcon);
	}
	
	@Then("employee shows up in search results")
	public void employee_shows_up_in_search_results() {
		wait(5);
		String expectedEmployeeName = "Peter Mac Anderson";
	    String actualEmployeeName = employeeList.employeeNameInSearchResult.getText();
	    Assert.assertEquals("The employee name DOES NOT match!", expectedEmployeeName, actualEmployeeName);
	}

	@When("click on employee information")
	public void click_on_employee_information() {
		wait(3);
	    jsClick(employeeList.employeeNameInSearchResult);
	}
	
	@Then("employee details are displayed")
	public void the_employee_details_page_is_displayed() {
		wait(3);
		
		String expectedTabName = "Personal Details";
		String actualTabName = personalDetails.tabName.getText();
		Assert.assertTrue(actualTabName.contains(expectedTabName));
		
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Personal Details";
		Assert.assertEquals("The employee name DOES NOT match!", expectedPageTitle, actualPageTitle);
	}







}
