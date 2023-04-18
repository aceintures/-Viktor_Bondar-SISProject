package steps_old_copy;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddDependencyPageValidation extends CommonMethods {

///
///	
	@When("I loged in as admin")
	public void i_login_as_admin() {
		login.adminLogin();
	}

	@And("I navigate to employee list")
	public void i_navigate_to_employee_list() {
		click(dashboard.Home);
		click(dashboard.PIM);
		click(dashboard.employeeListLink);

	}

	@And("I click on first employee in a list")
	public void i_click_on_first_employee() {
		waitForClickability(driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")));
		click(driver.findElement(By.xpath("//table/tbody/tr[8]/td[3]")));

	}

	@And("I navigate to Dependets page")
	public void i_navigate_to_dependets_page() {
		waitForClickability(personalDetails.More_options_Button);
		click(personalDetails.More_options_Button);
		click(personalDetails.dependets);
	}

	@Then("I add dependent:{string},{string},{string},{string}")
	public void add_dependent(String name, String dateOfBirth, String relationship_status, String relationship) {
		waitForClickability(driver.findElement(By.xpath("//div[@id='socialMediaDiv']/div/a")));
		click(driver.findElement(By.xpath("//div[@id='socialMediaDiv']/div/a")));
		wait(3);
		sendText(driver.findElement(By.id("name")), name);
		sendText(driver.findElement(By.id("date_of_birth")), dateOfBirth);

		if (relationship_status.equals("Child")) {
			selectDropdown(driver.findElement(By.id("relationship_type")), "Child");
		} else if (relationship_status.equals("-- Select --")) {
			selectDropdown(driver.findElement(By.id("relationship_type")), "-- Select --");
		} else if (relationship_status.equals("Other")) {
			selectDropdown(driver.findElement(By.id("relationship_type")), "Other");
			sendText(driver.findElement(By.id("relationship")), relationship);
		}
		
		click(driver.findElement(By.id("modal-save-button")));
		
	}
	
	@Then("I add employee marriage info:{string},{string}")
	public void add_marriage_info(String certificateNumber, String dateOfRegistration)
	{
		sendText(driver.findElement(By.id("3")), certificateNumber);
		sendText(driver.findElement(By.id("4")), dateOfRegistration);
		wait(2);
		waitForClickability(driver.findElement(By.xpath("//button[@type='submit'][@ng-disabled='form.readonly']")));
		click(driver.findElement(By.xpath("//button[@type='submit'][@ng-disabled='form.readonly']")));
	}

	
	
	
	
	
	
	
	
	
	
	
}
