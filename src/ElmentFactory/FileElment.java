package ElmentFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileElment {
	WebDriver driver;
	public By customer = By.cssSelector(".content form select[name=customer_id]");
	public By btnSearch = By.cssSelector(".content form button.btn-sm");
	public By findList = By.cssSelector(".content table tbody");
	public By findName = By.cssSelector(".content table tbody .column-customer-name");
	public By account = By.cssSelector(".content form select[name=customer_account[id][]]");
	public By btnSubmit = By.cssSelector(".content form button[type=submit]");
	public By btnReset = By.cssSelector(".content form button[type=reset]");
	public By btnListCustomer = By.linkText("Danh sách");
	public By btnUpdate = By.linkText("Chỉnh sửa");
	public By btnDetail = By.linkText(" Chi tiết");
	public By btnLl = By.linkText("Làm lại");
	public By selOA = By.cssSelector(".content form select[name=customer_oa_id]");
	public By selFailOver = By.cssSelector("\".content form select[name=failover_sms]");
	public By messageError = By.cssSelector(".content form label[for=inputError]");
	public By listLableDetail = By.cssSelector(".content .form-horizontal label.control-label");
	public By listDataDetail = By.cssSelector(".content .form-horizontal .box-body");
	public By ElmentPerPage = By.cssSelector(".content select[name=per-page]");
	public By elmentPagination = By.cssSelector("content ul.pagination li.page-item");

	public By btnAdd = By.linkText("Mới");
	public By lblName = By.cssSelector(".content form label[for=name]");
	public By lblCustomer = By.cssSelector(".content form label[for=customer_id]");
	public By lblAccount = By.cssSelector(".content form label[for=customer_account_id]");
	public By lblAppType = By.cssSelector(".content form label[for=app_type]");
	public By lblCustomerOa = By.cssSelector(".content form label[for=customer_oa_id]");
	public By lblFailover = By.cssSelector(".content form label[for=failover_sms]");
	public By lblDescription = By.cssSelector(".content form label[for=description]");
	public By lblStatus = By.cssSelector(".content form label[for=status]");
	public By lblCallback_url = By.cssSelector(".content form label[for=callback_url]");
	public By inpName = By.cssSelector(".content form input#name");
	public By textDec = By.cssSelector(".content form textarea[name=description]");
	public By inpCallback = By.cssSelector(".content form input#callback_url");

	public By linkAPp = By.linkText("Kết nối APIs");

	public By email = By.name("username");
	public By password = By.name("password");
	public By btnLogin = By.cssSelector("button.btn-flat");
	public By errorMsgTextLogin = By.cssSelector(".login-box form label[for=inputError]");

	public String linkAdmin = "https://inside-fns.fpt.work/admin";
	public By actionTable = By.cssSelector(".content table tbody td.column-__actions__ li a");
	public By manipulation = By.cssSelector(".content table tbody td.column-__actions__ a");
	public By listBtn = By.cssSelector(".content .box-tools .btn-group");
	public By clickOA = By.linkText("Quản lý Zalo");

	public FileElment(WebDriver driver) {
		this.driver = driver;
	}

}