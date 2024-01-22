package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;
import main.Setup;

public class Allure extends Setup implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		take_screenshot();
		save_logs(method_name(result) + "test failed & screen shot saved");
	}

	@Override
	public void onTestStart(ITestResult result) {
		save_logs(method_name(result) + "test start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		save_logs(method_name(result) + "test completed");
	}

	 @Attachment(value = "Page screenshot", type = "image/png")
	private byte[] take_screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "method name", type = "text/plain")
	private String save_logs( String message) {
		return message;
	}

	private String method_name(ITestResult result) {
		return result.getMethod().getMethodName();
	}

}
