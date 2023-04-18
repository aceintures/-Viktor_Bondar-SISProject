package steps_old_copy;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddNewEmployeeFunctionalityValidationSteps extends CommonMethods {

	@Given("I click on PIM")
	public void i_click_on_pim() {
		click(dashboard.PIM);
	}

	@Given("I click on Add Employee")
	public void i_click_on_add_employee() {
		click(dashboard.addEmployeeLink);
	}

	@Then("I sees pop-up Add Employee page with details present")
	public void i_sees_pop_up_add_employee_page_with_details_present() throws Exception {
		if (addEmployee.addEmpPopUp.isDisplayed()) {
			System.out.println("Add Employee POP-UP DISPLAYED!!");
		} else {
			System.out.println("Add Employee POP-UP NOT DISPLAYED!!");
			throw new Exception();
		}
	}

	@Then("I will add a new employee")
	public void i_will_add_a_new_employee() {
		sendText(addEmployee.firstName, "Naim");
		sendText(addEmployee.middleName, "Sempai");
		sendText(addEmployee.lastName, "Muti");
		selectDropdown(addEmployee.location, "HQ - CA, USA");
		click(addEmployee.saveButton);
	}

	@Then("I validate employee created")
	public void i_validate_employee_created() throws Exception {
		String expectedID = addEmployee.employeeId.getAttribute("value");
		String actualID = personalDetails.employeeId.getAttribute("value");

		if (actualID.equals(expectedID)) {
			System.out.println("Employee added SUCCESSFULLY!!");
		} else {
			System.out.println("Employee add FAILED!!");
			throw new Exception();
		}
	}

}
