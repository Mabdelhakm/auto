package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import main.Loggers;
import main.Setup;

public class HomeScreen extends Setup {
	By sign_in_button = By.xpath("(//a[text()='Sign in']//parent::li)[1]");

	@Test
	public void clickingTheSignInButton() {
		getCustomActions().explicit_wait_till_visible(sign_in_button, 3);
		getCustomActions().clicking_element(sign_in_button);
		Allure.step("clicking home page sign in button");
		Loggers.logger.info("clicking the home page sign in button link");
	}
}
