package steps_old_copy;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddQualificationPageValidation extends CommonMethods {
	public static Actions action = new Actions(driver);

	@And("I navigate to Qualifications page")
	public void i_navigate_to_dependets_page() {
		waitForClickability(personalDetails.More_options_Button);
		click(personalDetails.More_options_Button);
		wait(6);

		click(personalDetails.qualifications);
	}

	@And("I navigate to Work Experience page")
	public void navigate_to_work_experience_page() {
		waitForVisibility(qualification.plusButton);
		action.moveToElement(qualification.plusButton).perform();
		wait(6);
		click(qualification.workExperiencePage);
		wait(5);
		waitForClickability(qualification.saveButton);

	}

	@And("I navigate to Education page")
	public void navigate_to_education_page() {
		waitForVisibility(qualification.plusButton);
		action.moveToElement(qualification.plusButton).perform();
		wait(6);
		click(qualification.educationPage);
		wait(6);
		waitForClickability(qualification.saveButton);

	}

	@And("I navigate to Skills page")
	public void navigate_to_skill_page() {

		waitForVisibility(qualification.plusButton);
		action.moveToElement(qualification.plusButton).perform();
		wait(5);
		action.moveToElement(qualification.plusButtonOptions).perform();
		click(qualification.skillPage);
		wait(5);
		waitForClickability(qualification.saveButton);

	}

	@And("I navigate to Language page")
	public void navigate_to_language_page() {
		waitForVisibility(qualification.plusButton);
		action.moveToElement(qualification.plusButton).perform();
		
		wait(2);
		click(qualification.languagesPage);
		wait(2);
		waitForClickability(qualification.saveButton);

	}

	@And("I navigate to License page")
	public void navigate_to_license_page() {
		waitForVisibility(qualification.plusButton);
		action.moveToElement(qualification.plusButton).perform();

		wait(2);
		click(qualification.licensePage);
		wait(2);
		waitForClickability(qualification.saveButton);

	}

	@And("I add Work Experience Info:{string},{string},{string},{string}")
	public void work_experience_page(String company, String jobtitle, String from_date, String to_date) {
		sendText(qualification.company, company);
		sendText(qualification.jobtitle, jobtitle);
		sendText(qualification.from_date, from_date);
		sendText(qualification.to_date, to_date);
		wait(5);
		click(qualification.creditableButton);
		wait(5);
		waitForClickability(qualification.saveButton);
		click(qualification.saveButton);
		wait(5);
	}

//	@And("I add Education Info:{string},{string},{string},{string},{string},{string},{string}")
//	public void education_page(String level, String institute, String major_specialization, String year,
//			String gpa_score, String startDate, String endDate) {
//		selectDropdown(qualification.level, level);
//		sendText(qualification.institute, institute);
//		sendText(qualification.major_specialization, major_specialization);
//		sendText(qualification.year, year);
//		sendText(qualification.gpa_score, gpa_score);
//		sendText(qualification.startDate, startDate);
//		sendText(qualification.endDate, endDate);
//		wait(1);
//		waitForClickability(qualification.saveButton);
//		click(qualification.saveButton);
//		wait(2);
//	}
	
	
	@And("I add Education Info:{string},{string},{string},{string},{string}, {string},{string}")
	public void i_add_education_info(String level, String institute, String major_specialization, String year,
			String gpa_score, String startDate, String endDate) {
		selectDropdown(qualification.level, level);
		sendText(qualification.institute, institute);
		sendText(qualification.major_specialization, major_specialization);
		sendText(qualification.year, year);
		sendText(qualification.gpa_score, gpa_score);
		sendText(qualification.startDate, startDate);
		sendText(qualification.endDate, endDate);
		wait(6);
		waitForClickability(qualification.saveButton);
		click(qualification.saveButton);
		wait(5);
	
	}
	
	

	@And("I add Skill Info:{string},{string}")
	public void skill_page(String skillId, String years_of_exp) {
		selectDropdown(qualification.skillId, skillId);
		sendText(qualification.years_of_exp, years_of_exp);
		wait(5);
		waitForClickability(qualification.saveButton);
		click(qualification.saveButton);
		wait(5);
	}

	@And("I add Language Info:{string},{string},{string}")
	public void language_page(String language, String languageLevel, String fluencyLevel) {
		selectDropdown(qualification.language, language);
		selectDropdown(qualification.languageLevel, languageLevel);
		selectDropdown(qualification.fluencyLevel, fluencyLevel);
		wait(5);
		waitForClickability(qualification.saveButton);
		click(qualification.saveButton);
		wait(6);
	}

	@And("I add License Info:{string},{string},{string},{string}")
	public void license_page(String licenseType, String licenseNumber, String issuedDate, String expiryDate) {
		selectDropdown(qualification.licenseType, licenseType);
		sendText(qualification.licenseNumber, licenseNumber);
		sendText(qualification.issuedDate, issuedDate);
		sendText(qualification.expiryDate, expiryDate);
		wait(5);
		waitForClickability(qualification.saveButton);
		click(qualification.saveButton);
		wait(6);
	}

}
