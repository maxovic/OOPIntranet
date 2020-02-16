package User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Vector;
import Courses.Course;
import News.Post;
import Tools.Tools;
import Tools.TeacherTool;

public class Teacher extends User implements Tools{
	private Vector<Course> courses = new Vector<Course>();
	private Vector<Post> messages;
	public Teacher(String name, String surname, String fathername,Date birthdate,Degree deg) {
		super(name,surname,fathername,birthdate,deg);
		this.setLogin(name);
		this.setPassword("KBTU111");
	}
	
	public int view() throws IOException {
		System.out.println("Select course: ");
		Tools.viewCourses(courses);
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		int n = reader.read();
		reader.close();
		return n;
	}
	public void viewCourse() {
		Tools.viewCourses(courses);
	}
	public void viewStudents(Degree deg, Vector<Course> courses) {
		TeacherTool.viewStudents(this.getDeg(), courses);
	}
	public void addCourseFile(Object object) {
		for(Course course:courses) {
			course.addFiles(object);
		}
	}	
	public void deleteCourseFiles(Vector<Course> courses) throws IOException {
		TeacherTool.deleteCourseFiles(courses);
	}
	public void viewMessages() {
		for(Post post:messages) {
			messages.remove(post);
		}
	}
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	public void putMarks() throws IOException {
		TeacherTool.putMarks(courses, Degree.ADMIN);
	}
	public String toString() {
		return this.getName() + " " + this.getSurname() + " " + this.getLastname();
	}
}
