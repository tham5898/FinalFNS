package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import manages.PageObjectManage;

public class CustomerOAPage extends PageObjectManage {
	WebDriver driver;
	By linkOA = By.linkText("Zalo Office Account");
	By customerOA = By.xpath("//*[@id=\"filter-box\"]/form/div[1]/div[1]/div/div/div[1]/div/select");
	By oaId = By.cssSelector(".content form input.zoa_id");

	public CustomerOAPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterOaId(String strId) {
		WebElement getOaId = driver.findElement(oaId);
		getOaId.sendKeys(strId);
	}

	@Override
	public void clickOA() {
		super.clickOA();
	}

	public void linkToCustomerOA() {
		WebElement getLinkOA = driver.findElement(linkOA);
		getLinkOA.click();
	}

	public void listCustomer() {
		WebElement findCustomer = driver.findElement(customerOA);
		Select selects = new Select(findCustomer);
		List<WebElement> listCustomer = selects.getOptions();
		for (int i = 0; i < listCustomer.size(); i++) {
			String value = listCustomer.get(i).getAttribute("value");
			if (value.equals("5")) {
				listCustomer.get(i).click();
			}
		}
	}

	@Override
	public void search() {
		super.search();
	}

	@Override
	public void listNameTable() {
		super.listNameTable();
	}

	@Override
	public void clikBtnAdd() {
		super.clikBtnAdd();
	}
}
