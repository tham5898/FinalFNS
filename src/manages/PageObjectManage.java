package manages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import ElmentFactory.FileElment;

public class PageObjectManage extends FileElment {
	WebDriver driver;

	public PageObjectManage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void perPage(String number) {
		try {
			WebElement findPerPage = driver.findElement(ElmentPerPage);
			Select selects = new Select(findPerPage);
			List<WebElement> listPerPage = selects.getOptions();
			for (int i = 0; i < listPerPage.size(); i++) {
				System.out.println(listPerPage.get(i).getText());
				String value = listPerPage.get(i).getText();
				if (value.equals(number)) {
					listPerPage.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pagition() {
		try {
			WebElement findPage = driver.findElement(elmentPagination);
			List<WebElement> listPage = findPage.findElements(By.tagName("a"));
			System.out.println(listPage.size());
			for (int i = 0; i < listPage.size(); i++) {
				System.out.println(listPage.get(i).getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateApp() {
		List<WebElement> listTable = driver.findElements(manipulation);
		for (int i = 0; i < listTable.size();) {
			listTable.get(i).click();
			break;
		}
		List<WebElement> list = driver.findElements(actionTable);
		for (int j = 0; j < list.size();) {
			list.get(j).click();
			break;
		}
	}

	public void scrollViews() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(1000,1000)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listCustomer() {
		try {
			WebElement findCustomer = driver.findElement(customer);
			Select selects = new Select(findCustomer);
			List<WebElement> listCustomer = selects.getOptions();
			System.out.println(listCustomer.size());
			for (int i = 0; i < listCustomer.size(); i++) {
				String value = listCustomer.get(i).getAttribute("value");
				if (value.equals("5")) {
					listCustomer.get(i).click();
				}
			}
			Thread.sleep(1000);
		} catch (Exception e) {
		}

	}

	public void listAccount() {
		try {
			WebElement findCustomer = driver.findElement(account);
			Select selects = new Select(findCustomer);
			List<WebElement> listAccount = selects.getOptions();
			for (WebElement element : listAccount) {
				element.click();
				System.out.println("ahdjdjdj");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
		}

	}

	public void listOA() {
		try {
			WebElement findOA = driver.findElement(selOA);
			Select selects = new Select(findOA);
			List<WebElement> list = selects.getOptions();
			for (WebElement elemet : list) {
				System.out.println(elemet.getText());
				elemet.click();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
		}

	}

	public void listFailOver() {
		try {
			WebElement findFailOver = driver.findElement(selFailOver);
			Select selects = new Select(findFailOver);
			List<WebElement> list = selects.getOptions();
			for (int i = 0; i < list.size(); i++) {
				String value = list.get(i).getAttribute("value");
				if (value.equals("1")) {
					list.get(i).click();
				}
			}
			Thread.sleep(1000);
		} catch (Exception e) {
		}

	}

	public void getMessageError() {
		List<WebElement> listMessageError = driver.findElements(messageError);
		for (int i = 0; i < listMessageError.size(); i++) {
			System.out.println(listMessageError.get(i).getText());
		}
	}

	public void getLableDetail() {
		List<WebElement> listGetLabelDetail = driver.findElements(listLableDetail);
		for (int i = 0; i < listGetLabelDetail.size(); i++) {
			System.out.println(listGetLabelDetail.get(i).getText());
		}
	}

	public void getDataDetail() {
		List<WebElement> listGetDataDetail = driver.findElements(listDataDetail);
		for (int i = 0; i < listGetDataDetail.size(); i++) {
			System.out.println(listGetDataDetail.get(i).getText());
		}
	}

	public void submit() {
		driver.findElement(btnSubmit).click();
	}

	public void reset() {
		driver.findElement(btnReset).click();
	}

	public void clickCustomerList() {
		driver.findElement(btnListCustomer).click();
	}

	public void clickUpdate() {
		driver.findElement(btnUpdate).click();
	}

	public void clickDetail() {
		driver.findElement(btnDetail).click();
	}

	public void btnDetail(String strValue) {
		List<WebElement> list = driver.findElements(listBtn);
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i).getText();
			if (value.equals(strValue)) {
				list.get(i).click();
				break;
			}
		}
	}

	public void clickOA() {
		WebElement getCustomerOA = driver.findElement(clickOA);
		getCustomerOA.click();
	}

	public void search() {
		WebElement getBtnSearch = driver.findElement(btnSearch);
		getBtnSearch.click();
	}

	public void listNameTable() {
		ArrayList<String> name = new ArrayList<>();
		WebElement getListTable = driver.findElement(findList);
		List<WebElement> list = getListTable.findElements(findName);
		for (int i = 0; i < list.size(); i++) {
			name.add(list.get(i).getText());
		}
		System.out.println(name);
	}

	public void btnLL() {
		WebElement getBtnReset = driver.findElement(btnLl);
		getBtnReset.click();
	}
	public void clikBtnAdd() {
		driver.findElement(btnAdd).click();
	}
}
