package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.qameta.allure.Allure;
import main.Loggers;

public class Edge {
	public  WebDriver init_edge() {
		EdgeOptions options = new EdgeOptions();
//		options.addArguments("--headless");
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(options);
		Allure.step("start edge browser");
		Loggers.logger.info("start edge browser");
		return driver;
	}
}
