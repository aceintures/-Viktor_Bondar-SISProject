package steps_old_copy;

import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddImmigrationDetailsPageValidationSteps extends CommonMethods {

	@When("I click Employee List tag")
	public void i_click_employee_list_tag() {
		click(addImmPage.empListTab);
	}

	@When("I click Employee List Search box")
	public void i_click_employee_list_search_box() {
		waitForClickability(addImmPage.empNameSearchBox);
		click(addImmPage.empNameSearchBox);
	}

	@When("I search {string} and {string} and click quick search icon")
	public void i_search_and_and_click_quick_search_icon(String firstName, String lastName) {
		sendText(addImmPage.empNameSearchBox, firstName + " " + lastName);
		wait(1);
		click(addImmPage.quickSearchIcon);
	}

	@When("I click Odis Adalwin on Employee List")
	public void i_click_odis_adalwin_on_employee_list() {
		waitForClickability(addImmPage.empOnEmpList);
		click(addImmPage.empOnEmpList);
		wait(2);
	}

	@When("I click More tag")
	public void i_click_more_tag() {
		click(addImmPage.moreTab);
		wait(2);
	}

	@When("I click Immigration tag")
	public void i_click_immigration_tag() {
		addImmPage.immigrationTab.click();
	}

	@When("I click Add Immigration button")
	public void i_click_add_immigration_button() {
		waitForClickability(addImmPage.addImmigrationButton);
		click(addImmPage.addImmigrationButton);
		wait(1);
	}

	@When("I modify Immigration Details {string}, {string}, {string},")
	public void i_modify_immigration_details(String document, String documentNumber, String issuedBy) {
		jsClick(addImmPage.passportRadioButton);
		wait(1);
		sendText(addImmPage.documentNumber, documentNumber);
		wait(1);

		click(addImmPage.issuedBy);
		wait(1);
		for (WebElement country : addImmPage.countryList) {
			if (country.getText().equals(issuedBy)) {
				country.click();
				break;
			}
		}

		wait(1);
	}

	@When("I modify IssuedDate,ExpiryDate,EligibleReviewDate")
	public void i_modify_issued_date_expiry_date_eligible_review_date() {
		// *-*-*-*-*-* issuedDate Part *-*-*-*-*-*-*-
		click(addImmPage.issuedDate);
		wait(1);
		addImmPage.issuedDateMonthButton.click();
		addImmPage.month.click();
		addImmPage.issuedDateYearButton.click();
		addImmPage.year.click();
		wait(1);

		for (WebElement date : addImmPage.issuedDateDateList) {
			if (date.getText().equals("1")) {
				date.click();
				break;
			}
		}
		wait(2);
		// *-*-*-*-*-*-*-*-*-* expiryDate Part *-*-*-*-*-*-*-*-*-*
		click(addImmPage.expiryDate);
		wait(1);
		addImmPage.expiryDateMonthButton.click();
		addImmPage.month2.click();
		addImmPage.expiryDateYearButton.click();
		addImmPage.year2.click();
		wait(1);

		for (WebElement date : addImmPage.expiryDateDateList) {
			if (date.getText().equals("1")) {
				date.click();
				break;
			}
		}
		wait(5);
	}

	@When("I modify Eligible Status and Comment")
	public void i_modify_eligible_status_and_comment() {
		sendText(addImmPage.eligibleStatus, "He is eligible!");
		sendText(addImmPage.comments, "Immigration Details Done! ");
	}

	@When("I save the process")
	public void i_save_the_process() {
		addImmPage.saveButton.click();
	}

	@Then("I validate Immigration Details Process with {string}")
	public void i_validate_immigration_details_process_with(String documentNumber) {
		wait(3);

		for (WebElement number : addImmPage.validationNumberList) {

			if (number.getText().equals(documentNumber)) {
				System.out.println("Validation Process is succesfully completed!");
			}break;
		}

		

	}

	

}
