package DB;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import Courses.Course;
import News.Post;
import User.Admin;
import User.Degree;
import User.Manager;
import User.Student;
import User.Teacher;
import User.TechSupport;
import User.User;

public class Database implements Serializable{
	private static Vector<Manager> managers = new Vector<Manager>();
	private static Vector<Student> students = new Vector<Student>();
	private static Vector<Teacher> teachers = new Vector<Teacher>();
	private static Vector<Admin> admins = new Vector<Admin>();
	private static Vector<TechSupport> techSupport = new Vector<TechSupport>();
	private static Vector<Post> posts = new Vector<Post>();
	private static Vector<Course> courses = new Vector<Course>();
	static FileInputStream fis;
	static FileOutputStream fos;
	static ObjectOutputStream oos;
	static ObjectInputStream oin;
	
	public static void desCourses() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("courses");
		oin = new ObjectInputStream(fis);
		courses = (Vector<Course>) oin.readObject();
	}
	public static void serCourses()throws IOException{
		fos = new FileOutputStream("courses");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.close();
	}
	public  static void desStudents() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("students");
		oin = new ObjectInputStream(fis);
		students = (Vector<Student>) oin.readObject();
	}
	
	public static void serStudents()throws IOException{
		fos = new FileOutputStream("students");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(students);
		oos.close();
	}
	public static void serTechers() throws IOException {
		fos = new FileOutputStream("teachers");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(teachers);
		oos.close();
	}
	public  static void desTeachers() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("teachers");
		oin = new ObjectInputStream(fis);
		teachers = (Vector<Teacher>) oin.readObject();
	}
	
	public  static void desTech() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("tech");
		oin = new ObjectInputStream(fis);
		techSupport = (Vector<TechSupport>) oin.readObject();
	}
	
	public  static void desManager() throws IOException, ClassNotFoundException{
		fis = new FileInputStream("managers");
		oin = new ObjectInputStream(fis);
		managers = (Vector<Manager>) oin.readObject();
	}
	
	public static void serMan()throws IOException{
		fos = new FileOutputStream("managers");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(managers);
		oos.close();
	}
	
	public static void serTech()throws IOException{
		fos = new FileOutputStream("tech");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(techSupport);
		oos.close();
	}
	
	public static boolean addUser(User user, Degree deg) {
		if(Degree.ADMIN == deg) {
			if(user.getDeg() == Degree.BD)
				students.add((Student)user);
			else if(user.getDeg() == Degree.TD)
				teachers.add((Teacher) user);
			else if(user.getDeg() == Degree.ADMIN)
				admins.add((Admin)user);
			else
				managers.add((Manager)user);
			return true;
		}else {
			return false;
		}
	}
	public static boolean deleteUser(User user, Degree deg) {
		if(Degree.ADMIN == deg) {
			if(user.getDeg() == Degree.BD) {
				return students.remove((Student)user);
			}else if(user.getDeg() == Degree.TD) {
				return teachers.remove((Teacher)user);
			}else {
				return managers.remove((Manager)user);
			}
		}else {
			return false;
		}
	}
	public static boolean listStudents(Degree deg) {
		if(deg == Degree.STUFF || deg == Degree.ADMIN) {
			for(int i = 0; i < students.size(); i++) {
				System.out.println(students.elementAt(i).toString());
			}
			return true;
		}
		return false;
	}
	public static boolean listTeachers(Degree deg) {
		if(deg == Degree.STUFF || deg == Degree.ADMIN) {
			for(int i = 0; i < teachers.size(); i++) {
				Teacher teach = teachers.elementAt(i);
				
				System.out.println(teachers.elementAt(i).toString() + " " + teach.getLogin() + " " + teach.getPassword());
			}
			return true;
		}
		return false;
	}
	public static Vector<Course> getCourses(Degree deg){
		if(deg == Degree.ADMIN || deg == Degree.STUFF)
			return courses;
		return null;
	}
	public static Vector<Student> getStudents(Degree deg){
		if(deg == Degree.ADMIN || deg == Degree.STUFF)
			return students;
		return null;
	}
	public static Vector<Teacher> getTeachers(Degree deg){
		if(deg == Degree.ADMIN || deg == Degree.STUFF)
			return teachers;
		return null;
	}
	public static boolean addPost(Post post,Degree deg) {
		if(deg == Degree.STUFF || deg == Degree.ADMIN) {
			posts.add(post);
			return true;
		}
		return false;
	}
	public static boolean deletePost(Post post, Degree deg) {
		if(deg == Degree.STUFF || deg == Degree.ADMIN) {
			posts.remove(post);
			return true;
		}
		return false;
	}
	public static boolean addCourse(Course course, Degree deg) {
		if(deg == Degree.STUFF || deg == Degree.ADMIN) {
			courses.add(course);
			return true;
		}
		return false;
	}
	public static boolean deleteCourse(Course course, Degree deg) {
		if(deg == Degree.STUFF || deg == Degree.ADMIN) {
			courses.remove(course);
			return true;
		}
		return false;
	}
	public static Vector<Admin> getAdmins(){
		return admins;
	}
	public static Vector<Manager> getManagers(){
		return managers;
	}
}
