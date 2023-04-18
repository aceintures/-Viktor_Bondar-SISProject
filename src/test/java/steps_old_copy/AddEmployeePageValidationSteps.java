package steps_old_copy;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeePageValidationSteps extends CommonMethods {

	@When("I click PIM tab")
	public void i_click_pim_tab() {

		click(addEmployee.PIM);
		waitForVisibility(addEmployee.addEmployeeTab);
	}

	@When("I click on Add Employee tab")
	public void i_click_on_add_employee_tab() {
		click(addEmployee.addEmployeeTab);
		waitForVisibility(addEmployee.addEmployeePageText);
		wait(3);
	}

	@Then("I validate Add Employee Page")
	public void i_validate_add_employee_page() {
		String expectedText = "Add Employee";
		String actualText = addEmployee.addEmployeePageText.getText();

		Assert.assertEquals("The Add Employee Page DOES NOT match!", expectedText, actualText);

	}

}
