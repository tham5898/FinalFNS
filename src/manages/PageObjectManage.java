package manages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import elmentFactory.FileElment;

public class PageObjectManage extends FileElment {


	public PageObjectManage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void perPage() {
		try {
			WebElement findPerPage = driver.findElement(ElmentPerPage);
			Select selects = new Select(findPerPage);
			List<WebElement> listPerPage = selects.getOptions();
			for (WebElement element : listPerPage) {
				element.click();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pagition() {
		try {
			WebElement findPage = driver.findElement(elmentPagination);
			List<WebElement> listPage = findPage.findElements(By.tagName("a"));
			for (WebElement elemet : listPage) {
				elemet.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateApp() {
		try {
			List<WebElement> listTable = driver.findElements(manipulation);
			for (int i = 0; i < listTable.size();) {
				listTable.get(i).click();
				break;
			}
			Thread.sleep(1000);
			List<WebElement> list = driver.findElements(actionTable);
			for (int j = 0; j < list.size();) {
				list.get(j).click();
				break;
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void detail() {
		try {
			List<WebElement> listTable = driver.findElements(manipulation);
			for (int i = 0; i < listTable.size();) {
				listTable.get(i).click();
				break;
			}
			Thread.sleep(1000);
			List<WebElement> list = driver.findElements(actionTable);
			for (int j = 1; j < list.size();) {
				list.get(j).click();
				break;
			}
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void priceView() {
		try {
			List<WebElement> listTable = driver.findElements(manipulation);
			for (int i = 0; i < listTable.size();) {
				listTable.get(i).click();
				break;
			}
			Thread.sleep(1000);
			List<WebElement> list = driver.findElements(actionTable);
			for (int j = 3; j < list.size();) {
				list.get(j).click();
				break;
			}
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
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

	public void listCustomer(String strCustomer) {
		try {
			WebElement findCustomer = driver.findElement(customer);
			if (findCustomer.isEnabled()) {
				Select selects = new Select(findCustomer);
				List<WebElement> listCustomer = selects.getOptions();
				for (int i = 0; i < listCustomer.size(); i++) {
					String value = listCustomer.get(i).getAttribute("value");
					if (value.equals(strCustomer)) {
						listCustomer.get(i).click();
					}
				}
			} else {
				System.out.println("Không được phép chỉnh sửa customer");
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

	public void checkAllStatus() {
		List<WebElement> list = driver.findElements(clickStatus);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
		}
	}

	public void checkActive() {
		List<WebElement> list = driver.findElements(clickStatus);
		for (int i = 0; i < list.size();) {
			list.get(i).click();
			break;
		}
	}

	public void checkLock() {
		List<WebElement> list = driver.findElements(clickStatus);
		for (int i = 1; i < list.size();) {
			list.get(i).click();
			break;
		}
	}

	public void listOASearch() {
		try {
			WebElement findOA = driver.findElement(oaSearch);
			Select selects = new Select(findOA);
			List<WebElement> list = selects.getOptions();
			for (WebElement elemet : list) {
				elemet.click();
				break;
			}
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	public void listTypeTemp() {
		try {
			WebElement findType = driver.findElement(type);
			Select selects = new Select(findType);
			List<WebElement> listType = selects.getOptions();
			for (WebElement element : listType) {
				element.click();
				break;
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listSupplier(String strsupp) {
		try {
			WebElement findSupplier = driver.findElement(supplier);
			if (findSupplier.isEnabled()) {
				Select selects = new Select(findSupplier);
				List<WebElement> list = selects.getOptions();
				for (int i = 0; i < list.size(); i++) {
					String value = list.get(i).getAttribute("value");
					if (value.equals(strsupp)) {
						list.get(i).click();
						break;
					} else {
						System.out.println("Không tìm thấy supplier này");
					}
				}
			} else {
				System.out.println("Không được phép chỉnh sửa NCC");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listTypeAdd() {
		try {
			WebElement findTypeAdd = driver.findElement(typeAdd);
			Select selects = new Select(findTypeAdd);
			List<WebElement> listType = selects.getOptions();
			for (WebElement element : listType) {
				element.click();
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listButton(String str) {
		List<WebElement> list = driver.findElements(btnList);
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i).getText();
			if (value.equals(str)) {
				list.get(i).click();
			}
		}
	}
	public void time(String strStart, String strEnd) {
		WebElement start = driver.findElement(startDay);
		WebElement end = driver.findElement(endDay);
		start.sendKeys(Keys.DELETE);
		start.sendKeys(strStart);
		end.sendKeys(strEnd);
	}
}
