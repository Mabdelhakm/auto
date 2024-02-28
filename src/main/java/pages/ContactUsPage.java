package pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import main.Loggers;
import main.SafeThread;
import main.Setup;

public class ContactUsPage extends Setup {
	By name_field = By.id("contact1");
	By phone_number_field = By.id("contact2");
	By email_field = By.id("contact32");
	By company_field = By.id("contact4");
	By subject_field = By.id("contact5");
	By question_field = By.id("contact6");
	By submit_button = By.xpath("//a[text()='Submit']");
	By error = By.id("s_website_form_result");
	By chat_main_shadow_element = By.className("o-livechat-root");

	public void typing_in_name_field(String text) {
		getCustomActions().explicit_wait_till_present(chat_main_shadow_element, 10);
		getCustomActions().explicit_wait_till_visible(name_field, 10);
		getCustomActions().typing_in_element(name_field, text);
		Allure.step("typing: " + text + " in the name field");
		Loggers.logger.info("typing: " + text + " in the name field");
		byte[] screenshotBytes = ((TakesScreenshot) SafeThread.getDriver()).getScreenshotAs(OutputType.BYTES);

		// Save screenshot bytes to a file
		String screenshotFileName = System.getProperty("user.dir") + File.separator + "allure-results" + File.separator
				+ "screenshot.png"; // Change the filename as needed
		saveScreenshotLocally(screenshotBytes, screenshotFileName);

		// Attach screenshot to Allure report
		attachScreenshotToReport(screenshotBytes);
	}

	// Method to save screenshot bytes to a file
	private static void saveScreenshotLocally(byte[] screenshotBytes, String fileName) {
		// Write bytes to file
		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			fos.write(screenshotBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to attach screenshot to Allure report
	@Attachment(value = "Screenshot", type = "image/png")
	private static byte[] attachScreenshotToReport(byte[] screenshotBytes) {
		return screenshotBytes; // Return bytes to be attached to the report
	}

	public void typing_in_phone_number_field(String text) {
		getCustomActions().explicit_wait_till_visible(phone_number_field, 10);
		getCustomActions().typing_in_element(phone_number_field, text);
		Allure.step("typing: " + text + " in the phone number field");
		Loggers.logger.info("typing: " + text + " in the phone number field");
		Allure.addAttachment("hi1", "bye1");
	}

	public void typing_in_email_field(String text) {
		getCustomActions().explicit_wait_till_visible(email_field, 1);
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
		getCustomActions().explicit_wait_till_visible(error, 35);
		return getCustomActions().is_element_displayed(error);
	}

}
