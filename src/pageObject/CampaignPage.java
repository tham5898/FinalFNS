package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import manages.PageObjectManage;

public class CampaignPage extends PageObjectManage {
	WebDriver driver;
	By linkCampaign = By.linkText("Quản lý chiến dịch");
	By customer = By.xpath("//*[@id=\"filter-box\"]/form/div[1]/div/div/div/div[1]/div/select");
	By account = By.cssSelector(".content form select[name='customer_account[]']");
	public By findList = By.cssSelector(".content table tbody");
	public By findName = By.cssSelector(".content table tbody .column-name");

	public CampaignPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void goToCampaignPage() {
		WebElement findLink = driver.findElement(linkCampaign);
		findLink.click();
	}

	public void listCustomerList(String strCustomer) {
		WebElement findCustomer = driver.findElement(customer);
		Select selects = new Select(findCustomer);
		List<WebElement> listCustomer = selects.getOptions();
		for (int i = 0; i < listCustomer.size(); i++) {
			String value = listCustomer.get(i).getAttribute("value");
			if (value.equals(strCustomer)) {
				listCustomer.get(i).click();
			}
		}
	}

	public void listAccount() {
		WebElement findAccount = driver.findElement(account);
		Select selects = new Select(findAccount);
		List<WebElement> listAccount = selects.getOptions();
		for (WebElement element : listAccount) {
			element.click();
			break;
		}
	}

	public void listCampaignTable() {
		ArrayList<String> name = new ArrayList<>();
		WebElement getListTable = driver.findElement(findList);
		List<WebElement> list = getListTable.findElements(findName);
		for (int i = 0; i < list.size(); i++) {
			name.add(list.get(i).getText());
		}
		System.out.println(name);
	}


}
