package runTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CustomerOAPage;
import pageObject.LoginPage;

public class CustomerOATest {
	static WebDriver driver;
	public CustomerOAPage customerOaPage;

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
	public void linkOA() {
		try {
			customerOaPage = new CustomerOAPage(driver);
			customerOaPage.clickOA();
			Thread.sleep(1000);
			customerOaPage.linkToCustomerOA();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void searchCustomer() {
		try {
			customerOaPage = new CustomerOAPage(driver);
			customerOaPage.listCustomer();
			Thread.sleep(1000);
			customerOaPage.search();
			Thread.sleep(1000);
			customerOaPage.listNameTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void searchOAID() {
		try {
			customerOaPage = new CustomerOAPage(driver);
			customerOaPage.enterOaId("4118709775274470865");
			customerOaPage.search();
			Thread.sleep(1000);
			customerOaPage.listNameTable();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void reset() {
		customerOaPage = new CustomerOAPage(driver);
		customerOaPage.btnLL();
	}

	@Test(priority = 6)
	public void addOa() {
		try {
			customerOaPage = new CustomerOAPage(driver);
			customerOaPage.clikBtnAdd();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
