package Courses;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import User.Teacher;

public class Course implements Serializable{
	private String name;
	private String course_id;
	private int credits;
	private Vector<Teacher> teachers;
	private Vector files;
	private int year;
	public Course(String name, String id, int credits, int year) {
		this.name = name;
		this.course_id = id;
		this.credits = credits;
		this.year = year;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name + " " + " Credists: " + credits + " Course ID: " + course_id;
	}
	public String getName() {
		return this.name;
	}
	public Vector getFiles() {
		return this.files;
	}
	public void addFiles(Object obj) {
		files.add(obj);
	}
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	public Vector<Teacher> getTeachers(){
		return this.teachers;
	}
	public void clearFiles() {
		this.files.clear();
	}
}
