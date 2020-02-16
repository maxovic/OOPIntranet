package Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import DB.Database;
import User.Admin;
import User.Degree;
import User.Manager;
import User.Student;
import User.Teacher;
import User.TechSupport;

public class AdminTool {
	public static boolean createUser(Degree deg) throws IOException, ParseException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name:");
		String name = reader.readLine();
		System.out.println("Enter surname:");
		String surname = reader.readLine();
		System.out.println("Enter lastname:");
		String lastname = reader.readLine();
		System.out.println("Enter your birthdate in format \"dd/MM/yyyy\":");
		String birthdate = reader.readLine();
		Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate); 
		System.out.println("Who you are registering? /Teacher/Student/Manager/TechSupport");
		String level = reader.readLine();
		boolean created = false;
		switch(level){
		case("Student"):
			System.out.println("Enter year of study:");
			int year = reader.read(); 
			Student newone = new Student(name,surname,lastname,birthday,Degree.BD,year);
			Database.addUser(newone, Degree.ADMIN);
			created = true;
			break;
		case("Teacher"):
			Teacher newteacher = new Teacher(name,surname,lastname,birthday,Degree.TD);
			Database.addUser(newteacher, Degree.ADMIN);
			created = true;
			break;
		case("Manager"):
			Manager newmanager = new Manager(name,surname,lastname,birthday,Degree.STUFF);
			Database.addUser(newmanager,Degree.ADMIN);
			created = true;
			break;
		case("TechSupport"):
			TechSupport tech = new TechSupport(name,surname,lastname,birthday,Degree.STUFF);
			Database.addUser(tech,Degree.ADMIN);
			created = true;
			break;
		case("Admin"):
			Admin admin = new Admin(name,surname,lastname,birthday,Degree.ADMIN);
			Database.addUser(admin, Degree.ADMIN);
			created = true;
			break;
		}
		if(created) System.out.println("Success!");
		return created;
	}
}
