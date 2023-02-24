package pageObject;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javaCore.Customer;
import manages.PageObjectManage;

public class CustomerPage extends PageObjectManage {
	WebDriver driver;
	By linkCustomer = By.linkText("Khách hàng");
	By customer = By.linkText("Quản lý khách hàng");
	By table = By.cssSelector(".content table tbody");
	ArrayList<Customer> listCustomer = new ArrayList<>();

	public CustomerPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickCustomer() {
		WebElement findClick = driver.findElement(linkCustomer);
		findClick.click();
	}

	public void linkCustomer() {
		WebElement findCustomer = driver.findElement(customer);
		findCustomer.click();
	}

	public void listTable() {
		WebElement getListTable = driver.findElement(table);
		List<WebElement> listTable = getListTable.findElements(By.tagName("tr"));
		for (int i = 0; i < listTable.size(); i++) {
			String name = listTable.get(i).findElement(By.className("column-name")).getText();
			String email = listTable.get(i).findElement(By.className("column-email")).getText();
			String creatDate = listTable.get(i).findElement(By.className("column-created_at")).getText();
			Customer customer = new Customer(name, email, creatDate);
			listCustomer.add(customer);
			System.out.println(customer.listInfor());
		}
	}

	public void exportData() throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Customer");
		// tạo dòng và cột trong sheet
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Name");
		headerRow.createCell(1).setCellValue("Email");
		headerRow.createCell(2).setCellValue("CreatDate");
		int rowIndex = 1;
		
		for (Customer customer : listCustomer) {
			Row row = sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(customer.getName());
			row.createCell(1).setCellValue(customer.getEmail());
			row.createCell(2).setCellValue(customer.getCreatDate());
		}
		FileOutputStream outputStream = new FileOutputStream("D:\\ZNS 2023\\Customer.xlsx");
		workbook.write(outputStream);
		workbook.close();

	}
	

}
