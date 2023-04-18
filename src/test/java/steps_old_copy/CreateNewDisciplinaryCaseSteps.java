package steps_old_copy;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CreateNewDisciplinaryCaseSteps extends CommonMethods {
	
	@And("I navigate to AddEmployee page")
	public void i_navigates_to_add_employee_page() {
		click(dashboard.PIM);
		click(dashboard.addEmployeeLink);
	}
	@When("I enter employee first name {string} and last name {string}")
	public void i_enters_employee_first_name_and_last_name(String firstName, String lastName) {
		sendText(addEmployee.firstName, firstName);
		sendText(addEmployee.lastName, lastName);
	}
	@And("I select a location")
	public void i_selects_a_location() {
		selectDropdown(addEmployee.location, "New York Sales Office");
	}
	@And("I click on save button")
	public void i_clicks_on_save_button() {
		wait(1);
		click(addEmployee.saveButton);
	}
	@Then("I validate that employee {string} is added successfully")
	public void i_validate_that_employee_is_added_successfully(String expectedName) {
		waitForVisibility(personalDetails.personalDetailsForm);
		String actualName = personalDetails.employeeName.getText();
		Assert.assertEquals("The newly created employee name doesn't match!", expectedName, actualName);
	}
	
	@When("I click on Discipline on the dashboard")
	public void i_click_on_discipline_on_the_dashboard() {
		wait(2);
		click(dashboard.discipline);
	}
	
	
	@Then("I click on Disciplinary Cases")
	public void i_click_on_disciplinary_cases() {
		wait(2);
		click(disciplinaryCases.disciplinaryCase);
		wait(2);
	}
	@And("I click on the Add Disciplinary Cases")
	public void i_click_on_the_add_disciplinary_cases() {
		driver.switchTo().frame(0);
		wait(2);
		click(disciplinaryCases.AddDisciplinaryLink);
		wait(2);
	}
	
	@Then("I enter the fullname of newly created employee {string}")
	public void i_enter_the_fullname_of_newly_created_employee(String fullName) {
		wait(2);
		sendText(disciplinaryCases.fullNameBox, fullName);
		WebElement validateName = disciplinaryCases.fullNameBox;
		validateName.sendKeys(Keys.ENTER);
		
	}
	@And("I enter the case name {string}")
	public void i_enter_the_case_name(String caseName) {
		wait(1);
		sendText(disciplinaryCases.caseNameBox,caseName);
	}
	@Then("I enter the description {string}")
	public void i_enter_the_description(String description) {
		wait(1);
		sendText(disciplinaryCases.descriptionBox, description);
	}
	
	@And("I click on green save button and cancel")
	public void i_click_on_green_save_button_and_cancel() {
		wait(1);
		click(disciplinaryCases.greenSaveButton);
		wait(3);
		click(disciplinaryCases.orangeCancelButton);
	}
	
	
	@Then("I validate that a new disciplinary case created")
	public void i_validate_that_a_new_disciplinary_case_created() {
		waitForVisibility(disciplinaryCases.disciplinaryCase);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		int rowIndex = -1;
		
		
		for (int i=1; i < rows.size();i++)
		{
			rowIndex = i+1;
			String rowText = rows.get(i).getText();
			
			if(rowText.contains("Zonny Das"))
			{
				System.out.println("Validated a new disciplinary case added");
				
				System.out.println("i --> " + i);
						
				break;
				
			}
		
		}
	
	}
	
	
}