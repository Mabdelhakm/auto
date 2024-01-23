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
		Loggers.logger.info("wait for the element tag: " + driver.findElement(ele).getTagName() + " to be visible");
	}

	public void explicit_wait_till_clickable(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Loggers.logger.info("wait for the element tag: " + driver.findElement(ele).getTagName() + " to be clickable");
	}

	public void explicit_wait_till_invisibility(By ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
		Loggers.logger.info("wait for the element tag:" + driver.findElement(ele).getTagName() + " to be invisible");
	}
	
	public void clicking_element(By ele) {
		driver.findElement(ele).click();
		Loggers.logger.info("clicking on element tag:" + driver.findElement(ele).getTagName());
	}
	

	public void typing_in_element(By ele, String text) {
		driver.findElement(ele).sendKeys(text);
		Loggers.logger.info("typing: "+text+" in the element tag: "+ driver.findElement(ele).getTagName());
	}
	
	public void clicking_enter(By ele) {
		driver.findElement(ele).sendKeys(Keys.ENTER);
		Loggers.logger.info("clicking enter on element tag: " + driver.findElement(ele).getTagName());
	}
	
	public void clicking_arrow_up_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_UP);
		Loggers.logger.info("clicking arrow up key");
	}
	
	public void clicking_arrow_down_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_DOWN);
		Loggers.logger.info("clicking arrow down key");
	}
	
	
	public void clicking_arrow_right_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_RIGHT);
		Loggers.logger.info("clicking arrow right key");
	}
	
	
	public void clicking_arrow_left_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.ARROW_LEFT);
		Loggers.logger.info("clicking arrow left key");
	}
	
	public void clicking_end_key(By ele) {
		driver.findElement(ele).sendKeys(Keys.END);
		Loggers.logger.info("clicking end key");
	}
	
	public WebElement return_element_from_list(By ele, int index) {
		WebElement eee = null;
		for (int i=0; i<driver.findElements(ele).size();i++) {
			if(i==index) {
				eee=driver.findElements(ele).get(index);
				break;
			}
			else {
				eee=driver.findElements(ele).get(0);
			}
		}
		return eee;
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
