package steps_old_copy;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;

public class AddPersonalDetailsSteps extends CommonMethods {

	@Then("I am able to modify Employee Personal Details {string}, {string}, {string}, {string},  {string}, {string}, {string},  {string},  {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_personal_details(String OtherId, String DateOfBirth, String MartialStatus,
			String Gender, String Nationality, String DriverLicense, String ExpirationDate, String NickName,
			String MilitaryService, String Smoker , String Etnicity) {
		// Write code here that turns the phrase above into concrete actions
		waitForVisibility(personalDetails.personalDetailsForm);
             wait(5);
		// other id
		sendText(personalDetails.otherId, OtherId);
          wait(6);
		// Date of Birth

		click(personalDetails.BirthDate); // Will show the calendar

		String[] parts = DateOfBirth.split("-");

		// Select the year
		click(personalDetails.BirthYearInput); // Will show the years
		clickOnElement(personalDetails.BirthYearOptions, parts[0]);
		wait(3);
		// Select the month
		click(personalDetails.BirthMonthInput); // Will show the months
		int m = Integer.parseInt(parts[1]); // Converting 05 to integer 5
		click(personalDetails.BirthMonthOptions.get(m - 1)); // Because May is index 5-1

		// Select the day
		int d = Integer.parseInt(parts[2]); // Converting 08 to integer 8
		selectCalendarDate(personalDetails.BirthDays, d + ""); // Converting int 8 to a String

		wait(1);

		// martial status

		click(personalDetails.MartialInput);

		clickOnElement(personalDetails.MartialOptions, MartialStatus);
		wait(2);
		// gender

		click(personalDetails.genderInput);
		clickOnElement(personalDetails.genderOptions, Gender);
		wait(2);

		// Driver License

		sendText(personalDetails.driverLicense, DriverLicense);

		// EXPIRATION DATE
		click(personalDetails.licExpDate); // Will show the calendar

		String[] partS = ExpirationDate.split("-");

		// Select the year
		click(personalDetails.licExpYearInput); // Will show the years
		clickOnElement(personalDetails.licExpYearOptions, partS[0]);

		// Select the month
		click(personalDetails.licExpMonthInput); // Will show the months
		int months = Integer.parseInt(partS[1]); // Converting 05 to integer 5
		click(personalDetails.licExpMonthOptions.get(months - 1)); // Because May is index 5-1

		// Select the day
		int days = Integer.parseInt(partS[2]); // Converting 08 to integer 8
		selectCalendarDate(personalDetails.licExpDays, days + ""); // Converting int 8 to a String

		wait(1);

		// NickName
		sendText(personalDetails.nickName, NickName);

		// Military Service

		sendText(personalDetails.militaryService, MilitaryService);

		// smoker
		if (Smoker.equals("Yes")) {
			click(personalDetails.smokerBox);
		}
		wait(2);

		// nationality

		click(personalDetails.nationInput);

		clickOnElement(personalDetails.nationOptions, Nationality);
		wait(2);

		
		// Etnicity

				click(personalDetails.EtnicityInput);

				clickOnElement(personalDetails.EtnicityOptions, Etnicity);
				wait(2);
	}


	@Then("user clicks on Personal Details save button")
	public void user_clicks_on_personal_details_save_button() {
		jsClick(personalDetails.detailsSaveBtn);
		wait(3);
	}

	@Then("I am able to modify Employee Important Details2 {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_important_details2(String BloodGroup, String Hobbies, String ShirtSize) {
		// Write code here that turns the phrase above into concrete actions
		// waitForVisibility(personalDetails.personalDetailsForm);

		// blood Type 

		click(personalDetails.BloodInput);

		clickOnElement(personalDetails.BloodOptions, BloodGroup);
		wait(2);

		// hobbies
		sendText(personalDetails.hobbies, Hobbies);

		// Shirt Size

		click(personalDetails.shirtSizeInput);
		clickOnElement(personalDetails.shirtSizeOptions, ShirtSize);
		wait(2);

	}

	@Then("user clicks on Important save button")
	public void user_clicks_on_important_save_button() {
		jsClick(personalDetails.importanSaveBtn);
		wait(3);
	}

	@Then("I am able to modify Employee Prefences Details {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_prefences_details(String Food, String Activities, String Sports) {
		// Write code here that turns the phrase above into concrete actions

		// FOOD

		if (Food.equals("Veg")) {
			click(personalDetails.foodBox);
		}
		wait(2);

		// activities
		if (Activities.equals("Arts")) {
			click(personalDetails.activityBox);
		}
		wait(2);

		// sports

		if (Sports.equals("Golf")) {
			click(personalDetails.sportBox);
		}
		wait(2);
	}

	@Then("user clicks on Prefences save button")
	public void user_clicks_on_prefences_save_button() {
		jsClick(personalDetails.preferenceSaveBtn);
		wait(3);

	}

	@Then("user clicks on add button")
	public void user_clicks_on_add_button() {
		jsClick(personalDetails.addBtn);
		wait(3);

	}

	@Then("I am able to modify Employee Attachments Details {string}")
	public void i_am_able_to_modify_employee_attachments_details( String Description) {
		

	// Write code here that turns the phrase above into concrete actions
	
		
		
		
		
		wait(3);

	
		
	String filePath = System.getProperty("user.dir") + "\\UploadFiles\\bb.png";

	//sendText(personalDetails.fileDirection, filePath);
	System.out.println(filePath);
		personalDetails.fileDirection.sendKeys(filePath);
		wait(2);
	
		
		sendText(personalDetails.attachmentDes, Description);
		
		
		
	}


	@Then("user clicks on Attachments add button")
	public void user_clicks_on_attachments_add_button() {
		jsClick(personalDetails.AttachmentsAddBtn);
		wait(3);
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
