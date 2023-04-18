package steps_old_copy;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddSocialMediaDetailsSteps extends CommonMethods {

	@When("Admin user proceeded to Social Media page")
	public void admin_user_proceeded_to_social_media_page() {
		click(dashboard.pim);
		click(dashboard.employeeList);
		wait(2);
		sendText(employeeList.employeeNameSearchBox, "Alice Duval");
		wait(2);
		jsClick(employeeList.searchIcon);
		wait(3);
		click(employeeList.employeeNameInSearchResult);
		waitForVisibility(personalDetails.employeeId);
		wait(4);
		click(personalDetails.moreMenu);
		click(personalDetails.socialMediaDetails);
		wait(4);
		click(socialMedia.addButton);
		waitForVisibility(socialMedia.content);

	}

	@When("Admin user sends social media Type {string} , Handle {string} and Link {string}")
	public void admin_user_sends_social_media_type_handle_and_link(String type, String handle, String link) {
		click(socialMedia.typeButton);
		click(driver.findElement(By.xpath("//span[.='" + type + "']")));
		wait(1);
		sendText(socialMedia.handle, handle);
		sendText(socialMedia.link, link);
	}

	@Then("Admin user click on Allow share in public")
	public void admin_user_click_on_allow_share_in_public() {
		wait(1);
		jsClick(socialMedia.allowShareCheckBox);
	}

	@Then("Admin clicks on save button")
	public void admin_clicks_on_save_button() {
		wait(1);
		click(socialMedia.saveButton);
		wait(5);
		waitForClickability(personalDetails.employeeName);
	}

}
