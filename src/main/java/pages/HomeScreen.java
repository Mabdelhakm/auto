package pages;

import org.openqa.selenium.By;
import io.qameta.allure.Allure;
import main.Loggers;
import main.Setup;

public class HomeScreen extends Setup {
	By sign_in_button = By.xpath("(//a[text()='Sign in']//parent::li)[1]");
	By contact_us_button = By.xpath("(//a[text()='Contact Us'])[1]");

	public void clickingTheSignInButton() {
		getCustomActions().explicit_wait_till_visible(sign_in_button, 10);
		getCustomActions().clicking_element(sign_in_button);
		Allure.step("clicking home page sign in button");
		Loggers.logger.info("clicking the home page sign in button link");
	}

	public void clickingTheContactUsButton() {
		getCustomActions().explicit_wait_till_visible(contact_us_button, 10);
		getCustomActions().clicking_element(contact_us_button);
		Allure.step("clicking home page contact us button");
		Loggers.logger.info("clicking the home page contact us button link");
	}
}
