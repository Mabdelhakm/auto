package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import browsers.Chrome;
import browsers.Edge;
import browsers.Firefox;

public class Setup {
	public WebDriver driver;
	public FileReader fr;
	public Properties prop;

	@BeforeMethod
	public void initialize_browser() {
		try {
			fr = new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		prop = new Properties();
		try {
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (prop.getProperty("browser").trim().toLowerCase().equals("chrome")) {
			driver = Chrome.init_chrome();
		}
		else if (prop.getProperty("browser").trim().toLowerCase().equals("edge")) {
			driver = Edge.init_edge();
		}
		else if (prop.getProperty("browser").trim().toLowerCase().equals("firefox")) {
			driver = Firefox.init_firefox();
		}
	}

}