package runTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class LoginTest {
	static WebDriver driver;
	public LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://inside-fns.dev.fpt.work/admin/auth/login");
	}

	@Test(priority = 1)
	public void verify() {
		try {
			LoginPage pageLogin = new LoginPage(driver);
			pageLogin.loginToFNS("y", "Admi2n@123");
			pageLogin.verifyLogin();
			driver.navigate().refresh();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test(priority = 2)
	public void login() {
		try {
			LoginPage pageLogin = new LoginPage(driver);
			pageLogin.loginToFNS("thamlt8@fpt.com.vn", "Admin@123");
			pageLogin.verifyLogin();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
