package steps_old_copy;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewEmployeeSteps extends CommonMethods {

	@When("Admin user navigates to PIM menu")
	public void admin_user_navigates_to_pim_menu() {
		dashboard.pim.click();
	}

	@When("Admin user clicks to Add Employee")
	public void admin_user_clicks_to_add_employee() {
		dashboard.addEmployee.click();
		wait(5);
	}

	@Then("Admin user enters employee first name {string}, middle name {string} and last name {string}")
	public void admin_user_enters_employee_first_name_middle_name_and_last_name(String firstName, String middleName,
			String lastName) {
		sendText(addEmployee.firstName, firstName);
		sendText(addEmployee.lastName, lastName);
		sendText(addEmployee.middleName, middleName);
	}

	@Then("Admin user selects a location {string}")
	public void admin_user_selects_a_location(String location) {
		wait(2);
		selectDropdown(addEmployee.location, location);
	}

	@Then("Admin user clicks on save button")
	public void admin_user_clicks_on_save_button() {
		addEmployee.saveButton.click();
		waitForVisibility(personalDetails.employeeName);
	}

	@Then("validate that employee {string} is added successfully")
	public void validate_that_employee_is_added_successfully(String expectedName) {
		waitForVisibility(personalDetails.employeeName);
		String actualName = personalDetails.employeeName.getText();
		Assert.assertEquals("Employee name does NOT match!", expectedName, actualName);
		wait(2);

	}
}
