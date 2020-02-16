package User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Courses.Course;
import Courses.Mark;

public abstract class User implements Serializable{
	private String login;
	private String user_id;
	private String name;
	private String surname;
	private String lastname;
	private Degree deg;
	private Date birthdate;
	static int count = 1;
	private Map<String,String> account = new HashMap<String, String>();
	public User(String name, String surname, String lastname, Date birthdate ,Degree deg) {
		this.lastname = lastname;
		this.surname = surname;
		this.name = name;
		this.user_id = Integer.toString(count++)+deg.toString();
		this.deg = deg;
		this.birthdate = birthdate;
		this.setLogin("USER1");
		this.setPassword("KBTU111");
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return account.get(login);
	}
	public void setPassword(String password) {
		this.account.put(login, password);
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Degree getDeg() {
		return deg;
	}
	public void setDeg(Degree deg) {
		this.deg = deg;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public void changePassword() throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter new password:");
		String pass1 = reader.readLine();
		System.out.println("Enter your new password again:");
		String pass2 = reader.readLine();
		if(pass1.equals(pass2)) {
			System.out.println("Success!");
			this.setPassword(pass1);
			reader.close();
		}else {
			System.out.println("The password and confirm password fields do not match.");
			System.out.println("Please, try again.");
			reader.close();
			changePassword();
		}
	}
	public Map<String,String> getAcc(){
		return this.account;
	}
}
