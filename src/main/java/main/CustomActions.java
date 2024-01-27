package main;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomActions extends Setup {
//	private WebDriver driver;
//
//	public CustomActions(WebDriver driver) {
//		this.driver = driver;
//	}

	public void explicit_wait_till_visible(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

	public void explicit_wait_till_clickable(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void explicit_wait_till_invisibility(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(SafeThread.getDriver(), Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
	}

	public void clicking_element(By ele) {
		SafeThread.getDriver().findElement(ele).click();
	}

	public void typing_in_element(By ele, String text) {
		SafeThread.getDriver().findElement(ele).sendKeys(text);
	}

	public void clicking_enter(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ENTER);
	}

	public void clicking_arrow_up_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_UP);
	}

	public void clicking_arrow_down_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_DOWN);
	}

	public void clicking_arrow_right_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_RIGHT);
	}

	public void clicking_arrow_left_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.ARROW_LEFT);
	}

	public void clicking_end_key(By ele) {
		SafeThread.getDriver().findElement(ele).sendKeys(Keys.END);
	}

	public WebElement return_element_from_list(By ele, int index) {
		WebElement elements = null;
		for (int i = 0; i < SafeThread.getDriver().findElements(ele).size(); i++) {
			if (i == index) {
				elements = SafeThread.getDriver().findElements(ele).get(index);
				break;
			} else {
				elements = SafeThread.getDriver().findElements(ele).get(0);
			}
		}
		return elements;
	}

	public void return_parent_frame() {
		SafeThread.getDriver().switchTo().parentFrame();
	}

	public void switch_frame(By ele) {
		SafeThread.getDriver().switchTo().frame(SafeThread.getDriver().findElement(ele));
	}

	public void accept_alert() {
		SafeThread.getDriver().switchTo().alert().accept();
	}

	public void dismiss_alert() {
		SafeThread.getDriver().switchTo().alert().dismiss();
		;
	}

	public void switch_alert() {
		SafeThread.getDriver().switchTo().alert();
	}

	public boolean is_element_displayed(By ele) {
		return SafeThread.getDriver().findElement(ele).isDisplayed();
	}

	public boolean is_element_selected(By ele) {
		return SafeThread.getDriver().findElement(ele).isSelected();
	}

	public boolean is_element_enabled(By ele) {
		return SafeThread.getDriver().findElement(ele).isEnabled();
	}
}
