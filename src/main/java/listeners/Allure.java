package listeners;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import main.Loggers;
import main.Setup;

public class Allure extends Setup implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		take_screenshot(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		save_logs(method_name(result) + "test start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		save_logs(method_name(result) + "test completed");
	}

	@Attachment(value = "Page screenshot", type = "image/png", fileExtension = ".png")
	private byte[] take_screenshot(ITestResult result) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		Loggers.logger.info("Save screen shot");
		File source = ts.getScreenshotAs(OutputType.FILE);
		String time = java.time.LocalTime.now().toString().replace(":", "-").substring(0, 5);
		String date = java.time.LocalDate.now().toString();
		Loggers.logger.info("Save screen shot name with time -> " + time + " and date -> " + date);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + date + "_" + time + "\\"
				+method_name(result) + "_" + ThreadLocalRandom.current().nextInt() + ".png";
		try {
			Loggers.logger.info("copy screen shot to destination place : " + destination);
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ts.getScreenshotAs(OutputType.BYTES);
	
	}

	@Attachment(value = "method name", type = "text/plain")
	private String save_logs(String message) {
		return message;
	}

	private String method_name(ITestResult result) {
		return result.getMethod().getMethodName();
	}

}
