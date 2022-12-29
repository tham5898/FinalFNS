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
	By inpName = By.cssSelector(".content form input#name");
	By inpOaId = By.cssSelector(".content form input#zoa_id");
	By selType = By.cssSelector(".content form select[name=business_type_id]");
	By selBrandname = By.cssSelector(".content form select[name=brandname_id]");
	By checkbox = By.cssSelector(".content form input.is_follower.la_checkbox");
	By checkboxStatus = By.cssSelector(".content form input.status .la_checkbox");
	String url = "https://inside-fns.dev.fpt.work/admin/customer-oa";

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

	public void listCustomerList() {
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

	public void businessType(String strNumber) {
		WebElement findBusiness = driver.findElement(selType);
		Select selects = new Select(findBusiness);
		List<WebElement> listBusiness = selects.getOptions();
		for (int i = 0; i < listBusiness.size(); i++) {
			String value = listBusiness.get(i).getAttribute("value");
			if (value.equals(strNumber)) {
				listBusiness.get(i).click();
			}
		}
	}

	public void brandname(String strNumber) {
		WebElement findBrandname = driver.findElement(selBrandname);
		Select selects = new Select(findBrandname);
		List<WebElement> listBrandname = selects.getOptions();
		for (int i = 0; i < listBrandname.size(); i++) {
			String value = listBrandname.get(i).getAttribute("value");
			if (value.equals(strNumber)) {
				listBrandname.get(i).click();
			}
		}
	}

	public void enterDataAdd(String strName, String strID, String strType, String strBradname, String strCustomer) {
		try {
			listCustomer(strCustomer);
			WebElement findName = driver.findElement(inpName);
			WebElement findId = driver.findElement(inpOaId);
			findName.sendKeys(strName);
			findId.sendKeys(strID);
			businessType(strType);
			brandname(strBradname);
			Thread.sleep(1000);
			submit();
			Thread.sleep(1000);
			String urlCurrent = driver.getCurrentUrl();
			if (urlCurrent.equalsIgnoreCase(url)) {
				System.out.println("Them moi thanh cong");
			} else {
				getMessageError();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterDataUpdate(String strName, String strID, String strType, String strBradname, String strCustomer) {
		try {
			listCustomer(strCustomer);
			WebElement findName = driver.findElement(inpName);
			WebElement findId = driver.findElement(inpOaId);
			findName.clear();
			findName.sendKeys(strName);
			findId.clear();
			findId.sendKeys(strID);
			businessType(strType);
			brandname(strBradname);
			Thread.sleep(1000);
			submit();
			Thread.sleep(1000);
			String urlCurrent = driver.getCurrentUrl();
			if (urlCurrent.equalsIgnoreCase(url)) {
				System.out.println("update thanh cong");
			} else {
				getMessageError();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkboxFollower() {
		WebElement listCheckbox = driver.findElement(checkbox);
		listCheckbox.click();
	}

	public void checkboxStatus() {
		WebElement listCheckbox = driver.findElement(checkboxStatus);
		listCheckbox.click();
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

	@Override
	public void listCustomer(String strCustomer) {
		super.listCustomer(strCustomer);
	}

	@Override
	public void submit() {
		super.submit();
	}

	@Override
	public void checkAllStatus() {
		super.checkAllStatus();
	}

	@Override
	public void checkActive() {
		super.checkActive();
	}

	@Override
	public void checkLock() {
		super.checkLock();
	}

	@Override
	public void updateApp() {
		super.updateApp();
	}
	@Override
	public void detail() {
		super.detail();
	}
	@Override
	public void clickCustomerList() {
		super.clickCustomerList();
	}
}
