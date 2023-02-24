package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import manages.PageObjectManage;

public class AddCustomerApp extends PageObjectManage {
	WebDriver driver;
	public By iconXCustomer = By.cssSelector(".content form #select2-customer_id-65-container");
	public By iconXAccount = By.cssSelector(".content form #select2-customer_account_id-pn-container");
	public By iconXOA = By.cssSelector(".content form #select2-customer_oa_id-0a-container");
	By inpName = By.cssSelector(".content form input#name");
	By findList = By.cssSelector(".content table tbody");
	By findName = By.cssSelector(".content table tbody .column-name");
	ArrayList<String> name = new ArrayList<>();
	By inpDes = By.cssSelector(".content form textarea[name=description]");
	By iconX = By.cssSelector(".content form .select2-selection__clear");

	public AddCustomerApp(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void listIconX(String x) {
		List<WebElement> listIcon = driver.findElements(iconX);
		System.out.println(listIcon.size());
		for (int i = 0; i < listIcon.size(); i++) {
			String value = listIcon.get(i).getText();
			if (value.equals(x)) {
				System.out.println(value);
				listIcon.get(i).click();
			}
		}
	}

	public void listNameTable() {
		WebElement getListTable = driver.findElement(findList);
		List<WebElement> list = getListTable.findElements(findName);
		for (int i = 0; i < list.size(); i++) {
			name.add(list.get(i).getText());
		}
		System.out.println(name);
	}

	public void checkDataUpdate() {
		WebElement getName = driver.findElement(inpName);
		String value = getName.getAttribute("value");
		if (name.indexOf(value) != -1) {
			System.out.println("Case pass");
		} else {
			System.out.println("Bị Sai rồi check lại đi!!!!!!");
		}
	}

	public void editApp() {
		WebElement getName = driver.findElement(inpName);
		getName.sendKeys("ahaiai");
		WebElement getDes = driver.findElement(inpDes);
		getDes.sendKeys("test demo");
	}

	public void editRemoveApp() {
		WebElement getName = driver.findElement(inpName);
		getName.clear();
		WebElement getDes = driver.findElement(inpDes);
		getDes.clear();
	}

	// click vao man hinh them moi api
	@Override
	public void clikBtnAdd() {
		super.clikBtnAdd();
	}

	// lay danh sach cac truong du lieu cua man hinh them moi api
	public void getFields() {
		System.out.println(driver.findElement(lblName).getText());
		System.out.println(driver.findElement(lblCustomer).getText());
		System.out.println(driver.findElement(lblAccount).getText());
		System.out.println(driver.findElement(lblAppType).getText());
		System.out.println(driver.findElement(lblCustomerOa).getText());
		System.out.println(driver.findElement(lblFailover).getText());
		System.out.println(driver.findElement(lblDescription).getText());
		System.out.println(driver.findElement(lblStatus).getText());
		System.out.println(driver.findElement(lblCallback_url).getText());
	}



	@Override
	public void listAccount() {
		super.listAccount();
	}

	// enter data to form
	public void EnterData(String strName, String strDes, String strCallback, String strCustomer) {
		try {
			WebElement name = driver.findElement(inpName);
			name.sendKeys(strName);
			listCustomer(strCustomer);
			listAccount();
			listOA();
			listFailOver();
			WebElement des = driver.findElement(textDec);
			des.sendKeys(strDes);
			WebElement callback = driver.findElement(inpCallback);
			callback.sendKeys(strCallback);
			submit();
			Thread.sleep(1000);
			verify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update data
	public void updateData(String strName, String strDes, String strCallback) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verify() {
		String currentUlr = driver.getCurrentUrl();
		String pageApp = "https://inside-fns.dev.fpt.work/admin/customer-apps";
		if (currentUlr.equalsIgnoreCase(pageApp)) {
			System.out.println("Case pass => Thêm mới thành công");
		} else {
			System.out.println("Case faile => Thêm mới thất bại");
			getMessageError();
		}
	}

	@Override
	public void submit() {
		super.submit();
	}

	@Override
	public void reset() {
		super.reset();
	}

	@Override
	public void clickCustomerList() {
		super.clickCustomerList();
	}

	@Override
	public void listOA() {
		super.listOA();
	}

	@Override
	public void listFailOver() {
		super.listFailOver();
	}

	@Override
	public void getMessageError() {
		super.getMessageError();
	}

	@Override
	public void updateApp() {
		super.updateApp();
	}

	@Override
	public void btnDetail(String strValue) {
		super.btnDetail(strValue);
	}
}
