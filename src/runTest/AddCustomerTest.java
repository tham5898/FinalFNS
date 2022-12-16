package runTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CustomerApps;
import pageObject.LoginPage;

public class AddCustomerTest {
	static WebDriver driver;
	public LoginPage loginPage;
	public CustomerApps customerApp;
	public pageObject.AddCustomerApp addCustomerApp;

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
	public void testcas1() throws InterruptedException {
		customerApp = new CustomerApps(driver);
		customerApp.linkToCustomerApp();
		Thread.sleep(3000);
	}

//	@Test(priority = 3)
//	private void publi() throws InterruptedException {
//		addCustomerApp = new pageObject.AddCustomerApp(driver);
//		addCustomerApp.clikBtnAdd();
//		Thread.sleep(1000);
//	}
//
//	@Test(priority = 4)
//	private void pu() {
//		addCustomerApp = new pageObject.AddCustomerApp(driver);
//		addCustomerApp.listCustomer();
//	}
//	@Test(priority = 5)
//	private void testCase3() {
//		addCustomerApp = new pageObject.AddCustomerApp(driver);
//		addCustomerApp.EnterData("thamlt8", "ahihi", "");
//	}
//	@Test(priority = 6)
//	public void testcase6 () throws InterruptedException {
//		addCustomerApp = new pageObject.AddCustomerApp(driver);
//		addCustomerApp.clickCustomerList();
//		Thread.sleep(3000);
//		addCustomerApp.updateApp();
//	}

//	@Test(priority = 3)
//	public void caseListName() {
//		addCustomerApp = new pageObject.AddCustomerApp(driver);
//		addCustomerApp.listNameTable();
//	}

	@Test(priority = 4)
	private void pbli() {
		try {
			addCustomerApp = new pageObject.AddCustomerApp(driver);
			addCustomerApp.listNameTable();
			Thread.sleep(1000);
			addCustomerApp.updateApp();
			Thread.sleep(1000);
			addCustomerApp.checkDataUpdate();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 5)
	public void testCaseUpdate() throws InterruptedException {
		addCustomerApp = new pageObject.AddCustomerApp(driver);
		addCustomerApp.editRemoveApp();
		Thread.sleep(500);
		addCustomerApp.editApp();
		addCustomerApp.listIconX("x");
		Thread.sleep(2000);
		addCustomerApp.submit();
		Thread.sleep(1000);
	}

//	@Test(priority = 6)
//	public void testCaseClickBtnDetail() {
//		addCustomerApp = new pageObject.AddCustomerApp(driver);
//		addCustomerApp.btnDetail("Chi tiết");
//
//	}
}
