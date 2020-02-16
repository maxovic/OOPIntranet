package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

import Courses.Course;
import DB.Database;
import User.Admin;
import User.Degree;
import User.Manager;
import User.Student;
import User.Teacher;
import User.User;


public class Main {
	public static void save() throws IOException {
		Database.serCourses();
		Database.serStudents();
		Database.serTech();
		Database.serTechers();
		Database.serMan();
	}
	public static void deser() throws ClassNotFoundException, IOException {
		Database.desCourses();
		Database.desStudents();
		Database.desTeachers();
		Database.desTech();
		Database.desManager();
	}
	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
//		Admin admin = new Admin("Admin", "AADMIN", "ADMIN", null, Degree.ADMIN);
//		Admin admin1 = new Admin("Admin1", "AADMIN", "ADMIN", null, Degree.ADMIN);
//
//		Teacher teacher1 = new Teacher("Teacher1","teacher", "Teacher", null, Degree.TD);
//		Teacher teacher2 = new Teacher("Teacher2","teacher", "Teacher", null, Degree.TD);
//		Teacher teacher3 = new Teacher("Teacher3","teacher", "Teacher", null, Degree.TD);
//		Teacher teacher4 = new Teacher("Teacher4","teacher", "Teacher", null, Degree.TD);
//		Teacher teacher5 = new Teacher("Teacher5","teacher", "Teacher", null, Degree.TD);
//		Manager manager = new Manager("manager", "manager", "Manager", null, Degree.STUFF);
//		Student student1 = new Student("student1", "student1", "student1", null, Degree.BD, 3);
//		Student student2 = new Student("student2", "student2", "student2", null, Degree.BD, 3);
//		Student student3 = new Student("student3", "student3", "student3", null, Degree.BD, 3);
//		Student student4 = new Student("student4", "student4", "student4", null, Degree.BD, 3);
//		Student student5 = new Student("student5", "student5", "student5", null, Degree.BD, 3);
//		Student student6 = new Student("student6", "student6", "student6", null, Degree.BD, 3);
//		Student student7 = new Student("studen7", "student7", "student7", null, Degree.BD, 3);
//		Student student8 = new Student("student8", "student8", "student8", null, Degree.BD, 3);
//		Student student9 = new Student("student9", "student9", "student9", null, Degree.BD, 3);
//		Student student10 = new Student("student10", "student10", "student10", null, Degree.BD, 3);
//		Course course1 = new Course("Calculus", "MATH123", 3, 1);
//		Course course2 = new Course("Calculus1", "MATH123", 3, 2);
//		Course course3 = new Course("Calculus2", "MATH123", 3, 2);
//		Course course4 = new Course("PP1", "MATH123", 3, 3);
//		Course course5 = new Course("PP2", "MATH123", 3, 4);
//		admin.addUser(teacher1);
//		admin.addUser(teacher2);
//		admin.addUser(teacher3);
//		admin.addUser(teacher4);
//		admin.addUser(teacher5);
//		admin.addUser(student1);
//		admin.addUser(student2);
//		admin.addUser(student3);
//		admin.addUser(student4);
//		admin.addUser(student5);
//		admin.addUser(student6);
//		admin.addUser(student7);
//		admin.addUser(student8);
//		admin.addUser(student9);
//		admin.addUser(student10);
//		admin.addCourse(course1);
//		admin.addCourse(course2);
//		admin.addCourse(course3);
//		admin.addCourse(course4);
//		admin.addCourse(course5);
//		admin.addUser(manager);
//		admin.addUser(admin1);
//		admin.createUser();
//		save();
//		
		deser();
		Admin admin1 = new Admin("Admin1", "AADMIN", "ADMIN", null, Degree.ADMIN);
//		admin1.createUser();
		Vector<Manager> managers = Database.getManagers();
		System.out.println(managers.size());
		Manager manager = managers.elementAt(0);
		manager.openCourseRegistration(manager.getDeg());
		Vector<Student> students = Database.getStudents(Degree.ADMIN);
		for(Student student:students) {
			System.out.println(student.getName());
			Vector<Course> courses = student.getCourses();
			for(Course course:courses) {
				System.out.println(course.getName());
			}
		}
		for(Student student:students) {
			student.RegisterForCourse();
		}
		manager.createCourse("DEEP LEARNING", "MASDAC", 2, 3);
		
		for(Student student:students) {
			System.out.println(student.getName());
			Vector<Course> courses = student.getCourses();
			for(Course course:courses) {
				System.out.println(course.getName());
			}
		}
		Vector<Teacher> teachers = Database.getTeachers(Degree.ADMIN);
		Teacher teacher = teachers.elementAt(0);
		Vector<Course> vec = Database.getCourses(Degree.ADMIN);
		for(Course course:vec) {
			teacher.addCourse(course);
		}
		teacher.putMarks();
	}
}
