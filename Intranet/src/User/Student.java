package User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import Courses.Course;
import Courses.Mark;
import Tools.StudentTool;
import Tools.Tools;

public class Student extends User implements Tools{
	private int year_of_study;
	private Vector<Course> courses = new Vector<Course>();
	private Vector<Course> retakes = new Vector<Course>();
	private Vector<Object> files;
	private static Vector<Course> unregisteredCourses = new Vector<Course>();
	private Map<Course, Mark> mark = new HashMap<Course, Mark>();
	
	public Student(String name, String surname, String lastname,Date birthdate ,Degree deg, int year) {
		super(name,surname,lastname,birthdate,deg);
		this.year_of_study = year;
		this.setLogin(name);
		this.setPassword("KBTU111");
	}
	
	public void RegisterForCourse() {
		for(int i = 0; i < unregisteredCourses.size(); i++) {
			Course cur = unregisteredCourses.elementAt(i);
			if(cur.getYear() == this.getYear_of_study() && courses.contains(cur) == false) {
				courses.add(cur);
			}
		}
	}
	
	public boolean addNewCourse(Course course ,Degree deg) {
		if(deg == Degree.STUFF){
			courses.add(course);
			return true;
		}
		return false;
	}
	
	public static boolean closeRegistration(Degree deg) {
		if(deg == Degree.STUFF) {
			unregisteredCourses.clear();
			return true;
		}
		return false;
	}

	
	public void viewMark() {
		int mk = StudentTool.viewMark(courses, mark);
		System.out.println(mk);
	}
	
	public void viewTranscript() {
		StudentTool.viewTranscript(courses,mark);
	}
	
	public void downloadFiles() {
		this.files = (Vector<Object>)Tools.downloadFiles(courses, files);
	}
	
	public int getYear_of_study() {
		return year_of_study;
	}
	
	public void setYear_of_study(int year_of_study) {
		this.year_of_study = year_of_study;
	}
	
	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public Vector<Course> getRetakes() {
		return retakes;
	}

	public void setRetakes(Vector<Course> retakes) {
		this.retakes = retakes;
	}
	
	public void setMark(Course course, int mk) {
		mark.clear();
		Mark newMark = new Mark(mk);
		mark.put(course, newMark);
		
	}
	
	public String toString() {
		return this.getName()+" "+this.getSurname() + " " + this.getLastname();
	}

	
	
}
