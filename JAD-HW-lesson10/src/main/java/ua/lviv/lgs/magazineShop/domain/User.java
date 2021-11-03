package ua.lviv.lgs.magazineShop.domain;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String accessLevel;

	public User(int id, String firstName, String lastName, String email, String password, String accessLevel) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public User(String firstName, String lastName, String email, String password, String accessLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.accessLevel = accessLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		if (id == 0)
			return firstName + " " + lastName + ", email: " + email + ", password: " + password + ", " + accessLevel;
		else
			return "User ID#" + id + ": " + firstName + " " + lastName + ", email: " + email + ", password: " + password
					+ ", " + accessLevel;
	}
}