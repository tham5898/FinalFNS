package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import manages.PageObjectManage;

public class CustomerApps extends PageObjectManage {
	WebDriver driver;

	public CustomerApps(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void linkToCustomerApp() {
		try {
			WebElement getLink = driver.findElement(linkAPp);
			getLink.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listAccount() {
		WebElement getAccount = driver.findElement(account);
		Select select = new Select(getAccount);
		List<WebElement> list = select.getOptions();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
	}

	// add customer app
	public void clickBtnAdd() {
		driver.findElement(linkAPp).click();
	}

	@Override
	public void perPage(String number) {
		super.perPage(number);
	}

	@Override
	public void scrollViews() {
		super.scrollViews();
	}

	@Override
	public void pagition() {
		super.pagition();
	}
}
