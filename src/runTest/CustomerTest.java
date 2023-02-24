package runTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import manages.Setup;
import pageObject.CustomerPage;
import pageObject.LoginPage;

public class CustomerTest {
	WebDriver driver;
	LoginPage pageLogin;
	CustomerPage customerPage;

	@BeforeClass
	public void beforeClass() {
		Setup setup = new Setup();
		driver = setup.setUp();

	}

	@Test(priority = 1)
	public void login() {
		try {
			pageLogin = new LoginPage(driver);
			pageLogin.loginToFNS("thamlt8@fpt.com.vn", "Admin@123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void goToCustomer() throws InterruptedException, IOException {
		customerPage = new CustomerPage(driver);
		customerPage.clickCustomer();
		Thread.sleep(1000);
		customerPage.linkCustomer();
		Thread.sleep(1000);
		customerPage.listTable();
		Thread.sleep(1000);
		customerPage.exportData();
		
	}
}
