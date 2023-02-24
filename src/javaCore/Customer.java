package javaCore;

public class Customer {
	private String name;
	private String email;
	private String creatDate;

	public Customer(String name, String email, String creaString) {
		this.name = name;
		this.email = email;
		this.creatDate = creaString;
	}
	 public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getCreatDate() {
	        return creatDate;
	    }
	    public String listInfor() {
			return name  +"|"+ email +"|" + creatDate;
		}
}
