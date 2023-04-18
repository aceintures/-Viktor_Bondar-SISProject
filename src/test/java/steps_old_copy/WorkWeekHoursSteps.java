package steps_old_copy;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class WorkWeekHoursSteps extends CommonMethods {
	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		login.adminLogin();
	}

	@Given("click on PIM and Employee List")
	public void click_on_pim_and_employee_list() {
		click(dashboard.PIM);
		click(dashboard.employeeListLink);
		wait(2);
	}

	@Given("click on {string} to see employee details")
	public void click_on_to_see_employee_details(String empName) {
		sendText(employeeList.searchBox, empName);
		wait(1);
		jsClick(employeeList.searchIcon);
		wait(3);
		click(employeeList.employeeNameInSearchResult);
		wait(3);

	}

	@Given("click on More and Work Week")
	public void click_on_more_and_work_week() {
		click(header.moreMenu);
		click(header.workWeek);
		wait(2);
	}

	@Given("click on Enable Work Week switch")
	public void click_on_enable_work_week_switch() {
		boolean enabled = workWeek.enableWorkDaySwitch.isSelected();
		if (enabled == false) {
			click(workWeek.enableWorkDaySwitch);
		}
	}

	@Given("i want to change work week hours")
	public void i_want_to_change_work_week_hours(DataTable DataWeeks) {
		List<Map<String, String>> listOfHrs = DataWeeks.asMaps();
		// MONDAY
		boolean monday = workWeek.mondayTypeInput.getAttribute("value").equalsIgnoreCase(listOfHrs.get(0).get("Type"));
		if (monday == false) {
			click(workWeek.mondayTypeInput);
			clickOnElement(workWeek.mondayTypeOptions, listOfHrs.get(0).get("Type"));
		}

		sendText(workWeek.mondayShiftIn, listOfHrs.get(0).get("Shift_In"));

		sendText(workWeek.mondayShiftOut, listOfHrs.get(0).get("Shift_Out"));

		sendText(workWeek.mondayLunchIn, listOfHrs.get(0).get("Lunch_In"));

		sendText(workWeek.mondayLunchOut, listOfHrs.get(0).get("Lunch_Out"));
		wait(2);

		// TUESDAY
		boolean tuesday = workWeek.tuesdayTypeInput.getAttribute("value")
				.equalsIgnoreCase(listOfHrs.get(1).get("Type"));
		if (tuesday == false) {
			click(workWeek.tuesdayTypeInput);
			clickOnElement(workWeek.tuesdayTypeOptions, listOfHrs.get(1).get("Type"));
		}

		sendText(workWeek.tuesdayShiftIn, listOfHrs.get(1).get("Shift_In"));

		sendText(workWeek.tuesdayShiftOut, listOfHrs.get(1).get("Shift_Out"));

		sendText(workWeek.tuesdayLunchIn, listOfHrs.get(1).get("Lunch_In"));

		sendText(workWeek.tuesdayLunchOut, listOfHrs.get(1).get("Lunch_Out"));
		wait(2);

		// WEDNESDAY
		boolean wednesday = workWeek.wednesdayTypeInput.getAttribute("value")
				.equalsIgnoreCase(listOfHrs.get(2).get("Type"));
		if (wednesday == false) {
			click(workWeek.wednesdayTypeInput);
			clickOnElement(workWeek.wednesdayTypeOptions, listOfHrs.get(2).get("Type"));
		}

		sendText(workWeek.wednesdayShiftIn, listOfHrs.get(2).get("Shift_In"));

		sendText(workWeek.wednesdayShiftOut, listOfHrs.get(2).get("Shift_Out"));

		sendText(workWeek.wednesdayLunchIn, listOfHrs.get(2).get("Lunch_In"));

		sendText(workWeek.wednesdayLunchOut, listOfHrs.get(2).get("Lunch_Out"));
		wait(2);

		// THURSDAY
		boolean thursday = workWeek.thursdayTypeInput.getAttribute("value")
				.equalsIgnoreCase(listOfHrs.get(3).get("Type"));
		if (thursday == false) {
			click(workWeek.thursdayTypeInput);
			clickOnElement(workWeek.thursdayTypeOptions, listOfHrs.get(3).get("Type"));
		}

		sendText(workWeek.thursdayShiftIn, listOfHrs.get(3).get("Shift_In"));

		sendText(workWeek.thursdayShiftOut, listOfHrs.get(3).get("Shift_Out"));

		sendText(workWeek.thursdayLunchIn, listOfHrs.get(3).get("Lunch_In"));

		sendText(workWeek.thursdayLunchOut, listOfHrs.get(3).get("Lunch_Out"));
		wait(2);
		// FRIDAY
		boolean friday = workWeek.thursdayTypeInput.getAttribute("value")
				.equalsIgnoreCase(listOfHrs.get(4).get("Type"));
		if (friday == false) {
			click(workWeek.fridayTypeInput);
			clickOnElement(workWeek.fridayTypeOptions, listOfHrs.get(4).get("Type"));
		}

		sendText(workWeek.fridayShiftIn, listOfHrs.get(4).get("Shift_In"));

		sendText(workWeek.fridayShiftOut, listOfHrs.get(4).get("Shift_Out"));

		sendText(workWeek.fridayLunchIn, listOfHrs.get(4).get("Lunch_In"));

		sendText(workWeek.fridayLunchOut, listOfHrs.get(4).get("Lunch_Out"));
		wait(2);

		// Saturday
		boolean saturday = workWeek.saturdayTypeInput.getAttribute("value")
				.equalsIgnoreCase(listOfHrs.get(5).get("Type"));
		if (saturday == false) {
			click(workWeek.saturdayTypeInput);
			clickOnElement(workWeek.saturdayTypeOptions, listOfHrs.get(5).get("Type"));
		}

		// Sunday
		boolean sunday = workWeek.sundayTypeInput.getAttribute("value").equalsIgnoreCase(listOfHrs.get(6).get("Type"));
		if (sunday == false) {
			click(workWeek.sundayTypeInput);
			clickOnElement(workWeek.sundayTypeOptions, listOfHrs.get(6).get("Type"));
		}
	}

	@Given("click on save button")
	public void click_on_save_button() {
		click(workWeek.saveBtn);
	}

	@Then("i validate to Successfully Saved message shown")
	public void i_validate_to_successfully_saved_message_shown() {
		boolean msg = workWeek.toastMsg.isDisplayed();
		Assert.assertTrue("PASSED", msg);
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
