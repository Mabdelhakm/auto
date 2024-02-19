package pages;

import org.openqa.selenium.By;
import io.qameta.allure.Allure;
import main.Loggers;
import main.SafeThread;
import main.Setup;

public class SignInPage extends Setup {

	By username_field = By.id("login");
	By password_field = By.id("password");
	By login_button = By.xpath("//button[text()='Log in']");
	By reset_password=By.xpath("//a[text()='Reset Password']");
	By error=By.cssSelector(".alert.alert-danger");
	By sign_up=By.xpath("//a[@href='/web/signup']");
	public void typing_username(String msg) {
		getCustomActions().explicit_wait_till_visible(username_field, 10);
		getCustomActions().typing_in_element(username_field, msg);
		Allure.step("typing " + msg + " at user name field");
		Loggers.logger.info("typing " + msg + " at user name field");
	}

	public void typing_password(String msg) {
		getCustomActions().explicit_wait_till_visible(password_field, 10);
		getCustomActions().typing_in_element(password_field, msg);
		Allure.step("typing " + msg + " at password field");
		Loggers.logger.info("typing " + msg + " at password field");
	}

	public void clicking_login_button() {
		getCustomActions().explicit_wait_till_visible(login_button, 10);
		getCustomActions().clicking_element(login_button);
		Allure.step("clicking the login button");
		Loggers.logger.info("clicking the login button");
	}
	
	public void clicking_sign_up() {
		getCustomActions().explicit_wait_till_visible(sign_up, 10);
		getCustomActions().clicking_element(sign_up);
		Allure.step("clicking the sign_up button");
		Loggers.logger.info("clicking the sign_up button");
	}
	
	public void clicking_reset_password_button() {
		getCustomActions().explicit_wait_till_visible(reset_password, 10);
		getCustomActions().clicking_element(reset_password);
		Allure.step("clicking the reset_password button");
		Loggers.logger.info("clicking the reset_password button");
	}
	
	
	public boolean check_error() {
		getCustomActions().explicit_wait_till_visible(error, 10);
		return getCustomActions().is_element_displayed(error);
		
	}
	
	public String check_validation_message() {
		getCustomActions().explicit_wait_till_visible( username_field, 10);
		return SafeThread.getDriver().findElement(username_field).getDomProperty("validationMessage");
	}
		

	
	
	public boolean check_page() {
		getCustomActions().explicit_wait_till_visible(username_field, 10);
		return getCustomActions().is_element_displayed(username_field);
		
	}
}
