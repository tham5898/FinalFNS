package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import manages.PageObjectManage;

public class ZnsTemplatePage extends PageObjectManage {
	WebDriver driver;
	By znsTemplate = By.linkText("Mẫu tin nhắn");
	By customerOA = By.xpath("//*[@id=\"filter-box\"]/form/div[1]/div[1]/div/div/div[1]/div/select");
	By templateId = By.cssSelector(".content form input[name=zoa_template_id]");
	By nameTemplate = By.cssSelector(".content form input[name=name]");
	By contracts = By.xpath("//*[@id=\"filter-box\"]/form/div[1]/div[1]/div/div/div[2]/div/div/input");
	By cta1 = By.cssSelector(".content form select[name=cta_1]");
	By cta2 = By.cssSelector(".content form select[name=cta_2]");
	By name = By.cssSelector(".content form input#name");
	By templateIdAdd = By.cssSelector(".content form input#zoa_template_id");
	By content = By.cssSelector(".content form textarea[name=text]");
	By note = By.cssSelector(".content form textarea[name=note_template]");
	By key = By.cssSelector(".content form tbody tr td input[name='validate_template[keys][]']");
	By value = By.cssSelector(".content form tbody tr td input[name='validate_template[values][]']");
	By add = By.cssSelector(".content form tfoot tr .validate_template-add.btn.btn-success.btn-sm.pull-right)");
	By table = By.cssSelector(".content table tbody");
	By tableName = By.cssSelector(".content table tbody .column-name");
	ArrayList<String> table_Template_Name = new ArrayList<>();
	By inforTemplate = By.cssSelector(".content form .box.box-solid.box-default.no-margin.box-show");
	By uploadFile = By.cssSelector(".content form .file-input-new input.file_upload");
	By getName = By.cssSelector(".modal-content form input#template111");
	By getPrice = By.cssSelector(".modal-content form input#price_msg");
	By getCta1 = By.cssSelector(".modal-content form input#price_cta_1");
	By getCta2 = By.cssSelector(".modal-content form input#price_cta_2");
	By total = By.cssSelector(".modal-content form input#total");
	By btnClose = By.cssSelector(".modal-content form button.close");

	public ZnsTemplatePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void listNameTable() {
		WebElement getListTable = driver.findElement(table);
		List<WebElement> list = getListTable.findElements(tableName);
		for (int i = 0; i < list.size(); i++) {
			table_Template_Name.add(list.get(i).getText());
		}
		System.out.println(table_Template_Name);
	}

	public void checkDetailName() {
		WebElement getName = driver.findElement(name);
		String value = getName.getAttribute("value");
		if (table_Template_Name.indexOf(value) != -1) {
			System.out.println("Hiển thị đúng tên template");
		} else {
			System.out.println("Bị Sai rồi check lại đi!!!!!!");
		}

	}

	public void enterDataSearch(String strTempId, String strTempName, String strContracts) {
		WebElement findTempId = driver.findElement(templateId);
		WebElement findTempName = driver.findElement(nameTemplate);
		WebElement findContract = driver.findElement(contracts);
		findTempId.sendKeys(strTempId);
		findTempName.sendKeys(strTempName);
		findContract.sendKeys(strContracts);
	}

	public void goToZnsTemplate() {
		WebElement findZnsTemplate = driver.findElement(znsTemplate);
		findZnsTemplate.click();
	}

	public void listCustomerList(String strCustomer) {
		WebElement findCustomer = driver.findElement(customerOA);
		Select selects = new Select(findCustomer);
		List<WebElement> listCustomer = selects.getOptions();
		for (int i = 0; i < listCustomer.size(); i++) {
			String value = listCustomer.get(i).getAttribute("value");
			if (value.equals(strCustomer)) {
				listCustomer.get(i).click();
			}
		}
	}

	public void cta1(String strCta1) {
		WebElement findCta1 = driver.findElement(cta1);
		if (findCta1.isEnabled()) {
			Select selects = new Select(findCta1);
			List<WebElement> listCta1 = selects.getOptions();
			for (int i = 0; i < listCta1.size(); i++) {
				String value = listCta1.get(i).getAttribute("value");
				if (value.equals(strCta1)) {
					listCta1.get(i).click();
				}
			}
		} else {
			System.out.println("Không được phép thay đổi CTA 1");
		}

	}

	public void cta2(String strCta2) {
		WebElement findCta2 = driver.findElement(cta2);
		if (findCta2.isEnabled()) {
			Select selects = new Select(findCta2);
			List<WebElement> listCta2 = selects.getOptions();
			for (int i = 0; i < listCta2.size(); i++) {
				String value = listCta2.get(i).getAttribute("value");
				if (value.equals(strCta2)) {
					listCta2.get(i).click();
				}
			}
		} else {
			System.out.println("Không được phép thay đổi CTA 2");
		}

	}

	public void enterAddTemplate(String strName, String strTemplateId, String strContent, String strNote) {
		WebElement findName = driver.findElement(name);
		WebElement findTemplateId = driver.findElement(templateIdAdd);
		WebElement findContent = driver.findElement(content);
		WebElement findNote = driver.findElement(note);
		findName.sendKeys(strName);
		findTemplateId.sendKeys(strTemplateId);
		findContent.sendKeys(strContent);
		findNote.sendKeys(strNote);
		WebElement upload = driver.findElement(uploadFile);
		upload.sendKeys("D:\\Aouto\\FTI - S - 15S - OTP.xlsx");
	}

	public void config() throws InterruptedException {
		WebElement findKey = driver.findElement(key);
		findKey.sendKeys("Customer_name");
		WebElement findValue = driver.findElement(value);
		findValue.sendKeys("required");
//		Thread.sleep(2000);
//		WebElement findAdd = driver.findElement(add);
//		Thread.sleep(2000);
//		findAdd.click();
	}

	public void enterDataUpdate(String strName, String strTemplateId, String strContent, String strNote, String strCta1,
			String strCta2, String strCustomer, String strSupplier) {
		try {
			WebElement findName = driver.findElement(name);
			findName.clear();
			findName.sendKeys(strName);
			Thread.sleep(1000);
			WebElement findTemplateId = driver.findElement(templateIdAdd);
			if (findTemplateId.isEnabled()) {
				System.out.println("được phép chỉnh sửa");
				findTemplateId.sendKeys(strTemplateId);
			} else {
				System.out.println("No editing allowed templateID");
			}
			Thread.sleep(1000);
			WebElement findContent = driver.findElement(content);
			findContent.clear();
			findContent.sendKeys(strContent);
			Thread.sleep(1000);
			WebElement findNote = driver.findElement(note);
			findNote.clear();
			findNote.sendKeys(strNote);
			Thread.sleep(1000);
			listSupplier(strSupplier);
			Thread.sleep(1000);
			listCustomer(strCustomer);
			cta1(strCta1);
			cta2(strCta2);
//			Thread.sleep(1000);
//			WebElement upload = driver.findElement(uploadFile);
//			upload.sendKeys("D:\\Chứa FILE download\\FTI - S - 2H - ĐĂNG KÝ DỊCH VỤ.xlsx");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getInforDetailTemplate() {
		List<WebElement> list = driver.findElements(inforTemplate);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
	}

	public void getName() {
		WebElement name = driver.findElement(getName);
		if (name.getAttribute("readonly").equals("true")) {
			System.out.println("Tên mẫu tin nhắn: " + name.getAttribute("value"));
		}
	}

	public void getPrice() {
		WebElement price = driver.findElement(getPrice);
		if (price.getAttribute("readonly").equals("true")) {
			System.out.println("Giá tin nhắn: " + price.getAttribute("value"));
		}
	}

	public void getCTA1() {
		WebElement cta1 = driver.findElement(getCta1);
		if (cta1.getAttribute("readonly").equals("true")) {
			System.out.println("Giá CTA 1: " + cta1.getAttribute("value"));
		}
	}

	public void getCTA2() {
		WebElement cta2 = driver.findElement(getCta2);
		if (cta2.getAttribute("readonly").equals("true")) {
			System.out.println("Giá CTA 2: " + cta2.getAttribute("value"));
		}
	}

	public void getTotal() {
		WebElement findTotal = driver.findElement(total);
		if (findTotal.getAttribute("readonly").equals("true")) {
			System.out.println("Tổng giá mẫu tin: " + findTotal.getAttribute("value"));
		}
	}
//	public void btnClose() {
//		WebElement findClose = driver.findElement(btnClose);
//		findClose.click();
//	}

	@Override
	public void search() {
		super.search();
	}

	@Override
	public void listOASearch() {
		super.listOASearch();
	}

	@Override
	public void clickOA() {
		super.clickOA();
	}

	@Override
	public void listTypeTemp() {
		super.listTypeTemp();
	}

	@Override
	public void pagition() {
		super.pagition();
	}
}
