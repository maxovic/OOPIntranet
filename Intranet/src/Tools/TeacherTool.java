package Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import Courses.Course;
import DB.Database;
import News.Post;
import User.Degree;
import User.Student;
import User.TechSupport;

public class TeacherTool implements Tools{
	public static void viewStudents(Degree deg, Vector<Course> courses) {
		Vector<Student> students = Database.getStudents(deg);
		for(Course course:courses) {
			System.out.println(course.getName() + ":");
				for(Student student:students) {
					Vector<Course> studentCourses = student.getCourses();
					if(studentCourses.contains(course)) {
						System.out.println(student.getName() + " " + student.getLastname());
						break;
					}
				}
		}
	}
	public static void deleteCourseFiles(Vector<Course> courses) throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Choose a course by entering its number:");
		Tools.viewCourses(courses);
		int n = reader.read();
		Course neededCourse = courses.elementAt(n-1);
		neededCourse.clearFiles();
		reader.close();
	}
	public static void putMarks(Vector<Course> courses, Degree deg) throws IOException {
		BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
		Vector<Student> students = Database.getStudents(deg);
		for(Course course:courses) {
			System.out.println(course.getName() + ":");
				for(Student student:students) {
					Vector<Course> studentCourses = student.getCourses();
					if(studentCourses.contains(course)) {
						System.out.println(student.getName() + " " + student.getLastname());
						System.out.println("Enter point: ");
						int point = reader.read();
						student.setMark(course, point);
					}
				}
		}
	}
	public void sendMessage(Post post, TechSupport tech) {
		tech.acceptReport(post);
	}
}
