package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import manages.PageObjectManage;

public class LogPage extends PageObjectManage {
	WebDriver driver;
	By linkLogs = By.linkText("Tra cứu tin nhắn");
	By startDate = By.cssSelector(".content form input#sent_time_start");
	By endDate = By.cssSelector(".content form input#sent_time_end");
	By btnSearch = By.cssSelector(".content form button.btn-sm");
	By perPage = By.cssSelector(".content label select[name=per-page]");

	public LogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void goToLogs() {
		WebElement findClick = driver.findElement(linkLogs);
		findClick.click();
	}
//chọn ngày gửi là ngày hiện tại

	public void startDate() throws InterruptedException {
		WebElement findStartDate = driver.findElement(startDate);
		findStartDate.click();
		findStartDate.sendKeys("2023-02-24 00:00:00");
		WebElement findEndDate = driver.findElement(endDate);
		findEndDate.sendKeys("2023-02-24 23:59:59");
		Thread.sleep(2000);
		
		WebElement findBtnSearch = driver.findElement(btnSearch);
		findBtnSearch.click();
	}

	public void paginationNumber(String number) {
		WebElement findPerPag = driver.findElement(perPage);
		Select select = new Select(findPerPag);
		List<WebElement> list = select.getOptions();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i).getText();
			if (value.equals(number)) {
				list.get(i).click();
				break;
			}
		}
	}
	public void listInforLogs() {
		
	}

}
