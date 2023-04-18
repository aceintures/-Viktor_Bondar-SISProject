package steps_old_copy;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportToValidation extends CommonMethods {

	@When("user navigates to personal details page")
	public void user_navigates_to_personal_details_page() {
		click(dashboard.PIM);
		click(dashboard.employeeListLink);
		
		wait(3);
		
		String employeeName = "Peter Mac Anderson";
		sendText(employeeList.searchBox, employeeName);
		
		wait(3);
		jsClick(employeeList.searchIcon);
		
		wait(3);
	    jsClick(employeeList.employeeNameInSearchResult);
	}
	@When("clicks on the more tab in the navigation bar")
	public void clicks_on_the_more_tab_in_the_navigation_bar() {
	    wait(3);
		jsClick(header.moreMenu);
	}
	@When("clicks on the report to button")
	public void clicks_on_the_report_to_button() {
	    wait(3);
	    jsClick(header.reportTo);
	    
	}
	@Then("correct page is displayed")
	public void correct_page_is_displayed() {
		
		
		String expectedAssignedSupervisorTableTitle = "Assigned Supervisors";
		String expectedAssignedSubordinatesTableTitle = "Assigned Subordinates";
		
		String actualAssignedSupervisorsTableTitle = reportTo.assignedSupervisorsTableTitle.getText();
		String actualAssignedSubordiantesTableTitle = reportTo.assignedSubordinatesTableTitle.getText();
		
		Assert.assertEquals("The supervisor table name DOES NOT match!", expectedAssignedSupervisorTableTitle, actualAssignedSupervisorsTableTitle);
		Assert.assertEquals("The subordinate table name DOES NOT match!", expectedAssignedSubordinatesTableTitle, actualAssignedSubordiantesTableTitle);
	    
	}

	@When("user navigates to report to page")
	public void user_navigates_to_report_to_page() {
		click(dashboard.PIM);
		click(dashboard.employeeListLink);
		
		String employeeName = "Peter Mac Anderson";
		sendText(employeeList.searchBox, employeeName);
		
		wait(2);
		jsClick(employeeList.searchIcon);
		
		wait(2);
	    jsClick(employeeList.employeeNameInSearchResult);
	    
	    wait(2);
		jsClick(header.moreMenu);
		
		wait(2);
	    jsClick(header.reportTo);
	}
	
	@When("clicks on the plus button")
	public void clicks_on_the_plus_button() {
	    wait(2);
		jsClick(reportTo.plusButton);
	}
	
	@When("clicks on the add supervisor button")
	public void clicks_on_the_add_supervisor_button() {
	    wait(2);
	    jsClick(reportTo.addSupervisorButton);
	}
	
	@When("fills out the add supervisor form fields")
	public void fills_out_the_add_supervisor_form_fields() {
		 wait(2);
		 String supervisorName = "Jacqueline White";
		 sendText(addSupervisor.nameField, supervisorName);
		 
		 wait(2);
		 jsClick(addSupervisor.dropdownButton);
		 wait(2);
		 selectDropdown(addSupervisor.reportingMethod, "Direct");
	}
	
	@When("clicks on save button")
	public void clicks_on_save_button() {
		wait(3);
	    jsClick(addSupervisor.saveButton);
	}

	@When("clicks on the add subordinate button")
	public void clicks_on_the_add_subordinate_button() {
		wait(3);
	    jsClick(reportTo.addSubordinateButton);
	}
	
	@Then("user should be redirected to report to page")
	public void user_should_be_redirected_to_report_to_page() {
		String actualAssignedSupervisorsTableTitle = reportTo.assignedSupervisorsTableTitle.getText();
		String expectedAssignedSupervisorTableTitle = "Assigned Supervisors";
		
		String expectedAssignedSubordinatesTableTitle = "Assigned Subordinates";
		String actualAssignedSubordiantesTableTitle = reportTo.assignedSubordinatesTableTitle.getText();
		
		Assert.assertEquals("The supervisor table name DOES NOT match!", expectedAssignedSupervisorTableTitle, actualAssignedSupervisorsTableTitle);
		Assert.assertEquals("The subordinate table name DOES NOT match!", expectedAssignedSubordinatesTableTitle, actualAssignedSubordiantesTableTitle);
	}

	@When("fills out the add subordinate form fields")
	public void fills_out_the_add_subordinate_form_fields() {
		wait(2);
		String supervisorName = "Steven Caldwell";
		sendText(addSubordinate.nameField, supervisorName);
		 
		wait(2);
		jsClick(addSubordinate.dropdownButton);
		wait(2);
		selectDropdown(addSubordinate.reportingMethod, "Direct");
	    
	}












		
}
