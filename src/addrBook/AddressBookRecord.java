package addrBook;

public class AddressBookRecord {
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String email;
	private String gender;
	private String address;

	public AddressBookRecord() {
		super();
	}

	public AddressBookRecord(String firstName, String lastName, String phoneNum, String email, String gender, String address) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNum(phoneNum);
		setEmail(email);
		setGender(gender);
		setAddress(address);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isMale() {
		if (gender != null && gender.equalsIgnoreCase("Male")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFemale() {
		if (gender != null && gender.equalsIgnoreCase("Female")) {
			return true;
		} else {
			return false;
		}
	}
}
