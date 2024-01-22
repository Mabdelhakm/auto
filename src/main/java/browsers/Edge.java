package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.qameta.allure.Allure;
import main.Loggers;

public class Edge {
	public static WebDriver init_edge() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(options);
		Allure.step("start edge");
		Loggers.logger.info("start edge");
		return driver;
	}
}
