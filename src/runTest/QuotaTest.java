package runTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import manages.Setup;
import pageObject.LoginPage;
import pageObject.QuotaPage;

public class QuotaTest {
	WebDriver driver;
	QuotaPage quotaPage;
	LoginPage pageLogin;

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
	public void goToQuota() {
		quotaPage = new QuotaPage(driver);
		quotaPage.goToQuotaPage();
		
	}
	@Test(priority = 3)
	public void goToAdd() {
		quotaPage = new QuotaPage(driver);
		quotaPage.gotoAddNewQuota();
		quotaPage.listCustomer();
	}
}
