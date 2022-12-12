package runTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class Main {
	static WebDriver driver;
	public static void login(WebDriver driver) {
		LoginPage pageLogin = new LoginPage(driver);
		pageLogin.verifyLogin();
		pageLogin.loginToFNS("thamlt8@fpt.com.vn", "Admin@123");
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://inside-fns.fpt.work/admin/auth/login");
		login(driver);
	}

}
