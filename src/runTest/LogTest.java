package runTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import manages.Setup;
import pageObject.LogPage;
import pageObject.LoginPage;

public class LogTest {
	WebDriver driver;
	LoginPage pageLogin;
	LogPage logPage;

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
	public void goToLogsPage() throws InterruptedException {
		logPage = new LogPage(driver);
		logPage.goToLogs();
		Thread.sleep(2000);
		logPage.startDate();
		Thread.sleep(2000);
		logPage.paginationNumber("100");
	}
}
