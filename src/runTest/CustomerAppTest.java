package runTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CustomerApps;
import pageObject.LoginPage;

public class CustomerAppTest {
	static WebDriver driver;
	public LoginPage loginPage;
	public CustomerApps customerApp;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://inside-fns.fpt.work/admin/auth/login");
	}

	@Test(priority = 1)
	public void login() {
		try {
			LoginPage pageLogin = new LoginPage(driver);
			pageLogin.loginToFNS("thamlt8@fpt.com.vn", "Admin@123");
			pageLogin.verifyLogin();
		} catch (Exception e) {
		}
	}

	@Test(priority = 2)
	public void testcas1() throws InterruptedException {
		customerApp = new CustomerApps(driver);
		customerApp.linkToCustomerApp();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	private void publ() {
		try {
			customerApp = new CustomerApps(driver);
			customerApp.listAccount();
		} catch (Exception e) {
		}

	}

	@Test(priority = 4)
	public void testName() {
		try {
			customerApp = new CustomerApps(driver);
			customerApp.scrollViews();
			Thread.sleep(1000);
			customerApp.perPage();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	private void pu() {
		try {
			customerApp = new CustomerApps(driver);
			customerApp.pagition();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
