package pages;

import org.openqa.selenium.By;

import io.qameta.allure.Allure;
import main.Loggers;
import main.Setup;

public class Sign_Up_Page extends Setup{

	By email_field=By.id("login");
	By username=By.id("name");
	By password=By.id("password");
	By confirm_password=By.id("confirm_password");
	By signup_button=By.xpath("//button[@class='btn btn-primary']");
	By already_have_account=By.xpath("//a[@class='btn btn-link btn-sm']");
	By login_with_oddo=By.xpath("//div[@class='o_auth_oauth_providers list-group mt-1 mb-1 text-start']");
	By check_signing_up=By.xpath("//h3[text()='My account']");
	By check_error=By.xpath("//p[@class='alert alert-danger']");
	
	
	public boolean check_signing_upp() {
		getCustomActions().explicit_wait_till_visible(check_signing_up, 10);
		return getCustomActions().is_element_displayed(check_signing_up);
	}
	
	public boolean check_error() {
		getCustomActions().explicit_wait_till_visible(check_error, 10);
		return getCustomActions().is_element_displayed(check_error);
	}
	public void type_email_field(String text) {
		getCustomActions().explicit_wait_till_visible(email_field, 10);
		getCustomActions().typing_in_element(email_field, text);
		Allure.step("typing: "+text+ " in the email field" );
		Loggers.logger.info("typing: "+text+ " in the email field");
	}
	
	
	public void type_user_name_field(String text) {
		getCustomActions().explicit_wait_till_visible(username, 10);
		getCustomActions().typing_in_element(username, text);
		Allure.step("typing: "+text+ " in the username field" );
		Loggers.logger.info("typing: "+text+ " in the username field");
	}
	
	
	
	public void type_password_field(String text) {
		getCustomActions().explicit_wait_till_visible(password, 10);
		getCustomActions().typing_in_element(password, text);
		Allure.step("typing: "+text+ " in the password field" );
		Loggers.logger.info("typing: "+text+ " in the password field");
	}
	
	
	
	public void type_confirm_password_field(String text) {
		getCustomActions().explicit_wait_till_visible(confirm_password, 10);
		getCustomActions().typing_in_element(confirm_password, text);
		Allure.step("typing: "+text+ " in the confirm_password field" );
		Loggers.logger.info("typing: "+text+ " in the confirm_password field");
	}
	
	
	public void click_sign_up( ) {
		getCustomActions().explicit_wait_till_visible(signup_button, 10);
		getCustomActions().clicking_element(signup_button);
		Allure.step("clicking on the sign up button" );
		Loggers.logger.info("clicking on the sign up button");
	}
	
	
	
	public void click_log_in_with_oddo( ) {
		getCustomActions().explicit_wait_till_visible(login_with_oddo, 10);
		getCustomActions().clicking_element(login_with_oddo);
		Allure.step("clicking on the login_with_oddo button" );
		Loggers.logger.info("clicking on the  login_with_oddo button");
	}
	
	
	public void click_have_an_account( ) {
		getCustomActions().explicit_wait_till_visible(already_have_account, 10);
		getCustomActions().clicking_element(already_have_account);
		Allure.step("clicking on the already_have_account button" );
		Loggers.logger.info("clicking on the already_have_account button");
	}
	
	
}
