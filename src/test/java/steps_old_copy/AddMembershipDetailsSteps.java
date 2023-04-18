package steps_old_copy;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddMembershipDetailsSteps extends CommonMethods {

	@When("Admin user proceeded to membership page")
	public void admin_user_proceeded_to_membership_page() {
		click(dashboard.pim);
		click(dashboard.employeeList);
		wait(1);
		sendText(employeeList.employeeNameSearchBox, "Alice Duval");
		wait(2);
		jsClick(employeeList.searchIcon);
		wait(4);
		click(employeeList.employeeNameInSearchResult);
		waitForVisibility(personalDetails.employeeId);
		wait(4);
		click(personalDetails.moreMenu);
		click(personalDetails.memberships);
		wait(4);
		click(memberships.addButton);
		waitForVisibility(memberships.addMembershipTitle);
	}

	@Then("Admin user selects membership {string}, Subscription Paid By {string}")
	public void admin_user_selects_membership_subscription_paid_by(String membership, String subscriptionPaidBy) {
		wait(1);
		clickOnElements(memberships.membershipOptions, membership);
		clickOnElements(memberships.subscriptionOptions, subscriptionPaidBy);
		wait(2);
	}

	@Then("Admin user enters Subscription Amount amount {string}")
	public void admin_user_enters_subscription_amount_amount(String subscriptionAmount) {
		sendText(memberships.subscriptionAmount, subscriptionAmount);
	}

	@Then("Admin user selects {string}")
	public void admin_user_selects(String currency) {
		clickOnElements(memberships.currencyOptions, currency);
		wait(5);
	}

	@Then("I am able to modify Employee Details {string}, {string}")
	public void i_am_able_to_modify_employee_details(String subscriptionCommenceDate, String subscriptionRenewalDate) {
		click(memberships.subscriptionCommenceDate);
		wait(1);
		String[] parts = subscriptionCommenceDate.split("-");
		int d = Integer.parseInt(parts[2]);
		selectCalendarDate(memberships.commenceDateOptions, d + "");
		wait(3);

		click(memberships.subscriptionRenewalDate);
		String[] parts2 = subscriptionRenewalDate.split("-");
		click(memberships.renewalYear);
		clickOnElements(memberships.renewalYearOptions, parts2[0]);
		click(memberships.renewalMonth);
		int m = Integer.parseInt(parts2[1]);
		click(memberships.renewalMonthOptions.get(m));
		wait(2);
		int d2 = Integer.parseInt(parts2[2]);
		selectCalendarDate(memberships.renewalDateOptions, d2 + "");
		wait(2);

	}
}
