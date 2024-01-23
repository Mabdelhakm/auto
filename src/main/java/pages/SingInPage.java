package pages;

import org.openqa.selenium.By;

import main.Setup;

public class SingInPage  extends Setup{
	
	By username_field=By.id("login");
	By password_field=By.id("password")  ;
	By login_button=By.cssSelector(".btn.btn-primary")    ;
	
	
	public void typing_username(String msg) {
		customized_actions().explicit_wait_till_visible(username_field, 10);
		customized_actions().typing_in_element(username_field, msg);
	}
	
	public void typing_password(String msg) {
		customized_actions().explicit_wait_till_visible(password_field, 10);
		customized_actions().typing_in_element(password_field, msg);
	}

	public void clicking_login_button() {
		customized_actions().explicit_wait_till_visible(login_button, 10);
		customized_actions().clicking_element(login_button);
	}
}
