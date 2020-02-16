package User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Courses.Course;
import DB.Database;
import Tools.AdminTool;

public class Admin extends User{
	public Admin(String name, String surname, String lastname,Date birthdate, Degree deg) {
		super(name,surname,lastname,birthdate,deg);
	}
	public boolean createUser() throws IOException, ParseException {
		return AdminTool.createUser(this.getDeg());
	}
	public boolean deleteUser(User user) {
		return Database.deleteUser(user,this.getDeg());
	}
	public boolean addUser(User user) {
		return Database.addUser(user, this.getDeg());
	}
	public boolean addCourse(Course course) {
		return Database.addCourse(course, this.getDeg());
	}
	public boolean viewTeachers() {
		return Database.listTeachers(this.getDeg());
	}
}
