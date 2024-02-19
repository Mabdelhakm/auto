package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

import io.qameta.allure.Allure;
import main.Loggers;
import main.Setup;

public class ContactUsPage extends Setup {
	By name_field = By.id("contact1");
	By phone_number_field = By.id("contact2");
	By email_field = By.id("contact3");
	By company_field = By.id("contact4");
	By subject_field = By.id("contact5");
	By question_field = By.id("contact6");
	By submit_button = By.xpath("//a[text()='Submit']");
	By error = By.id("s_website_form_result");
	By chat_main_shadow_element=By.cssSelector(".o-livechat-root");
	By element_inside_shadow=By.cssSelector(".fa fa-commenting");
	
	
	
	public void typing_in_name_field(String text) {
		// handled using sleep till learning how to handle shadow elements
		
		try {
			Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getCustomActions().explicit_wait_till_visible(name_field, 10);
		getCustomActions().typing_in_element(name_field, text);
		Allure.step("typing: " + text + " in the name field");
		Loggers.logger.info("typing: " + text + " in the name field");
	}

	public void typing_in_phone_number_field(String text) {
		getCustomActions().explicit_wait_till_visible(phone_number_field, 10);
		getCustomActions().typing_in_element(phone_number_field, text);
		Allure.step("typing: " + text + " in the phone number field");
		Loggers.logger.info("typing: " + text + " in the phone number field");
	}

	public void typing_in_email_field(String text) {
		getCustomActions().explicit_wait_till_visible(email_field, 10);
		getCustomActions().typing_in_element(email_field, text);
		Allure.step("typing: " + text + " in the email field");
		Loggers.logger.info("typing: " + text + " in the email field");
	}

	public void typing_in_company_field(String text) {
		getCustomActions().explicit_wait_till_visible(company_field, 10);
		getCustomActions().typing_in_element(company_field, text);
		Allure.step("typing: " + text + " in the company field");
		Loggers.logger.info("typing: " + text + " in the company field");
	}

	public void typing_in_subject_field(String text) {
		getCustomActions().explicit_wait_till_visible(subject_field, 10);
		getCustomActions().typing_in_element(subject_field, text);
		Allure.step("typing: " + text + " in the subject field");
		Loggers.logger.info("typing: " + text + " in the subject field");
	}

	public void typing_in_questions_field(String text) {
		getCustomActions().explicit_wait_till_visible(question_field, 10);
		getCustomActions().typing_in_element(question_field, text);
		Allure.step("typing: " + text + " in the questions field");
		Loggers.logger.info("typing: " + text + " in the questions field");
	}

	public void clicking_submit_button() {
		getCustomActions().explicit_wait_till_visible(submit_button, 10);
		getCustomActions().clicking_element(submit_button);
		Allure.step("clicking the submit button");
		Loggers.logger.info("clicking the submit button");
	}

	public boolean check_error() {
		getCustomActions().explicit_wait_till_visible(error, 15);
		return getCustomActions().is_element_displayed(error);
	}

}
