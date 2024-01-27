package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.qameta.allure.Allure;
import main.Loggers;

public class Chrome {
	public WebDriver init_chrome() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--headless");
		options.addArguments("--window-size=1280,800");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--allow-insecure-localhost");
		WebDriver driver = new ChromeDriver(options);
		Allure.step("start chrome browser");
		Loggers.logger.info("start chrome browser");
		return driver;

	}
}
