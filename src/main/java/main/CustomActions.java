package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomActions extends Setup{
	private WebDriver driver;

	public CustomActions(WebDriver driver) {
		this.driver = driver;
	}

	public void explicit_wait_till_visible(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

	public void explicit_wait_till_clickable(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void explicit_wait_till_invisibility(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
	}
	
	public void clicking_element(By ele) {
		driver.findElement(ele).click();
	}
	

	public void typing_in_element(By ele, String text) {
		driver.findElement(ele).sendKeys(text);
	}
	
	public void clicking_enter(By ele) {
		driver.findElement(ele).sendKeys(Keys.ENTER);
	}
	
	public void clicking_arrow_up_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_UP);
	}
	
	public void clicking_arrow_down_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_DOWN);
	}
	
	
	public void clicking_arrow_right_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_RIGHT);
	}
	
	
	public void clicking_arrow_left_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_LEFT);
	}
	
	public void clicking_end_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.END);
	}
	
	public WebElement return_element_from_list(By ele, int index) {
		WebElement elements = null;
		for (int i=0; i<driver.findElements(ele).size();i++) {
			if(i==index) {
				elements=driver.findElements(ele).get(index);
				break;
			}
			else {
				elements=driver.findElements(ele).get(0);
			}
		}
		return elements;
	}
	
	
	
	public void return_parent_frame() {
		driver.switchTo().parentFrame();
	}
	
	public void switch_frame(By ele) {
		driver.switchTo().frame(driver.findElement(ele));
	}
	
	
	public void accept_alert() {
		driver.switchTo().alert().accept();
	}
	
	public void dismiss_alert() {
		driver.switchTo().alert().dismiss();;
	}
	
	public void switch_alert() {
		driver.switchTo().alert();
	}
	

	public boolean is_element_displayed(By ele) {
		return driver.findElement(ele).isDisplayed();
	}
	
	public boolean is_element_selected(By ele) {
		return driver.findElement(ele).isSelected();
	}
	
	public boolean is_element_enabled(By ele) {
		return driver.findElement(ele).isEnabled();
	}
}
