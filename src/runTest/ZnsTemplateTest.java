package runTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;
import pageObject.ZnsTemplatePage;

public class ZnsTemplateTest {
	static WebDriver driver;
	ZnsTemplatePage znsTemplatePage;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://inside-fns.dev.fpt.work/admin/auth/login");
	}

	@Test(priority = 1)
	public void login() {
		try {
			LoginPage pageLogin = new LoginPage(driver);
			pageLogin.loginToFNS("thamlt8@fpt.com.vn", "Admin@123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void linkTemplate() {
		try {
			znsTemplatePage = new ZnsTemplatePage(driver);
			znsTemplatePage.clickOA();
			Thread.sleep(1000);
			znsTemplatePage.goToZnsTemplate();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void searchCustomerOA() {
		try {
			znsTemplatePage = new ZnsTemplatePage(driver);
			znsTemplatePage.listCustomerList("3");
			Thread.sleep(1000);
			znsTemplatePage.listOASearch();
			znsTemplatePage.search();
			Thread.sleep(1000);
			znsTemplatePage.btnLL();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void searchEnterData() {
		try {
			znsTemplatePage = new ZnsTemplatePage(driver);
			znsTemplatePage.listCustomerList("3");
			Thread.sleep(1000);
			znsTemplatePage.listOASearch();
			Thread.sleep(1000);
			znsTemplatePage.listTypeTemp();
			Thread.sleep(1000);
			znsTemplatePage.search();
			Thread.sleep(1000);
			znsTemplatePage.btnLL();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void searchEnterDataInput() {
		try {
			znsTemplatePage = new ZnsTemplatePage(driver);
			znsTemplatePage.listCustomerList("3");
			Thread.sleep(1000);
			znsTemplatePage.enterDataSearch("223255", "Mau danh gia v", "Fwork");
			Thread.sleep(1000);
			znsTemplatePage.search();
			znsTemplatePage.btnLL();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6)
	public void searchEnterDataInput1() {
		try {
			znsTemplatePage = new ZnsTemplatePage(driver);
			znsTemplatePage.listCustomerList("3");
			Thread.sleep(1000);
			znsTemplatePage.enterDataSearch("", "Mau danh gia v", "");
			Thread.sleep(1000);
			znsTemplatePage.search();
			Thread.sleep(1000);
			znsTemplatePage.btnLL();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void checkBox() {
		try {
			znsTemplatePage = new ZnsTemplatePage(driver);
			znsTemplatePage.checkAllStatus();
			znsTemplatePage.search();
			Thread.sleep(1000);
			znsTemplatePage.btnLL();
			Thread.sleep(1000);
			znsTemplatePage.checkActive();
			Thread.sleep(1000);
			znsTemplatePage.search();
			Thread.sleep(1000);
			znsTemplatePage.btnLL();
			Thread.sleep(1000);
			znsTemplatePage.checkLock();
			Thread.sleep(1000);
			znsTemplatePage.search();
			Thread.sleep(1000);
			znsTemplatePage.btnLL();
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void checkPagition() {
		try {
			znsTemplatePage = new ZnsTemplatePage(driver);
			znsTemplatePage.perPage();
			Thread.sleep(1000);
			znsTemplatePage.pagition();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 9)
	public void addTemplate() throws InterruptedException {
		znsTemplatePage = new ZnsTemplatePage(driver);
		znsTemplatePage.clikBtnAdd();
		Thread.sleep(2000);
		znsTemplatePage.enterAddTemplate("mau test fti", "12345", "abc", "xyz");
		Thread.sleep(1000);
		znsTemplatePage.listTypeAdd();
		Thread.sleep(1000);
		znsTemplatePage.listCustomer("3");
		Thread.sleep(1000);
		znsTemplatePage.listOA();
		Thread.sleep(1000);
		znsTemplatePage.listSupplier("VIHAT");
		Thread.sleep(1000);
		znsTemplatePage.cta1("1");
		Thread.sleep(1000);
		znsTemplatePage.cta2("7");
		Thread.sleep(1000);
		znsTemplatePage.config();
		Thread.sleep(1000);
		znsTemplatePage.submit();
		Thread.sleep(1000);

	}

	@Test(priority = 10)
	public void editTemplate() throws InterruptedException {
		znsTemplatePage = new ZnsTemplatePage(driver);
		znsTemplatePage.listNameTable();
		Thread.sleep(1000);
		znsTemplatePage.updateApp();
		Thread.sleep(1000);
		znsTemplatePage.checkDetailName();
		znsTemplatePage.enterDataUpdate("1234", "eee", "e3", "123", "3", "2", "6", "VIHAT");
		znsTemplatePage.submit();
		Thread.sleep(1000);
	}

	@Test(priority = 11)
	public void detailTemplate() throws InterruptedException {
		znsTemplatePage = new ZnsTemplatePage(driver);
		znsTemplatePage.detail();
		Thread.sleep(1000);
		znsTemplatePage.getInforDetailTemplate();
		Thread.sleep(1000);
		znsTemplatePage.clickUpdate();
		Thread.sleep(2000);
		znsTemplatePage.listButton("Chi tiết");
		Thread.sleep(1000);
		znsTemplatePage.listButton("Danh sách");
		Thread.sleep(1000);
	}
	@Test(priority = 12)
	public void viewPricePopup() throws InterruptedException {
		znsTemplatePage = new ZnsTemplatePage(driver);
		znsTemplatePage.priceView();
		Thread.sleep(1000);
		znsTemplatePage.getName();
		znsTemplatePage.getPrice();
		znsTemplatePage.getCTA1();
		znsTemplatePage.getCTA2();
		znsTemplatePage.getTotal();
		Thread.sleep(1000);
		//znsTemplatePage.btnClose();
	}
}
