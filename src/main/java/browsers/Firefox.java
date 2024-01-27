package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.qameta.allure.Allure;
import main.Loggers;

public class Firefox {

	public  WebDriver init_firefox() {
		FirefoxOptions options = new FirefoxOptions();
//		options.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(options);
		Allure.step("start fire fox browser");
		Loggers.logger.info("start fire fox browser");
		return driver;
	}
}
