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
import org.testng.annotations.Parameters;

import browsers.Chrome;
import browsers.Edge;
import browsers.Firefox;
import io.qameta.allure.Allure;

public class Setup {
	public  static WebDriver driver;
	private FileReader fr;
	public Properties prop;
	private Actions built_in_actions;
	private CustomActions custom_actions;

	@Parameters("browser")
	@BeforeMethod
	public void initialize_browser(String browser) {
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

		if (browser.equals("chrome")) {
			Chrome ch=new Chrome();
			driver =  ch.init_chrome();
			SafeThread.setDriver( driver);
		} 
		else if (browser.equals("edge")) {
			Edge ed=new Edge();
			driver =  ed.init_edge();
			SafeThread.setDriver( driver);
		} 
		else if (browser.equals("firefox")) {
			Firefox ff=new Firefox();
			driver = ff.init_firefox();
			SafeThread.setDriver(driver);
		}
//		driver.manage().window().maximize();
//		SafeThread.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SafeThread.getDriver().get(prop.getProperty("url"));
		Loggers.logger.info("navigate to " + prop.getProperty("url"));
	}

	public CustomActions getCustomActions() {
		custom_actions = customized_actions();
		return custom_actions;
	}

	public Actions getBuiltInActions() {
		built_in_actions = selenium_built_in_actions();
		return built_in_actions;
	}

	private CustomActions customized_actions() {
		if (custom_actions instanceof CustomActions) {
			return custom_actions;
		} else {
			custom_actions = new CustomActions();
			return custom_actions;
		}

	}

	private Actions selenium_built_in_actions() {
		if (built_in_actions instanceof Actions) {
			return built_in_actions;
		} else {
			built_in_actions = new Actions(SafeThread.getDriver());
			return built_in_actions;
		}
	}

	@AfterMethod
	public void close_browser() {
		
		SafeThread.getDriver().quit();
		SafeThread.unload();
		Allure.step("close browser");
		Loggers.logger.info("close browser");
	}

}