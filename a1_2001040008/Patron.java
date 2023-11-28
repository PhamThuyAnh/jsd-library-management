package a1_2001040008;

import common.PatronType;

import java.util.Date;

public class Patron {
	private String patronID;
	private String name;
	private Date dob;
	private String email;
	private String phone;
	private PatronType patronType;

	private static int patronCount = 0;

	public Patron(String name, Date dob, String email, String phone, PatronType patronType) {
		patronCount++;
		this.patronID = generatePatronID();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.patronType = patronType;
		System.out.println("Patron " + this.patronID + " initialized.");
	}

	private String generatePatronID() {
		return "P" + String.format("%03d", patronCount);
	}

	public String getPatronID() {
		return patronID;
	}

	public void setPatronID(String patronID) {
		this.patronID = patronID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PatronType getPatronType() {
		return patronType;
	}

	public void setPatronType(PatronType patronType) {
		this.patronType = patronType;
	}

	@Override
	public String toString() {
		return "Patron{"
		       + "patronID='"
		       + patronID
		       + '\''
		       + ", name='"
		       + name
		       + '\''
		       + ", dob="
		       + dob
		       + ", email='"
		       + email
		       + '\''
		       + ", phone='"
		       + phone
		       + '\''
		       + ", patronType="
		       + patronType
		       + '}';
	}
}