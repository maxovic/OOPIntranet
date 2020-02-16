package User;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

import Courses.Course;
import DB.Database;
import News.Post;
public class Manager extends User{
	public Vector<Course> courses;
	public Manager(String name, String surname, String lastname,Date birthdate, Degree deg) {
		super(name,surname,lastname,birthdate,deg);
		this.setLogin(name);
		this.setPassword("KBTU111");
	}
	public void viewCourses() {
		for(int i = 0; i < courses.size(); i++) {
			System.out.println((i+1)+" "+courses.elementAt(i).getName());
		}
	}
	public void viewStudents() {
		Database.listStudents(this.getDeg());
	}
	public void viewTeachers() {
		Database.listTeachers(this.getDeg());
	}
	public boolean openCourseRegistration(Degree deg) {
		Vector<Course> vec = Database.getCourses(deg);
		Vector<Student> students = Database.getStudents(Degree.ADMIN);
		for(Student student:students) {
			Vector<Course> coursess = student.getCourses();
			for(Course course:vec) {
				coursess.add(course);
			}
			student.setCourses(coursess);
		}
		return true;
	}
	public boolean closeCourseRegistration() {
		return Student.closeRegistration(this.getDeg());
	}
	public boolean createPost(String title, String text, User author, Date date) {
		Post newpost = new Post(title,text,author,date);
		return Database.addPost(newpost, this.getDeg());
	}
	public boolean deletePost(Post post) {
		return Database.deletePost(post, this.getDeg());
	}
	public boolean createCourse(String name, String id, int credits, int year) {
		Course course = new Course(name,id,credits,year);
		Database.addCourse(course, this.getDeg());
		Vector<Student> students = Database.getStudents(Degree.ADMIN);
		for(Student student:students) {
			student.addNewCourse(course, Degree.STUFF);
		}
		return true;
		
	}
	public void sendReport(Post post, TechSupport tech) {
		tech.acceptReport(post);
	}
}	
