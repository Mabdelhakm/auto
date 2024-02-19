package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Allure;
import main.Loggers;
import main.Setup;

public class Reset_Password_Page extends Setup{

	By email_field=By.id("login");
	By reset_button=By.xpath("//button[@class='btn btn-primary']");
	By login_with_oddo=By.xpath("//div[@class='o_auth_oauth_providers list-group mt-1 mb-1 text-start']");
	By back_to_page=By.xpath("//a[text()='Back to Login']");
	By success_alert=By.xpath("//p[@class='alert alert-success']");
	By fail_alert=By.xpath("//p[@class='alert alert-danger']");
	public void type_email(String text) {
		getCustomActions().explicit_wait_till_visible(email_field, 10);
		getCustomActions().typing_in_element(email_field, text);
		Allure.step("typing "+text+ " in the email field");
		Loggers.logger.info("typing "+text+ " in the email field");
	}
	
	
	public void click_reset_button() {
		getCustomActions().explicit_wait_till_visible(reset_button, 10);
		getCustomActions().clicking_element(reset_button);
		Allure.step("clicking on the reset button");
		Loggers.logger.info("clicking on the reset button");
	}
	
	public void click_back_to_lgin_link() {
		getCustomActions().explicit_wait_till_visible(back_to_page, 10);
		getCustomActions().clicking_element(back_to_page);
		Allure.step("clicking on the back to login page button");
		Loggers.logger.info("clicking on the back to login page button");
	}
	
	public void click_login_with_oddo_link() {
		getCustomActions().explicit_wait_till_visible(login_with_oddo, 10);
		getCustomActions().clicking_element(login_with_oddo);
		Allure.step("clicking on the login_with_oddo button");
		Loggers.logger.info("clicking on the login_with_oddo button");
	}
	
	
	public boolean check_success_alert() {
		getCustomActions().explicit_wait_till_visible(success_alert, 10);
		return getCustomActions().is_element_displayed(success_alert);
	}

	public boolean check_fail_alert() {
		getCustomActions().explicit_wait_till_visible(fail_alert, 10);
		return getCustomActions().is_element_displayed(fail_alert);
	}
}
