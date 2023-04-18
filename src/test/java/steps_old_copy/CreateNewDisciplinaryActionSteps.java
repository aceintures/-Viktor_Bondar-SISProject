package steps_old_copy;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewDisciplinaryActionSteps extends CommonMethods {

	@When("I enter the fullname of the employee {string}")
	public void i_enter_the_fullname_of_the_employee(String fullName) {
		wait(2);
		sendText(disciplinaryCases.fullNameBox, fullName);
		WebElement validateName = disciplinaryCases.fullNameBox;
		validateName.sendKeys(Keys.ENTER);
	}

	@Then("I enter the case {string}")
	public void i_enter_the_case(String caseName) {
		wait(1);
		sendText(disciplinaryCases.caseNameBox, caseName);
	}

	@And("I enter the description of case {string}")
	public void i_enter_the_description_of_case(String description) {
		wait(1);
		sendText(disciplinaryCases.descriptionBox, description);
	}

	@Then("I click on green save button")
	public void i_click_on_green_save_button() {
		wait(1);
		click(disciplinaryCases.greenSaveButton);
	}

	@Then("I click on the orange take disciplinary action button")
	public void i_click_on_the_orange_take_disciplinary_action_button() {
		wait(1);
		click(disciplinaryCases.orangeTakeDisActionButton);
	}

	@Then("I click on terminate")
	public void i_click_on_terminate() {
		wait(2);
		click(disciplinaryCases.terminate);

	}

	@Then("I click on select")
	public void i_click_on_select() {
		wait(1);
		click(disciplinaryCases.greenSelectButton);
	}

	@Then("I enter the name of the owner {string}")
	public void i_enter_the_name_of_the_owner(String owner) {
		sendText(disciplinaryCases.ownerBox, owner);
		WebElement validateName = disciplinaryCases.ownerBox;
		validateName.sendKeys(Keys.ENTER);
	}

	@Then("I select the status as completed")
	public void i_select_the_status_as_completed() {
		wait(1);
		click(disciplinaryCases.selectStatus);
		wait(1);
		clickOnElement(disciplinaryCases.selectStatusOptions, "Completed");

	}

	@Then("I enter the description of the add action {string}")
	public void i_enter_the_description_of_the_add_action(String addActionDescription) {
		wait(1);
		sendText(disciplinaryCases.descriptionBox2, addActionDescription);
	}

	@Then("I validate that a new disciplinary action created")
	public void i_validate_that_a_new_disciplinary_action_created() {
		wait(1);
		click(disciplinaryCases.greenSaveButton2);
		boolean expected = disciplinaryCases.successMsg.isDisplayed();
		Assert.assertTrue("PASSED", expected);

	}

	public void clickOnElement(List<WebElement> list, String value) {
		wait(1);
		for (WebElement option : list) {
			// System.out.println(option.getText());
			if (option.getText().equals(value)) {
				click(option);
				break;
			}
		}
	}


}



