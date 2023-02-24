package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import manages.PageObjectManage;

public class QuotaPage extends PageObjectManage {
	WebDriver driver;
	By linkQuota = By.linkText("Quotas");
	By btnAdd = By.linkText("Mới");
	By customer = By.cssSelector(".content form select[name=customer_id]");
	ArrayList<String> name = new ArrayList<>();

	public QuotaPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void goToQuotaPage() {
		WebElement findLink = driver.findElement(linkQuota);
		findLink.click();
	}

	// click thêm mới Quotas
	public void gotoAddNewQuota() {
		WebElement findAdd = driver.findElement(btnAdd);
		findAdd.click();

	}

	// Lấy danh sách KH
	public void listCustomer() {
		WebElement list = driver.findElement(customer);
		Select select = new Select(list);
		List<WebElement> optionElement = select.getOptions();
		for (int i = 0; i < optionElement.size(); i++) {
			name.add(optionElement.get(i).getText());
		}
		System.out.println("Danh sách khách hàng hiện có: " + name);

	}
}
