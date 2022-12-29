package runTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CampaignPage;
import pageObject.LoginPage;

public class CampaignTest {
	static WebDriver driver;
	CampaignPage campaignPage;

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
	public void goToCampaignPage() throws InterruptedException {
		campaignPage = new CampaignPage(driver);
		campaignPage.goToCampaignPage();
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void search() throws InterruptedException {
		campaignPage = new CampaignPage(driver);
		campaignPage.listCustomerList("3");
		Thread.sleep(1000);
		campaignPage.listAccount();
		Thread.sleep(1000);
		campaignPage.time("2022-12-15 00:00:00", "2022-12-16 00:00:00");
		Thread.sleep(1000);
		campaignPage.search();
		Thread.sleep(1000);
		campaignPage.listCampaignTable();
		Thread.sleep(1000);
		campaignPage.btnLL();
		Thread.sleep(1000);
		campaignPage.listCampaignTable();
		
	}
	@Test(priority = 4)
	public void detail() throws InterruptedException {
		campaignPage = new CampaignPage(driver);
		campaignPage.updateApp();
		Thread.sleep(1000);
		
	}
}
