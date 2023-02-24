package javaCore;

public class Logs {
	private String phone;
	private String homeNetWork;
	private String nameTemplate;
	private String status;
	private String statusErro;
	private String customer;
	private String date;

	public Logs(String phone, String homeNetWork, String nameTemplate, String status, String statusErro,
			String customer, String date) {
		this.phone = phone;
		this.homeNetWork = homeNetWork;
		this.nameTemplate = nameTemplate;
		this.status = status;
		this.statusErro = statusErro;
		this.customer = customer;
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public String getHomeNetWork() {
		return homeNetWork;
	}

	public String getNameTemplate() {
		return nameTemplate;
	}

	public String getStatus() {
		return status;
	}

	public String getStatusErro() {
		return statusErro;
	}

	public String getCustomer() {
		return customer;
	}

	public String getDate() {
		return date;
	}

	public String infor() {
		return phone + homeNetWork + nameTemplate + status + statusErro + customer + date;
	}

}
