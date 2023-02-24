package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import manages.PageObjectManage;

import org.openqa.selenium.Keys;

public class LoginPage extends PageObjectManage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void resetInputLogin() {
		WebElement enterEmail = driver.findElement(email);
		enterEmail.sendKeys(Keys.DELETE);
		WebElement enterPass = driver.findElement(password);
		enterPass.sendKeys(Keys.DELETE);
	}

	public void setEmail(String strEmail) {
		WebElement enterEmail = driver.findElement(email);
		enterEmail.sendKeys(strEmail);
		
	}

	public void setPassword(String strPass) {
		WebElement enterPass = driver.findElement(password);
		enterPass.sendKeys(strPass);
		;
	}

	public void setLogin() {
		driver.findElement(btnLogin).click();
	}

	public void getError() {

	}

	public String getErrorMessage() {
		String strErrorMsg = null;
		List<WebElement> errorMsg = driver.findElements(errorMsgTextLogin);
		System.out.println(errorMsg);
		for (int i = 0; i < errorMsg.size(); i++) {
			System.out.println(errorMsg.get(i).getText());
		}
		return strErrorMsg;
	}

	public void loginToFNS(String strEmail, String strPassword) {
		try {
			this.setEmail(strEmail);
			this.setPassword(strPassword);
			this.setLogin();
			getErrorMessage();
			Thread.sleep(1000);
			String currentURL = driver.getCurrentUrl();
			if (currentURL.equalsIgnoreCase(linkAdmin)) {
				System.out.println("Case pass => Đăng nhập thành công");
			} else {
				System.out.println("Case fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void verifyLogin() {
		this.setEmail("");
		this.setPassword("");
		this.setLogin();
		getErrorMessage();
	}
}
