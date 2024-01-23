package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import browsers.Chrome;
import browsers.Edge;
import browsers.Firefox;
import io.qameta.allure.Allure;

public class Setup {
	public WebDriver driver;
	private FileReader fr;
	public Properties prop;
	private Actions built_in_actions;
	private CustomActions custom_actions;

	@BeforeMethod
	public void initialize_browser() {
		try {
			fr = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Loggers.logger.fatal("can't find configuration file");
		}

		prop = new Properties();
		try {
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
			Loggers.logger.fatal("can't read the configuration file");
		}

		if (prop.getProperty("browser").trim().toLowerCase().equals("chrome")) {
			driver = Chrome.init_chrome();
		} else if (prop.getProperty("browser").trim().toLowerCase().equals("edge")) {
			driver = Edge.init_edge();
		} else if (prop.getProperty("browser").trim().toLowerCase().equals("firefox")) {
			driver = Firefox.init_firefox();
		}

		driver.get(prop.getProperty("url"));
		Loggers.logger.info("navigate to " + prop.getProperty("url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
	}

	public Actions selenium_built_in_actions() {
		if (built_in_actions instanceof Actions) {
			return built_in_actions;
		} else {
			built_in_actions = new Actions(this.driver);
			return built_in_actions;
		}
	}

	public CustomActions customized_actions() {
		if (custom_actions instanceof CustomActions) {
			return custom_actions;
		} else {
			custom_actions = new CustomActions(driver);
			return custom_actions;
		}

	}

	@AfterMethod
	public void close_browser() {
		driver.quit();
		Allure.step("close browser");
		Loggers.logger.info("close browser");
	}

}